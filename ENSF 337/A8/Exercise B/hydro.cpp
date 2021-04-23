/* hydro.cpp
 * ENSF 337 Fall 2020 Lab 8 Exercise B
 * Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 11/24/2020
 */

#include <fstream>
#include <iostream>
#include <stdlib.h>
#include <string>
#include <sstream>
#include <iomanip>
using namespace std;

#include "hydro.h"

int main(){
	FlowList listA;
	int records=0;
	displayHeader();
	records=readData(listA);
	int yearIn=0;
	double flowIn=0;
	
	while(1){     //infinite loop
		switch(menu()){		
			case 1:
				display(listA);
				pressEnter();
				break;
				
			case 2:
				cout<<"\nPlease enter a year to add: ";
				cin>>yearIn;
				cout<<"Please enter the flow for that year: ";
				cin>>flowIn;
				addData(listA, yearIn, flowIn);
				pressEnter();
				break;
				
			case 3:
				saveData(listA);
				pressEnter();
				break;
				
			case 4:
				cout<<"\nPlease enter the year to remove: ";
				cin>>yearIn;
				removeData(listA, yearIn);
				pressEnter();
				break;
				
			case 5:
				cout<<"\nProgram terminated successfully. \n";
				exit(1);
				
			default:	//if input is not 1, 2, 3, 4, 5...
				cout<<"\nInvalid input. \n";
				pressEnter();
				break;
		}
	}
	
	return 0;
}

void displayHeader(){
	//Displays intro screen (program name, version, lab section, name)
	cout<<"Program: Flow Studies, Fall 2020 \nVersion: 1.0 \nLab section: B02 \nProduced by: Dylan Mah (30086580)";
	pressEnter();
}

int readData(FlowList &list){
	//records years and flows from input file and inserts them into list, returns number of records in input file
	int count=0;
	int yearX=0;
	double flowX=0;
	string text;
	stringstream ss;
	
	ifstream input("C:\\cygwin64\\home\\Dylan\\ENSF337\\lab8\\B\\flow.txt");
	ListItem *temp=new ListItem;
	
	while(getline(input, text)){     //while getline() doesn't return NULL...
		stringstream ss(text);
		ss>>yearX>>flowX;
		//cout<<yearX<<"   "<<flowX<<endl;
		
		temp->year=yearX;
		temp->flow=flowX;
		list.insert(*temp);
		
		count++;
	}
	
	input.close();
	delete temp;
	
	return count;
}

int menu(){
	//displays a menu and returns user's choice
	cout<<"\nPlease select one of the following operations: \n"
	<<"1. Display flow list and average flow \n"
	<<"2. Add data to list \n"
	<<"3. Save data to file \n"
	<<"4. Remove data from list \n"
	<<"5. Quit \n"
	<<"Enter your choice of 1, 2, 3, 4 or 5: ";
	
	int option;
	cin>>option;
	return option;
}

void display(FlowList &list){
	//displays years and flows and shows AVERAGE of flows	
	cout<<"\nYear          Flow (in billions of cubic meters) \n";
	list.print();
	
	double a=average(list);	//should be 3025.22/15 = 201.6813
	cout<<"\nAnnual average of flow is: "<<a<<" bilion cubic meters. \n";
}

void addData(FlowList &list, int yearIn, double flowIn){
	//prompts user to enter new data nd inserts it into linked lists, updates number of records
	if(list.searchYear(yearIn)==0){     //if yearIn doesn't exist in list, add data
		ListItem *newItem=new ListItem;
		newItem->year=yearIn;
		newItem->flow=flowIn;
		list.insert(*newItem);
		cout<<"\nNew record inserted successfully.";
		delete newItem;
	}
	
	else{
		cout<<"\nError: duplicate data.";
	}
}

void removeData(FlowList &list, int yearIn){
	//prompts user to indicate what year to be removed and removes that record from list, updates number of records		
	if(list.searchYear(yearIn)==0){
		cout<<"\nError: No such data exists.";
	}
	
	else{     //if yearIn does exist in list, remove data
		list.remove(yearIn);
		cout<<"\nRecord was successfully removed.";
	}
}

double average(FlowList& list){
	//returns flow average in current list
	return list.averageFlow();
}

void saveData(FlowList &list){
	//opens flow.txt file for writing and writes content of linked list into file
	list.saveList("flow.txt");
}

void pressEnter(){
	//program continues if user presses enter/return key, should occur after every function is called	
	cout<<"\n<<<Press ENTER to continue>>>";
	cin.get();
	
	if(cin.get()=='\n'){
		ifstream input("C:\\cygwin64\\home\\Dylan\\ENSF337\\lab8\\B\\flow.txt");
		
		if(input.fail()){
			cout<<"Error opening file... Exiting program. \n";
			exit(1);
		}
		
		input.close();

	}
}

