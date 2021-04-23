/* list.h
 * ENSF 337 Fall 2020 Lab 8 Exercise B
 * Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 11/24/2020
 */

#ifndef FlowList_H
#define FlowList_H

struct ListItem{
	int year;
	double flow;
};

struct Node{
	ListItem item;
	Node *next;
};

class FlowList{
	//contains set of nodes that contains ListItems
	public:
	FlowList();      //Default constructor
	FlowList(const FlowList& source);     //Copy constructor
	FlowList& operator = (const FlowList& source);     //Overloading assignment operator
	~FlowList();     //Destructor
	
	void insert(const ListItem& itemA);
	/* REQUIRES: item is defined
	 * PROMISES: adds item to FlowList according to year (so list is ordered ascendingly)
	 */
	
	void remove(int yearX);
	/* REQUIRES: item is defined and FlowList is defined
	 * PROMISES: deletes item from FlowList
	 */
	
	void print();
	/* REQUIRES: FlowList is defined
	 * PROMISES: displays the contents of FlowList
	 */
	
	double averageFlow();
	/* REQUIRES: FlowList is defined
	 * PROMISES: returns the average of the flow values in FlowList
	 */
	 
	int searchYear(int yearX);
	/* REQUIRES: FlowList is defined and yearIn is positive
	 * PROMISES: searches FlowList for yearIn, returns 1 if found and 0 if not found
	 */
	
	void saveList(const char *file);
	/* REQUIRES: FlowList is defined
	 * PROMISES: copies the data in FlowList to file
	 */	
	
	
	private:
	Node *head;
	void copy(const FlowList& source);
	//PROMISES: copies content of source into FlowList
	
	void destroy();
	//PROMISES: deallocates memory from FlowList, sets head to 0
};
#endif
