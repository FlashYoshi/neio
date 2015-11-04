package be.ugent.neio;

import be.ugent.neio.parsing.*;
import be.ugent.neio.util.Constants;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    /**
     * Exit code 1: Invalid call to program
     * Exit code 2: Input file can not be read or does not exist
     * Exit code 3: Input file has the wrong extension
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            printHelp("neio.jar");
            System.exit(1);
        }

        String fileName = args[0];
        File file = new File(fileName);
        if (!file.isFile() || !file.canRead()) {
            System.err.println(fileName + " isn't a valid file or it isn't readable.");
            System.exit(2);
        }

        if (!file.getName().endsWith(Constants.EXTENSION)) {
            System.err.println(fileName + " doesn't have the right extension.\nThe right extension is: " + Constants.EXTENSION);
            System.exit(3);
        }

        visitScript(file);
    }

    public static void printHelp(String programName) {
        System.out.println("USAGE: java -jar " + programName + " <path-to-inputfile>");
    }

    public static void visitClass(File file, String fileName) {
        try {
            CharStream input = new ANTLRInputStream(new FileInputStream(file));
            Lexer lexer = new NeioClassLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);
            NeioClassParser parser = new NeioClassParser(tokens);
            ClassConverter converter = new ClassConverter();
            String klassName = fileName.substring(fileName.lastIndexOf('/') + 1);
            klassName = klassName.split("\\.java")[0];
            converter.visitDocument(parser.document(), klassName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void visitScript(File file) {
        try {
            CharStream input = new ANTLRInputStream(new FileInputStream(file));
            Lexer lexer = new NeioScriptLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);
            NeioScriptParser parser = new NeioScriptParser(tokens);
            ScriptConverter converter = new ScriptConverter();
            converter.visitDocument(parser.document());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}