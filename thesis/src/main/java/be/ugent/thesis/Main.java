package be.ugent.thesis;

import java.io.File;

public class Main {

    /**
     * Exit code 1: Invalid call to program
     * Exit code 2: Input file can not be read or does not exist
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
    }

    public static void printHelp(String programName) {
        System.out.println("USAGE: java -jar " + programName + " <path-to-inputfile>");
    }

}
