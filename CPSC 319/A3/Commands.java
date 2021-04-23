/**
 * CPSC 319 - Assignment 3
 * Dylan Mah (30086580)
 *
 * Note: This file must be used alongside CustomTernaryTree.java and Runner.java to execute the program. Make sure
 * all files are in the same directory when trying to compile and run the program!
 **/

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

// All characters (excluding whitespaces) are valid arguments for Strings a and b!!!!!
// No spaces between args (ex. a,_b) allowed. This should cause an input error.
// Any commas BEFORE String b are part of String a. Any commas AFTER b are part of String b.
// String b cannot only consist of only "," or "$". These are regarded as empty arguments.

public class Commands{
    // Function to handle reading of inputs and printing of outputs (either error messages or values from tree)
    public static void fileIO(File inFile, File outFile) throws IOException{
        boolean outFileUpdated=false;   // Flag to see if the output file has been written to

        if(outFile.length() != 0){
            // Clearing output file contents if they exist
            FileWriter empty=new FileWriter(outFile);
            empty.flush();
            empty.close();
        }

        if(inFile.length()==0){
            // If input file consists of only one blank line (i.e. it is empty)...
            throw new IOException("Input file cannot be blank");
        }

        try{
            // Try to read from and write to the specified files
            CustomTernaryTree ctt=new CustomTernaryTree();
            Scanner scanner=new Scanner(inFile);
            BufferedWriter bWriter=new BufferedWriter(new FileWriter(outFile, true));
            // Regex to check if both arguments have no whitespaces and are in the format "(a,b)"
            Pattern p1=Pattern.compile("\\(([^\\s]+),([^\\s]+)\\)");
            // Regex to check if single arg has no whitespaces
            Pattern p2=Pattern.compile("\\(([^\\s]+)\\)");
            String a="", b="", scannedLine;

            while(scanner.hasNextLine()){
                scannedLine=scanner.nextLine();
                Matcher m1=p1.matcher(scannedLine);
                Matcher m2=p2.matcher(scannedLine);

                if(!scannedLine.endsWith(")")){
                    // If the input command has characters AFTER the closing brace...
                    if(outFileUpdated){
                        // Add a new line before error message outputs already exist
                        bWriter.newLine();
                    }

                    //System.out.println("Input doesn't end with closing brace");
                    bWriter.write("Input error.");
                    bWriter.close();        // Need to close scanner to prevent memory leaks
                    scanner.close();        // Need to close writer so error message is written to the output file
                    System.exit(0);
                }

                if(m1.find()){
                    // If the add or exchange commands have arguments in correct format, set Strings a and b to those
                    // values
                    a=m1.group(1);
                    b=m1.group(2);

                    if(b.equals(",") || b.equals("$")){
                        // If the String b only consists of "," or "$", the argument is invalid because it is
                        // considered empty
                        if(outFileUpdated){
                            // Add a new line before error message outputs already exist
                            bWriter.newLine();
                        }

                        //System.out.println("Argument b cannot only contain '$' or ','");
                        bWriter.write("Input error.");
                        bWriter.close();        // Need to close scanner to prevent memory leaks
                        scanner.close();        // Need to close writer so error message is written to the output file
                        System.exit(0);
                    }
                }

                else if(m2.find()){
                    // If the delete command has argument in correct format, set String a to that value
                    a=m2.group(1);
                }

                if((a.isEmpty() || b.isEmpty()) && !scannedLine.equals("Print()")){
                    // If both regex checks failed and the command print is NOT called...
                    if(outFileUpdated){
                        // Add a new line before error message outputs already exist
                        bWriter.newLine();
                    }

                    //System.out.println("Invalid argument format");
                    bWriter.write("Input error.");
                    bWriter.close();        // Need to close scanner to prevent memory leaks
                    scanner.close();        // Need to close writer so error message is written to the output file
                    System.exit(0);
                }

                //System.out.println(a + " | " + b);

                if(scannedLine.contains("AddL")){
                    ctt.add(a, b, "left");

                    if(!ctt.output.isEmpty()){
                        // Print error message only if add function could not create subtree
                        if(outFileUpdated){
                            // Add a new line before error message outputs already exist
                            bWriter.newLine();
                        }

                        bWriter.write(ctt.output);
                        outFileUpdated=true;
                    }
                }

                else if(scannedLine.contains("AddM")){
                    ctt.add(a, b, "middle");

                    if(!ctt.output.isEmpty()){
                        // Print error message only if add function could not create subtree
                        if(outFileUpdated){
                            // Add a new line before error message outputs already exist
                            bWriter.newLine();
                        }

                        bWriter.write(ctt.output);
                        outFileUpdated=true;
                    }
                }

                else if(scannedLine.contains("AddR")){
                    ctt.add(a, b, "right");

                    if(!ctt.output.isEmpty()){
                        // Print error message only if add function could not create subtree
                        if(outFileUpdated){
                            // Add a new line before error message outputs already exist
                            bWriter.newLine();
                        }

                        bWriter.write(ctt.output);
                        outFileUpdated=true;
                    }
                }

                else if(scannedLine.contains("Exchange")){
                    ctt.exchange(ctt.root, a, b);
                }

                else if(scannedLine.contains("DelL")){
                    ctt.delete(a, "left");
                }

                else if(scannedLine.contains("DelM")){
                    ctt.delete(a, "middle");
                }

                else if(scannedLine.contains("DelR")){
                    ctt.delete(a, "right");
                }

                else if(scannedLine.equals("Print()")){
                    if(outFileUpdated){
                        // Add a new line before printing if an output already exists
                        bWriter.newLine();
                    }

                    ctt.print();
                    // length() - 1 will remove the last "\n" character
                    bWriter.write(ctt.output.substring(0, ctt.output.length() - 1));
                    outFileUpdated=true;
                }

                else{
                    // If the input command is invalid, print error message and terminate program
                    if(outFileUpdated){
                        // Add a new line before error message if an output already exists
                        bWriter.newLine();
                    }

                    //System.out.println("Invalid input format");
                    bWriter.write("Input error.");
                    bWriter.close();        // Need to close scanner to prevent memory leaks
                    scanner.close();        // Need to close writer so error message is written to the output file
                    System.exit(0);
                }
            }

            // If there were no errors, close the scanner and buffered writer after all inputs have been read
            scanner.close();
            bWriter.close();
        }

        catch(FileNotFoundException e){
            // If input file doesn't exist, throw an exception
            e.printStackTrace();
        }
    }
}   // End of class
