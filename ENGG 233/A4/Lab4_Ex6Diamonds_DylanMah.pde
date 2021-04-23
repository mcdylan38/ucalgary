size (500, 500); 
int x=250, y=0, count, row=0;  

//loop for changing y
do{
  y=10*row;  
  count=0;
  
  //loop for changing x
  do{
    x=250 - 10*row + 20*count;
    if(row%2==0){
      fill(0);
    }
    else{
      fill(255);
    }
    quad(x, y, x-10, y+10, x, y+20, x+10, y+10);    //start at top and build down
    count++;
  }
  while(x < 250+10*row);
  
  row++;
}
while(y < 240);
