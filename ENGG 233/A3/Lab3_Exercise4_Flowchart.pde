import javax.swing.JOptionPane;

String term=JOptionPane.showInputDialog("Do you want an open or closed mortgage?");
String input2=JOptionPane.showInputDialog("Do you want a 1, 3 or 5 year mortgage?");
int year=Integer.parseInt(input2);

if(term.equals("open")==true || term.equals("Open")==true){
  if(year==1){
    println("An open mortgage for 1 year is 7.10%.");
  }
  if(year==3){
    println("An open mortgage for 3 years is 7.50%.");
  }
  if(year==5){
    println("An open mortgage for 5 years is unavailable.");
  }
}
  
if(term.equals("closed")==true || term.equals("Closed")==true){
  if(year==1){
    println("An open mortgage for 1 year is 5.30%.");
  }
  if(year==3){
    println("An open mortgage for 3 years is 5.00%.");
  }
  if(year==5){
    println("An open mortgage for 5 years is 5.75%.");
  }
}

if(term.equals("Open")==false && term.equals("open")==false && term.equals("closed")==false && term.equals("Closed")==false){
  println(term, "is an invalid term type");
}

if(year!=1 && year!=3 && year!=5){
  println(year, "is an invalid term duration.");
}
