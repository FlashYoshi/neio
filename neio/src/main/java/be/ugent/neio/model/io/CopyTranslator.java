package be.ugent.neio.model.io;

import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.language.Language;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.support.translate.IncrementalTranslator;
import org.aikodi.chameleon.workspace.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public class CopyTranslator extends IncrementalTranslator<Language, Language> {
    /**
     * Create a new incremental translator that translates documents from the given
     * source view into the given target view.
     *
     * @param source The source view
     * @param target The target view to which translated documented must be added.
     */
    public CopyTranslator(View source, View target) {
        super(source, target);
    }

    @Override
    public Collection<Document> build(Document source, BuildProgressHelper buildProgressHelper) throws BuildException {
        List<Document> l = new ArrayList<>();
        l.add(source);

        return l;
    }
}
