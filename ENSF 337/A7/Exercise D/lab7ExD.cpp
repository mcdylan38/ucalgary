// ENSF 337 - lab 7 Exercise D

#include "simpleVector.h"
#include <iostream>
using namespace std;

void print (const SimpleVector& v);

int main(void){
    TYPE bar[] = {45, 69, 12};
    TYPE array[4] = {3000, 6000, 7000, 8000};
    
    SimpleVector v1 (bar, 3);
    SimpleVector v2(array, 4);

    cout << "Object v1 is expected to display: 45 69 12" << endl;
    print(v1);
    
    cout << "\nObject v2 is expected to diaplay: 3000 6000 7000 8000" << endl;
    print(v2);
    
    v1.at(0) = 1000;
    v1.at(1) = 2000;
    
    cout << "\nAfter two calls to at v1 is expected to display: 1000 2000 12:\n";
    print(v1);
    
    for(int i = 0; i <2; i++){
        v2.push_back((i + 3) * 7);
	}
    
    cout << "\nv2 expected to display: 3000 6000 7000 8000 21 28" << endl;
    print(v2);
    
	
    // When ready to test copying objects, change #if 0 to #if 1. First, try to test your assignment operator by moving the #if 0 to the line before object v4 is declared.
	#if 1
    v2 = v1;
    v1.at(2) = 8000;
    cout << "\nAfter copy v2 is expected to display: 1000 2000 12" << endl;
    print(v2);
    
    cout << "\nv1 is expected to display: 1000 2000 8000" << endl;
    print(v1);
    
    SimpleVector v3 (v2);
    cout << "\nv3 is expected to diplay: 1000 2000 12" << endl;
    v2.at(0) = -333;
    print(v3);
    
    cout << "\nv2 is expected to display: -333 2000 12" << endl;
    print(v2);
    
    SimpleVector v4(v1);
    cout << "\nv4 is expected to diplay: 1000 2000 8000" << endl;
    v1.at(0) = -1000;
    print(v4);
    
	
	#if 1
    v1 = v1;
    cout << "\nv1 after self-copy is expected to diplay: -1000 2000 8000" << endl;
    print(v1);
    
    v1 = v2 = v3;
    cout << "\nv1 after chain-copy is expected to diplay: 1000 2000 12" << endl;
    print(v1);
    cout << "\nv2 after chain-copy is expected to diplay: 1000 2000 12" << endl;
    print(v2);
	
	#endif
	#endif
    
    return 0;
}



void print (const SimpleVector& v)
{
    for (int i =0; i < v.size(); i++){
        cout << v.at(i) << " ";
    }
    cout << endl;
}
