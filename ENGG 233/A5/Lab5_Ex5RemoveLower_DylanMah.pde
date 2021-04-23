void setup(){
  String str="ENGG 233, Fall 2019, UCalgary";
  String lowerStr=allLowerCase(str);            //Call user defined function allLowerCase to convert upper case letters in String to lower case
  println(lowerStr);                            //Print result of allLowerCase
}

String allLowerCase(String input){
  //A = 65, Z = 90
  //a = 97, z= 122
  String output=" ";
  
  //Loop to convert each character for entire String
  for(int a=0; a<input.length(); a++){
    char ch=input.charAt(a);                 //Get each char of String
    int n=parseInt(ch);                      //Convert each char into its numerical value
    
    //Checking decimal values of char to see if they are uppercase letters
    if (n>=65 && n<=90){
      n+=32;                //Converting upper case to lower case (97-65=32)
      ch=char(n);           //Convert int back to characters
    }
    output+=ch;             //Store characters in a string
  }
  return output;
}
