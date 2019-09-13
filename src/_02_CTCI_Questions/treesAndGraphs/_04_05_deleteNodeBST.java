package _02_CTCI_Questions.treesAndGraphs;

public class _04_05_deleteNodeBST {

	 Node root =null;
	
	 class Node{
		int data;
		Node left, right;
		public Node(int d){
			this.data=d;
			left = right=null;
		}
		
	}
	 
	void deleteKey(int key){
		root=deleteNodeFromBST(root, key);
	}
	 
	 Node deleteNodeFromBST(Node root, int key){
		
		if(root == null){		// base case if tree is empty
			return root;
		}
		// traveling down the tree
		if(key < root.data){
			root.left=deleteNodeFromBST(root.left, key);
		}
		else if(key > root.data){
			 root.right=deleteNodeFromBST(root.right, key);
		 }
		
		// if the key is equal to root value, this node to be deleted 
		else{
			// node with only one child 
			if(root.right==null)
			return root.left;
			
			else if(root.left==null)
			return root.right;
			
			// node with two children: get the inOrder successor of Right subTree 
			root.data=minValue(root.right);
			
			// deleting the inOrder successors
			// this call will delete the node which is now moved up, 
			// it will use node with one key function 
			root.right=deleteNodeFromBST(root.right, root.data); 
			
		 }
		
		return root;
		 
	 }
	 //finding the last node i.e also the minimum value 
	 int minValue(Node root){
		int minValue = root.data;
		while(root.left != null){
			minValue = root.left.data;
			root=root.left;
		}
		return minValue;
		 
	 }
	 
	 
	// Creating tree
     void insert(int key) {
       root = insertNodeToBST(root, key);
    }
    
     Node insertNodeToBST(Node root, int key){
		if(root == null){
			root = new Node(key);
			return root;
		}
    	if (key < root.data){
    		root.left=insertNodeToBST(root.left, key);
    	}
    	else if(key > root.data){
    		root.right=insertNodeToBST(root.right, key);    		
    	}
    	
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
	
	
	public static void main(String[] args) {
		_04_05_deleteNodeBST bst = new _04_05_deleteNodeBST();
/* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 */
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
//Print the inOrder tree
		 System.out.println("In-Order search");
		 bst.inorderPrint();
		 
// deleting the node in BST
		 System.out.println("\n Deleting the node in BST");
		 bst.deleteKey(78);
//Print the inOrder tree
		 System.out.println("In-Order search after deleting node");
		 bst.inorderPrint();		 
	
	}

}
