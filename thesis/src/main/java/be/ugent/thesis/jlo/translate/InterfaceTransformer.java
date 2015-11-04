package be.ugent.thesis.jlo.translate;

import java.util.List;

import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.core.property.ChameleonProperty;
import org.aikodi.chameleon.core.reference.NameReference;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.oo.language.ObjectOrientedLanguage;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.type.BasicTypeReference;
import org.aikodi.chameleon.oo.type.ParameterBlock;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeElement;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.TypeParameter;
import org.aikodi.chameleon.oo.type.generics.TypeParameterBlock;
import org.aikodi.chameleon.oo.type.inheritance.InheritanceRelation;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.VariableDeclarator;
import org.aikodi.chameleon.support.modifier.Interface;
import org.aikodi.chameleon.util.Util;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.rejuse.logic.ternary.Ternary;
import be.kuleuven.cs.distrinet.rejuse.property.Property;

public class InterfaceTransformer extends AbstractTranslator {

	public Document interfaceCompilationUnit(Document original, Document implementation) throws ModelException {
		Document interfaceCompilationUnit = null;
		Java7 lang = original.language(Java7.class);
		if(! original.isTrue(lang.INTERFACE)) {
			original.flushCache();
			implementation.flushCache();

			Type implementationType = original.namespaceDeclaration(0).declarations(Type.class).get(0);
			if(splitClass(implementationType)) {
				interfaceCompilationUnit = implementation.cloneTo(implementation.view());
				NamespaceDeclaration interfaceNamespacePart = interfaceCompilationUnit.namespaceDeclaration(1);
				Type interfaceType = interfaceNamespacePart.declarations(Type.class).get(0);
				interfaceType.addModifier(new Interface());
				interfaceType.flushCache();
				transformToInterfaceDeep(interfaceType);
				for(BasicJavaTypeReference tref: interfaceType.descendants(BasicJavaTypeReference.class)) {
					String name = tref.name();
					if(name.endsWith(IMPL)) {
						tref.setName(interfaceName(name));
					}
				}
				for(NameReference tref: interfaceType.descendants(NameReference.class)) {
					String name = tref.name();
					if(name.endsWith(IMPL)) {
						tref.setName(interfaceName(name));
					}
				}
				interfaceCompilationUnit.flushCache();
			} else {
				for(Type type: implementation.descendants(Type.class)) {
					List<InheritanceRelation> relations = type.inheritanceRelations();
					for(InheritanceRelation relation: relations) {
						TypeReference t = relation.superClassReference();
						if(t.hasMetadata(IMPL)) {
							if(t instanceof BasicTypeReference) {
								BasicTypeReference b = (BasicTypeReference) t;
								b.setName(b.name()+IMPL);
							}
						}
					}
				}
			}
		}
		return interfaceCompilationUnit;
	}
	
	private void transformToInterfaceDeep(Type type) throws ModelException {
		List<Type> types = type.descendants(Type.class);
		types.add(type);
		for(Type t: types) {
			transformToInterface(t);
		}
	}
	
	private void transformToInterface(Type type) throws ModelException {
		String name = type.name();
		Java7 language = type.language(Java7.class);
		if(name.endsWith(IMPL)) {
			copyTypeParametersIfNecessary(type);
			makePublic(type);
			List<SubtypeRelation> inheritanceRelations = type.nonMemberInheritanceRelations(SubtypeRelation.class);
			int last = inheritanceRelations.size() - 1;
			inheritanceRelations.get(last).disconnect();
			
			for(TypeElement decl: type.directlyDeclaredElements()) {
				transform(language, decl);
			}
			type.setName(interfaceName(name));
			if(! (type.is(language.INTERFACE) == Ternary.TRUE)) {
				type.addModifier(new Interface());
				type.flushCache();
			} 
		}
	}

	private void transform(Java7 language, TypeElement decl) throws ModelException {
		if(decl instanceof Method) {
			((Method) decl).setImplementation(null);
			if(decl.is(language.CLASS) == Ternary.TRUE) {
				decl.disconnect();
			}
		}
		if(
			 (decl.parent() != null) && (
			 (decl.is(language.CONSTRUCTOR) == Ternary.TRUE) ||
			 (decl.is(language.PRIVATE) == Ternary.TRUE && (! (decl instanceof Type))) ||
			 (decl instanceof VariableDeclarator ))) { // && (! (decl.is(language.CLASS) == Ternary.TRUE))
			decl.disconnect();
		} 
		if(decl.parent() != null) {
			makePublic(decl);
			removeNonInterfaceModifiers(decl);
		}
	}

	private void removeNonInterfaceModifiers(TypeElement element) throws ModelException {
		removeFinal(element);
		removeSynchronized(element);
	}

	private void removeSynchronized(TypeElement element) throws ModelException {
		ChameleonProperty property = element.language(Java7.class).SYNCHRONIZED;
		for(Modifier modifier: element.modifiers(property)) {
			element.removeModifier(modifier);
		}
	}
	
	private void removeFinal(TypeElement element) throws ModelException {
	  ChameleonProperty property = element.language(ObjectOrientedLanguage.class).OVERRIDABLE.inverse();
		for(Modifier modifier: element.modifiers(property)) {
			element.removeModifier(modifier);
		}
	}

	private void copyTypeParametersIfNecessary(Type type) {
		Type outmost = type.farthestAncestor(Type.class);
		if(outmost != null && (! type.isTrue(type.language(Java7.class).CLASS))) {
			List<TypeParameter> typeParameters = outmost.parameters(TypeParameter.class);
			ParameterBlock tpars = type.parameterBlock(TypeParameter.class);
			if(tpars == null) {
				type.addParameterBlock(new TypeParameterBlock());
			}
			for(TypeParameter typeParameter:typeParameters) {
				type.addParameter(TypeParameter.class, Util.clone(typeParameter));
			}
		}
	}


}
