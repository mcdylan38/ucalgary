float a=0, b=0, c, d;

void setup() {
  size(800, 800);
  background(#FC00C6);
}

void draw() {
  //making endpoints of lines be the same
  a=c;
  b=d;
  
  //genearte random values for end points of line
  c=random(0,800);
  d=random(0,800);
  
  line(a,b,c,d);
  frameRate(0.5);    //slowing down drawing speed
}
