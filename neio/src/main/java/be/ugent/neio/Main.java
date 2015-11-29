package be.ugent.neio;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.chameleonsupport.build.LanguageBuilder;
import be.ugent.neio.builder.ClassBuilder;
import be.ugent.neio.builder.NeioBuilder;
import be.ugent.neio.industry.LazyFileTextFactory;
import be.ugent.neio.industry.NeioDocumentModelFactory;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.input.ModelFactory;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.workspace.*;

import java.io.File;

import static be.ugent.neio.util.Constants.AUTO_GEN_DIR;
import static be.ugent.neio.util.Constants.EXTENSION;

public class Main {

    /**
     * args[1] = input file
     * <p>
     * Exit code 1: Invalid call to program
     * Exit code 2: Input path can not be read or does not exist
     * Exit code 3: Could not build everything in NEIO_HOME
     * Exit code 4: Could not build everything in input path
     */
    public static void main(String[] args) {
        new Main().read(args);
    }

    private void read(String[] args) {
        String inputPath = getInputPath(args);
        ClassBuilder builder = new ClassBuilder();
        View view = builder.build("../base_library/project.xml");
        // Creates the Java files for the Neio class files
        // Not needed for now as we're just trying to create a non-working java file
        /*LanguageBuilder builder = new NeioBuilder(view);
        try {
            builder.buildAll(new File(AUTO_GEN_DIR), null);
        } catch (BuildException e) {
            e.printStackTrace();
            System.exit(3);
        }*/

        translateDocuments(inputPath, (JavaView) view);
    }

    private String getInputPath(String[] args) {
        if (args.length < 1) {
            printHelp("neio.jar");
            System.exit(1);
        }

        String path = args[0];
        File inputFile = new File(path);
        if (!inputFile.isDirectory() || !inputFile.canRead()) {
            System.err.println(path + " isn't a valid folder or it isn't readable.");
            System.exit(2);
        }

        return path;
    }

    private void printHelp(String programName) {
        System.out.println("USAGE: java -jar " + programName + " <path-to-outputdir> <path-to-inputfile-directory>");
    }

    private void translateDocuments(String inputPath, JavaView view) {
        try {
            File output = new File(AUTO_GEN_DIR);

            // We're done scanning Neio class files, change the classparser to the documentparser
            view.language().setPlugin(ModelFactory.class, new NeioDocumentModelFactory());
            DirectoryScanner scanner = new DirectoryScanner(inputPath,
                    new ExtensionPredicate(EXTENSION), new LazyFileTextFactory());
            view.addSource(scanner);


            for (Document doc : scanner.documents()) {
                TextDocument document = (TextDocument) doc;
                LanguageBuilder builder = new NeioBuilder(document.view(), false);
                try {
                    builder.build(document, output);
                } catch (BuildException e) {
                    e.printStackTrace();
                    System.exit(4);
                }
            }
        } catch (InputException | ProjectException e) {
            e.printStackTrace();
        }
    }
}