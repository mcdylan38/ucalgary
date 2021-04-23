/**
 * Dylan Mah (30086580)
 * CPSC 319 Assignment 1 - Confused Stack
 **/

import java.util.regex.*;
import java.util.Scanner;
import java.io.*;

class Node{
    private int data;
    private Node next;

    public Node(int data){
        this.data=data;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next=next;
    }
}

public class ConfusedStack{
    int size=0;
    Node end=null;

    public void push(int toAdd){
        Node newNode=new Node(toAdd);
        newNode.setNext(end);
        end=newNode;
        size++;
    }

    public int pop(){
        Node hold=end;
        end=end.getNext();
        size--;
        return hold.getData();
    }

    public int top(){
        return end.getData();
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public static void callsFromFile(File inputFile, File outputFile){
        ConfusedStack cs=new ConfusedStack();

        try{
            Scanner scanner=new Scanner(inputFile);

            while(scanner.hasNextLine()){
                String scannedLine=scanner.nextLine();

                if(scannedLine.contains("push")){
                    /*
                    if(scannedLine.contains(" ") || scannedLine.contains("\t")){
                        // if the scanned line contains a whitespace after "push"...
                        outputToFile(outputFile, "Imput error.");
                        System.exit(0);
                    }

                    for(int i=4; i < scannedLine.length(); i++){        // i = 4 makes the loop check AFTER the opening bracket
                        if(Character.isLetter(scannedLine.charAt(i))){
                            // if there are non-numeric characters as the argument to push...
                            outputToFile(outputFile, "Imput error.");
                            System.exit(0);
                        }

                        if(scannedLine.charAt(i) == ')'){
                            if (i + 1 > scannedLine.length()){
                                // if the string continues AFTER the closing bracket...
                                outputToFile(outputFile, "Imput error.");
                                System.exit(0);
                            }
                        }
                    }
                    */

                    int arg=0;
                    String input="";

                    Pattern p=Pattern.compile("[(][\\d]+[)]$");
                    Matcher m=p.matcher(scannedLine);

                    if(m.find()){
                        // using regex to remove anything that is not a digit, decimal point or negative sign
                        input=scannedLine.replaceAll("[^\\d.]", "");
                    }

                    else{
                        outputToFile(outputFile,"Imput error.");
                        System.exit(0);
                    }

                    // check if argument has a 0 at the beginning and continues (ex. 01, 000324)
                    if(input.charAt(0)=='0' && input.length() > 1){
                        outputToFile(outputFile, "Imput error.");
                        System.exit(0);
                    }

                    /*
                    // try-catch to see if the input from the text file is a valid integer
                    try{
                        arg=Integer.parseInt(input);
                    }
                    catch(NumberFormatException e){
                        // if the number found is a float/double...
                        outputToFile(outputFile, "Imput error.");
                        System.exit(0);
                    }
                    */

                    arg=Integer.parseInt(input);

                    if(arg < 0){
                        // if argument is NOT a natural number...
                        outputToFile(outputFile, "Imput error.");
                        System.exit(0);
                    }

                    else if(arg==0){
                        if(cs.isEmpty()){
                            // if stack is empty, add 0
                            cs.push(0);
                        }
                        // if stack is NOT empty, do nothing
                    }

                    else if(arg==666){
                        cs.push(666);
                        cs.push(666);
                        cs.push(666);
                    }

                    else if(arg==3){
                        cs.push(7);
                    }

                    else if(arg==13){
                        while(!cs.isEmpty()){
                            // emptying list and printing values into output file
                            String poppedValue=String.valueOf(cs.pop());
                            outputToFile(outputFile, poppedValue);
                        }

                        cs.push(13);
                    }

                    else{
                        // normal call to push
                        cs.push(arg);
                    }
                }

                else if (scannedLine.equals("pop()")){
                    String poppedValue;

                    if(cs.isEmpty()) {
                        // if stack is empty...
                        outputToFile(outputFile, "Error");
                        System.exit(0);     // terminating program
                    }

                    else if(cs.top()==666){
                        poppedValue=String.valueOf(cs.pop());
                        outputToFile(outputFile, poppedValue);

                        if(!cs.isEmpty()){
                            // if stack has more than one element, remove the next element too
                            cs.pop();
                        }
                    }

                    else if(cs.top()==7){
                        outputToFile(outputFile, "7");
                    }

                    else if(cs.top()==42) {
                        while(!cs.isEmpty()){
                            // loop to empty stack but NOT output popped values
                            cs.pop();
                        }

                        outputToFile(outputFile, "42");
                    }

                    else{
                        // normal call to pop
                        poppedValue=String.valueOf(cs.pop());
                        outputToFile(outputFile, poppedValue);
                    }
                }

                else if (scannedLine.equals("top()")){
                    if(cs.isEmpty()){
                        // if stack is empty...
                        outputToFile(outputFile, "null");
                    }

                    else if(cs.top()==7){
                        cs.pop();
                    }

                    else if(cs.top()==666){
                        outputToFile(outputFile, "999");
                    }

                    else if(cs.top()==319){
                        outputToFile(outputFile, "666");
                    }

                    else{
                        // normal call to top
                        String topValue=String.valueOf(cs.top());
                        outputToFile(outputFile, topValue);
                    }
                }

                else{
                    // if line doesn't contain "push", "pop" or "top"...
                    outputToFile(outputFile, "Input error.");
                    System.exit(0);
                }
            }

            scanner.close();
        }

        catch(Exception e){
            // if input file doesn't exist, catch it and print an error message
            e.printStackTrace();
        }
    }

    public static void outputToFile(File outputFile, String toPrint) throws IOException{
        FileWriter fw=new FileWriter(outputFile, true);     // cannot add onto file without FileWriter being in append mode

        if(outputFile.length() != 0){
            // adds new line if String is not on the first line
            fw.write("\n");
        }

        fw.write(toPrint);
        fw.close();
    }

    public static void main(String[] args) throws IOException{
        File in=new File(args[0]);
        File out=new File(args[1]);

        if(out.length() != 0){
            // clearing file contents if they exist
            FileWriter empty=new FileWriter(out);
            empty.flush();
            empty.close();
        }

        callsFromFile(in, out);
        System.out.println("   ~~~ File read with no errors ~~~ \n");
    }
}

// javac ConfusedStack.java
// java ConfusedStack input.txt output.txt