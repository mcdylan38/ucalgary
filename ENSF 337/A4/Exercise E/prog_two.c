/* prog_two.c
 * ENSF 337 Fall 2020 Lab 4 Exercise  E
 * Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 10/12/2020
 */

#include <stdio.h>
#include <limits.h>
#include "read_input.h"

#define SIZE 50

int main(void){
  double n=0;
  char digits[SIZE];  

  int y=EOF;
  
  while(1){	//Infinite loop
    printf("Enter a double or press Ctrl-D to quit: ");
    y=read_real(digits, SIZE, &n); 
  
    if(y==1){
		printf("Your double value is: %lf \n\n", n);	//Should've been %0.10lf
	}
	
    else if(y==EOF){
		printf("\nGood Bye.\n");
		break;
	}
	
    else{
		printf("%s is an invalid double. \n\n", digits);
	}
  }
    
  return 0;
}
