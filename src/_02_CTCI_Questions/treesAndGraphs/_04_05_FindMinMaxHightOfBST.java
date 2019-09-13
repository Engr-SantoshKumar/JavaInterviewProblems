package _02_CTCI_Questions.treesAndGraphs;


public class _04_05_FindMinMaxHightOfBST {
	 Node root = null;
	class Node{
		int data;
		Node left, right;
		public Node(int d){
			data =d;
			left=right=null;
		}
		
	}
	  int printFindHight(){
		return findTheMaxHightofBST(root);
	}
	int findTheMaxHightofBST(Node root){
		if(root == null){
			return -1;  // -1 when considering height 0 of the tree if leaf nodes are null
						//  0 when considering height 1 of the tree if the leaf nodes are null
		}
		int leftHight = findTheMaxHightofBST(root.left);
		int rightHight = findTheMaxHightofBST(root.right);
		return Math.max(leftHight, rightHight)+1;
	}
	
	
	void insert( int key ){
		root = insertNodeToBST(root, key);
	}
	
	Node insertNodeToBST(Node root, int value){
		   
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
	
	int printMinHightofBST(){
		return findtheMinHightofBST(root); 
	}
	
	int findtheMinHightofBST(Node root){
		
		if(root == null) return 0;
		
		int leftSize = findtheMinHightofBST(root.left);
		int rightSize = findtheMinHightofBST(root.right);
		
		return Math.min(leftSize, rightSize) + 1;
			
	}
	
	public static void main(String[] args) {

		_04_05_FindMinMaxHightOfBST bst = new _04_05_FindMinMaxHightOfBST();
/* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 
 			  /  \
 			75  
 */
		 bst.insert(50);
		 //System.out.println(" root :: "+bst.root);
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
		 bst.printtraverse();
		 System.out.println();
		 System.out.println("Hight of BST ");
		 System.out.println(bst.printFindHight());
		 System.out.println("Min Hight of the BST");
		 System.out.println(bst.printMinHightofBST());
		 

	}
	
	void printtraverse(){
		traverse(root);
	}
	 void traverse(Node root){
		if(root == null){
			return;
		}
		
		traverse(root.left);
		System.out.print(root.data+ "->");
		traverse(root.right);
	}
}
