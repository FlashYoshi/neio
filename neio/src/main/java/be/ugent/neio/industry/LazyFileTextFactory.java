package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.input.LazyJavaFileInputSourceFactory;
import be.ugent.neio.model.io.LazyFileTextDocumentLoader;
import org.aikodi.chameleon.core.namespace.DocumentLoaderNamespace;
import org.aikodi.chameleon.util.Util;
import org.aikodi.chameleon.workspace.DirectoryScanner;
import org.aikodi.chameleon.workspace.IFileDocumentLoader;
import org.aikodi.chameleon.workspace.InputException;

import java.io.File;

/**
 * @author Titouan Vervack
 */
public class LazyFileTextFactory extends LazyJavaFileInputSourceFactory {

    @Override
    public IFileDocumentLoader create(File file, DirectoryScanner loader) throws InputException {
        DocumentLoaderNamespace currentNamespace = (DocumentLoaderNamespace) currentNamespace();
        String declarationName = Util.getAllButLastPart(file.getName());

        return new LazyFileTextDocumentLoader(file, declarationName, currentNamespace, loader);
    }
}
