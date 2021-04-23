// simpleVector.h
// ENSF 337 - lab-7 Exercise D

#ifndef simpleVector_h
#define simpleVector_h

typedef int TYPE;

class SimpleVector{
public:
    SimpleVector(): storageM(0), sizeM(0), capacityM(0) {};
    
    SimpleVector(const TYPE *arr, int n);
    // REQUIRES:
    //        arr points to the beginning of a an array with the  elements
    //        arr[0], arr[1], ..., arr[n-1].
    //        n > 0
    // PROMISES:
    //        allocates dynamically memory space for the vector with n elements of
    //        of TYPE. Then copies the values from arr[0] to storageM[0], followed
    //        by copying arr[1]  ..., and arr[n-1] to the dynamically allocate
    //        memory space, and updates the size of the vector with n.
    
    ~SimpleVector() { delete [] storageM; } 			//Destructor
    SimpleVector(const SimpleVector& source);			//Copy constructor
    SimpleVector& operator= (const SimpleVector& rhs);	//Copy assignment operator
    int size() const { return sizeM; }
    
    TYPE& at(int i);
    // PROMISES: returns reference to element i of object
    //           - if i < 0 or i >= sizeM terminates the program
    
    const TYPE& at(int i)const;
    // PROMISES: returns reference to element i of object
    //           - if i < 0 or i >= sizeM terminates the program
    
    void push_back(TYPE arg);
    // PROMISES: Size of vector is increased by one element, if needed.
    //           Sets the last element to arg.

    
private:
    TYPE *storageM;
    int sizeM;     	// number of used elements in the dynamically allocated space 
    int capacityM;	// total number of dynamically allocated elements for storageM
};

#endif
