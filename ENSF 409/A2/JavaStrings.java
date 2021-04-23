//Exercise 5.1
/**
 * @author: Dylan Mah
 * @version: 1.1
 * @since: 1.0
 */

public class JavaStrings {
    /**
     * @param s1: First string to have its trailing and leading whitespaces deleted
     * @param s2: Second string to have its trailing and leading whitespaces deleted
     * @return Value of the combined length of the two trimmed strings is returned
     */
    public int addTogether(String s1, String s2){
        //Trims leading/trailing whitespaces, adds the two strings together and returns the length of the new String
        String s3=s1.trim()+s2.trim();

        return s3.length();
    }

    /**
     * @param firstName: String representing the first name of the pet owner
     * @param lastName: String representing the last name of the pet owner
     * @param pet: String representing the name of the pet
     * @param birthYear: Integer representing the birth year of the pet
     * @return String containing the first character of firstName, lastName and pet as well as the birthYear is returned
     */
    public String idProcessing(String firstName, String lastName, String pet, int birthYear){
        //Creates a unique ID from a person's first name, last name, pet name and the pet's birth year
        String id="";

        id+=firstName.charAt(0);
        id+=lastName.charAt(0);
        id+=pet.charAt(0);
        id+=String.valueOf(birthYear);

        return id;
    }

    /**
     * @param s: String that is to be converted into a secret code
     * @return String containing the first 3 letters of the argument with any vowels changed to 'z' is returned
     */
    public String secretCode(String s){
        //Replaces any vowels with 'z' and only stores the first 3 letters of the argument String
        String code="";

        for(int i=0; i<3; i++){
            //Changing any lowercase vowels to 'z'
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                code+='z';
            }

            //Changing any uppercase vowels to 'z'
            if(s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U'){
                code+='z';
            }

            //If letter is NOT a vowel, keep it
            else {
                code += s.charAt(i);
            }
        }

        return code;
    }

    public static void main(String[] args){
        String fn="Dylan";
        String ln="Mah";
        String pet="Pedro";
        int petYear=2018;

        JavaStrings js=new JavaStrings();

        int a=js.addTogether(fn, ln);
        System.out.println(a);

        String b=js.idProcessing(fn, ln, pet, petYear);
        System.out.println(b);

        String c=js.secretCode("Tomato");
        System.out.println(c);

        System.out.println(js.secretCode("aeiou"));
    }
}//end of class
