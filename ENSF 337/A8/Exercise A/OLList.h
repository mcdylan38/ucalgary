// OLList.h
// ENSF 337 Fall 2020 Lab 8 Exercises A

#ifndef OLLIST_H
#define OLLIST_H

typedef int ListItem;

struct Node {
  ListItem item;
  Node *next;
};

class OLList {
public:
  OLList(); // PROMISES: Creates empty list.
  OLList(const OLList& source);
  OLList& operator = (const OLList& rhs);
  ~OLList();

  void insert(const ListItem& itemA);
  // PROMISES:
  //    A node with a copy of itemA is added in 
  //    a way that preserves the nondecreasing 
  //    order of items in nodes.

  void remove(const ListItem& itemA);
  //  PROMISES:
  //    If no node has an item matching itemA, 
  //    list is unchanged.
  //    Otherwise exactly one node with 
  //    its item == itemA is removed.

  void print() const;
  // PROMISES:
  //   Prints items in list on a single line, with commas separating
  //   the items and square brackets marking the ends of the list.
  // NOTE:
  //   This is different from the print function presented in lectures.

private:
  Node *headM;
  void destroy(); 
  // Deallocate all nodes, set headM to zero.

  void copy(const OLList& source); 
  // List becomes copy of source.
};

#endif
