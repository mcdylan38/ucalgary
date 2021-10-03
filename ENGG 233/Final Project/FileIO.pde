import controlP5.*;
import javax.swing.JOptionPane;

class Main{
  String filePath;
  Table dataTable;

  Main(){
    filePath=" ";
  }
}

boolean Bar_or_Scatter=true;

void setup(){
  size(1436, 800);  
  ControlP5 cp5=new ControlP5(this);
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");

  final int month[]=new int [object.dataTable.getRowCount()];
  final float minTemp[]=new float [object.dataTable.getRowCount()];
  final float maxTemp[]=new float [object.dataTable.getRowCount()];
  final float snow[]=new float [object.dataTable.getRowCount()];
  //use final keyword so the arrays can be used within controlEvent function, but makes them unchangeable
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    month[i]=new Date().month;
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    snow[i]=new TempData().snowFall;
  }
  fillMonth(month);
  fillMin(minTemp);
  fillMax(maxTemp);
  fillSnow(snow);
  
  //CallbackListener allows for a pop-up dialogue box to appear so users can specify the range of years they want to see data for
  cp5.addButton("Range").setValue(0).setPosition(180, 20).setSize(65, 40).addCallback(new CallbackListener(){
    public void controlEvent(CallbackEvent event){
      if(event.getAction()==ControlP5.ACTION_RELEASE){
        String input1=JOptionPane.showInputDialog("Enter the year that will be the start of the range in numerical form (ex. 1990).");
        String input2=JOptionPane.showInputDialog("Enter the year that will be the end of the range in numerical form (ex. 1991).");
        //type casting inputs to convert strings to ints
        int start=int(input1);
        int end=int(input2);
        
        //reset background, draw graph and redraw axis on top of graph for inputted years
        if(Bar_or_Scatter==true){
          background(#DBDBDB);
          drawRangeBar(minTemp, maxTemp, start, end);
          graphSkeleton(255);
        }
        else{
          background(#DBDBDB);
          drawRangeScatter(minTemp, maxTemp, start, end);
          graphSkeleton(0);
        }
      } } });
    
  cp5.addToggle("Bar_or_Scatter").setValue(Bar_or_Scatter).setPosition(300, 20).setSize(70, 40).setMode(ControlP5.SWITCH).setColorLabel(0);
  
  cp5.addButton("Snow_Fall").setValue(0).setPosition(70, 110).setSize(70, 40);      
  cp5.addButton("Min_Only").setValue(0).setPosition(180,65).setSize(70,40);      
  cp5.addButton("Max_Only").setValue(0).setPosition(180,110).setSize(70,40);  
  cp5.addButton("January").setValue(0).setPosition(750,20).setSize(70,30);      
  cp5.addButton("February").setValue(0).setPosition(850,20).setSize(70,30);      
  cp5.addButton("March").setValue(0).setPosition(950,20).setSize(70,30);      
  cp5.addButton("April").setValue(0).setPosition(1050,20).setSize(70,30);      
  cp5.addButton("May").setValue(0).setPosition(1150,20).setSize(70,30);      
  cp5.addButton("June").setValue(0).setPosition(1250,20).setSize(70,30);      
  cp5.addButton("July").setValue(0).setPosition(750,60).setSize(70,30);      
  cp5.addButton("August").setValue(0).setPosition(850,60).setSize(70,30);      
  cp5.addButton("September").setValue(0).setPosition(950,60).setSize(70,30);      
  cp5.addButton("October").setValue(0).setPosition(1050,60).setSize(70,30);      
  cp5.addButton("November").setValue(0).setPosition(1150,60).setSize(70,30);      
  cp5.addButton("December").setValue(0).setPosition(1250,60).setSize(70,30);
  cp5.addButton("Scatter_Plot").setValue(0).setPosition(70, 65).setSize(75, 40);
  cp5.addButton("Bar_Graph").setValue(0).setPosition(70, 20).setSize(65, 40);
}

//draw function allows buttons to be pressed and the window to be continually updated
void draw(){
  size(1436, 800);
}
