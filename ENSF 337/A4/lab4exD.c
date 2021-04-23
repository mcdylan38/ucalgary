/* lab4exD.c
 * ENSF 337 Fall 2020 Lab 4 Exercise  D
 */

#include <stdio.h>
#include <string.h>

int my_strlen(const char *s);
/*  Duplicates strlen from <string.h>, except return type is int.
 *
 *  REQUIRES
 *     s points to the beginning of a string.
 *  PROMISES
 *     Returns the number of chars in the string, not including the terminating null.
 */

void my_strncat(char *dest, const char *source, int n);
/*  Duplicates strncat from <string.h>, except return type is void.
 *
 *  REQUIRES
 *     dest and source point to the beginning of two strings.
 *  PROMISES
 *     Appends source to the end of dest. If length of source is more than n. Only copies the first n elements of source.
 */

int my_strncmp(const char* str1, const char* str2);
/*  Duplicates strcmp from <string.h>, except return type is int.
 *
 *  REQUIRES
 *     str1 points to the beginning of a string, and str2 to the beginning of another string.
 *  PROMISES
 *     Returns 0 if str1 and str2 are identical.
 *     Returns a negative number of str1 < str2.
 *     Returns a positive nubmer of str1 > str2.
 */

int main(void){
    char str1[7] = "banana";		//609
    const char str2[] = "-tacit";	//578
    const char* str3 = "-toe";		//373
    
    char str5[] = "ticket";			//644
    char my_string[100]="";			//0
    int bytes;
    int length;
    int y;
    
    printf("TESTING strlen FUNCTION ... \n");
    
    // using strlen function 
    length = (int) my_strlen(my_string);
    printf("\nExpected to display: my_string length is 0.");
    printf("\nmy_string length is %d.", length);
    
    // using sizeof operator
    bytes = sizeof (my_string);
    printf("\nExpected to display: my_string size is 100 bytes.");
    printf("\nmy_string size is %d bytes.", bytes);
    
    // using strcpy C libarary function 
    strcpy(my_string, str1);
    printf("\nExpected to display: my_string contains banana.");
    printf("\nmy_string contains %s", my_string); 
    
    length = (int) my_strlen(my_string);
    printf("\nExpected to display: my_string length is 6.");
    printf("\nmy_string length is %d.", length);
    
    my_string[0] = '\0';	//[\0][a][n][a][n][a]
    printf("\nExpected to display: my_string contains \"\".");
    printf("\nmy_string contains:\"%s\"", my_string);
    
    length = (int) my_strlen(my_string);
    printf("\nExpected to display: my_string length is 0.");
    printf("\nmy_string length is %d.", length);
    
    bytes = sizeof (my_string);
    printf("\nExpected to display: my_string size is still 100 bytes.");
    printf("\nmy_string size is still %d bytes.", bytes);
    
    printf("\n\nTESTING strncat FUNCTION ... \n");
	
    // strncat append the first 3 characters of str5 to the end of my_string
    my_strncat(my_string, str5, 3);
    printf("\nExpected to display: my_string contains \"tic\"");
    printf("\nmy_string contains \"%s\"", my_string);
    
    length = (int) my_strlen(my_string);
    printf("\nExpected to display: my_string length is 3.");
    printf("\nmy_string length is %d.", length);
    
    my_strncat(my_string, str2,  4);
    printf("\nExpected to display: my_string contains \"tic-tac\"");
    printf("\nmy_string contains:\"%s\"", my_string);
    
    // strncat append ONLY up ot '\0' character from str3 -- not 6 characters 
    my_strncat(my_string, str3, 6);
    printf("\nExpected to display: my_string contains \"tic-tac-toe\"");
    printf("\nmy_string contains:\"%s\"", my_string);
    
    length = (int) my_strlen(my_string);
    printf("\nExpected to display: my_string has 11 characters.");
    printf("\nmy_string has %d characters.", length);
    
    printf("\n\nUsing strcmp - C library function: ");
    printf("\nExpected to display: \"ABCD\" is less than \"ABCDE\"");
    printf("\nstrcmp returns %d", strcmp("ABCD", "ABCDE"));   
    
    printf("\n\nTESTING strcmp FUNCTION ... \n");
    if((y = my_strncmp("ABCD", "ABND")) < 0){
        printf("\n\"ABCD\" is less than \"ABND\" ... my_strcmp returns %d", y);
	}
    if((y = my_strncmp("ABCD", "ABCD")) == 0){
        printf("\n\"ABCD\" is equal to \"ABCD\" ... my_strcmp returns %d", y);
	}
    if((y = my_strncmp("ABCD", "ABCd")) < 0){
        printf("\n\"ABCD\" is less than \"ABCd\" ... my_strcmp returns %d", y);
    }
    if((y = my_strncmp("Orange", "Apple")) > 0){
        printf("\n\"Orange\" is greater than \"Apple\" ... my_strcmp returns %d\n", y);
	}
	
    return 0;
}

int my_strlen(const char *s){
	int length=0;
	
	while(*s != '\0'){
		s++;
		length++;
	}
	
	return length;
}

void my_strncat(char *dest, const char *source, int n){	//n = # of characters to append
	//int i=0;
	int j=0;
	
	while(*dest != '\0'){	//Reach end of string
		dest++;
		//i++;
	}
	
	while(j<n){			//When counter is < # of characters, append strings
		*dest=*source;
		
		dest++;
		source++;
		j++;
	}
	*dest='\0';
}

int my_strncmp(const char* str1, const char* str2){
	int diff=0;
	
	while(*str1 != '\0' && *str2 != '\0'){
		diff+=*str1-*str2;
		
		str1++;
		str2++;
	}
	
	return diff;
}
