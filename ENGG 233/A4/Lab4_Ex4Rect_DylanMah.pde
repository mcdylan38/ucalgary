int s=20;

void setup(){
  size(200,200);
}

void draw(){
  //white squares
  for(int a=200; a>=0; a-=20){  //horizontal
    for(int b=a; b>=0; b-=20){  //vertical
      fill(255);
      square(a,b,s);
    }
  }
  
  //diagonal from top left to bottom right black squares
  for(int a=0; a<200; a+=20){      //horizontal
    for (int b=a; b<200; b+=200){  //vertical
      fill(0);
      square(a,b,s);
    }
  }
  
  //diagonal from top right to middle black squares
  for(int a=0; a<200; a+=20){    //horizontal
    for(int b=0; b<200; b+=20){  //vertical
      if(a==b || (a==180-b && b<100)){
        fill(0);
        square(a,b,s);
      }
    }
  }
}
