/* prog_one.c
 * ENSF 337 Fall 2020 Lab 4 Exercise  E
 */

#include <stdio.h>
#include <limits.h>
#include "read_input.h"

#define SIZE 50

int main(void){
  int n = 0;
  char digits[SIZE];  

  int y = EOF;
  
  while (1){
	printf("Enter an integer or press Ctrl-D to quit: ");
    y = read_integer(digits, SIZE, &n); 
  
    if(y == 1){
		printf("Your integer value is: %d \n\n", n);
	}
    else if(y == EOF){
		printf("\nGood Bye.\n");
		break;
	}
    else{
		printf("%s is an invalid integer. \n\n", digits);
	}
  }
    
  return 0;
}
