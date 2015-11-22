package be.ugent.neio;

import be.kuleuven.cs.distrinet.jnome.output.JavaDocumentWriter;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.builder.ClassBuilder;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.parsing.DocumentConverter;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.plugin.build.DocumentWriter;
import org.antlr.v4.runtime.*;
import org.neio.antlr.DocumentLexer;
import org.neio.antlr.DocumentParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

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
        List<Document> documents = builder.build("../base_library/project.xml");

        Document document = documents.get(0);
        translateDocument(inputFile, document.view(JavaView.class), document);
        /*LanguageBuilder builder = new NeioBuilder(view);
        try {
            builder.buildAll(new File(AUTO_GEN_DIR), null);
        } catch (BuildException e) {
            e.printStackTrace();
            System.exit(4);
        }*/
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

    private void translateDocument(File file, JavaView view, Document d) {
        try {
            File output = new File(AUTO_GEN_DIR);
            String name = file.getName().split("\\.")[0];

            Neio target = new NeioLanguageFactory().create();
            JavaView targetView = new JavaView(new LazyRootNamespace(), target);
            TextDocument document = new TextDocument(targetView, d, new Block());

            DocumentParser parser = getParser(file);
            DocumentConverter converter = new DocumentConverter(view, name);
//            Block block = converter.visitDocument(parser.document());
            converter.visitDocument(parser.document(), document.namespaceDeclarations().get(0));

            //document.add(nd);

//            LanguageBuilder builder = new NeioBuilder(document.view(), name, document);
//            try {
//                builder.build(document, output);
//            } catch (BuildException e) {
//                e.printStackTrace();
//                System.exit(4);
//            }
            //Document javaDocument = createJavaDocument;
            DocumentWriter writer = new JavaDocumentWriter(".java");
            //writer.write(javaDocument, output);
            writer.write(document, output);
        } catch (IOException | ModelException e) {
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