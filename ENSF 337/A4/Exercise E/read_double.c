/* read_double.c
 * ENSF 337 Fall 2020 Lab 4 Exercise E
 * Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 10/12/2020
 */
 
#include "read_input.h"

int read_real(char* digits, int n, double* num){
	if(get_string(digits, n)==EOF){
		return EOF;
	}

	if(is_valid_double(digits)){	//if true...
		if(digits[0]=='-'){
			*num=-convert_to_double(digits+1);
		}

		else if(digits[0]=='+'){
			*num=convert_to_double(digits+1);
		}
		
		else{
			*num=convert_to_double(digits);
		}
    return 1;
  }

  return 0;
}

int is_valid_double(const char* digits){
	int i=0;
	int valid=1;
	int d_count=0;
	
	if(digits[0]=='-' || digits[0]=='+'){
		i=1;
	}
	
	if(digits[i]=='\0'){
		valid=0;
	}
	
	else{	//If digits[i] != '\0'...
		while(valid==1 && digits[i] != '\0'){
		if(digits[i]=='.'){		//Checking for decimal point
			d_count++;
			
			if(digits[i+1]<'0' || digits[i+1]>'9'){		//If decimal point is not followed by a number...
				valid=0;
			}
		}
		
		if(digits[i] != '.' && (digits[i]<'0' || digits[i]>'9')){		//If character is not a decimal point and not a number...
			valid=0;
		}
		
		if(d_count>1){		//If there are more than 1 decimal points...
			valid=0;
			break;
		}
		
		i++;
		}
	}
	
	return valid;
}

double convert_to_double(const char* digits){
	//Cannot use library functions
	
	double result=0;
	double sum=0;
	int decimal_found=0;
	double d_count=1;
	
	for(int i=0; digits[i] != '\0'; i++){
		if(digits[i]=='.'){
			decimal_found=1;
		}
		
		sum=digits[i]-'0';
		
		if(digits[i] != '.'){		//If character is a number...
			result=10*result + sum;
			
			if(decimal_found==1){	//Counter for decimal places
				d_count/=10;
			}
		}
	}
	
	return result*d_count;	//Shifts decimal over d_count times
}
