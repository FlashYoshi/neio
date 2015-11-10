package be.ugent.neio.language;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaProjectConfiguration;
import org.aikodi.chameleon.core.language.Language;
import org.aikodi.chameleon.workspace.ConfigException;
import org.aikodi.chameleon.workspace.FileDocumentLoaderFactory;
import org.aikodi.chameleon.workspace.View;

public class NeioProjectConfiguration extends JavaProjectConfiguration {

    private final String langName;

    public NeioProjectConfiguration(View view, FileDocumentLoaderFactory inputSourceFactory, String langName)
            throws ConfigException {
        super(view, inputSourceFactory);
        this.langName = langName;
    }

    protected Language neio() {
        return language(langName);
    }

}
