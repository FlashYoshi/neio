package be.ugent.neio.industry;

import org.aikodi.chameleon.plugin.build.DocumentWriter;
import org.aikodi.chameleon.plugin.build.DocumentWriterFactory;

import be.ugent.neio.model.io.CopyDocumentWriter;

/**
 * @author Titouan Vervack
 */
public class CopyDocumentWriterFactory implements DocumentWriterFactory {

    @Override
    public DocumentWriter writer() {
        return new CopyDocumentWriter("");
    }
}
