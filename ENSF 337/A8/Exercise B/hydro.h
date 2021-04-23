/* hydro.h
 * ENSF 337 Fall 2020 Lab 8 Exercise B
 * Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 11/24/2020
 */


#include "list.h"

void displayHeader();
//PROMISES: shows information about program
 
int readData(FlowList& list);
/* REQUIRES: item is defined
 * 
 * PROMISES: reads data from input file and returns the number of entries
 */
 
int menu();
//PROMISES: shows options and takes in user input to determine what the program should do
 
void display(FlowList& list);
//PROMISES: shows the content of FlowList
 
void addData(FlowList& list, int yearIn, double flowIn);
/* REQUIRES: item is defined
 * 
 * PROMISES: inserts item into FlowList
 */
 
void removeData(FlowList& list, int yearIn);
/* REQUIRES: item is defined
 * 
 * PROMISES: removes item from FlowList
 */
 
double average(FlowList& list);
/* REQUIRES: FlowList is defined
 * 
 * PROMISES: returns the average flow rate from FlowList
 */
 
void saveData(FlowList& list);
/* REQUIRES: FlowList is defined
 * 
 * PROMISES: outputs the contents of FlowList into an output file
 */
 
void pressEnter();
/* REQUIRES: output file can be written into
 * 
 * PROMISES: when user presses return key, brings up menu
 */
 