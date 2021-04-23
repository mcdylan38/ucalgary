/**
 * ENSF 409 - Assignment 7
 * Dylan Mah (30086580)
 * Version 1.0
 * Since 1.0
 */

package edu.ucalgary.ensf409;
import java.util.regex.*;

/*
 Problems in original code:
 * addTogetherMirror did not mirror the Strings after adding them together
 * idProcessing does not recognize Strings like "O'Reilly" (and also doesn't throw exceptions for invalid arguments)
 * idProcessing did not check if names had a minimum of 2 letters and a maximum of 26 letters
 * idProcessing doesn't check if the birth year is before 2021
 * secretCode did not return anything and also didn't loop back around the alphabet (ex. z -> a)
 */

public class StringProcessor{
    private final String storedString;

    public StringProcessor(String input){
        this.storedString=input;
    }

    public String getStoredString(){
        return this.storedString;
    }

    public String addTogetherMirror(String inputString){
        String combined=storedString.trim() + inputString.trim();     // trim will remove any trailing/leading whitespaces
        String reversed="";

        for(int i=combined.length() - 1; i > -1; i--){
            // Loop to reverse combined Strings and print characters in lower case
            reversed+=Character.toLowerCase(combined.charAt(i));
        }

        return reversed;
    }

    public static String idProcessing(String firstName, String lastName, String petName, int year) throws NullPointerException{
        // Using regex to check if names only contains characters that are letters, ', -, . or a space
        // Also checks if names starts with a capital, ends with some letter and is between 2 and 26 characters long
        Pattern validName=Pattern.compile("^[A-Z][a-zA-Z-'. ]{0,24}[a-zA-Z]$");    // Max = 1 + 24 + 1 = 26
        Matcher firstNameMatch=validName.matcher(firstName);
        Matcher lastNameMatch=validName.matcher(lastName);
        Matcher petNameMatch=validName.matcher(petName);

        if(!firstNameMatch.find() || !lastNameMatch.find() || !petNameMatch.find() || year > 2021 || year < 1000){
            // If names do not match regex or invalid year is entered...
            throw new IllegalArgumentException("Invalid format of one or more inputs");
        }

        // Using regex to check if there are any duplicates in the punctuation for names with valid characters
        Pattern duplicates=Pattern.compile("[a-zA-Z]+[-.']{2,}[a-zA-Z]+");
        firstNameMatch=duplicates.matcher(firstName);
        lastNameMatch=duplicates.matcher(lastName);
        petNameMatch=duplicates.matcher(petName);

        if(firstNameMatch.find() || lastNameMatch.find() || petNameMatch.find()){
            // If there are two or more valid punctuations found in one of the names...
            throw new IllegalArgumentException("Invalid format of one or more inputs");
        }

        return String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0)) + String.valueOf(petName.charAt(0)) + String.valueOf(year);
    }

    public String secretCode(int offset){
        String encodedString="";

        if(offset < 0){
            throw new IllegalArgumentException("Offset cannot be negative");
        }

        for(int i=0; i < storedString.length(); i++){

            char charToShift=storedString.charAt(i);

            if(Character.isLetter(charToShift)){     // Only applying shift to letters
                int code=0;

                if(Character.isUpperCase(charToShift)){
                    // If character is in upper case...
                    code=(charToShift + offset - 'A') % 26 + 'A';
                    // First calculates the distance from A, finds the remainder if divided by 26 then adds that value to A
                }

                if(Character.isLowerCase(charToShift)){
                    // If character is in lower case...
                    code=(charToShift + offset - 'a') % 26 + 'a';
                }

                // Need cases for upper and lower case because ascii values of upper and lower case letters are vastly different

                encodedString+=(char) code;     // Converting ascii value to its character representation
            }

            else{
                // Keeping non-letter characters at the same index
                encodedString+=charToShift;
            }
        }

        return encodedString;
    }
}
