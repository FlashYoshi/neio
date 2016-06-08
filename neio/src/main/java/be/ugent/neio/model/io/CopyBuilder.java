package be.ugent.neio.model.io;

import java.util.List;

import java.io.File;

import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.language.Language;
import org.aikodi.chameleon.plugin.ViewPlugin;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.plugin.build.DocumentWriterFactory;
import org.aikodi.chameleon.plugin.build.LanguageBuilder;
import org.aikodi.chameleon.workspace.View;

/**
 * @author Titouan Vervack
 */
public class CopyBuilder extends LanguageBuilder<Language, Language> {

    public CopyBuilder(View view, DocumentWriterFactory dwf) {
        super(view, dwf);
    }

    @Override
    public <T extends ViewPlugin> void setContainer(View view, Class<T> pluginInterface) {
        translator = new CopyTranslator(view, view);
    }

    public void buildAll(List<Document> input, File outputDir, BuildProgressHelper buildProgressHelper) throws BuildException {
        build(input, outputDir, buildProgressHelper);
    }
}
