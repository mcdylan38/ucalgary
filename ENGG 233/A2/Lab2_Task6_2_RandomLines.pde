float a, b, c, d;
PShape line;

void setup() {
  size(800, 800);
  background(#FC00C6);
}

void draw() {
  //continuously generate random values for the x & y coordinates for the line
  a=random(0,400);
  b=random(0,400);
  c=random(400,800);
  d=random(400,800);
  
  line(a,b,c,d);
  frameRate(10);    //slowing down drawing speed
}
