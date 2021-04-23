/* ENSF 337 Lab 9 - Exercise E
 * matrix.h
 * Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 11/__/2020
 */

#ifndef lab9_Dynamic_Matrix__matrix__
#define lab9_Dynamic_Matrix__matrix__

#include <fstream>
#include <iostream>
#include <iomanip>
#include <cassert>
using namespace std;

class Matrix{
public:
    Matrix(int m, int n);
    // REQUIRES: m and n refer to the number of rows and columns in a numeric matrix.
    // PROMISES: - assigns matrixM, to a dynamically allocated array of m double-pointer, where each pointer points to a dynamically allocated array of n doubles.
    //           - assigns sum_rowsM to a dynamically allocated array of m doubles
    //           - assigns sum_colsM to a dynamically allocated array of n doubles
    //           - initializes rowsM and colsM with the values of m and n respectively
    

    Matrix():matrixM(NULL), sum_rowsM(NULL), sum_colsM(NULL), rowsM(0), colsM(0){}    //Default constructor
    ~Matrix();
	//PROMISES: - calls helper function destroy
	
    Matrix& operator=(const Matrix& rhs);
    Matrix(const Matrix& source);// copy constructor    
    int get_rows() const {return rowsM;}    
    int get_cols() const {return colsM;}
    
    double& at(int r, int c) {return matrixM[r][c];}
    // PROMISES: returns the value in the r_th row and c_th column of matrixM
    
    const double& at(int r, int c)const {return matrixM[r][c];}
    // PROMISES: returns the value in the r_th row and c_th column of matrixM
    
    double get_sum_col(int i) const;
    // REQUIRES: i >=0 and i < colsM
    // PROMISES: returns sum of the values in the i_th column
	
    double get_sum_row(int i) const;
    // REQUIRES: i >=0 and i < rowsM
    //PROMISES: returns sum of the values in the i_th row
	
    void sum_of_rows()const;
    // PROMISES: calculate sum of values in each row of the matrix, storing them into the elements of sum_rowsM array, already created by the constructor
    
    void sum_of_cols()const;
    // PROMISES: calculate sum of values in each column of the matrix, storing them into the elements of the sum_colsM array, already create by a constructor
    
private:
    double** matrixM;   // points to an array of double-pointers on the heap
    double* sum_rowsM;   // points to an array of doubles on the heap
    double* sum_colsM;   // points to an array of doubles on the heap
    int rowsM;           // number of rows of matrix
    int colsM;           // number of columns of matrix
    
    void copy(const Matrix& source);
    // PROMISES: makes this matrix a copy of source
    
    void destroy();
    //PROMISES: - deallocates memory which is dynamically allocated for each pointer in each element matrixM. Then deallocates memory which is dynamiclaly allocated for
	//			  matrixM. Also deallocates memories allocated for arrays sum_colsM, and sum_rowsM.
};

#endif /* defined(lab9_Dynamic_Matrix__matrixM__) */
