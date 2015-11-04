package be.ugent.neio.jlo.translate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.member.Member;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.MethodHeader;
import org.aikodi.chameleon.oo.method.RegularImplementation;
import org.aikodi.chameleon.oo.method.SimpleNameMethodHeader;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.type.DeclarationWithType;
import org.aikodi.chameleon.oo.type.ParameterBlock;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.member.simplename.SimpleNameMethodInvocation;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.statement.ReturnStatement;
import org.aikodi.chameleon.support.statement.StatementExpression;
import org.aikodi.chameleon.support.statement.ThrowStatement;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;
import org.aikodi.chameleon.util.Util;
import be.ugent.neio.jlo.model.component.AbstractInstantiatedComponentParameter;
import be.ugent.neio.jlo.model.component.ActualComponentArgument;
import be.ugent.neio.jlo.model.component.ComponentNameActualArgument;
import be.ugent.neio.jlo.model.component.ComponentParameter;
import be.ugent.neio.jlo.model.component.ComponentRelationSet;
import be.ugent.neio.jlo.model.component.FormalComponentParameter;
import be.ugent.neio.jlo.model.component.MultiActualComponentArgument;
import be.ugent.neio.jlo.model.component.MultiFormalComponentParameter;
import be.ugent.neio.jlo.model.component.ParameterReferenceActualArgument;
import be.ugent.neio.jlo.model.component.Subobject;
import be.ugent.neio.jlo.model.component.SubobjectType;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.JavaMethodInvocation;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.JavaTypeReference;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class SelectorCreator extends AbstractTranslator {

	public List<Method> selectorsFor(Subobject rel) throws LookupException {
		if(rel.componentType().descendants(ComponentParameter.class).isEmpty()) {
			Type t = rel.referencedComponentType();
			return selectorsForComponent(t);
		} else {
			return selectorsForComponent(rel.componentType());
		}
	}

	private FormalComponentParameter highestSubobjectParameter(FormalComponentParameter par) throws LookupException {
		FormalComponentParameter result = par;
		Set<? extends Member> overridden = result.overriddenMembers();
		while(! overridden.isEmpty()) {
			result = (FormalComponentParameter) overridden.iterator().next();
			overridden = result.overriddenMembers();
		}
		return result;
	}
	
	public List<Method> selectorsForComponent(Type t) throws LookupException {
		List<Method> result = new ArrayList<Method>();
		Builder<ComponentParameter> builder = ImmutableList.<ComponentParameter>builder();
		builder.addAll(t.parameters(ComponentParameter.class));
		builder.addAll(t.members(ComponentParameter.class));
		// HACK that must be removed (as in "always used" so no if statement) when functional
		// style parameters are removed.
		List<ComponentParameter> parameters = builder.build();
		for(ComponentParameter par: parameters) {
			AbstractInstantiatedComponentParameter instantiatedPar = (AbstractInstantiatedComponentParameter) par;
			FormalComponentParameter formalParameter = instantiatedPar.formalParameter();
			FormalComponentParameter originalFormalParameter = (FormalComponentParameter) formalParameter.origin();
//			FormalComponentParameter<?> highestFormalParameter = highestSubobjectParameter(originalFormalParameter);
			Type p = t;
			if(t instanceof SubobjectType) {
				p = originalFormalParameter.nearestAncestor(Type.class);
			}
			Method realSelector= realSelectorFor(instantiatedPar);
			realSelector.setUniParent(p);
			substituteTypeParameters(realSelector);
			realSelector.setUniParent(null);
			result.add(realSelector);
		}
		return result;
	}
	
	private Method realSelectorFor(AbstractInstantiatedComponentParameter par) throws LookupException {
		FormalComponentParameter formal = par.formalParameter();
		Java7 language = par.language(Java7.class);
		ExpressionFactory expressionFactory = language.plugin(ExpressionFactory.class);
//		Method result = new NormalMethod(header,formal.componentTypeReference().clone());
		Type declarationType = formal.declarationType();
		JavaTypeReference reference = language.reference(declarationType);
		reference.setUniParent(null);
		MethodHeader header = new SimpleNameMethodHeader(selectorName((ComponentParameter) par),reference);
		Method result = language.plugin(ObjectOrientedFactory.class).createNormalMethod(header);
		result.addModifier(new Public());
//		result.addModifier(new Abstract());
		header.addFormalParameter(new FormalParameter("argument", Util.clone(formal.containerTypeReference())));
		Block body = new Block();
		result.setImplementation(new RegularImplementation(body));
		ActualComponentArgument arg = par.argument();
		Expression expr;
		if(arg instanceof ComponentNameActualArgument) {
			ComponentNameActualArgument singarg = (ComponentNameActualArgument) arg;
			expr = new JavaMethodInvocation(getterName(singarg.declaration()),expressionFactory.createNameExpression("argument", null));
			body.addStatement(new ReturnStatement(expr));
		} else if(arg instanceof ParameterReferenceActualArgument) {
			ParameterReferenceActualArgument ref = (ParameterReferenceActualArgument) arg;
			ComponentParameter p = ref.declaration();
			expr = new JavaMethodInvocation(selectorName(p), null);
			((JavaMethodInvocation)expr).addArgument(expressionFactory.createNameExpression("argument",null));
			body.addStatement(new ReturnStatement(expr));
		}
		 else {
			// result variable declaration
			VariableDeclaration declaration = new VariableDeclaration("result");
			BasicJavaTypeReference arrayList = language.createTypeReference("java.util.ArrayList");
			JavaTypeReference componentType = language.reference(formal.componentTypeReference().getElement());
			componentType.setUniParent(null);
			
//			BasicTypeArgument targ = language.createBasicTypeArgument(componentType);
//			arrayList.addArgument(targ);
			
			LocalVariableDeclarator varDecl = new LocalVariableDeclarator(Util.clone(arrayList));

			Expression init = new ConstructorInvocation(arrayList, null);
			declaration.setInitialization(init);
			varDecl.add(declaration);
			body.addStatement(varDecl);
			
			// add all components
			ComponentRelationSet componentRelations = ((MultiActualComponentArgument)arg).declaration();
			for(DeclarationWithType rel: componentRelations.relations()) {
				Expression t = expressionFactory.createNameExpression("result");
				SimpleNameMethodInvocation inv = new JavaMethodInvocation("add", t);
				Expression componentSelector;
				if(rel instanceof ComponentParameter) {
					if(rel instanceof MultiFormalComponentParameter) {
						inv.setName("addAll");
					}
					componentSelector = new JavaMethodInvocation(selectorName((ComponentParameter)rel), null);
					((JavaMethodInvocation)componentSelector).addArgument(expressionFactory.createNameExpression("argument"));
				} else {
				  componentSelector = expressionFactory.createNameExpression(rel.signature().name(), expressionFactory.createNameExpression("argument"));
				}
				inv.addArgument(componentSelector);
				body.addStatement(new StatementExpression(inv));
			}
			
			// return statement
			expr = expressionFactory.createNameExpression("result");
			body.addStatement(new ReturnStatement(expr));
		}
    return result;		
	}
	
	public List<Method> selectorsFor(Type type) throws LookupException {
		List<Method> result = new ArrayList<Method>();
		List<ComponentParameter> parameters = new ArrayList<ComponentParameter>(); 
		ParameterBlock<ComponentParameter> block = type.parameterBlock(ComponentParameter.class);
		if(block != null) {
		  parameters.addAll(block.parameters());
		}
		parameters.addAll(type.members(ComponentParameter.class));
		for(ComponentParameter par: parameters) {
	  	result.add(selectorFor((FormalComponentParameter) par));
	  }
		
		return result;
	}

	public String selectorName(ComponentParameter par) throws LookupException {
//		Type type;
//		if(par instanceof InstantiatedMemberSubobjectParameter) {
//			type = (Type) ((InstantiatedMemberSubobjectParameter) par).formalParameter().origin().nearestAncestor(Type.class);
//		} else {
//			type = par.nearestAncestor(Type.class);
//		}
//		return "__select$"+ toUnderScore(type.getFullyQualifiedName())+"$"+par.signature().name();
		return "__select$" + par.signature().name();
	}
	
	private Method selectorFor(FormalComponentParameter par) throws LookupException {
		Java7 language = par.language(Java7.class);
		JavaTypeReference reference = language.reference(par.declarationType());
		reference.setUniParent(null);
		MethodHeader header = new SimpleNameMethodHeader(selectorName(par),reference);
		Method result = par.language(Java7.class).plugin(ObjectOrientedFactory.class).createNormalMethod(header);
		result.addModifier(new Public());
		header.addFormalParameter(new FormalParameter("argument", Util.clone(par.containerTypeReference())));
		Block body = new Block();
		result.setImplementation(new RegularImplementation(body));
		ConstructorInvocation cons = new ConstructorInvocation((BasicJavaTypeReference) par.language(Java7.class).createTypeReference("java.lang.Error"), null);
		body.addStatement(new ThrowStatement(cons));
		return result;
	}


}
