// lab5exF.c
// ENSF 337- Fall 2020, Exercise F

#include "lab5exF.h"
#include <stdio.h>
#include <math.h>
#include<string.h>

int main(void){
    Point struct_array[10];
    int i;
    int position;
    
    populate_struct_array(struct_array, 10);
    printf("Array of Points contains: \n");
    for(i=0; i < 10; i++){
        display_struct_point(struct_array[i], i);
	}
    
    printf("\nTesting the search function... \n");    
    position = search(struct_array, "v0", 10);
    if(position != -1){
        printf("\nFound: struct_array[%d] contains %s", position, struct_array[position].label);
	}
    else{
        printf("\nstruct_array doesn't have label: %s.", "v0");
	}
    
    position = search(struct_array, "E1", 10);
    if(position != -1){
        printf("\nFound: struct_array[%d] contains %s", position, struct_array[position].label);
	}
    else{
        printf("\nstruct_array doesn't have label: %s.", "E1");
	}
    
    position = search(struct_array, "C5", 10);
    if(position != -1){
        printf("\nFound: struct_array[%d] contains %s", position, struct_array[position].label);
	}
    else{
        printf("\nstruct_array doesn't have label: %s.", "C5");
	}
    
    position = search(struct_array, "B7", 10);
    if(position != -1){
        printf("\nFound: struct_array[%d] contains %s", position, struct_array[position].label);
	}
    else{
        printf("\nstruct_array doesn't have label: %s.", "B7");
	}
	
    position = search(struct_array, "A9", 10);
    if(position != -1){
        printf("\nFound: struct_array[%d] contains %s", position, struct_array[position].label);
	}
    else{
        printf("\nstruct_array doesn't have label: %s.", "A9");
	}
		
    position = search(struct_array, "E11", 10);
    if(position != -1){
        printf("\nFound: struct_array[%d] contains %s", position, struct_array[position].label);
	}
    else{
        printf("\nstruct_array doesn't have label: %s.", "E11");
	}
    
    position = search(struct_array, "M1", 10);
    if(position != -1){
        printf("\nFound: struct_array[%d] contains %s \n", position, struct_array[position].label);
	}
    else{
        printf("\nstruct_array doesn't have label: %s. \n", "M1");
    }
	
    printf("\nTesting the reverse function... \n");
    reverse(struct_array, 10);
    printf("\nThe reversed array is: \n");
    for(i=0; i < 10; i++)
        display_struct_point(struct_array[i], i);
    
    return 0;
}

void display_struct_point(const Point x , int i){
    printf("struct_array[%d]: %s <%.2lf, %.2lf, %.2lf> \n", i, x.label, x.x, x.y, x.z);
}

void populate_struct_array(Point* array, int n){
    int i;
    char ch1 = 'A';
    char ch2 = '9';
    char ch3 = 'z';
    
    for(i = 0; i < n; i++){
        /* generating some random values to fill them elements of the array: */
        array[i].x = (7 * (i + 1) % 11) * 100 - i / 2;
        array[i].y = (7 * (i + 1) % 11) * 120 - i / 3;
        array[i].z = (7 * (i + 1) % 11) * 150 - i / 4;
        
        if(i % 2 == 0){
            array[i].label[0] = ch1++;
		}
        else{
            array[i].label[0] = ch3--;
		}
		
        array[i].label[1] = ch2--;
        array[i].label[2] = '\0';
    }
}

int search(const Point* struct_array, const char* target, int n){
    //YOU ARE NOT ALLOWED TO USE ANY C LIBRARY FUNCTION IN YOUR SOLUTION
	//Returns index of first occurence of target in struct_array
	
	int i=0, j=0, index=0;
	
	if(struct_array[0].label[0]=='\0'){
		return -1;
	}
	
	while((struct_array[i].label[j] != '\0' || target[j] != '\0') && i<n){	//Cycles through struct_array to check if label matches target	
		if(struct_array[i].label[j]==target[j]){
			index=i;
			j++;
		}
		else if((struct_array[i].label[j] != '\0' && target[j]=='\0') || (struct_array[i].label[j]=='\0' && target[j] != '\0') || (struct_array[i].label[j] != target[j])){
			index=-1;
			i++;
		}
	}
	
    return index;
}

void reverse (Point *a, int n){
    //Reverses elements of array a with length n
	
	Point temp[n];
	int i, j, k, l;
	
	if(a!=NULL){				//if a is not empty...
		for(i=0; i < n; i++){	//Copying a into temp
			temp[i].x=a[i].x;
			temp[i].y=a[i].y;
			temp[i].z=a[i].z;
		
			for(j=0; a[i].label[j] != '\0'; j++){
				temp[i].label[j]=a[i].label[j];
			}
			temp[i].label[j]='\0';
		}
	
		for(k=0; n >= 1; k++){		//Reversing a
			a[k].x=temp[n-1].x;
			a[k].y=temp[n-1].y;
			a[k].z=temp[n-1].z;
		
			for(l=0; a[k].label[l] != '\0'; l++){
				a[k].label[l]=temp[n-1].label[l];
			}
			a[k].label[l]='\0';
		
			n--;
			}
		}
	
	else{
		printf("Array could not be reversed");
	}
}
