/**
 * CPSC 319 - Assignment 2
 * Dylan Mah(30086580)
 *
 * This is the main class that will read inputs from a file, sort those inputs and write the sorted values to another
 * file. Note: Requires LinkedList.java to be in the same directory to work!
 */

// https://stackoverflow.com/questions/29869094/bubble-sort-manually-a-linked-list-in-java
// https://www.devglan.com/datastructure/linkedlist-implementation-java

import java.io.*;
import java.util.Scanner;

public class ConfusedSorter{
    public static LinkedList sort(LinkedList arg, boolean descending){
        // Sorts list from largest to smallest (descending order) if boolean is true
        // Sorts list from smallest to largest (ascending order) if boolean is false
        LinkedList sorted=arg;
        Node unsortedHead=sorted.head;          // Similar to array[i]

        while(unsortedHead != null){
            Node nextNode=unsortedHead.next;    // Similar to array[j], where j=i+1

            while(nextNode != null){
                double value1=unsortedHead.data;
                double value2=nextNode.data;

                if(descending) {
                    if(value1 < value2) {
                        // Swap values if not in descending order
                        double hold=unsortedHead.data;
                        unsortedHead.data=nextNode.data;
                        nextNode.data=hold;
                    }
                }

                else{
                    if(value1 > value2) {
                        // Swap values if not in ascending order
                        double hold=unsortedHead.data;
                        unsortedHead.data=nextNode.data;
                        nextNode.data=hold;
                    }
                }

                nextNode=nextNode.next;         // Move to next element
            }

            unsortedHead=unsortedHead.next;     // Move to next element
        }

        return sorted;
    }

    // Function will throw an exception if the scanner cannot read the specified file or the buffered writer cannot
    // write to the specified file (system memory may be full and prevent the creation/update of the file)
    public static void fileIO(File inFile, File outFile)throws IOException{
        if(outFile.length()!= 0){
            // Clearing output file contents if they exist
            FileWriter empty=new FileWriter(outFile);
            empty.flush();
            empty.close();
        }

        if(inFile.length()==0){
            // If input file consists of only one blank line (i.e. it is empty)...
            throw new IOException("Input file cannot be blank");
        }

        LinkedList unsorted=new LinkedList();       // Contains original data
        LinkedList sorted=new LinkedList();         // Contains sorted data

        try{
            // Try to read and write to the specified files
            Scanner scanner=new Scanner(inFile);
            BufferedWriter bw=new BufferedWriter(new FileWriter(outFile, true));
            String scannedLine;
            boolean found666=false;     // Boolean to check if the input file contains any number of 666

            while(scanner.hasNextLine()){
                scannedLine=scanner.nextLine();

                // Insert decimals in place of symbols(with values that match assignment description)
                if(scannedLine.equals("Do")){
                    unsorted.insert(0.1);
                }

                else if(scannedLine.equals("Re")){
                    unsorted.insert(100.1);
                }

                else if(scannedLine.equals("Mi")){
                    unsorted.insert(1000.1);
                }

                else if(scannedLine.equals("&")){
                    unsorted.insert(3.2);
                }

                else if(scannedLine.equals("@")){
                    unsorted.insert(3.1);
                }

                else if(scannedLine.equals("%")){
                    unsorted.insert(1005000.1);
                }

                else if(scannedLine.equals("Asymbolwithareallylongname")){
                    unsorted.insert(55.1);
                }

                else if(scannedLine.equals("$")){
                    unsorted.insert(20.1);
                }

                else if(scannedLine.equals("Fa")){
                    unsorted.insert(15.1);
                }

                else if(scannedLine.equals("One")){
                    unsorted.insert(103.1);
                }

                else if(scannedLine.equals("Two")){
                    unsorted.insert(103.2);
                }

                else if(scannedLine.equals("Three")){
                    unsorted.insert(103.3);
                }

                else if(scannedLine.matches("^\\d+$") && !(scannedLine.charAt(0) == '0' && scannedLine.length() > 1)){
                    // If the input line is NOT a symbol, check if it is a natural number (zero or positive integer) 
                    // with no leading zeros
                    if(scannedLine.equals("666")){
                        // If the number is 666, don't add it to the list, but update a boolean to say that it exists
                        found666=true;
                    }

                    else{
                        // If the number is NOT 666, add it to the list
                        unsorted.insert(Integer.parseInt(scannedLine));
                    }
                }

                else{
                    // If input line is NOT a symbol or natural number or it has leading zeros...
                    bw.write("Input error.");
                    bw.close();             // Need to close the scanner to prevent memory leaks
                    scanner.close();        // Need to close the buffered writer so the String is written to the output file
                    System.exit(0);
                }
            }

            scanner.close();

            /*
            // Didn't work if 666 was at the end of the input file
            if(unsorted.findElement(666)){
                unsorted.deleteAllElement(666);
                unsorted.insert(3.1);
                sorted=cs.sortListAscending(unsorted);
            }
            */

            if(found666){
                // If there is at least one 666 in the list, add one "@" and sort in ascending order
                unsorted.insert(3.1);                   // Insert one "@" into list
                sorted=sort(unsorted, false);
            }

            else{
                // If there were no 666s in the input, sort list (no added or deleted elements) in descending order
                sorted=sort(unsorted, true);
            }

            // Getting sorted list as an array of Strings
            String[] sortedValues=sorted.getListValues();

            for(int i=0; i < sortedValues.length; i++){
                // Loop to output sorted items to the provided output file
                if(i > 0){
                    // Adds new line if String is NOT on the first line
                    bw.newLine();
                }

                bw.write(sortedValues[i]);
            }

            bw.close();
        }

        catch(FileNotFoundException e){
            // If input or output file could not be found...
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws IOException{
        double start=System.nanoTime();
        File input=new File(args[0]);       // Storing name of input file
        File output=new File(args[1]);      // Storing name of output file

        fileIO(input, output);

        System.out.println("Execution time: " + (System.nanoTime() - start)/1000000000 + "s");
    }
}

// javac ConfusedSorter.java
// java ConfusedSorter randomInputs.txt output.txt
// java ConfusedSorter inputWithSymbols.txt output.txt
// java ConfusedSorter testInput.txt output.txt

// java ConfusedSorter test19.txt output.txt