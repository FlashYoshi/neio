package be.ugent.neio.model.io;

import be.kuleuven.cs.distrinet.jnome.input.LazyJavaFileInputSourceFactory;
import org.aikodi.chameleon.core.namespace.DocumentLoaderNamespace;
import org.aikodi.chameleon.util.Util;
import org.aikodi.chameleon.workspace.DirectoryScanner;
import org.aikodi.chameleon.workspace.IFileDocumentLoader;
import org.aikodi.chameleon.workspace.InputException;

import java.io.File;

/**
 * @author Titouan Vervack
 */
public class CopyDocumentFactory extends LazyJavaFileInputSourceFactory {

    @Override
    public IFileDocumentLoader create(File file, DirectoryScanner loader) throws InputException {
        DocumentLoaderNamespace currentNamespace = (DocumentLoaderNamespace) currentNamespace();
        String declarationName = Util.getAllButLastPart(file.getName());

        return new CopyDocumentLoader(file, declarationName, currentNamespace, loader);
    }
}
