package be.ugent.neio.builder;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.language.NeioProjectConfigurator;
import org.aikodi.chameleon.core.Config;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.plugin.output.Syntax;
import org.aikodi.chameleon.workspace.*;

import java.io.File;

/**
 * @author Titouan Vervack
 */
public class ClassBuilder {

    public View build(String configfilePath) {
        Config.setCaching(true);
        LanguageRepository repo = new LanguageRepository();
        Workspace workspace = new Workspace(repo);

        repo.add(new Java7LanguageFactory().create());
        Neio neio = new NeioLanguageFactory().create();
        repo.add(neio);
        ((NeioProjectConfigurator) neio.plugin(ProjectConfigurator.class)).searchInParent();

        File configFile = new File(configfilePath);
        XMLProjectLoader config = new XMLProjectLoader(workspace);
        Project project = config.project(configFile, null);
        View view = project.views().get(0);

        try {
            for (Document document : view.sourceDocuments()) {
                System.out.println(neio.plugin(Syntax.class).toCode(document));
            }

        } catch (InputException | ModelException e) {
            e.printStackTrace();
        }

        return view;
    }
}
