class Point {
  int x, y, z;
  
  Point(){
    x=0;
    y=0;
    z=0;
  }
}
  
void FillPoint(Point p) {
  //Filling each coordinate with random values
  p.x=(int) random(1,100);
  p.y=(int) random(1,100);
  p.z=(int) random(1,100);
}
  
float DistanceBetweenPoints(Point pt1, Point pt2) {
  float d=0;
  //Using the distance formula to find the distance between the 2 points
  d=sqrt(pow((pt1.x-pt2.x), 2) + pow((pt1.y-pt2.y), 2) + pow((pt1.z-pt2.z), 2));
  return d;
}

void setup() {
  //Creating two new objects of type Point
  Point p1=new Point();
  Point p2=new Point();
  
  //Calling the FillPoint function to give the object values
  FillPoint(p1);
  FillPoint(p2);
  
  //println("P1:", p1.x, p1.y, p1.z);
  //println("P2:", p2.x, p2.y, p2.z);
  
  //Calling the DistanceBetweenPoints function to find the distance between the two points
  float d=DistanceBetweenPoints(p1,p2);
  println("The distance is", d, "units.");
}
