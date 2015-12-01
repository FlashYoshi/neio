package be.ugent.neio.model.namespace;

import be.kuleuven.cs.distrinet.jnome.core.namespacedeclaration.JavaNamespaceDeclaration;
import be.ugent.neio.industry.NeioFactory;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.core.reference.CrossReference;
import org.aikodi.chameleon.oo.namespacedeclaration.TypeImport;
import org.aikodi.chameleon.oo.type.BasicTypeReference;
import org.aikodi.chameleon.oo.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Titouan Vervack
 */
public class WildcardNamespaceDeclaration extends JavaNamespaceDeclaration {
    public WildcardNamespaceDeclaration(CrossReference<Namespace> ref) {
        super(ref);
    }

    public void addImports(Namespace namespace, String name) {
        List<Namespace> subns = namespace.descendantNamespaces().stream().filter(a -> a.toString().equals(name)).collect(Collectors.toList());
        getImports(namespace, subns).forEach(a -> addImport(new TypeImport(new BasicTypeReference(a))));
    }

    private List<String> getImports(Namespace rootNamespace, List<Namespace> namespaces) {
        List<String> imports = new ArrayList<>();

        if (!namespaces.isEmpty()) {
            for (Namespace namespace : namespaces) {
                imports.addAll(getImports(namespace, namespace.descendantNamespaces()));
            }
        } else {
            for (NamespaceDeclaration ns : rootNamespace.namespaceDeclarations()) {
                imports.addAll(ns.declarations(Type.class).stream().map(toImport -> ns.getFullyQualifiedName() + "." + toImport.name()).collect(Collectors.toList()));
            }
        }

        return imports;
    }
}
