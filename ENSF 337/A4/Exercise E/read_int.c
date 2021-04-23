/* read_int.c
 * ENSF 337 Fall 2020 Lab 4 Exercise  E
 */

#include "read_input.h"

int read_integer(char* digits, int n, int* num)
{
  if(get_string(digits, n)== EOF)
    return EOF;

  if(is_valid_integer(digits)){	//if true...
    if(digits[0] == '-')
      *num = -convert_to_integer(digits + 1);
    else if(digits[0] == '+') 
      *num = convert_to_integer(digits + 1);
    else
      *num = convert_to_integer(digits);
    return 1;
  }

  return 0;
}


int is_valid_integer(const char* digits)
{
  int valid = 1;
  int i;

  /* i = index where first digit should be */
  if(digits[0] == '+' || digits[0] == '-')
    i = 1;
  else
    i = 0;

  /* Must have at least one digit, and no non-digits. */
  if (digits[i] == '\0')
    valid = 0;
  else
    while (valid && (digits[i] != '\0')) {
      if(digits[i] < '0' ||  digits[i] > '9')
        valid = 0;
      i++;
    }
  
  return valid;
}


int convert_to_integer(const char* digits)
{
  int sum = 0;
  int i = 0;
  
  while(digits[i] != '\0') {
    sum = 10 * sum + (digits[i] - '0');
    i++;
  }
  return sum;
}
