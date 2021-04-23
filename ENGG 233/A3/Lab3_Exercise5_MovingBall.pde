int r=100, x=50, y=50;

void setup() {
  size(300,300);
}

void draw(){
 background(#D8D8D8);
 frameRate(100);
 
 if(x<250 && y==50){
   circle(x++,y,r);
 }
 
 if(x==250 && y<250){
   circle(x,y++,r);
 }
 
 if(x>50 && y==250){
   circle(x--,y,r);
 }
 
 if(x==50 && y>50){
   circle(x,y--,r);
 }
}
