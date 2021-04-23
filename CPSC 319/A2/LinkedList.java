/**
 * CPSC 319 - Assignment 2
 * Dylan Mah (30086580)
 *
 * This is the class for the implementation of a custom linked list using a node class and its functions
 * Note: This class is required to make ConfusedSorter.java work!
 */

class Node{
    double data;
    Node next;

    Node(double data){
        // Constructor to make a new node
        this.data=data;
    }
}

public class LinkedList{
    public Node head;
    public int size=0;

    public void insert(double value){
        // Inserts new data with value at the end of the linked list
        Node newNode=new Node(value);

        if(head==null){
            // If the list is empty, make head take the value from the argument
            head=newNode;
        }

        else{
            Node current=head;

            while(current.next != null){
                // Loop to get to end of the list
                current=current.next;
            }

            current.next=newNode;
        }

        size++;
    }

    // Unused in final product because it didn't remove 666 if it was the last element in the list
    /*
    public void deleteAllElement(double value){
        // Removes all instances of value
        Node current=head;

        while(current.next != null){
            if(current.next.data==value){
                // Skipping over the desired node (Java will automatically delete the unused memory)
                // and decrease the size of the list by 1
                current.next=current.next.next;
                size--;
            }

            else{
                // If the desired value is not found, continue iterating through the list
                current=current.next;
            }
        }
    }

    public boolean findElement(double value){
        // Returns true if the value is found, otherwise returns false
        Node current=head;

        if(head.data==value){
            // If first node has the desired value...
            return true;
        }

        while(current != null){
            // Loop to iterate through the list
            if(current.data==value){
                // If the value is found, return true (will exit function, and the loop)
                return true;
            }

            current=current.next;
        }

        return false;
    }
    */

    public String[] getListValues(){
        // Return a String array with all the linked list values and replace decimals with symbols
        // Function is used AFTER successful sorting, so no invalid values will be in the list
        String[] nodes=new String[this.size];
        Node current=this.head;

        for(int i=0; i < this.size || current != null; i++, current=current.next){
            try{
                // Try to convert double to int, which is stored in nodes if successful
                nodes[i]=String.valueOf((int) current.data);
            }
            catch(NumberFormatException ignored){}
            // If value is a decimal (symbol), ignore it and check the following cases

            // Converting decimal values back to symbol names
            if(current.data==0.1){
                nodes[i]="Do";
            }

            else if(current.data==3.1){
                nodes[i]="@";
            }

            else if(current.data==3.2){
                nodes[i]="&";
            }

            else if(current.data==15.1){
                nodes[i]="Fa";
            }

            else if(current.data==20.1){
                nodes[i]="$";
            }

            else if(current.data==55.1){
                nodes[i]="Asymbolwithareallylongname";
            }

            else if(current.data==100.1){
                nodes[i]="Re";
            }

            else if(current.data==103.1){
                nodes[i]="One";
            }

            else if(current.data==103.2){
                nodes[i]="Two";
            }

            else if(current.data==103.3){
                nodes[i]="Three";
            }

            else if(current.data==1000.1){
                nodes[i]="Mi";
            }

            else if(current.data==1005000.1){
                nodes[i]="%";
            }
        }

        return nodes;
    }
}
