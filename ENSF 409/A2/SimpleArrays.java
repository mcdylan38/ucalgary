//Exercise 4.1
/**
 * @author: Dylan Mah
 * @version: 1.0
 * @since 1.0
 */

import java.util.Arrays;

public class SimpleArrays{
    private String[] stringArray=new String[4];

    /**
     * @param s: String argument that the first 4 elements of stringArray are set to
     */
    SimpleArrays(String s) {
        //Constructor for one String argument that fills each element with String s
        Arrays.fill(stringArray, s);
    }

    SimpleArrays() {
        //Overload constructor for zero argument (default constructor) to have a default value instead of null
        Arrays.fill(stringArray, "Hello, ENSF 409");
    }

    /**
     * @param n: Integer argument used to indicate the index where concatenation should begin
     * @return String variable containing all of the Strings from index n to the end of stringArray is returned
     */
    public String arrayConcat(int n){
        //Accepts an array index and returns a String consisting of all elements in stringArray from the index to the end
        //Error handling if the index n is out of bounds
        if(n > stringArray.length || n < 0) {
            System.out.print("IndexOutOfBoundsException for inputted value of " + n);
            return " ";
        }

        String toConcat=start_to_end(n, stringArray.length);

        return toConcat;
    }

    public String concat() {
        //In the case no index is specified, concat prints all of the elements of stringArray (goes from index 0 to the end)
        String toConcat=start_to_end(0, stringArray.length);
        return toConcat;
    }

    /**
     * @param start: Integer argument used to indicate the beginning
     * @param end: Integer argument used to indicate the end
     * @return String variable containing all of the Strings from index start to end is returned
     */
    public String arrayCrop(int start, int end) {
        //Accepts 2 int arguments, start and end, and returns a String that contains elements from stringArray from start to end
        if(end < start){        //if the indices are backwards, swap them
            int hold=start;
            start=end;
            end=hold;
        }

        if(start < 0 || end < 0 || start > stringArray.length || end > stringArray.length){     //if one of the indices is out of bounds...
            return "Fail";
        }

        if(start==end){
            return "Match";
        }

        String toCrop=start_to_end(start, end);

        return toCrop;
    }

    /**
     * @param index1: Integer argument used to indicate the beginning index of Strings that should be copied
     * @param index2: Integer argument used to indicate the last index of Strings that should be copied
     * @return String that contains a compilation of the Strings from stringArray from index1 to index 2 is returned
     */
    public String start_to_end(int index1, int index2){
        //Fills a string with all the characters from the ints index1 to index2
        String toFill="";

        for(int i=index1; i < index2; i++){
            toFill+=stringArray[i];

            if(i != index2 - 1) {
                toFill+='#';
            }
        }

        return toFill;
    }

    public static void main(String[] args){
        SimpleArrays array1=new SimpleArrays();
        for(int i=0; i < array1.stringArray.length; i++) {
            System.out.print(array1.stringArray[i] + "   ");
        }
        System.out.println();

        String s1=array1.arrayConcat(4);
        System.out.println(s1);

        String s2=array1.arrayCrop(2,0);
        System.out.println(s2);

        String s3=array1.arrayCrop(0,5);
        System.out.println(s3 + "\n");


        SimpleArrays array2=new SimpleArrays("Big Yoshi");
        for(int i=0; i < array2.stringArray.length; i++) {
            System.out.print(array2.stringArray[i] + "   ");
        }
        System.out.println();

        String s4=array2.arrayConcat(3);
        System.out.println(s4);

        String s5=array2.arrayCrop(0,3);
        System.out.println(s5);

        String s6=array2.arrayCrop(1,1);
        System.out.println(s6);
    }
} //end of class
