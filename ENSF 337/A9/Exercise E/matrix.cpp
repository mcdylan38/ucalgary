/* ENSF 337 Lab 9 - Exercise E
 * matrix.cpp
 * Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 11/__/2020
 */

#include "matrix.h"

//Public
Matrix::Matrix(int r, int c):rowsM(r), colsM(c){
    matrixM = new double* [rowsM];
    assert(matrixM != NULL);
    
    for(int i=0; i < rowsM; i++){
        matrixM[i] = new double[colsM];
        assert(matrixM[i] != NULL);
    }
	
    sum_rowsM = new double[rowsM];
    assert(sum_rowsM != NULL);
    sum_colsM = new double[colsM];
    assert(sum_colsM != NULL);
}

Matrix::~Matrix(){
    destroy();
}

Matrix::Matrix(const Matrix& source){
    copy(source);
}

Matrix& Matrix::operator = (const Matrix& rhs){
    if(&rhs != this){
        destroy();
        copy(rhs);
    }
   
    return *this;
}

double Matrix::get_sum_col(int i) const{
    assert(i >= 0 && i < colsM);
    return sum_colsM[i];
}

double Matrix::get_sum_row(int i) const{
    assert(i >= 0 && i < rowsM);
    return sum_rowsM[i];
}

void Matrix::sum_of_rows() const{
    //Sums values in each row then stores them in array sum_rowsM
	double sum;
	
	for(int i=0; i<rowsM; i++){
		sum=0;
		
		for(int j=0; j<colsM; j++){
			sum+=matrixM[i][j];
		}
		
		sum_rowsM[i]=sum;
	}
}

void Matrix::sum_of_cols() const{
    //Sums values in each column then stores them in array sum_colsM
	double sum;
	
	for(int i=0; i<colsM; i++){
		sum=0;
		
		for(int j=0; j<rowsM; j++){
			sum+=matrixM[j][i];
		}
		
		sum_colsM[i]=sum;
	}
}


//Private
void Matrix::copy(const Matrix& source){
	if(source.matrixM == NULL){     //If source is empty, set all private variables in Matrix to 0
        matrixM = NULL;
        sum_rowsM = NULL;
        sum_colsM = NULL;
        rowsM = 0;
        colsM = 0;
        return;
    }
    
    rowsM = source.rowsM;
    colsM = source.colsM;
    
    sum_rowsM = new double[rowsM];
    assert(sum_rowsM != NULL);
    
    sum_colsM = new double[colsM];
    assert(sum_colsM != NULL);
    
    matrixM = new double*[rowsM];
    assert(matrixM !=NULL);
	
    for(int i =0; i < rowsM; i++){
        matrixM[i] = new double[colsM];
        assert(matrixM[i] != NULL);
    }
	
    //Add code below to make copy functional
	for(int i=0; i<rowsM; i++){
		for(int j=0; j<colsM; j++){
			matrixM[i][j]=source.matrixM[i][j];
			sum_rowsM[i]=source.sum_rowsM[i];
			sum_colsM[j]=source.sum_colsM[j];
		}
	}
}

void Matrix::destroy(){
    //Deallocates memory for each array in matrixM, as well as memory for matrixM, sum_rowsM and sum_colsM
	delete[] sum_rowsM;
	delete[] sum_colsM;
	
	for(int i=0; i<rowsM; i++){
		delete[] matrixM[i];
	}
	
	delete[] matrixM;
}
