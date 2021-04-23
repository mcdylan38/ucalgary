void graphSkeleton(int colour){
  fill(0, 100, 0);
  rect(60, 0, 2, 800);   //y-axis 
  fill(0);    //y-axis Text Colour
  textSize(11);
  //positive Y-Values
  text("25", 38, 200);
  text("20", 38, 260);
  text("15", 38, 320);
  text("10", 38, 380);
  text(" 5", 38, 440);

  //negative section of y-axis 
  text("-5", 37, 560); 
  text("-10", 33, 620); 
  text("-15", 33, 680);
  text("-20", 33, 740); 
  fill(0, 100, 0);
  rect(60, 500, 1436, 2);  //x-axis
  fill(colour); //X-Axis text colour
  for(int i=0; i<=14; i++){
    text(1991+2*i, 95+90*i, 522);
  }
}

public void Bar_Graph(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  background(#DBDBDB);
  drawBarChart(minTemp, maxTemp);
  graphSkeleton(255);
}

public void Scatter_Plot(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  
  //reset background, draw graph and redraw axis on top of graph for scatter plot
  background(#DBDBDB);
  drawScatterPlot(minTemp, maxTemp);
  graphSkeleton(0);
}

public void Snow_Fall(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating array to store the objects in
  float snowFall []=new float[object.dataTable.getRowCount()];
  float minTemp []=new float[object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    snowFall[i]=new TempData().snowFall;
    minTemp[i]=new TempData().minTemp;
  }
  //function to fill the array
  fillSnow(snowFall);
  fillMin(minTemp);
  
  //reset background, draw graph and redraw axis on top of graph for snow fall
  if(Bar_or_Scatter==true){
  background(#DBDBDB);
  drawSnowBar(snowFall, minTemp);
  graphSkeleton(255);
  }
  else{
    background(#DBDBDB);
    drawSnowScatter(snowFall, minTemp);
    graphSkeleton(0);
  }
}

public void Min_Only(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawMinBar(minTemp);
    graphSkeleton(255);
  }
  else{
    background(#DBDBDB);
    drawMinScatter(minTemp);
    graphSkeleton(0);
  }
}

public void Max_Only(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float maxTemp []=new float [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    maxTemp[i]=new TempData().minTemp;
  }
  //functions to fill the arrays
  fillMax(maxTemp);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawMaxBar(maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawMaxScatter(maxTemp);
    graphSkeleton(0);
  }
}

public void January(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(1, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(1, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void February(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(2, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(2, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void March(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(3, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(3, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void April(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(4, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(4, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void May(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(5, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(5, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void June(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(6, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(6, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void July(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(7, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(7, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void August(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(8, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(8, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void September(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(9, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(9, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void October(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(10, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(10, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void November(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(11, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(11, minTemp, maxTemp);
    graphSkeleton(0);
  }
}

public void December(){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //creating arrays to store the objects in
  float minTemp []=new float [object.dataTable.getRowCount()];
  float maxTemp []=new float [object.dataTable.getRowCount()];
  int month []=new int [object.dataTable.getRowCount()];
  //loop to declare each array entry as a new object
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    minTemp[i]=new TempData().minTemp;
    maxTemp[i]=new TempData().maxTemp;
    month[i]=new Date().month;
  }
  //functions to fill the arrays
  fillMin(minTemp);
  fillMax(maxTemp);
  fillMonth(month);
  
  //reset background, draw graph and redraw axis on top of graph for bar graph
  if(Bar_or_Scatter==true){
    background(#DBDBDB);
    drawFilterMonthBar(12, minTemp, maxTemp);
    graphSkeleton(0);
  }
  else{
    background(#DBDBDB);
    drawFilterMonthScatter(12, minTemp, maxTemp);
    graphSkeleton(0);
  }
}
