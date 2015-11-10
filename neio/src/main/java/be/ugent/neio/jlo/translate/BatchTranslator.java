package be.ugent.neio.jlo.translate;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.ugent.neio.chameleonCommon.build.LanguageBuilder;
import be.ugent.neio.jlo.build.JLoBuilder;
import be.ugent.neio.jlo.model.language.JLo;
import be.ugent.neio.jlo.model.language.JLoLanguageFactory;
import be.ugent.neio.jlo.model.language.JLoProjectConfigurator;
import be.ugent.neio.jlo.model.type.RegularJLoType;
import org.aikodi.chameleon.core.Config;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.input.ParseException;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.test.provider.BasicDescendantProvider;
import org.aikodi.chameleon.test.provider.ElementProvider;
import org.aikodi.chameleon.workspace.*;

import java.io.File;
import java.io.IOException;

/**
 * A class for building all classes in a project.
 *
 * @author Marko van Dooren
 */
public class BatchTranslator {

    private File _outputDir;
    private LanguageBuilder _builder;
    private View _sourceView;
    private ElementProvider<RegularJLoType> _typeProvider;

    public BatchTranslator(View view, ElementProvider<Namespace> namespaceProvider, File outputDir) throws ParseException, IOException {
        _sourceView = view;
        _typeProvider = new BasicDescendantProvider<RegularJLoType>(namespaceProvider, RegularJLoType.class);
        _builder = new JLoBuilder(_sourceView);
        _outputDir = outputDir;
    }

    /**
     * args[0] = path for the directory to write output
     * args[1] = path to read input files
     * ...1 or more input paths possible...
     * args[i] = fqn of package to read, let this start with "@" to read the package recursively
     * ...1 or more packageFqns possible...
     * args[n] = fqn of package to read, let this start with "#" to NOT read the package recursively.
     * ...1 or more packageFqns possible...
     * <p>
     * Example
     * java Copy outputDir apiInputDir customInputDir1 customInputDir2 @myPackage.subPackage
     */
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java .... JavaTranslator projectXML outputDir @recursivePackageFQN*"); // #packageFQN* $typeFQN*
        }
        Config.setCaching(true);

        LanguageRepository repo = new LanguageRepository();
        Workspace workspace = new Workspace(repo);

        repo.add(new Java7LanguageFactory().create());
        JLo jlo = new JLoLanguageFactory().create();
        repo.add(jlo);
        ((JLoProjectConfigurator) jlo.plugin(ProjectConfigurator.class)).searchInParent();
        File configFile = new File(args[0]);
        XMLProjectLoader config = new XMLProjectLoader(workspace);
        try {
            Project project = config.project(configFile, null);
            // Attach the builder
            LanguageBuilder builder = new JLoBuilder(project.views().get(0));
            // build!
            try {
                builder.buildAll(new File(args[1]), null);
                System.out.println("Done building.");
            } catch (org.aikodi.chameleon.plugin.build.BuildException e) {
                throw new BuildException(e);
            }
        } catch (ConfigException e) {
            throw new BuildException(e);
        }
    }

    public LanguageBuilder builder() {
        return _builder;
    }

    public View sourceProject() {
        return _sourceView;
    }

    public ElementProvider<? extends Type> typeProvider() {
        return _typeProvider;
    }

    public void translate() throws BuildException {
        for (Type type : typeProvider().elements(sourceProject())) {
            // The second argument is never used for the JLo translation, but for now it must be present because otherwise the
            // aspect weaver does not know which compilation units are present in the project.
            Document compilationUnit = type.nearestAncestor(Document.class);
            compilationUnit.verify();
            _builder.build(compilationUnit, _outputDir);
        }
    }

}
