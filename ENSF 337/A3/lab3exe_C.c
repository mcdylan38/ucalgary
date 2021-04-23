/*  lab3exe_C.c
 *  ENSF 337, lab3 Exercise C
 *  Name: Dylan Mah (30086580)
 *  Lab section: B02
 *  Submission date: 10/05/2020
 */

#include <stdio.h>
#include <stdlib.h>

void pascal_triangle(int n);

/* REQUIRES: Input of 0 < n <= 20
 *
 * PROMISES: displays a pascal triangle, where the first 5 line of the function's output should have the following format:
 * row 0:  1
 * row 1:  1   1
 * row 2:  1   2   1
 * row 3:  1   3   3   1
 * row 4:  1   4   6   4   1
 */

int main(){
    int nrow;

    printf("Enter the number of rows (max of 20): ");
    scanf("%d", &nrow);
	
    if(nrow<=0 || nrow>20) {
        printf("Error: the number of rows is invalid. \n");
		exit(1);
    }
    
    pascal_triangle(nrow);
	
    return 0;
}

void pascal_triangle(int n){
	int current[n], prev[n];
	
	for (int i=0; i<n; i++){
        for (int j=0; j<n; j++){
			if(j==i || j==0){
				current[j]=1;	//sets outer elements to 1
			}
			else{
				current[j]=prev[j-1]+prev[j];	//summing of two previous diagonal elements
			}
        }
        for (int k=0; k<=i; k++){
            printf(" %d ", current[k]);
            prev[k]=current[k];		//setting the previous row to be the current row before the next row is updated
        }
        printf("\n");
    }
}
