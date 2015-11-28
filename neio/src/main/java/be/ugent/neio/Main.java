package be.ugent.neio;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.chameleonsupport.build.LanguageBuilder;
import be.ugent.neio.builder.ClassBuilder;
import be.ugent.neio.builder.NeioBuilder;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.parsing.DocumentConverter;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.workspace.View;
import org.antlr.v4.runtime.*;
import org.neio.antlr.DocumentLexer;
import org.neio.antlr.DocumentParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static be.ugent.neio.util.Constants.AUTO_GEN_DIR;
import static be.ugent.neio.util.Constants.EXTENSION;

public class Main {

    /**
     * args[1] = input file
     * <p>
     * Exit code 1: Invalid call to program
     * Exit code 2: Input file can not be read or does not exist
     * Exit code 3: Input file has the wrong extension
     * Exit code 4: Could not build everything in NEIO_HOME
     */
    public static void main(String[] args) {
        new Main().read(args);
    }

    private void read(String[] args) {
        File inputFile = getInputFile(args);
        ClassBuilder builder = new ClassBuilder();
        View view = builder.build("../base_library/project.xml");
        // Creates the Java files for the Neio class files
        // Not needed for now as we're just trying to create a non-working java file
        /*LanguageBuilder builder = new NeioBuilder(view);
        try {
            builder.buildAll(new File(AUTO_GEN_DIR), null);
        } catch (BuildException e) {
            e.printStackTrace();
            System.exit(4);
        }*/

        translateDocument(inputFile, (JavaView) view);
    }

    private File getInputFile(String[] args) {
        if (args.length < 1) {
            printHelp("neio.jar");
            System.exit(1);
        }

        String fileName = args[0];
        File inputFile = new File(fileName);
        if (!inputFile.isFile() || !inputFile.canRead()) {
            System.err.println(fileName + " isn't a valid folder or it isn't readable.");
            System.exit(2);
        }

        if (!inputFile.getName().endsWith(EXTENSION)) {
            System.err.println(fileName + " doesn't have the right extension.\nThe right extension is: " + EXTENSION);
            System.exit(3);
        }

        return inputFile;
    }

    private void printHelp(String programName) {
        System.out.println("USAGE: java -jar " + programName + " <path-to-outputdir> <path-to-inputfile>");
    }

    private void translateDocument(File file, JavaView view) {
        try {
            File output = new File(AUTO_GEN_DIR);
            String name = file.getName().split("\\.")[0];

            DocumentParser parser = getParser(file);
            DocumentConverter converter = new DocumentConverter(view, name);
            TextDocument document = converter.visitDocument(parser.document());

            LanguageBuilder builder = new NeioBuilder(document.view(), name, false);
            try {
                builder.build(document, output);
            } catch (BuildException e) {
                e.printStackTrace();
                System.exit(4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DocumentParser getParser(File file) throws IOException {
        CharStream input = new ANTLRInputStream(new FileInputStream(file));
        Lexer lexer = new DocumentLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);

        return new DocumentParser(tokens);
    }
}