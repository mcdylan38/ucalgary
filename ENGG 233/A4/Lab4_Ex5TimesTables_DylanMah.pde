import javax.swing.JOptionPane;

void setup(){
  int max, row, column, x=20, y=30;
  size(870, 850);
  background(0);
 
  PFont f;
  f=createFont("Arial", 20, true);
  textFont(f);
 
  do{
    String answer=JOptionPane.showInputDialog("How many rows would you like in your times table?" + "\nEnter a number between 1 and 16.");
    max=Integer.parseInt(answer);
  }while(max<1 || max>16);
  
  text("X", x, y);
  x+=50;
  
  //Making rows
  for(row=1; row<=max; row++){
    text(Integer.toString(row), x, y);
    x+=50;
  }
  
  //Making columns
  for(column=1; column<=max; column++){
    text(Integer.toString(column), 20, y+50);
    y+=50;
  }
  
  //Making entries of products
  for(column=1; column<=max; column++){
    for(row=1; row<=max; row++){
      int product=row*column;
      text(Integer.toString(product), row*50+20, column*50+30);
    }
  }
}
