package _02_CTCI_Questions.treesAndGraphs;

	public class BST {
	public Node root =null;

	/* Class containing left and right child of current node and key value*/	
	public class Node{
		int data;
		Node left, right;
		public Node(int d){
			data =d;
			left=right=null;
		}
		
	}
	
	// This method mainly calls insertRec()
    public void insert(int key) {
       root = insertNodeToBST(root, key);
    }
	
	/* A recursive function to insert a new key in BST */
	   public Node insertNodeToBST(Node root, int value){
		   
		   if(root==null){					
			   root= new Node(value);
			   return root;
		   }
		   
		   if(value < root.data) 
			   root.left=insertNodeToBST(root.left, value);
			else if(value > root.data )
				root.right=insertNodeToBST(root.right, value);
		
		   /* return the (unchanged) node pointer */
		   return root;
		   
	   }

}
