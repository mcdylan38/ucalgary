/**
 * ENSF 409 - Assignment 7
 * Dylan Mah (30086580)
 * Version: 1.0
 * Since: 1.0
 */

// https://stackoverflow.com/questions/20386335/printing-out-unicode-from-java-code-issue-in-windows-console
// No file extensions should be in command line argument (ex. do "en-US" instead of "en-US.txt")

package edu.ucalgary.ensf409;

import java.io.*;

public class DayMemory{
    /* main
     * Accept a command-line argument which specifies a translation file. The argument should be in the form of a
     * two-letter language code, followed by a dash and a two-letter region code, e.g. en-US, which corresponds with
     * files en-US.txt and en-US.ser. If no argument is specified, it throws a custom exception,
     * CommandArgumentNotProvidedException. Additional arguments are ignored.
     */
    public static void main(String[] args) throws CommandArgumentNotProvidedException, IOException, ArgFileNotFoundException{
        if(args.length==0){
            // If no command line arguments are given...
            throw new CommandArgumentNotProvidedException();
        }

        String input=args[0];
        Translator translator=new Translator(input);
        System.out.println(translator.translate(3, 8, 2021));
        translator.serialize();
    }
}

// javac edu/ucalgary/ensf409/DayMemory.java
// java -Dfile.encoding=UTF-8 edu.ucalgary.ensf409.DayMemory edu/ucalgary/ensf409/es-BO
// Use "chcp 65001" for Greek letters