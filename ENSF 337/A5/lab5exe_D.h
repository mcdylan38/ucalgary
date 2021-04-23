// ENSF 337 - Fall 2020 - lab 5 - exercise D
//  lab5exe_D.h

#ifndef lab5ExD_h
#define lab5ExD_h

#define MAX_CAPACITY 100

typedef struct IntVector{
    int storage[MAX_CAPACITY];
    int number_of_data;
} IntVector;


void read_text_file (IntVector * vec, const char* filename);
/* REQUIRES: intV points to an existing array of IntVector.
 *
 * PROMISES: opens a text file with the given name by filename string.
 *           Reads the integer values in the text file into storage array in *vec
 */


void display_single_column(const IntVector *intV);
/* REQUIRES: intV points to an existing array of IntVector.
 *
 * PROMISES: displays data in each element of storage array, in intV, into the
 *           on the screen, in a single column.
 */


void display_multiple_column(const IntVector *intV, int col, const char* filename);
/* REQUIRES: intV points to an existing object of IntVector. col > 0.
 *
 * PROMISES: opens a text file with the given name by the string filename, and
 *           saves the data in the storage array of intV, into the opened text
 *           file, in tabular format (like a table depending on the value of col).
 *           For example if col is 3 and storage contains values:
 *           30, 40, 50, 70, 90, 3, 4, 5. It will print the data into the text
 *           file in 3 columns, as follows:
 *           30  40  50
 *           70  90   3
 *            4   5
 *
 *           However, if col is greater than or equal number of the data in the
 *           array,for example, 8 or more, the data will be saved in the following
 *           format (8 columns but only one row):  30  40  50  70  90  3  4  5
 *           In other words, columns in the file, will be the number of data
 *           in the array printed in one row.
 */

#endif 
