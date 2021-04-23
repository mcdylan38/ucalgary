#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;

void insertion_sort(int *int_array, int n);
/* REQUIRES
 *    n > 0, array elements int_array[0] ... int_array[n - 1] exist.
 * PROMISES
 *    Element values are rearranged in non-decreasing order.
 */

void insertion_sort(const char** str_array, int n);
/* REQUIRES
 *   n > 0, array elements str_array[0] ... str_array[n - 1] exist.
 * PROMISES
 *   pointers in str_array are rearranged so that strings:
 *   str_array[0] points to a string with the smallest string (lexicographically), str_array[1] points to the second smallest string, 
 *   all the way to str_array[n-2], which points to the second largest, and str_array[n-1] points to the largest string
 */

int main(void){
    const char* s[] = {"AB", "XY", "EZ"};
    const char** z = s;
    z += 1;     //z[1] = s[1][0] = "X"
    
    cout << "The value of **z is: " << **z << endl;
    cout << "The value of *z is: " << *z << endl;
    cout << "The value of **(z-1) is: " << **(z-1)<< endl;
    cout << "The value of *(z-1) is: " << *(z-1)<< endl;
    cout << "The value of z[1][1] is: " << z[1][1]<< endl;
    cout << "The value of *(*(z+1)+1) is: " << *(*(z+1)+1)<< "\n\n";
 
    // point 1
	
    int a[] = { 413, 282, 660, 171, 308, 537 };
    int i;
    int n_elements = sizeof(a) / sizeof(int);
    
    cout << "Here is your array of integers before sorting: \n";
    for(i = 0; i < n_elements; i++){
        cout <<  a[i] << endl;
	}
    cout << endl;
    
    insertion_sort(a, n_elements);
    
    cout << "Here is your array of ints after sorting:  \n" ;
    for(i = 0; i < n_elements; i++){
        cout << a[i] << endl;
	}
	cout<<endl;
	
#if 1
    const char* strings[] = { "Red", "Blue", "pink", "apple", "almond", "white", "nut", "Law", "cup"};
    n_elements = sizeof(strings) / sizeof(char*);
    
    cout << "Here is your array of strings before sorting: \n";
    for(i = 0; i < n_elements; i++){
        cout <<  strings[i] << endl;
	}
    cout << endl;
	
    insertion_sort(strings, 9);
    
    cout << "Here is your array of strings after sorting:  \n" ;
    for(i = 0; i < n_elements; i++){
        cout << strings[i] << endl;
	}
    
#endif
    
    return 0;
}

void insertion_sort(int *int_array, int n){     //for array of numbres
    int i;
    int j;
    int value_to_insert;
    
    for (i = 1; i < n; i++){
        value_to_insert = int_array[i];
        
        /* Shift values greater than value_to_insert. */
        j = i;
		
        while(j > 0 && int_array[j - 1] > value_to_insert){
            int_array[j] = int_array[j - 1];
            j--;
        }
        
        int_array[j] = value_to_insert;
    }
}

void insertion_sort(const char** sArray, int n){     //for array of strings (array of char arrays)	
	const char *temp;
	
	for(int i=1; i<n; i++){     //set i=1 because first element is already sorted
		for(int j=0; j < n-i; j++){     //compare j to n-i because we assume that the previous elements (elements 0 to n-i) are sorted
			if(strcmp(sArray[j], sArray[j+1]) > 0){     //if element j is greater (in terms of ASCII value) than the next element (j+1), swaps them
				temp=sArray[j];
				sArray[j]=sArray[j+1];
				sArray[j+1]=temp;
			}
		}
	}
}
