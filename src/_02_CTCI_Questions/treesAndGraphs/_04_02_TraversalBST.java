package _02_CTCI_Questions.treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;
public class _04_02_TraversalBST {
	

/* -----------------------------------------------------------------------
 * BFS - Breadth first or level order Traversal
 */

	   public static void bfsTraversal(Node root){
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
	   
	

	   /* In-order traversal of BST  Left-Root-Right */
	  public static void inOrderTraversal(Node root){
		  if(root != null){
			  inOrderTraversal(root.left);
			  System.out.print(root.data);
			  System.out.print(" -> ");
			  inOrderTraversal(root.right);
			}
	  }
	  
	  /* Pre-order traversal of BST  Root-Left-Right */
	  public static void preOrderTraversal(Node root){
		  if(root != null ){
			 System.out.print(root.data);
			 System.out.print(" -> ");
			 preOrderTraversal(root.left);
			 preOrderTraversal(root.right);

		  }
	  }
	  
	  /* Post-order traversal of BST  Left-Right-Root */
	  public static void postOrderTraversal(Node root){
		  if(root != null){
			  postOrderTraversal(root.left);
			  postOrderTraversal(root.right);
			  System.out.print(root.data);
			  System.out.print(" -> ");
		  }
	  }
	   
	
	public static void main(String[] args) {

		int[] ar = new int[]{50,30,20,40,70,60,80, 90, 5};

		Node root = TreePrint.create(ar);

		//to create BST
        Node r = TreePrint.create(new int[]{6,4,8,2,5,7,9,1,3});
        //Node r1 = TreePrint.create(new int[]{10,5,20,3,8,15,50,1,4,6,9});
		// to create un-balanced tree
/*		Node root = new Node(5);
		root.left = new Node(6);
		root.right = new Node(7);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		TreePrint.print(root);*/
		System.out.println("\n \nBFS - Breadth first or level order Traversal");
		bfsTraversal(root);

		System.out.println("\n \nIn-order traversal of BST  Left-Root-Right");
		inOrderTraversal(r);

		System.out.println("\n \nPre-order traversal of BST  Root-Left-Right");
		preOrderTraversal(r);

		System.out.println("\n \nPost-order traversal of BST  Left-Right-Root");
		postOrderTraversal(r);




	}

}
