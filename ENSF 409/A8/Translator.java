/**
 * ENSF 409 - Assignment 7
 * Dylan Mah (30086580)
 * Version: 1.0
 * Since: 1.0
 */

package edu.ucalgary.ensf409;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.*;

public class Translator implements Serializable{
    private TranslationText translation;
    private final String fileName;
    private File file;

    /* constructor
     * Accepts a String of a two-letter language code, dash, and two-letter region code, e.g., te-IN and throws an
     * IllegalArgumentException if the language and region code are not in the correct format. Language codes are
     * ISO 639-1 and region codes are ISO 3166, but this method only checks the format of the String, not the validity
     * of the codes. It calls importTranslation().
     */
    Translator(String fileName) throws IllegalArgumentException, IOException, ArgFileNotFoundException{
        // Removing package from fileName to check if fileName is in the valid format (not the actual fileName that will be stored!)
        String justFileName=fileName.replace("edu/ucalgary/ensf409/", "");

        // Using regex to check if just the file name is in the correct format
        Pattern pattern=Pattern.compile("^[a-z]{2}-[A-Z]{2}$");
        Matcher matcher=pattern.matcher(justFileName);

        if(!matcher.find()){
            // If file name is not in format "la-CO"...
            throw new IllegalArgumentException("File name not in correct format");
        }

        this.fileName=fileName;     // Storing the full file path (package + file name)
        importTranslation();
    }

    public TranslationText getTranslation(){
        return this.translation;
    }

    /* translate()
     * Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for the 31st), and a year. Throws an
     * IllegalArgumentException if monthNum or dayNum is not valid. Returns the formatted sentence as a String. Notice
     * that the String containing formatting uses numbered arguments - this is because some languages will put the
     * words in the sentence in a different order, but the translate() method must be able to work without knowledge of
     * the language structure.
     * Note: You do not have to check if a day is valid for a particular month/year; February 31 or February 29, 2021
     * can both be accepted, but out of range values e.g., month 15 day 40, are not valid and should be handled with an
     * IllegalArgumentException.
     */
    public String translate(int monthNum, int dayNum, int year) throws IllegalArgumentException{
        if(monthNum < 1 || monthNum > 12 || dayNum < 1 || dayNum > 31){
            // If month/day is out of bounds...
            throw new IllegalArgumentException();
        }

        String translatedSentence=this.translation.getSentence();
        String month=this.translation.getMonth(monthNum - 1);       // Decrease month by 1 because array indices are from 0-11
        String day=this.translation.getDay(dayNum - 1);             // Decrease day by 1 because array indices are is from 0-30

        return String.format(translatedSentence, day, month, year);      // Replacing %d with arguments
    }

    /* importTranslation()
     * Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
     *
     * No arguments. Returns void.
     */
    public void importTranslation() throws IOException, ArgFileNotFoundException{
        File serFile=new File(this.fileName + ".ser");      // Adding a .ser extension to given file name

        if(serFile.exists()){
            // If a .ser file with the command line argument name exists...
            this.file=serFile;
            deserialize();
        }

        else{
            // If a .ser file with the command line argument doesn't exist, check if a .txt version exists
            this.file=new File(this.fileName + ".txt");
            importFromText();
        }
    }

    /* importFromText()
     * Reads in from a the two-letter language code, dash, two-letter region code text file, in the form of ab-XY.txt,
     * and instantiates a TranslationText object with the data. It can throw I/O exceptions. Throw a custom
     * ArgFileNotFoundException when the file isn't found. We expect the .txt file to be in a valid format. The file is
     * expected to be in the same directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They
     * will always consist of the month names, one per line, followed by the day names, one per line, followed by the
     * sentence containing formatting strings. This is the last line in the file. You cannot make any assumptions about
     * what will appear on each line, only that each line will contain only one data element, and that it will not
     * contain an empty line.
     *
     * No arguments. Returns void.
     */
    public void importFromText() throws IOException, ArgFileNotFoundException{
        if(!this.file.exists()){
            // If file could not be found...
            throw new ArgFileNotFoundException();
        }

        String[] months=new String[12];
        String[] days=new String[31];
        String sentence="";
        int i=0;
        int j=0;

        Scanner scanner=new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(this.file), StandardCharsets.UTF_8)));

        while(scanner.hasNext()){
            String scannedLine=scanner.nextLine();

            if(i < 11){
                // First 12 lines are always month names
                months[i]=scannedLine;
            }

            if(i > 11 && i < 43){
                // Lines 13 to 44 are always days
                days[j]=scannedLine;
                j++;
            }

            if(i==43){
                // Last line (44) is always the formatted sentence
                sentence=scannedLine;
            }

            i++;
        }

        scanner.close();
        this.translation=new TranslationText(months, days, sentence);
    }

    /* serialize()
     * Creates a serialized object file of the TranslationText object, with the name format la-CO.ser, where la is the
     * two-letter language code and CO is the two-letter region code. An example of a serialized object file can be
     * found in the exercise directory as es-BO.ser I/O exceptions can be thrown.
     *
     * No arguments. Returns void.
     */
    public void serialize() throws IOException{
        ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(this.fileName + ".ser"));

        output.writeObject(this.translation);
        output.close();
    }

    /* deserialize()
     * Creates a TranslationText object from a .ser file. The files are named xx-YY.ser, where xx is the two-letter
     * language code and YY is the two-letter region code. es-bo.ser is an example. It can throw I/O exceptions.
     *
     * No arguments. Returns void.
     */
    public void deserialize() throws IOException{
        ObjectInputStream input=new ObjectInputStream(new FileInputStream(this.file));
        this.translation=null;

        try{
            // If file can be opened, get data and store it in object
            this.translation=(edu.ucalgary.ensf409.TranslationText) input.readObject();
        }
        catch(ClassNotFoundException e){
            // If the typecasting class doesn't match the class in the .ser file...
            e.printStackTrace();
        }

        finally{
            input.close();
        }
    }
}
