void setup(){
  int x, y, z, counter=0;
  
  do{
    x=(int)random(1,5);
    y=(int)random(1,5);
    z=(int)random(1,5);
    println("3 random numbers:", x + ",", y + ",", z);    //Print the 3 randomly generated numbers
    
    if (allTheSame(x,y,z)==true){
      println("The three numbers are the same. \n");    //Print if all the 3 numbers are the same
    }
    else{
      printResult (leastOf3(x,y,z), greatestOf3(x,y,z));    //Run greatestOf3 & leastOf3 for the values of x, y & z
    }
    counter++;
  } while (counter<10);    //Execute loop 10 times
}

boolean allTheSame (int a, int b, int c){    //Check if a, b & c are the same
  if (a==b && a==c && b==c){
    return true;     //Code in if statement in setup is executed
  }
  else {
    return false;    //Code in else statement in setup is executed
  }
}

int greatestOf3 (int a, int b, int c){    //Compare a, b & c using the maxOf2 function, return the largest value
  int v=0;
  int x=maxOf2(a,b);
  int y=maxOf2(b,c);
  int z=maxOf2(a,c);
  
  if (x>=y && x>=z){
    v=x;
  }
  if (y>=x && y>=z){
    v=y;
  }
  if (z>=y && z>=x){
    v=z;
  }
  return v;
}

int maxOf2 (int c, int d){    //Compare c & d, return the larger value
  int x=0;
  if (c>=d){
    x=c;
  }
  if (d>=c){
    x=d;
  }
  return x;
}

int leastOf3 (int a, int b, int c){    //Compare a, b & c using the minOf2 function, return the smallest value
  int v=0;
  int x=minOf2(a,b);
  int y=minOf2(b,c);
  int z=minOf2(a,c);
  
  if (x<=y && x<=z){
    v=x;
  }
    if (y<=x && y<=z){
    v=y;
  }
    if (z<=y && z<=x){
    v=z;
  }
  return v;
}

int minOf2 (int c, int d){    //Compare c & d, return the smaller value
  int x=0;
  if (c<=d){
    x=c;
  }
  if (d<=c){
    x=d;
  }
  return x;
}

void printResult (int min, int max){
  println("Minimum is", min, "and maximum is", max + ". \n");    //Print the largest and smallest values
}
