package be.ugent.neio.model.io;

import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.namespace.DocumentLoaderNamespace;
import org.aikodi.chameleon.input.ModelFactory;
import org.aikodi.chameleon.workspace.DocumentScanner;
import org.aikodi.chameleon.workspace.InputException;
import org.aikodi.chameleon.workspace.LazyFileDocumentLoader;

import java.io.File;
import java.io.InputStream;

/**
 * @author Titouan Vervack
 */
public class LazyFileTextDocumentLoader extends LazyFileDocumentLoader {

    public LazyFileTextDocumentLoader(File file, String declarationName, DocumentLoaderNamespace ns, DocumentScanner scanner) throws InputException {
        super(file, declarationName, ns, scanner);
    }

    @Override
    public void doRefresh() throws InputException {
        if (rawDocument() == null) {
            setDocument(new TextDocument());
        } else {
            //FIXME I think this should call disconnectChildren() instead.
            rawDocument().disconnect();
        }
        try {
            InputStream inputStream = inputStream();
            TextDocument document = (TextDocument) rawDocument();
            document.setName(declarationName());
            namespace().language().plugin(ModelFactory.class).parse(inputStream, rawDocument());
        } catch (Exception e) {
            throw new InputException(e);
        }
    }
}
