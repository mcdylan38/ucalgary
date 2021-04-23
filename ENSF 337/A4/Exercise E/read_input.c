/* read_input.c
 * ENSF 337 Fall 2020 Lab 4 Exercise  E
 */

#include "read_input.h"

#include <math.h>
#include <string.h>
#include <stdio.h>
 
int get_string(char* digits, int n)
{
  int i = 0, j;
  int length;
  if(fgets(digits, n, stdin) == NULL)
    return EOF;

  /* If there is a newline character in the string replace it with '\0'. */
  length = strlen(digits);
  if (digits[length - 1] == '\n') {
    digits[length - 1] = '\0';
    length--;
  }

  /* remove leading spaces */
  i = 0;
  while(digits[i] == ' ')
    i++;
  length -= i;                  /* number of leading spaces == i. */
  j = 0;
  while (j <= length) {
    digits[j] = digits[i];
    i++;
    j++;
  }

  /* remove trailing spaces */
  if (length > 0) {
    j = length - 1;
    while (digits[j] == ' ')
      j--;
    length = j + 1;
    digits[length] = '\0';
  }

  return 1;
}




