int a[]={1,2,3,4,5,6,7};
int count=0;

for (int i=0; i<a.length; i++){       //Loop to check each element of array
  for(int j=0; j<a.length; j++){
    if (a[i]!=a[j] && i!=j){                 //Nested loop to check if the current and next entries are NOT the same (if they're unique)
      //println("The values are unique");    
      count++;    //Increment count if values are NOT the same (unique)
    } 
    if (a[i]==a[j] && i!=j){                    //Nest loop to check if the current and next entries are the same (if they're NOT unique)
      //println("The values are not unique");
      count--;    //Decrement count if some values are the same (NOT unique)
      break;
    }
  }
}

if (count==(a.length)*(a.length-1)){  //should equal 42
  println("The values are unique (" + count + ")");
}
else {
  println("The values are NOT unique (" + count + ")");
}
