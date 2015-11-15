package be.ugent.neio;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.ugent.chameleonsupport.build.LanguageBuilder;
import be.ugent.neio.language.Neio;
import be.ugent.neio.language.NeioBuilder;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.NeioProjectConfigurator;
import be.ugent.neio.parsing.DocumentConverter;
import be.ugent.neio.parsing.DocumentLexer;
import be.ugent.neio.parsing.DocumentParser;
import be.ugent.neio.util.Constants;
import org.aikodi.chameleon.core.Config;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.workspace.*;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static be.ugent.neio.util.Constants.AUTO_GEN_DIR;

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

        if (!inputFile.getName().endsWith(Constants.EXTENSION)) {
            System.err.println(fileName + " doesn't have the right extension.\nThe right extension is: " + Constants.EXTENSION);
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

        LanguageBuilder builder = new NeioBuilder(project.views().get(0));
        try {
            builder.buildAll(new File(AUTO_GEN_DIR), null);
        } catch (BuildException e) {
            e.printStackTrace();
            System.exit(4);
        }

        visitDocument(inputFile);
    }

    public static void printHelp(String programName) {
        System.out.println("USAGE: java -jar " + programName + " <path-to-outputdir> <path-to-inputfile>");
    }

    public static void visitDocument(File file) {
        try {
            CharStream input = new ANTLRInputStream(new FileInputStream(file));
            Lexer lexer = new DocumentLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);
            DocumentParser parser = new DocumentParser(tokens);
            DocumentConverter converter = new DocumentConverter();
            converter.visitDocument(parser.document());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}