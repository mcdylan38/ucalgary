/*	lab1exe_B.c
	ENSF 337 - Fall 2020 Lab 1 - Exercise B
	Completed by: Dylan Mah (30086580)
	Lab Section: B02  
	Submission date: 9/21/2020	*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define G 9.8
#define PI 3.141592654

void create_table(double v);
double Projectile_travel_time(double a, double v);
double Projectile_travel_distance(double a, double v);
double degree_to_radian(double d);

int main(void){
    int n;
    double velocity;
    
    printf ("Please enter the velocity at which the projectile is launched (m/sec): ");
    n = scanf("%lf", &velocity);
    
    if(n != 1){
        printf("Invlid input. Bye...\n\n");
        exit(1);
    }
    
    while (velocity < 0 ){
        printf ("Please enter a positive number for velocity: ");
        n = scanf("%lf", &velocity);
        if(n != 1){
            printf("Invlid input. Bye...\n\n");
            exit(1);
        }
    }
	
	create_table(velocity);
    
    return 0;
}

void create_table(double v){
	printf("\nAngle (deg)     t (sec)          d (m) \n");
	double a1=0;
	double a2=0;
	double t=0;
	double d=0;
	
	for (int n=0; n<19; n++){
		a2=degree_to_radian(a1);
		t=Projectile_travel_time(a2, v);
		d=Projectile_travel_distance(a2, v);
		
		printf("%lf        %lf        %lf \n", a1, t, d);
		a1+=5;
	}
}

double Projectile_travel_time(double a, double v){
	double t=2*v*sin(a)/G;
	return t;
}

double Projectile_travel_distance(double a, double v){
	double d=pow(v,2)/G*sin(2*a);
	return d;
}

double degree_to_radian(double d){
	double convert=d*PI/180;
	return convert;
}

