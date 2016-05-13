package be.ugent.neio.builder;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.language.NeioProjectConfigurator;
import org.aikodi.chameleon.core.Config;
import org.aikodi.chameleon.workspace.*;

import java.io.File;

/**
 * @author Titouan Vervack
 */
public class NeioProjectBuilder {

    public View build(String configfilePath) {
        Config.setCaching(true);
        LanguageRepository repo = new LanguageRepository();
        Workspace workspace = new Workspace(repo);

        Java7 java = new Java7LanguageFactory().create();
        Neio neio = new NeioLanguageFactory().create();
        repo.add(neio);
        repo.add(java);
        ((NeioProjectConfigurator) neio.plugin(ProjectConfigurator.class)).searchInParent();

        File configFile = new File(configfilePath);
        XMLProjectLoader config = new XMLProjectLoader(workspace);
        Project project = config.project(configFile, null);
        return project.views().get(0);
    }
}
