class TempData{
  Date monthYear;
  Main data;
  float minTemp;
  float maxTemp;
  float snowFall;

  TempData(){
    monthYear=new Date();
    data=new Main();
    minTemp=0;
    maxTemp=0;
    snowFall=0;
  }
}

void fillMin(float min[]){
  //create object to import csv data
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //loop to fill array with csv data for minimum temperature
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    TableRow row=object.dataTable.getRow(i);
    min[i]=row.getFloat("Min Temp");
  }
}

void fillMax(float max[]){
  //create object to import csv data
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //loop to fill array with csv data for maximum temperature
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    TableRow row=object.dataTable.getRow(i);
    max[i]=row.getFloat("Max Temp");
  }
}

void fillSnow(float snow[]){
  //create object to import csv data
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //loop to fill array with csv data for snow fall amount
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    TableRow row=object.dataTable.getRow(i);
    snow[i]=row.getFloat("Snow Fall");
  }
}
