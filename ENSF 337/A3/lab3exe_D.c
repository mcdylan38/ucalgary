/* lab3exe_D.c
 * ENSF 337, Lab 3 Exercise D
 * Name: Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 10/05/2020
 */

#include <stdio.h>
#include <string.h>

int substring(const char *s1, const char *s2);
/* REQUIRES
 * s1 and s2 are valid C-string terminated with '\0';
 *
 * PROMISES
 * returns 1 if s2 is a substring of s1. Otherwise returns 0.
 */

void select_negatives(const int *source, int n_source, int* negatives_only, int* number_of_negatives);
/* REQUIRES
 *   n_source >= 0.
 *   Elements source[0], source[1], ..., source[n_source - 1] exist.
 *   Elements negatives_only[0], negatives_only[1], ..., negatives_only[n_source - 1] exist.
 *
 * PROMISES
 *   number_of_negatives == number of negative values in source[0], ..., source[n_source - 1].
 *   negatives_only[0], ..., negatives_only[number_of_negatives - 1] contain those negative values, in
 *   the same order as in the source array.
 */

int main(void){
	//int a[] = { -10, 9, -17, 0, -15 };
	int a[]={4, -57, 800, -22, -45, 3, -999};
	int negative[5];
    int size_a, i, n_negative;
    
    size_a = sizeof(a) / sizeof(a[0]);
	
    printf("a has %d elements:", size_a);
    for (i = 0; i < size_a; i++){
        printf("  %d", a[i]);
	}
	printf("\n");
	
    select_negatives(a, size_a, negative, &n_negative);
	
    printf("Negative elements from array a are as follows:");
    for (i = 0; i < n_negative; i++){
		//if(negative[i] != 0)
			printf("  %d", negative[i]);
	}
    printf("\n\n");
	
	char s[] = "Knock knock! Who's there?";		//array length = 25
	
	printf("Substring returned %d for 'Who' \n", substring(s, "Who"));				//1
	printf("Substring returned %d for 'knowk' \n", substring(s, "knowk"));			//0
	printf("Substring returned %d for 'knock' \n", substring(s, "knock"));			//1
	printf("Substring returned %d for '' \n", substring(s, ""));					//0
	printf("Substring returned %d for 'ck! Who's' \n", substring(s, "ck! Who's"));	//1
	printf("Substring returned %d for 'ck!Who's' \n", substring(s, "ck!Who's"));	//0
	printf("Substring returns %d for 'there' \n", substring(s, "there"));			//1
	
    return 0;
}

int substring(const char *s1, const char* s2){	//s1 is whole string, s2 is substring
	int c1=0, c2=0, x;
	
	if(s2[0]=='\0' || s1[0]=='\0'){
		return 0;
	}
	
	while(s1[c1] != '\0'){	//finding length of s1
        c1++;
	}
    while(s2[c2] != '\0'){	//finding legnth of s2
        c2++;
	}
	
    for(int i=0; i<=c1-c2; i++){	//loop works as long as s1 >= s2
        for(int j=i; j<i+c2; j++){
            x=1;
			
            if(s1[j] != s2[j-i]){	//if characters don't match, exit inner loop
                x=0;
                break;
            }
        }
        if(x==1){	//when s2 has been found in s1, exit outer loop
            break;
		}
    }
	
    if (x==1){		//if s2 is in s1, returns 1
        return 1;
	}
    else{			//if s2 is NOT in s1, returns 0
        return 0;
	}
}

void select_negatives(const int *source, int n_source, int* negatives_only, int* number_of_negatives){
	int j=0;
	*number_of_negatives=0;
	
	if(n_source>=0){
		for(int i=0; i<n_source; i++){
			if(source[i]<0){
				negatives_only[j]=source[i];	//Negatives_only is ONLY updated when source[i] < 0
				j++;
				(*number_of_negatives)++;
			}
		}
	}
	
	else{
		printf("Invalid array entered");
	}
	
    return;
}

