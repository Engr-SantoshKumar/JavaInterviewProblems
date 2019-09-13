/*
 * https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
 */

package _02_CTCI_Questions.treesAndGraphs;

public class _04_01_searchingNodeBST {
	
	public Node root = null;
	
	public class Node{
		int data;
		Node left;
		Node right;
		public Node(int d){
			this.data=d;
			left=right=null;
		}
	}


/*	SEARCH	
 * 		Its very simple operation to perform. 	
 * 		start from the root and compare root.data with n 
 *		if root.data is greater than n that means we need to go to the left of the root. 
 * 		if root.data is smaller than n that means we need to go to the right of the root.
 * 		if any point of time root.data is equal to the n then we have found the node, return true.
 * 		if we reach to the leaves (end of the tree) return false, we didn’t find the element */	
	public boolean searchNodeInBST(int id){
		Node current = root;
		while (current != null){
			if(current.data == id){
				return true;
			}else if(current.data > id){
				current=current.left;				
			}else{
				current=current.right;
			}
		}
		return false;
	}
	// this code is without recursion // more simple code in BST.java
	public void InsertNodeBST(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	
	// This method mainly calls InorderRec()
	   public void inorderPrint(){
		   inOrderTraversal(root);
	   }
	   /* In-order traversal of BST  Left-Root-Right */
	  public void inOrderTraversal(Node root){
		  if(root != null){
			  inOrderTraversal(root.left);
			  System.out.print(root.data);
			  System.out.print(" -> ");
			  inOrderTraversal(root.right);
			}
	  }
	

	public static void main(String[] args) {
		_04_01_searchingNodeBST bst = new _04_01_searchingNodeBST();
		/* Let us create following BST
		        50
		     /     \
		    30      70
		   /  \    /  \
		 20   40  60   80 */
				 bst.InsertNodeBST(50);
				 bst.InsertNodeBST(30);
				 bst.InsertNodeBST(20);
				 bst.InsertNodeBST(40);
				 bst.InsertNodeBST(70);
				 bst.InsertNodeBST(60);
				 bst.InsertNodeBST(80);
				 
				//Print the inOrder tree
				 System.out.println("In-Order search");
				 bst.inorderPrint();
				 
				 System.out.println("\n\nCheck whether Node with value 40 exists : " + bst.searchNodeInBST(40));

	}

}













