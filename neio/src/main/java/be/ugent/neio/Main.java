package be.ugent.neio;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.kuleuven.cs.distrinet.jnome.output.JavaDocumentWriter;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.language.NeioProjectConfigurator;
import be.ugent.neio.parsing.DocumentConverter;
import be.ugent.neio.parsing.DocumentLexer;
import be.ugent.neio.parsing.DocumentParser;
import org.aikodi.chameleon.core.Config;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.core.namespace.RegularNamespaceFactory;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.plugin.build.DocumentWriter;
import org.aikodi.chameleon.workspace.*;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static be.ugent.neio.util.Constants.AUTO_GEN_DIR;
import static be.ugent.neio.util.Constants.EXTENSION;

public class Main {

    /**
     * args[0] = path for the directory to write output
     * args[1] = input file
     * <p>
     * Exit code 1: Invalid call to program
     * Exit code 2: Input file can not be read or does not exist
     * Exit code 3: Input file has the wrong extension
     * Exit code 4: Could not build everything NEIO_HOME
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            printHelp("neio.jar");
            System.exit(1);
        }

        String fileName = args[1];
        File inputFile = new File(fileName);
        if (!inputFile.isFile() || !inputFile.canRead()) {
            System.err.println(fileName + " isn't a valid folder or it isn't readable.");
            System.exit(2);
        }

        if (!inputFile.getName().endsWith(EXTENSION)) {
            System.err.println(fileName + " doesn't have the right extension.\nThe right extension is: " + EXTENSION);
            System.exit(3);
        }

        Config.setCaching(true);

        LanguageRepository repo = new LanguageRepository();
        Workspace workspace = new Workspace(repo);

        repo.add(new Java7LanguageFactory().create());
        Neio neio = new NeioLanguageFactory().create();
        repo.add(neio);
        ((NeioProjectConfigurator) neio.plugin(ProjectConfigurator.class)).searchInParent();

        File configFile = new File("../base_library/project.xml");
        XMLProjectLoader config = new XMLProjectLoader(workspace);
        Project project = config.project(configFile, null);

        View view = project.views().get(0);
        try {
            List<Document> documents = view.sourceDocuments();
            Document document = documents.get(0);
            translateDocument(inputFile, document.view(JavaView.class), document);
        } catch (InputException e) {
            e.printStackTrace();
        }
        /*LanguageBuilder builder = new NeioBuilder(project.views().get(0));
        try {
            builder.buildAll(new File(AUTO_GEN_DIR), null);
        } catch (BuildException e) {
            e.printStackTrace();
            System.exit(4);
        }*/
    }

    public static void printHelp(String programName) {
        System.out.println("USAGE: java -jar " + programName + " <path-to-outputdir> <path-to-inputfile>");
    }

    public static void translateDocument(File file, JavaView view, Document document) {
        try {
            CharStream input = new ANTLRInputStream(new FileInputStream(file));
            Lexer lexer = new DocumentLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);
            DocumentParser parser = new DocumentParser(tokens);


            //DocumentFactory df = new DocumentFactory();
            //NamespaceDeclaration ns = df.createDocument("be.ugent", view);
            //LanguageDocument document = new LanguageDocument(ns.nearestAncestor(Document.class), new Java7LanguageFactory().create());
            RegularNamespaceFactory ns = new RegularNamespaceFactory();
            Java7 target = new Java7LanguageFactory().create();
            JavaView targetView = new JavaView(new LazyRootNamespace(), target);
            Document newDocument = document.cloneTo(targetView);

            newDocument.namespaceDeclarations().forEach(NamespaceDeclaration::disconnect);
            File output = new File(AUTO_GEN_DIR);
            String name = file.getName().split("\\.")[0];

            DocumentConverter converter = new DocumentConverter(newDocument, view, name);
            Document javaDocument = converter.visitDocument(parser.document());

            DocumentWriter writer = new JavaDocumentWriter(".java");
            writer.write(javaDocument, output);
        } catch (IOException | ModelException e) {
            e.printStackTrace();
        }
    }
}