package be.ugent.neio.industry;

import be.ugent.chameleonsupport.build.DocumentWriterFactory;
import be.ugent.neio.model.io.CopyDocumentWriter;
import org.aikodi.chameleon.plugin.build.DocumentWriter;

/**
 * @author Titouan Vervack
 */
public class CopyDocumentWriterFactory implements DocumentWriterFactory {

    @Override
    public DocumentWriter writer() {
        return new CopyDocumentWriter("");
    }
}
