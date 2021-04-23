//Create 2D array
int a[][]={ {0,1,0,1,1},
            {1,0,1,1},
            {0,1},
            {1,0,1,1,0,0},
            {0,0,1},
            {1,1,1,0,0} };
                       
size(200,200);
for (int i=0; i<a.length; i++){          //Loop for rows (outer part of array)
  for (int j=0; j<a[i].length; j++){     //Loop for columns (loop ends when j is greater than or equal to column length, which is a[i] or inner
    if(a[i][j]==0){                      //part of array)
      fill(0);
      square(10+j*30, 10+i*30, 30);      //Create black square when entry (i,j = row,column) value is 0
    }
    else{
      fill(255);
      square(10+j*30, 10+i*30, 30);      //Create white square when entry (i,j= row,column) value is 1
    }
  }
}
