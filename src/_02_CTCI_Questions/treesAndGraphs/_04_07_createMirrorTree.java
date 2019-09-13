/*	(1)  Call recursion for left-subtree,  this way it will get to the last node at left side 
	(2)  Call recursion for right-subtree, this will get you the last right node at left side 
	(3)  Swap left and right subtrees.

	        50
	     /     \
	    30      70
	   /  \    /  \
	 20   40  60   80 
	 			  /  \
	 			75    85	
	e.g - in the this tree swapping will occurs in this way: 20<->40 , 75<->85, 60<->80, 30<->70 
more info = https://www.youtube.com/watch?v=vdwcCIkLUQI&t=186s
*/	

package _02_CTCI_Questions.treesAndGraphs;

public class _04_07_createMirrorTree {
	
    void printMirrorImage(){
    	root = mirrorImage(root);
    }
	
	Node mirrorImage(Node root){
		if(root==null) return root;
		
		Node left = mirrorImage(root.left);
		Node right = mirrorImage(root.right);
		
		/* swap the left and right pointers */
		root.left=right;
		root.right=left;
		return root;
	}
	
	
//-------------------------------------------------------------------------------
	public static void main(String[] args) {
		_04_07_createMirrorTree bst = new _04_07_createMirrorTree();

		 bst.insert(50);
		 bst.insert(30);
		 bst.insert(20);
		 bst.insert(40);
		 bst.insert(70);
		 bst.insert(60);
		 bst.insert(80);
		 bst.insert(75);
		 bst.insert(65);
		 bst.insert(78);
		 bst.insert(85);
		 bst.insert(83);
		 bst.insert(81);
		 bst.insert(82);
		 bst.insert(87);
		 bst.insert(88);
		 System.out.println("InOrder of Original Tree ");
		 bst.inorderPrint();
		 System.out.println("\n\nInOrder of Mirror Tree ");
		 bst.printMirrorImage();
		 bst.inorderPrint();
		 
	}
	
	Node root = null;
	class Node{
		int data;
		Node left, right;
		public Node(int d){
			data =d;
			left=right=null;
		}
	}
	
	void insert(int data){
		root =insertNode(root, data);
	}
	
	Node insertNode(Node root, int data){
		if(root == null){
			root = new Node(data);
			return root;
		}
		if(data < root.data) root.left = insertNode(root.left, data);
		if(data > root.data) root.right = insertNode(root.right, data);
		
		return root;
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
	

}
