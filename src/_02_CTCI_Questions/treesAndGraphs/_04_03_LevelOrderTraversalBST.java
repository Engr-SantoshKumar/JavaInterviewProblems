/* BFS Traversal
 * 1. Create a queue and add root in it 
 * 2. create a while loop (!queue.isEmpty())
 * 3. Remove the Node from queue and check if it has children nodes and push them to queue 
 * 4. do the above steps recursively 
 */


package _02_CTCI_Questions.treesAndGraphs;
import java.util.LinkedList;
import java.util.Queue;


public class _04_03_LevelOrderTraversalBST {
       Node root = null;
       class Node{
    	   int data;
    	   Node left,right;
    	   	public Node(int d){
    	   		data=d;
    	   		left=right=null;
    	   	}
       }
       
    // This method mainly calls insertRec()
        void insert(int key) {
          root = insertNodeToBST(root, key);
       }
   	
   	/* A recursive function to insert a new key in BST */
   	    Node insertNodeToBST(Node root, int value){
   		   if(root==null){					
   			   root= new Node(value);
   			   return root;
   		   }
   		   if(value < root.data) root.left=insertNodeToBST(root.left, value);
   		   else if(value > root.data )root.right=insertNodeToBST(root.right, value);
   		   return root;
   		 }
   	    
   	 // BFS Traversal    
   	    void bfsTraversalPrint(){
			   bfsTraversal(root);
		    }
		    void bfsTraversal(Node root){
			   //base case
			   if(root == null) return;
			   // crate an empty queue 
			   Queue<Node> q = new LinkedList<>();
			   q.add(root);
			   while(q.size() > 0){
				   Node current = q.peek();
				   q.remove();
				   System.out.print(current.data + " ");
				   if(current.left != null){
					   q.add(current.left);
				   }
				   if(current.right != null){
					   q.add(current.right);
				   }			   
			   }
			  return;
		   }
/**
 * Use one queue and delimiter to print level by level
 * each level is ending with null in queue 
 * check if the removed element is null, if yes push the null again ..thats means there will a null at the end if each level 
 */  
		 void bfsLinebyLinePrint(){
			 bfsLevelOnLineUsingOneQueue(root);
		 }
		 
		 void bfsLevelOnLineUsingOneQueue(Node root){
			  if(root==null) return;
			  
			  Queue<Node> q = new LinkedList<>();
			  q.add(root);
			  q.add(null);
			  
			  while(!q.isEmpty()){
				   Node current = q.peek();
				   q.remove();
				   if(current!=null)
				   {
					   System.out.print(current.data + " ");
				   		if(current.left != null){
				   			q.add(current.left);
				   		}
				   		if(current.right != null){
				   			q.add(current.right);
				   		}
				   }else{
					   if(!q.isEmpty())
					   System.out.println();
					   q.add(null);
				   }
				 }
		  }
 /**
  * Use two queue and delimiter to print level by level
  */  
		 		 void bfsLinebyLinePrintUsingTwoQueue(){
		 			 bfsLevelOnLineUsingTwoQueue(root);
		 		 }
		 		 
		 		 void bfsLevelOnLineUsingTwoQueue(Node root){
		 			 if(root == null) return;
		 			 
		 			Queue<Node> q1 = new LinkedList<>();
		 			Queue<Node> q2 = new LinkedList<>();
					q1.add(root);
					
					// do while there is any element in any of the queue
					while (!q1.isEmpty() || !q2.isEmpty()) {
			            
						while (!q1.isEmpty()) {
			                root = q1.poll();
			                System.out.print(root.data + " ");
			                if (root.left != null) {
			                    q2.offer(root.left);
			                }
			                if (root.right != null) {
			                    q2.offer(root.right);
			                }
			            }
			            System.out.println();
			            while (!q2.isEmpty()) {
			                root = q2.poll();
			                System.out.print(root.data + " ");
			                if (root.left != null) {
			                    q1.offer(root.left);
			                }
			                if (root.right != null) {
			                    q1.offer(root.right);
			                }
			            }
			            System.out.println();
			        }
		 		 }
	
	public static void main(String[] args) {
		_04_03_LevelOrderTraversalBST bst = new _04_03_LevelOrderTraversalBST();
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

		 
		 System.out.println("BFS search");
		 bst.bfsTraversalPrint();
		 System.out.println();
		 System.out.println("BFS line By Line Level using two queue");
		 bst.bfsLinebyLinePrintUsingTwoQueue();
		 System.out.println("BFS line By Line Level");
		 bst.bfsLinebyLinePrint();

	}

}
