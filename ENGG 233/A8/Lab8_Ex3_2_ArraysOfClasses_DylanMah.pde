class Student {
  int id;
  int grade;
}

//Function to insert random values into an array
void PopulateArray(Student a[]){
  for(int i=0; i<a.length; i++){
    a[i].id=i+1;
  }
  for(int j=0; j<a.length; j++){
    a[j].grade=(int) random(40,100);
  }
}

//Function to calculate the average of the values of an array
float Calculate_Average(Student a[]){
  float avg=0;
  for(int i=0; i<a.length; i++){
    avg+=a[i].grade;
  }
  return avg/a.length;
}

void setup(){
  //Creating an array of objects of type Student
  Student a[]=new Student [10];
  
  //For loop to declare each array cell as an object of type Student
  for(int i=0; i<a.length; i++){
    a[i]=new Student();
  }
  
  //Calling the PopulateArray function to randomly fill the array with grades
  PopulateArray(a);
  for(int i=0; i<a.length; i++){
    print(a[i].grade, " ");
  }
  
  //Calling the Calculate_Average function to find the average of the student grades
  float avg=Calculate_Average(a);
  println();
  println("Class average is:", avg);
}
