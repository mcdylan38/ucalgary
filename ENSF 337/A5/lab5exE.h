/* File: lab5exE.h
 * ENSF Fall 2020 - lab 5 - Exercise E
 */

#ifndef lab5ExE_h
#define lab5ExE_h

typedef struct point{		//a structure that represents a point on a Cartesian coordinates system.
    char label[10];  // a label for a point
    double x ;       // x coordinate for point in a Cartesian coordinate system
    double y;        // y coordinate for point in a Cartesian coordinate system
	double z;
} Point;

Point mid_point(const Point* p1, const Point* p2, const char* label);
/* REQUIRES:
 *   p1 and p2 point to Point objects
 *
 * PROMISES:
 *   returns an object of Point that its x and y coordinates are the middle-
 *   point of those objects that p1 and p2 are pointing to. The returned
 *   object's label will be the copy of argument label.
 */

void swap(Point* p1, Point *p2);
/* REQUIRES:
 *   p1 and p2 point to objects of Point
 *
 * PROMISES:
 *   swaps the values of data members in the two objects *p1 and *p2.
 */

void display_struct_point(const Point x);

double distance (const Point* a, const Point* b);
/* REQUIRES:
 *   a and b point to objects of Point
 *
 * PROMISES:
 *   returns the distance between objects that a and b are pointing to.
 */
 
#endif /* lab5ExE_h */
