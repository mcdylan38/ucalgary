void setup () {
  float[] a={6.7, 5.9, 10, 23, 44, 4.6, 9.1, 100, 79};
  float b []={};

  //calling InsertAt function
  a=InsertAt(a, 38, 12);
  //b=InsertAt(b, 4, 3);

  println(a);
}

float [] InsertAt(float []array, float value, int index) {
  //creating a new empty array that has 1 more element than the reference
  float temp[]=new float [array.length + 1];

  //function only runs when the array has at least 1 element
  if (array.length>0) {
    if (index < array.length) {
      for (int i=0; i<temp.length; i++) {
        if (i<index) {
          temp[i]=array[i];
        }
        //point where loop reaches the index where the desired value should be placed
        if (i==index) {
          temp[i]=value;
        }
        if (i>=index && i<array.length) {
          //need i+1 to move each element over 1 index
          temp[i+1]=array[i];
        }
      }
      println("Inserting", value, "into index", index + ":");
    }
    else{
      println("Index", index, "is out of range, so the value", value, "cannot be added to the array.");
    }
  }
 else {
    //error message if the reference array is empty
    println("The element", value, "cannot be added to the array.");
  }  

  //return larger array with the desired value inserted into the original array
  return temp;
}
