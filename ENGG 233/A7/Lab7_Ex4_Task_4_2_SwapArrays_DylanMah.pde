void setup () {
  float [] a1={6.7, 5.9, 10, 23, 44, 4.6, 9.1};
  float [] a2={11, 12, 13, 14, 15, 16, 17};
  
  //need two new arrays to store old values, otherwise both arrays would contain the same values when swapping because a1=a2
  float a1Copy []=new float [a1.length];
  float a2Copy []=new float [a2.length];
  
  //copying a1 into the empty array a1Copy
  for (int c1=0; c1<a1.length; c1++){
    a1Copy[c1]=a1[c1];
  }
  
  //copying a2 into the empty array a2Copy
  for (int c2=0; c2<a2.length; c2++){
    a2Copy[c2]=a2[c2];
  }
  
  //calling swap array functions
  a1=SwapArrays(a2,a1);
  
  //since a1=a2, the swap of a1 and a2 is ineffective, so the copies must be swapped because they contain the original vales of a1 and a2
  a2Copy=SwapArrays(a1Copy,a2Copy);
  
  println("\n" + "Array 1:");
  printArray(a1);
  println("\n" + "Array 2:");
  printArray(a2Copy);
}

float [] SwapArrays (float [] a, float [] b){
  //function only runs when the two arrays are the same length
  if(a.length==b.length){
    //loop to switch the elements of arrays one at a time
    for(int i=0; i<a.length; i++){
      b[i]=a[i];
    }
  }
  else{
    //error message appears in console if arrays are different length
    println("The arrays cannot be swapped");
  }
  return b;
}
