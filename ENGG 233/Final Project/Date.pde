class Date{
  int month;
  int year;

  Date(){
    month=0;
    year=0;
  }
}

void fillMonth(int m[]){
  //create object to import csv data
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //loop to fill array with csv data for year and month
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    TableRow row=object.dataTable.getRow(i);
    m[i]=row.getInt("Month");
  }
}

void fillYear(int y[]){
  //create object to import csv data
  Main object=new Main();
  object.filePath="C:\\Users\\coolp\\Documents\\Processing\\ENGG 233 Assignments\\FileIO\\Data\\CalgaryWeather.csv";
  object.dataTable=loadTable(object.filePath, "header");
  
  //loop to fill array with csv data for year and month
  for(int i=0; i<object.dataTable.getRowCount(); i++){
    TableRow row=object.dataTable.getRow(i);
    y[i]=row.getInt("Year");
  }
}
