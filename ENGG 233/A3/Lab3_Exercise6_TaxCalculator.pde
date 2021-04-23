import javax.swing.JOptionPane;
String prov=JOptionPane.showInputDialog("Please enter your province's two-letter abbreviation (e.g., AB for Alberta): ");
String answer=JOptionPane.showInputDialog("Please enter your taxable income: ");
float gIncome=Float.parseFloat(answer);

float tax=0, nIncome=0, taxed=0;

//BC
if(prov.equals("BC") || prov.equals("bc")) {
  if(gIncome>0 && gIncome<=20000) {
    tax=0.2;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>20000 && gIncome<=35000){
    tax=0.225;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>35000 && gIncome<=50000){
    tax=0.3;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>50000 && gIncome<=65000){
    tax=0.325;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>65000 && gIncome<=80000){
    tax=0.365;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>80000 && gIncome<=100000){
    tax=0.393;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>100000 && gIncome<=120000) {
    tax=0.41;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>120000) {
    tax=0.44;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
}

//Saksatchewan & Ontario
if(prov.equals("OT") || prov.equals("ot") || prov.equals("SK") || prov.equals("sk")) {
  if(gIncome>0 && gIncome<=40000) {
    tax=0.25;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>40000 && gIncome<=60000) {
    tax=0.3;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>60000 && gIncome<=80000) {
    tax=0.35;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>80000 && gIncome<=100000) {
    tax=0.4;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>100000 && gIncome<=120000) {
    tax=0.45;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>120000) {
    tax=0.5;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
}

//Alberta
if(prov.equals("AB") || prov.equals("ab")) {
  if(gIncome>0 && gIncome <=40000){
    tax=0.25;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>40000 && gIncome<=80000) {
    tax=0.32;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>80000 && gIncome<=120000) {
    tax=0.36;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
  
  if(gIncome>120000) {
    tax=0.39;
    nIncome=gIncome * (1-tax);
    taxed=gIncome * tax;
  }
}


size(500,350);
PFont f;
f=createFont("Arial",22,true);
textFont(f);

fill(0);  //black
text("Province: " + prov.toUpperCase(),180,50);

fill(#0560FA);  //blue
text("Gross income: " + "$" + nf(gIncome,0,2),30,100);

fill(0);  //black
text("Tax rate: " + nf(tax*100,0,1) + "%",30,140);

fill(#E80004);  //red
text("Tax amount: $" + nf(taxed,0,2),30,180);

fill(#0EA714);  //green
text("Net income: $" + nf(nIncome,0,2),30,220);
//nf function makes float values go to 1 or 2 decimal places

//bar graph for net income
fill(#0EA714);  //green
rect(40,280,410,7);

//bar graph for tax, (tax*410) makes the graph proportionate to the tax amount
fill(#E80004);  //red
rect(40,280,tax*410,7);

//bar graph for gross income
fill(#0560FA);  //blue
rect(40,305,410,7);
