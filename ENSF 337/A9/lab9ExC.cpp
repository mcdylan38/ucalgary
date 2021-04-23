// ENSF 337 - Lab 9 - exercise C
// lab9ExC.cpp

#include<vector>
#include<string>
#include <iostream>
using std::cout;
using std::cerr;
using std::endl;
using std::vector;
using std::string;

typedef vector<string> String_Vector;

String_Vector transpose(const String_Vector& sv);
// REQUIRES:
//    sv.size() >= 1
//    All the strings in sv are the same length, and that length is >= 1.
// PROMISES:
//    Return value is the "transpose" of sv, as defined in the Exercise B
//    instructions.

int main(){
    const int ROWS = 5;
    const int COLS = 4;
    
    char c = 'A';
    String_Vector sv;
    sv.resize(ROWS);
    
    for(int i = 0; i < ROWS; i++){
        for(int j = 0; j < COLS; j++){
            sv.at(i).push_back(c);
            c++;
			
            if(c == 'Z' + 1){
                c = 'a';
			}
			
            else if (c == 'z' + 1){
				c = 'A';
			}
		}
	}
    
    cout<<"Vector before transpose:"<<endl;
	
    for(int i = 0; i < ROWS; i++){
        cout<< sv.at(i);
        cout << endl;
    }
	cout<<endl;
	
	cout<<"Vector after transpose:"<<endl;
	
    String_Vector vs = transpose(sv);
    for(int i = 0; i < (int)vs.size(); i++){
        cout << vs.at(i) << endl;
	}
    
    return 0;
}

String_Vector transpose (const String_Vector& sv){
    //Swaps columns and rows of matrix sv (4x5 matrix becomes 5x4 matrix)
    String_Vector vs;
	int columns=(int) sv.size();     //# of columns in vs = # of rows sv
	int rows=(int) sv[0].size();     //# of rows in vs = # of columns in sv
	
	vs.resize(rows);
	
	//cout<<"rows = "<<rows<<"     columns = "<<columns<<endl;
	
	for(int i=0; i<rows; i++){	
		for(int j=0; j<columns; j++){
			char temp=sv[j][i];
			//cout<<temp<<"  ";
			vs[i].push_back(temp);
		}
		//cout<<endl;
	}
	
    return vs;
}
