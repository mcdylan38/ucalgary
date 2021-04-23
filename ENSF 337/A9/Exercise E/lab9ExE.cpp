//  lab9ExE.cpp

#include <iostream>
#include <fstream>
#include <iomanip>
#include <stdlib.h>
using namespace std;

#include "matrix.h"

void populate_matrix(Matrix& m, int seed);
// PROMISES: populates the elements of matrix m with arbitrary double numbers.
//           using seed to produce different values.

bool not_all_digits(const char* str);
// REQUIRES: returns true if any charactres in str is not a digit

void print(const Matrix& m);
// PROMISES: prints the values of the matrix in tabular format.

void print_with_sum(const Matrix& m);
// PROMISES: prints the matrix in tabular format, plus sum of its rows and columns

int main(int argc, const char * argv[]){
    int row, col;
    
    if(argc < 3){
        cout << "\nError: too few arguments";
        exit(1);
    }
    
    if(not_all_digits(argv[1])){
       cout << " The arguments of " << argv[0] << " must be digits.";
       exit(1);
    }
    
    if(not_all_digits(argv[2])){
        cout << " The arguments of " << argv[0] << " must be digits.";
        exit(1);
    }
  
    //library function atoi converts a string of digits to integer number
    row = atoi(argv[1]);
    col = atoi(argv[2]);
    
    Matrix m1(row, col);
    populate_matrix(m1, 5);
    
    cout << "The values in matrix m1 are:\n";
    print(m1);
    
#if 1
    Matrix m2 (4, 6);
    populate_matrix(m2, 6);

    cout << "\n\nThe values in matrix m2 are: \n";
    print(m2);
    
    m2.sum_of_rows();
    m2.sum_of_cols();
	
    m1 = m2;
    
    m2.at(0, 0)=5;
    m2.at(1, 1)=15;
    m2.at(2, 2)=25;

    cout << "\n\nThe new values in matrix m1 and sum of its rows and columns are\n";
    print_with_sum(m1);     //Prints non-zero sums for columns 1 and 2 of m1 if sum_of_cols isn't called
    
    m2.sum_of_rows();
    m2.sum_of_cols();
    
    Matrix m3 = m2;
    
    m2.at(0, 0)= -5;
    m2.at(1, 1)= -15;
    m2.at(2, 2)= -25;

    cout << "\n\nThe values in matrix m3 and sum of its rows and columns are:\n";
    print_with_sum(m3);
    
    m2.sum_of_rows();
    m2.sum_of_cols();
	
    cout << "\n\nThe new values in matrix m2 are:\n";
    print_with_sum(m2);
   
    cout << "\n\nThe values in matrix m3 and sum of it rows and columns are still the same:\n";
    print_with_sum(m3);
#endif
    
    return 0;
}

void populate_matrix(Matrix& m, int seed){
    cout << fixed << setprecision(1);
    for(int i= 0; i < m.get_rows(); i++){
        for(int j=m.get_cols()-1; j>=0; j--){
            m.at(i, j) = (seed + (j+i+1) +(j+1))/3.0;
		}
	}
}

void print(const Matrix& m){
    if(m.get_rows() == 0 && m.get_cols() == 0){
        cout << "Matrix is empty." << endl;
        return;
    }
    
    for(int i=0;i< m.get_rows(); i++){
        for(int j = 0; j < m.get_cols(); j++){
            cout << " " << setw(5) <<  m.at(i, j);
		}
        cout <<  endl;
    }
}


void print_with_sum(const Matrix& m){
    if(m.get_rows() == 0 && m.get_cols() == 0){
        cout << endl << "Your matrix is empty." << endl;
        return;
    }

    for (int i=0;i< m.get_rows(); i++){
        for(int j = 0; j < m.get_cols(); j++)
            cout << " " << setw(5) <<  m.at(i, j);
        cout << " |" << setw(5) << m.get_sum_row(i) << endl;
    }
    
    cout << setw(2) << ' ';
    for(int j =0; j < m.get_cols(); j++){
        cout<< "------";
	}
    cout << endl;
    
    for(int j =0; j < m.get_cols(); j++){
        cout<< " " << setw(5) << m.get_sum_col(j);
	}
    cout << endl;
}

bool not_all_digits(const char* str){
    for(int i=0; str[i] != '\0'; i++){
        if(!isdigit(str[i])){
            return true;
		}
	}
    return false;
}
