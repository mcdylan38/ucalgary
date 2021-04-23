/**
 * CPSC 319 - Assignment 3
 * Dylan Mah (30086580)
 *
 * Note: This file must be used alongside CustomTernaryTree.java and Commands.java to execute the program. Make sure
 * all files are in the same directory when trying to compile and run the program!
 **/

import java.io.*;

public class Runner{
    public static void main(String[] args) throws IOException{
        // Calling static function to read and/or write to a file based on the inputs read. Command line arguments are
        // used to make new File objects and passed as arguments to the function.
        Commands.fileIO(new File(args[0]), new File(args[1]));
        System.out.println(" ~~~ File read with no errors encountered! ~~~");
    }
}   // End of class

/*
 javac Runner.java
 java Runner input1.txt output.txt
 java Runner input2.txt output.txt
*/