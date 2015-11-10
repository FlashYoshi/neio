package be.ugent.neio.language;

import be.kuleuven.cs.distrinet.jnome.input.LazyJavaFileInputSourceFactory;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaProjectConfiguration;
import be.kuleuven.cs.distrinet.rejuse.predicate.SafePredicate;
import be.ugent.neio.chameleonCommon.language.BaseLibraryJavaProjectConfigurator;
import org.aikodi.chameleon.core.language.Language;
import org.aikodi.chameleon.workspace.*;

import static be.ugent.neio.util.Constants.*;

public class NeioProjectConfigurator extends BaseLibraryJavaProjectConfigurator {

    private final String langName = LANG_NAME;

    /**
     * Set baseLibraryInParent to true when running from class files outside eclipse.
     * Set baseLibraryInParent to false when running from class files inside eclipse.
     * When run from a jar, the base library is located correctly.
     */
    public NeioProjectConfigurator() {
        super();
    }

    @Override
    protected JavaProjectConfiguration createProjectConfig(View view) throws ConfigException {
        return new NeioProjectConfiguration(view, new LazyJavaFileInputSourceFactory(), langName);
    }

    @Override
    protected void addBaseLibraries(View view, BaseLibraryConfiguration baseLibraryConfiguration) {
        super.addBaseLibraries(view, baseLibraryConfiguration);

        LanguageBaseLibraryConfigurator neioBaseLibraryConfigurator = new LanguageBaseLibraryConfigurator(language(), NEIO_HOME);
        neioBaseLibraryConfigurator.process(view, baseLibraryConfiguration);
    }

    @Override
    public SafePredicate<? super String> sourceFileFilter() {
        return new ExtensionPredicate(EXTENSION);
    }

    protected Language neio(Workspace workspace) {
        return language(langName, workspace);
    }
}
