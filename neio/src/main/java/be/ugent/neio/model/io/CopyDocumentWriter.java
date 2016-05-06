package be.ugent.neio.model.io;

import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.plugin.LanguagePluginImpl;
import org.aikodi.chameleon.plugin.build.DocumentWriter;
import org.aikodi.chameleon.workspace.IFileDocumentLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Copies a given document exactly
 *
 * @author Titouan Vervack
 */
public class CopyDocumentWriter extends DocumentWriter {

    /**
     * Create a new document writer that writes files with the
     * same extension as the input file.
     *
     * @param extension The extension of the output files.
     */
    public CopyDocumentWriter(String extension) {
        super(extension);
    }

    public void copyFile(Path sourceFile, File destFile) throws IOException {
        Files.copy(sourceFile, new FileOutputStream(destFile));
    }

    @Override
    public String fileName(Document document) throws ModelException {
        return ((IFileDocumentLoader) document.loader()).file().getName();
    }

    @Override
    public String directoryName(Document document) throws ModelException {
        return ".";
    }

    @Override
    public LanguagePluginImpl clone() {
        return new CopyDocumentWriter(extension());
    }

    @Override
    public File write(Document document, File outputDir) throws ModelException, IOException {
        File out = new File(outputDir.getAbsolutePath() + File.separatorChar + fileName(document));
        Files.copy(((IFileDocumentLoader) document.loader()).file().getAbsoluteFile().toPath(), new FileOutputStream(out));
        System.out.println("Wrote: " + out.getAbsolutePath());
        return out;
    }
}
