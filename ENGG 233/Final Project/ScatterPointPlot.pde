void drawScatterPlot(float min[], float max[]){
  //create new object to import csv data
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");

  //loop to create scatter plot
  for(int i=0; i<object.dataTable.getRowCount(); i++){  //use values from arrays to make circles for scatter plot
    float maxTemp=max[i];
    fill(#FF0000);
    circle(62+3.75*i, 500-12*maxTemp, 5);

    float minTemp=min[i];
    fill(#0092FF);
    circle(62+3.75*i, 500-12*minTemp, 5);
  }
}

void drawSnowScatter(float snow[], float min[]){
  //create new object to import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");

  //loop to draw snow fall bar charts
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    float snowFall=snow[i];
    float minTemp=min[i];
    fill(255);
    circle(62+3.75*i, 500-12*snowFall, 5);
    fill(#0092FF);
    circle(62+3.75*i, 500-12*minTemp, 5);
  }
}

void drawMaxScatter(float max[]){
  //create new object to import csv data
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");

  //loop to create scatter plot
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    //use values from arrays to make circles for scatter plot
    float maxTemp=max[i];
    fill(#FF0000);
    circle(62+3.75*i, 500-12*maxTemp, 5);
  }
}

void drawMinScatter(float min[]){
  //create new object to import csv data
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");

  //loop to create scatter plot
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    //use values from arrays to make circles for scatter plot
    float minTemp=min[i];
    fill(#0092FF);
    circle(62+3.75*i, 500-12*minTemp, 5);
  }
}

void drawRangeScatter(float min[], float max[], int start, int end){
  //if the start and end of the range are the same, the code changes so a decision structure is necessary to apply different code for the
  //2 scenarios
  
  if(start!=end){  //shows 2+ years worth of temp data and adjusts the starting position based on the starting year
    for(int i=0; i<(end-start)*12; i++){
      float minTemp=min[i];
      float maxTemp=max[i];
      
      fill(#FF0000);  //red
      circle((62.5+44.5*(start-1990))+3.75*i, 500-12*maxTemp, 5);
      fill(#0092FF);  //blue
      circle((62.5+44.5*(start-1990))+3.75*i, 500-12*minTemp, 5);
      
      if(maxTemp < 0){
        fill(#FF0000);  //red
        circle((62.5+44.5*(start-1990))+3.75*i, 500-12*maxTemp, 5);
      }
    }
  }
  else{  //if start=end, only 12 entries are shown compared to the 24+ shown if start=/=end, still adjusts starting point based on starting year
    for(int i=start-1990; i<12; i++){
      float minTemp=min[i];
      float maxTemp=max[i];
      
      fill(#FF0000);  //red
      circle((62.5+44.5*(start-1990))+3.75*i, 500-12*maxTemp, 5);
      fill(#0092FF);  //blue
      circle((62.5+44.5*(start-1990))+3.75*i, 500-12*minTemp, 5);
      
      if(maxTemp < 0){
        fill(#FF0000);  //red
        circle((62.5+44.5*(start-1990))+3.75*i, 500-12*maxTemp, 5);
      }
    }
  }
}

void drawFilterMonthScatter(int m, float min[], float max[]){
  //declare new object and import csv values
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  int month []=new int [object.dataTable.getRowCount()];
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    month[i]=new Date().month;
  }
  fillMonth(month);
  
  for (int i=0; i<object.dataTable.getRowCount(); i++){
    if (month[i]==m){
      float maxTemp=min[i];
      float minTemp=max[i];
      fill(#FF0000);
      circle(62+3.75*i, 500-12*minTemp, 5);
      fill(#0092FF);
      circle(62+3.75*i, 500-12*maxTemp, 5);
    }
  }
}
