package be.ugent.neio.language;

import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.language.Language;

/**
 * @author Titouan Vervack
 */
public class LanguageDocument extends Document {

    private Language language;

    public LanguageDocument(Document d, Language language) {
        d.namespaceDeclarations().forEach(this::add);
        this.language = language;
    }

    @Override
    public Language language() {
        return language;
    }
}
