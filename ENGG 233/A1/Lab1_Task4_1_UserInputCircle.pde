import javax.swing.JOptionPane;

String xcoord;
xcoord=JOptionPane.showInputDialog("Enter value of x coordinate: ");
int x=Integer.parseInt(xcoord);

String ycoord;
ycoord=JOptionPane.showInputDialog("Enter value of y coordinate: ");
int y=Integer.parseInt(ycoord);

String radius;
radius=JOptionPane.showInputDialog("Enter value of circle's radius: ");
int r=Integer.parseInt(radius);

size(600,600);
background(#001589);

ellipseMode(RADIUS);
circle(x, y, r);
line(x, y, x, y-r);

float area=2*PI*r;

PFont f;
f=createFont("Comic Sans MS", 22, true);

fill(0);
textFont(f);
text("Area: " + area, x+6, y);

fill(0);
textFont(f);
text("Radius: " + r, x+6, y-(r/4));
