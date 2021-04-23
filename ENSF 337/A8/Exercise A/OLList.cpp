// OLList.cpp
// ENSF 337 Fall 2020 Lab 8 Exercise A

#include <iostream>
#include <stdlib.h>
using namespace std;

#include "OLList.h"

//Public functions
OLList::OLList(): headM(0){}

OLList::OLList(const OLList& source){
    copy(source);
}

OLList& OLList::operator = (const OLList& rhs){
    if(this != &rhs){
        destroy();
        copy(rhs);
    }
	
    return *this;
}

OLList::~OLList(){
    destroy();
}

void OLList::print() const{
    cout << '[';
	
    if(headM != 0){
        cout << ' ' << headM->item;
        for(const Node *p = headM->next; p != 0; p = p->next){
            cout << ", " << p->item;
		}
    }
	
    cout << " ]\n";
}

void OLList::insert(const ListItem& itemA){
    Node *new_node = new Node;
    new_node->item = itemA;
    
    if(headM == 0 || itemA <= headM->item){
        new_node->next = headM;
        headM = new_node;
    }
	
    else{
        Node *before = headM;		//Will point to node in front of new node
        Node *after = headM->next;	//Will be 0 or point to node after new node
		
        while(after != 0 && itemA > after->item){
            before = after;
            after = after->next;
        }
		
        new_node->next = after;
        before->next = new_node;
    }
}

void OLList::remove(const ListItem& itemA){
    if(headM == 0 || itemA < headM->item){   //If list is empty, do nothing
        return;
	}
    
    Node *doomed_node = 0;
    
    if(itemA == headM->item){     //if itemA is found...
		doomed_node = headM;
	    headM = headM->next;
    }
	
    else{
        Node *before = headM;
        Node *maybe_doomed = headM->next;
        
		while(maybe_doomed != 0 && itemA > maybe_doomed->item){     //while not at end of list and itemA not found
            before = maybe_doomed;
            maybe_doomed = maybe_doomed->next;
        }
    }
	
    //Add code so remove works for elements beyond the first
	Node *prev=headM;
	Node *current=headM->next;
	
	while(current != nullptr){
		if(current->item==itemA){
			break;
		}
		
		else{
			prev=current;
			current=current->next;
		}
	}
		
	prev->next=current->next;
	delete current;
}


//Private functions
void OLList::destroy(){
	//Removes set of nodes using a loop	
	Node *temp=headM;
	
	while(headM != nullptr){
		temp=headM->next;
		delete headM;
		headM=temp;
	}
	
	headM=0;
}

void OLList::copy(const OLList& source){
	//Generates new chain of nodes with items identical to an existing OLList object. Allocates nodes using new and manipulates pointer variables to create links.
    //DO NOT CALL INSERT!!
	Node *sourceHead=source.headM;
	
	if(sourceHead==nullptr){
		return;
	}
	
	else{
		while(sourceHead != nullptr){
			headM=new Node;
			Node *copy=headM;
			
			while(sourceHead != nullptr){
				copy->item=sourceHead->item;
				
				if(sourceHead->next==nullptr){
					copy->next=nullptr;
					sourceHead=nullptr;
				}
				
				else{
					copy->next=new Node;
					copy=copy->next;
					sourceHead=sourceHead->next;
				}
			}
		}
	}
}

//https://stackoverflow.com/questions/39386347/cloning-a-singly-linked-list-using-overloaded-assignment-operator
//https://stackoverflow.com/questions/62402670/inserting-a-node-at-the-end-of-linked-list-in-c
//https://stackoverflow.com/questions/44680873/linked-list-copy-constructor-undefined-behavior
//https://stackoverflow.com/questions/58970863/creating-a-copy-constructor-function-for-a-linked-list-in-c
//https://stackoverflow.com/questions/10082586/coding-a-function-to-copy-a-linked-list-in-c
