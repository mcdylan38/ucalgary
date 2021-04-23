/**
 * CPSC 319 - Assignment 3
 * Dylan Mah (30086580)
 *
 * Note: This file must be used alongside Runner.java and Commands.java to execute the program. Make sure all files
 * are in the same directory when trying to compile and run the program!
 **/

// https://gist.github.com/iowaguy/f46fe575feaec082fc80
// https://stackoverflow.com/questions/19330731/tree-implementation-in-java-root-parents-and-children
// https://www.geeksforgeeks.org/replace-node-with-depth-in-a-binary-tree
// https://www.geeksforgeeks.org/print-level-order-traversal-line-line
// https://stackoverflow.com/questions/15941204/searching-all-nodes-of-a-binary-tree-in-java
// https://stackoverflow.com/questions/4531449/height-of-a-binary-tree
// https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree
// https://leetcode.com/problems/subtree-of-another-tree/solution
// https://prismoskills.appspot.com/lessons/Binary_Trees/Complete_subtree.jsp

class Node{
    String data;
    Node left;
    Node middle;
    Node right;

    // Constructor
    Node(String data){
        this.data=data;
        this.left=null;
        this.middle=null;
        this.right=null;
    }
}

public class CustomTernaryTree{
    public Node root=new Node("root");      // Making the first value of the tree always take the value "root"
	// String that will be filled with values from the tree or error messages to be printed to the output file
	public String output;
	private Node[] matches=new Node[100];       // Array that will store references to nodes in the tree
	private int count=0;                        // Integer to be updated for each successful match in function findNode

	// Function that finds nodes whose data matches a and creates a new subtree at the deepest matching node.
    // Prioritizes the RIGHT-most node. If there are no nodes whose data matches a, the function does nothing. Makes
    // use of a helper function to find the deepest matching node in the left-most subtree.
    public void add(String a, String b, String child){
        this.output="";                             // Reset output so previous data from print or add are not used
        this.matches=new Node[100];                 // Reset matches so previous data from add or delete are not used
        this.count=0;                               // Reset count so first value in array is deepest match
        findMatch(this.root, a, false);
        Node key=this.matches[0];                   // The first stored value is ALWAYS the deepest matching node

		if(key != null){
		    //System.out.println("Match found! " + a + "=" + key.data);

		    // If a match is found, check if String b starts with "$" or not
			if(b.startsWith("$")){
				// If String b starts with "$", check if the desired subtree exists or not
				if(child.equals("left")){
					if(key.left==null){
						// If the left subtree does not exist, create new left child and exit function
						key.left=new Node(b.substring(1));
						return;
					}

					// Overwrite left subtree data to be String AFTER the "$"
					key.left.data=b.substring(1);
				}

				else if(child.equals("middle")){
					if(key.middle==null){
						// If the left subtree does not exist, create new middle child and exit function
						key.middle=new Node(b.substring(1));
						return;
					}

					// Overwrite middle subtree data to be String AFTER the "$"
					key.middle.data=b.substring(1);
				}

				else if(child.equals("right")){
					if(key.right==null){
						// If the left subtree does not exist, create new right child and exit function
						key.right=new Node(b.substring(1));
						return;
					}

					// Overwrite right subtree data to be String AFTER the "$"
					key.right.data=b.substring(1);
				}
			}

			else{
				// If b doesn't start with "$", check if the desired subtree already exists
				if(child.equals("left")){
					if(key.left != null){
						// If the node exists and already has a left subtree, add error message, exit function and do
						// nothing to tree
						this.output="Add operation not possible.";
						return;
					}

					// Make a new left subtree whose data is b
					key.left=new Node(b);
				}

				else if(child.equals("middle")){
					if(key.middle != null){
						// If the node exists and already has a middle subtree, add error message, exit function and do
						// nothing to tree
						this.output="Add operation not possible.";
						return;
					}

					// Make a new middle subtree whose data is b
					key.middle=new Node(b);
				}

				else if(child.equals("right")){
					if(key.right != null){
						// If the node exists and already has a right subtree, add error message, exit function and do
						// nothing to tree
						this.output="Add operation not possible.";
						return;
					}

					// Make a new right subtree whose data is b
					key.right=new Node(b);
				}
			}
		}
    }

	// Function that finds nodes whose data matches a and deletes the specified subtree of the deepest matching node.
    // Prioritizes the LEFT-most node. If there are no nodes whose data matches a, the function does nothing. Makes
    // use of a helper function to find the deepest matching node in the right-most subtree.
	public void delete(String a, String child){
        this.count=0;                               // Reset count so first value is the deepest match
        this.matches=new Node[100];                 // Reset matches so previous data is erased
        findMatch(this.root, a, true);
        Node key=this.matches[0];                   // The first stored value is ALWAYS the deepest matching node

		if(key != null){
            //System.out.println("Match found! " + a + "=" + key.data);

            // If a match is found, check if the desired subtree exists
			if(child.equals("left")){
			    if(key.left==null){
			        // If there is no left child, exit function and do nothing to tree
			        return;
                }

			    // If left child exists, set it to null (Java will handle memory deletion)
				key.left=null;
			}

			if(child.equals("middle")){
			    if(key.middle==null){
			        // If there is no middle child, exit function and do nothing to tree
			        return;
                }

                // If middle child exists, set it to null (Java will handle memory deletion)
				key.middle=null;
			}

			if(child.equals("right")){
			    if(key.right==null){
                    // If there is no right child, exit function and do nothing to tree
			        return;
                }

                // If right child exists, set it to null (Java will handle memory deletion)
				key.right=null;
			}
		}
	}

    // Recursive function that uses post-order traversal to find all nodes whose data matches a. If the String b 
	// starts with "$", append b to node.data. Otherwise, replace node.data with b.
    public void exchange(Node node, String a, String b){
        if(node==null){
            // Base case
            return;
        }

        // Use post order traversal to search tree
        exchange(node.left, a, b);
        exchange(node.middle, a, b);
        exchange(node.right, a, b);

        if(node.data.equals(a)){
            if(b.startsWith("$")){
                // Append String after "$"
                node.data+=b.substring(1);
            }

            else{
                // Replace data with b
                node.data=b;
            }
        }
    }

    // Function to write the values of the tree in level-order to the String output, which will be written to the
    // output file. Makes use of two helper functions, one to get the height of the tree and one to traverse the tree
    // in level-order.
    public void print(){
        int size=getHeight(this.root);      // Get height of tree
        this.output="";                     // Reset String output to be empty

        for(int i=1; i <= size; i++){
            printLevel(this.root, i);

            // length() - 3 will remove "_;_" from the end of the String
            this.output=this.output.substring(0, this.output.length() - 3) + "\n";
        }
    }

    // Helper function for print that recursively finds the deepest branch of the tree and returns its height
    private int getHeight(Node node){
        if(node==null){
            // Base case
            return 0;
        }

        // Getting the largest value of the depth of the left, middle and right subtrees. The +1 is to also account for
        // the root (which will not be checked with the recursion).
        return Math.max(Math.max(getHeight(node.left), getHeight(node.right)), getHeight(node.middle)) + 1;
    }

    // Helper function for print that recursively finds the values of the tree in level-order and stores them in a
    // String output to be printed to the output file
    private void printLevel(Node node, int level){
        if(node==null){
            // Base case
            return;
        }

        if(level == 1){
            // If at a leaf, store the data from that level in the String output
            this.output+=node.data + " ; ";
        }

        else if(level > 1){
			// Level-order traversal of tree
            printLevel(node.left, level - 1);
            printLevel(node.middle, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    // Helper function for insert and delete that uses depth first search to recursively search the tree for the
    // desired String, arg. The nodes with this value are stored in the array matches to be used later.
    private void findMatch(Node node, String arg, boolean leftFirst) {
        if(node==null){
            // Base case
            return;
        }

        if(leftFirst){
            // Use recursion to search LEFT subtree first to find node whose data matches String arg
            findMatch(node.left, arg, true);
            findMatch(node.middle, arg, true);
            findMatch(node.right, arg, true);
        }

        if(!leftFirst){
            // Use recursion to search RIGHT subtree first to find node whose data matches String arg
            findMatch(node.right, arg, false);
            findMatch(node.middle, arg, false);
            findMatch(node.left, arg, false);
        }

        if(node.data.equals(arg)){
            // If a matching node is found, store it in an array and increment count so the next element is the
            // next matching node (only need to increment so deepest matching node is NOT overwritten)
            matches[count]=node;
            count++;
        }
    }
}   // End of class
