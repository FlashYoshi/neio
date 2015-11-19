package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.ugent.neio.language.Neio;
import org.aikodi.chameleon.core.declaration.Declaration;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.ElementWithModifiers;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.property.ChameleonProperty;
import org.aikodi.chameleon.core.reference.CrossReferenceWithName;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.language.ObjectOrientedLanguage;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.FormalTypeParameter;
import org.aikodi.chameleon.oo.type.generics.InstantiatedTypeParameter;
import org.aikodi.chameleon.oo.type.generics.TypeArgument;
import org.aikodi.chameleon.oo.type.generics.TypeConstraint;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;

import java.util.function.Predicate;

public abstract class AbstractJava8Generator {

    protected final String IMPLEMENTATION_SUFFIX = "Impl";

    protected String fieldName(VariableDeclaration variableDeclaration) {
        return "field$" + variableDeclaration.origin().nearestAncestor(Type.class).name() + "$" + variableDeclaration.name();
    }

    protected String getterName(VariableDeclaration variableDeclaration) {
        return "get$" + variableDeclaration.origin().nearestAncestor(Type.class).name() + "$" + variableDeclaration.name();
    }

    protected String setterName(VariableDeclaration variableDeclaration) {
        return "set$" + variableDeclaration.origin().nearestAncestor(Type.class).name() + "$" + variableDeclaration.name();
    }

    protected String implementationName(Type t) {
        return t.name() + IMPLEMENTATION_SUFFIX;
    }

    protected Neio jlo(Element element) {
        return element.language(Neio.class);
    }

    protected Java7 java(Element element) {
        return element.language(Java7.class);
    }


    protected void renameConstructorCalls(Document target) {
        target.apply(CrossReferenceWithName.class, c -> {
            CrossReferenceWithName origin = (CrossReferenceWithName) c.origin();
            if (origin != c.origin()) {
                Declaration element;
                try {
                    element = origin.getElement();
                    if (element.isTrue(java(element).CONSTRUCTOR)) {
                        c.setName(implementationName((Type) element));
                    }
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        });

    }

    protected ModifierAdder add(Modifier modifier) {
        return new ModifierAdder(modifier);
    }

    public ModifierStripper strip(ChameleonProperty property) {
        return new ModifierStripper(m -> m.impliesTrue(property));
    }

    public ModifierStripper strip(Class<? extends Modifier> type) {
        return new ModifierStripper(type::isInstance);
    }

    protected Method createGetterTemplate(MemberVariableDeclarator d) throws LookupException {
        VariableDeclaration variableDeclaration = d.variableDeclarations().get(0);
        TypeReference tref = flattened(d.typeReference());

        return ooFactory(d).createNormalMethod(getterName(variableDeclaration), clone(d.typeReference()));
    }

    protected TypeReference flattened(TypeReference typeReference) throws LookupException {
        TypeReference tref = (TypeReference) typeReference.origin();
        Type tp = tref.nearestAncestor(Type.class);
        Declaration decl = tref.getDeclarator();
        if (decl instanceof FormalTypeParameter) {
            FormalTypeParameter param = (FormalTypeParameter) decl;
            TypeReference clone;
            if (param.nbConstraints() > 0) {
                TypeConstraint constraint = param.constraints().get(0);
                clone = clone(constraint.typeReference());
            } else {
                ObjectOrientedLanguage language = tref.language(ObjectOrientedLanguage.class);
                clone = language.createTypeReference(language.getDefaultSuperClassFQN());
            }
        } else if (decl instanceof InstantiatedTypeParameter) {
            InstantiatedTypeParameter param = (InstantiatedTypeParameter) decl;
            TypeArgument arg = param.argument();
        }

        return typeReference;
    }

    protected ObjectOrientedFactory ooFactory(Element element) {
        return java(element).plugin(ObjectOrientedFactory.class);
    }

    protected ExpressionFactory expressionFactory(Element element) {
        return java(element).plugin(ExpressionFactory.class);
    }

    protected Method createSetterTemplate(MemberVariableDeclarator d) {
        VariableDeclaration variableDeclaration = d.variableDeclarations().get(0);
        ObjectOrientedFactory factory = java(d).plugin(ObjectOrientedFactory.class);
        TypeReference fieldType = d.clone(d.typeReference());
        Method result = factory.createNormalMethod(setterName(variableDeclaration), java(d).createTypeReference("void"));
        result.header().addFormalParameter(new FormalParameter("value", fieldType));
        return result;
    }

    protected boolean isGenerated(Element element) {
        return element.origin() == element;
    }

    protected TypeReference expandedTypeReference(TypeReference element, ObjectOrientedLanguage targetLanguage) throws LookupException {
        TypeReference result = targetLanguage.reference(element.getElement());
        //disconnect the type reference. Note that this might give problems inside anonymous inner classes/
        result.setUniParent(null);
        return result;
    }

    protected <E extends Element> E clone(E element) {
        return element.clone(element);
    }

    protected <E extends Element> E cloneAndSetOrigin(E element) {
        E result = element.clone(element);
        result.setOrigin(element);
        return result;
    }

    public static class ModifierAdder {
        private Modifier modifier;

        public ModifierAdder(Modifier modifier) {
            this.modifier = modifier;
        }

        public <T extends ElementWithModifiers> ModifierConfiguration<T> to(Class<T> type) {
            return new ModifierConfiguration<>(modifier, type);
        }
    }

    public static class ModifierConfiguration<T extends ElementWithModifiers> {
        private Predicate<T> predicate;
        private Element element;
        private Class<T> type;
        private Modifier modifier;

        public ModifierConfiguration(Modifier modifier, Class<T> type) {
            this.type = type;
            this.modifier = modifier;
        }

        public ModifierConfiguration<T> in(Element element) {
            this.element = element;
            return this;
        }

        public void whenOrigin(Predicate<T> predicate) {
            this.predicate = predicate;
            element.apply(type, t -> {
                if (predicate.test((T) t.origin())) {
                    t.addModifier(modifier.clone(modifier));
                    t.flushCache();
                }
            });
        }

        public void whenTranslated(Predicate<T> predicate) {
            this.predicate = predicate;
            element.apply(type, t -> {
                if (predicate.test(t)) {
                    t.addModifier(modifier.clone(modifier));
                    t.flushCache();
                }
            });
        }
    }

    public static class ModifierStripper {
        private Predicate<Modifier> predicate;

        public ModifierStripper(Predicate<Modifier> predicate) {
            this.predicate = predicate;
        }

        public <T extends ElementWithModifiers> ModifierStripperConfiguration<T> from(Class<T> elementType) {
            return new ModifierStripperConfiguration<T>(predicate, elementType);
        }
    }

    public static class ModifierStripperConfiguration<T extends ElementWithModifiers> {
        private Predicate<Modifier> modifierPredicate;
        private Class<T> elementType;
        private Predicate<T> predicate;

        public ModifierStripperConfiguration(Predicate<Modifier> modifierPredicate, Class<T> elementType) {
            super();
            this.modifierPredicate = modifierPredicate;
            this.elementType = elementType;
        }

        public ModifierStripperConfiguration<T> when(Predicate<T> predicate) {
            this.predicate = predicate;
            return this;
        }

        public void in(Element element) {
            element.apply(elementType, e -> {
                if (predicate == null || predicate.test(e)) {
                    try {
                        e.modifiers().stream().filter(modifierPredicate).forEach(Element::disconnect);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            });
        }

    }

}
