void setup(){
  int [] id={12757, 20001, 12334, 14332, 99999, 10111, 20101, 12034, 10332, 99991};
  double [] midterm={99, 67, 88, 91, 56, 90, 70, 69, 79, 59};
  double [] final_exam={89, 76, 80, 67, 99, 98, 56, 96, 90, 60};
  String [] name={"Tim", "Joe", "Ali", "Kim", "Pam", "Rob", "Ben", "Ted", "Lee", "Jim"};

  //Array of indices will be used to indicate the order of records based on students' id numbers. (0=Tim, 1=Joe ... Jim=9)
  int [] indices={0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
  
  //Prints records of students in the order above
  print_records(id, midterm, final_exam, name);
  
  //Function sorts array id and matches the array indices to its corresponding element in id
  sort_records_by_id(id, indices);
  println();  
  println("Students records after sorting id by numbers:");
  
  //Function to print the records of the students in ascending order with respect to id
  print_sorted_records(indices, id, midterm, final_exam, name);
  
  //Search for positions of students in the array of names and print their records, if available.
  //This search should succeed.
  int position=search(name, "Kim");
  if (position==-1){
    println("Search failed: Kim NOT FOUND");
  }
  else{
    double average=student_average(midterm[position], final_exam[position]);
    println();
    println(name[position], "was found with id", id[position] + ", midterm mark of", midterm[position] + "%, final exam mark of", final_exam[position]
    + "%, term average of", average + "%, and overall final grade of", letter_final_exam(average));
  } 
    
  //This search should fail.
  position=search(name, "Sam");    
  if (position==-1){
    println();
    println("Search failed: Sam NOT FOUND");
  }
  else{
    double average=student_average(midterm[position], final_exam[position]);
    println();
    println(name[position], "was found with id", id[position] + ", midterm mark of", midterm[position] + "%, final exam mark of", final_exam[position]
    + "%, term average of", average + "%, and overall final grade of", letter_final_exam(average));
  }
}

double class_average(double [] exam){
  //Calculates the average of the either the midterm or final exam marks for the class
  double avg=0;
  for(int i=0; i<exam.length; i++){
    avg+=exam[i];
  }
  return avg/=exam.length;
}

double student_average(double midterm, double final_exam){
  //Calculates student's final grade using their midterm and final exam marks
  return (midterm+final_exam)/2;
}

char letter_final_exam(double mark){
  //Finds the letter grade corresponding to a student's numerical grade
  
  //Empty character that is filled based on the mark
  char temp=' ';
  if (mark<60){
    temp='F';
  }
  if (mark>=60 && mark<=69){
    temp='D';
  }
  if (mark>=70 && mark<=79){
    temp='C';
  }
  if (mark>=80 && mark<=89){
    temp='B';
  }
  if (mark>=90 && mark<=100){
    temp='A';
  }
  return temp;
}

void print_records(int [] id, double [] midterm, double [] final_exam, String [] name){
  //Prints student records as they are initialized in setup (unsorted)
  
  //Empty variables for midterm and final exam averages that can be printed once after the student records have been printed
  double midtermAvg=0;
  double finalAvg=0;
  
  println("  ID  |  Name  |  Midterm  |  Final  |  Average  |  Mark");
  println("------|--------|-----------|---------|-----------|--------");
  for (int i=0; i<id.length; i++){
    //Calling student_average and letter_final_exam functions to find the averages of the student and the letter representing their final exam mark    
    double studentAvg=student_average(midterm[i], final_exam[i]);
    char letter=letter_final_exam(studentAvg);
    
    //Calling class_average function to find the overall class average for the midterm and final exam marks
    midtermAvg=class_average(midterm);
    finalAvg=class_average(final_exam);
    
    println(id[i] + " |  " + name[i] + "   |  " + midterm[i] + "%    |  " + final_exam[i] + "%  |  " + studentAvg + "%    |  " + letter);
  }
  println("----------------------------------------------------------");
  println("Class midterm average is", midtermAvg + "%");
  println("Class final average is", finalAvg + "%");
}
 
void sort_records_by_id (int [] id, int [] indices){
  //Using insertion sort to rearrange the array id into ascending order and rearranges at the same time so the order of indices and id are the same
  
  //New empty array that is a copy of id so the **order of id stays the same**
  int temp[]=new int [id.length];
  
  //Loop to copy the elements of id into temp one at a time
  for (int i=0; i<id.length; i++){
    temp[i]=id[i];
  }
  //temp=id; would be the same as sorting id in ascending order and then printing it in the order of indices, making id unsorted in the end
  
  /* Insertion sort - loop starts at 2nd element (element 1 is already sorted when compared to nothing) and works backwards to see if the elements
     before are less than the current element. Increment i before to compare the elements to the right of the current one. */
  for (int i=1; i<temp.length; ++i){
    //Copy the values of the current element into new local variables
    int temp1=temp[i]; 
    int temp2=indices[i];
    
    //Secondary counter j which is always 1 less than i
    int j=i-1;    //1st loop: i=2, j=1
                  //2nd loop: i=3, j=1 ...
    
    while (j>=0 && temp[j]>temp1){
      /* Only compare temp (copy of id) because indices is already sorted, so adding the boolean indices[i]>temp2 would always return false,
         causing the loop to not run */
      
      //Copy the value of the current element, at index j, into the next element (move current element to the right once)
      temp[j+1]=temp[j];          //Since j=i-1, if i=2 & j=1, j+1 --> (i-1)+1=i, (1+1=2) therefore: temp[j+1]=temp[i]
      indices[j+1]=indices[j];
      
      //Decrement to compare the previous elements, that are now sorted, to the rest of the array
      j--;
    }
    
    /* Since j is 1 less than it was (ex. first loop j was 1, decremented once so now j is 0, so temp[j+1] = temp[0+1] = temp[1]). The value of
       the element two to the right of the current element, at index j, is now copied into the current element (move element to the right of the
       current one to the backw/left once). */
    temp[j+1]=temp1;
    indices[j+1]=temp2;
  }
}

void print_sorted_records(int [] indices, int [] id, double [] midterm, double [] final_exam, String [] name){
  //Prints the student records in ascending order with respect to id
  
  //Empty variables for midterm and final exam averages that can be called once after the student records have been printed
  double midtermAvg=0;
  double finalAvg=0;
  
  println("  ID  |  Name  |  Midterm  |  Final  |  Average  |  Mark");
  println("------|--------|-----------|---------|-----------|--------");
  for (int i=0; i<indices.length; i++){
    /*The variable "index" will print the records of the students in ascending order with respect to id. The function rearranging indices to match
      the sorted id array has already been called, so printing the student records using the values in indices will print the student records in
      ascending order with respect to id. */
    int index=indices[i];
    
    //Calling student_average and letter_final_exam functions to find the average of the student and the letter representing the final exam mark
    double studentAvg=student_average(midterm[index], final_exam[index]);
    char letter=letter_final_exam(studentAvg);
    
    //Calling class_average function to find the overall class average for the midterm and final exam marks
    midtermAvg=class_average(midterm);
    finalAvg=class_average(final_exam);

    println(id[index] + " |  " + name[index] + "   |  " + midterm[index] + "%    |  " + final_exam[index] + "%  |  " + studentAvg + "%    |  " + letter);
  }
  println("----------------------------------------------------------");
  println("Class midterm average is", midtermAvg + "%");
  println("Class final average is", finalAvg + "%");
  println();
}

int search(String [] name, String target){
  /* Searches to see if the desired student name is in the array. If the student is in the array, their record will be output onto the console. If
  the student is not in the array, an error message will be output to the console instead. */
  int temp=-1;
  
  for(int i=0; i<name.length; i++){
    if(name[i]==target){
      temp=i;
    }
  }
  return temp;
}
