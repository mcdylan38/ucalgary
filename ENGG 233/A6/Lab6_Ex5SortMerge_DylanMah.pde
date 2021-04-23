int n=5, m=8;
int x[]=new int[n];
int y[]=new int[m];

for (int c1=0; c1<n; c1++){    //Fill first array with random whole numbers
  int r1=(int) random(0,50);  
  x[c1]=r1;
}

for (int c2=0; c2<m; c2++){    //Fill second array with random whole numbers
  int r2=(int) random(0,50);
  y[c2]=r2;
}

x=sort(x);
y=sort(y);

int xy=m+n;
int z[]=new int [xy];        //New empty array with length of m+n

int count=0;
for (int c3=0; c3<xy; c3++){    //Loop to merge arrays
  if(c3<n){
    z[c3]=x[c3];
  }
  if(c3>=n && c3<xy){
    z[c3]=y[count];              //Need new counter to start at element 0 rather than element 5 (c3=4 when this if statement is true)
    count++;
  }
}

for(int c4=0; c4<xy; c4++){        //Loop through entire length of merged array to compare two elements
  for(int c5=0; c5<xy-1; c5++){    //Loop to compare and sort each element of merged array in ascending order
    if(z[c5]>z[c5+1]){
      int hold=z[c5+1];  //Variable to hold smaller term     //--|
      z[c5+1]=z[c5];                                         //  |>> Switch the two elements compared and rewrite the merged array
      z[c5]=hold;                                            //--|
    }
  }
}

printArray(z);    //Print sorted merged array
