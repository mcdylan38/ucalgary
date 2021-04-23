import javax.swing.JOptionPane;
String input=JOptionPane.showInputDialog("Enter a positive integer greater or equal to 3.");
int n=Integer.parseInt(input);

while(n<3){
  input=JOptionPane.showInputDialog("Enter a positive integer greater equal to 3.");
  n=Integer.parseInt(input);
}

int a=0, b=1, c;

println("The corresponding Fibonacci sequence until", n, "is:");

//print 1 as first number
print(b, "");

while(a+b < n){
  c=a+b;
  
  //print the sum of the preceeding terms
  print(c, "");
  
  //rewrite the variables so the sum of the next numbers is the sum of the preceeding terms
  a=b;
  b=c;
}
