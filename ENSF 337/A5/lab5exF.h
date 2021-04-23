// lab5exF.h
// ENSF - Fall 2020, Exercise F

#ifndef lab5ExF_h
#define lab5ExF_h
typedef struct point{
    char label[10];
    double x ;  // x coordinate for point in a Cartesian coordinate system
    double y;   // y coordinate for point in a Cartesian coordinate system
    double z;   // z coordinate for point in a Cartesian coordinate system
}Point;

void reverse (Point *a, int n);
/* REQUIRES: Elements a[0] ... a[n-2], a[n-1] exists.
 *
 * PROMISES: places the existing Point objects in array a, in reverse order.
 *           The new a[0] value is the old a[n-1] value, the new a[1] is the
 *           old a[n-2], etc.
 */

int search(const Point* struct_array, const char* target, int n);
/* REQUIRES: Elements struct_array[0] ... struct_array[n-2], struct_array[n-1]
 *           exists. target points to string to be searched for.
 *
 * PROMISES: returns the index of the element in the array that contains an
 *           instance of point with a matching label. Otherwise, if there is
 *           no point in the array that its label matches the target-label,
 *           it should return -1.
 *           If there are more than one match in the struct_array, returns
 *           the index of the first occurrence.
 *           In this exercise you are NOT allowed to use any C Library functions
 */

void display_struct_point(const Point x, int i);
void populate_struct_array(Point* array, int n);

#endif /* lab5ExF_h */
