/* list.cpp
 * ENSF 337 Fall 2020 Lab 8 Exercise B
 * Dylan Mah (30086580)
 * Lab section: B02
 * Submission date: 11/24/2020
 */

#include <iostream>
#include <stdlib.h>
#include <fstream>
using namespace std;

#include "list.h"

//Public Functions
FlowList::FlowList(): head(0){}

FlowList::FlowList(const FlowList& source){
	copy(source);
}

FlowList &FlowList::operator = (const FlowList& source){
	if(this != &source){
        destroy();
        copy(source);
    }
	
    return *this;
}

FlowList::~FlowList(){
	destroy();
}

void FlowList::insert(const ListItem& itemA){	
	Node *newNode=new Node;
    newNode->item=itemA;
    
    if(head==nullptr || itemA.year <= head->item.year){
        newNode->next=head;
        head=newNode;
    }
	
    else{
        Node *current=head;
        Node *after=head->next;
		
        while(after != nullptr && itemA.year > after->item.year){
            current=after;
            after=after->next;
        }
		
        newNode->next=after;
        current->next=newNode;
    }
}

void FlowList::remove(int yearX){
	if(head==nullptr){
		return; 
	}

	while(head != nullptr && head->item.year==yearX){
        head=head->next;
    
		if(head==nullptr){
			return;
		}
    }     
    
	Node *current=head;         
    
	while(current != nullptr){
		Node *temp=current->next; 
		
		while(temp != nullptr && temp->item.year==yearX){
			temp=temp->next; 
		}
		
		current->next=temp;
		current=current->next;
	}
	
	delete current;
}

void FlowList::print(){
	if(head != nullptr){
		cout<<head->item.year<<"          "<<head->item.flow<<endl;
		
		for(const Node *p=head->next; p!= nullptr; p=p->next){
			cout<<p->item.year<<"          "<<p->item.flow<<endl;
		}
	}
}

double FlowList::averageFlow(){
	int l=0;
	double sum=0;
	Node *current=head;
	
	while(current != nullptr){
		l++;
		sum+=current->item.flow;
		current=current->next;
	}
	
	//cout<<"\nl = "<< l <<"    sum = "<< sum << endl;
	
	return sum/l;
}

int FlowList::searchYear(int yearX){
	Node *current=head;
	
	while(current != nullptr){
		if(current->item.year==yearX){
			return 1;
		}
		
		current=current->next;
	}
	
	return 0;
}

void FlowList::saveList(const char *file){
	//ofstream output("flow.txt");
	ofstream output(file);
	Node *current=head;
	
	if(output.fail()){
		cout<<"Error opening "<<file<<endl;
		exit(1);
	}
	
	else{
		while(current != nullptr){
			output<<current->item.year<<"   "<< current->item.flow <<endl;
			current=current->next;
		}
		
		cout<<"\nData saved into file.";
	}
	
	output.close();
}


//Private Functions
void FlowList::copy(const FlowList& source){
	Node *temp=source.head;
	
	while(temp != nullptr){
		insert(temp->item);
		temp=temp->next;
	}
}

void FlowList::destroy(){
	Node *temp=head;
	
	while(head != nullptr){
		temp=head->next;
		delete(head);
		head=temp;
	}
	
	head=0;
}