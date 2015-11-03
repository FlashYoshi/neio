package be.ugent.thesis;

import be.ugent.thesis.parsing.*;
import be.ugent.thesis.util.Constants;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

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
            printHelp("thesis.jar");
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

        visitClass(file, fileName);
    }

    public static void printHelp(String programName) {
        System.out.println("USAGE: java -jar " + programName + " <path-to-inputfile>");
    }

    public static void visitClass(File file, String fileName) {
        try {
            CharStream input = new ANTLRInputStream(new FileInputStream(file));
            ThesisClassLexer lexer = new ThesisClassLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ThesisClassParser parser = new ThesisClassParser(tokens);
            ClassConverter converter = new ClassConverter();
            String klassName = fileName.substring(fileName.lastIndexOf('/') + 1);
            klassName = klassName.split("\\.java")[0];
            converter.visitDocument(parser.document(), klassName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}