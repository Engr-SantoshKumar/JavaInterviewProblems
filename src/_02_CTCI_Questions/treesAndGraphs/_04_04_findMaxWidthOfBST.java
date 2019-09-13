/* 
 * 
 */

package _02_CTCI_Questions.treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class _04_04_findMaxWidthOfBST {

	Node root = null;
	class Node{
		int data;
		Node left, right;
		public Node(int d){
			data =d;
			left=right=null;
		}
	}
	
	public int maxWidth =0;
	
	int printMaxWidth(){
		return findTheMaxWidthOfBST(root);
	}
	
	int findTheMaxWidthOfBST(Node root){
		
		Queue<Node> q = new LinkedList<>();
		int levelNodes =0;
		if(root== null) return 0;
		q.add(root);
		
		while(!q.isEmpty()){
			levelNodes = q.size();
			maxWidth = Math.max(maxWidth, levelNodes);
			
				while(levelNodes >0){
				Node current = q.poll();
				
				if(current.left!=null) q.add(current.left);
				if(current.right!=null) q.add(current.right);
				levelNodes --;
				}
			}
		return maxWidth;
		
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
	
	public static void main(String[] args) {
		_04_04_findMaxWidthOfBST bst = new _04_04_findMaxWidthOfBST();
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
		 System.out.println("The Maximum Width of the tree ");
		 System.out.println(bst.printMaxWidth());
		 
		 System.out.println("\n\n\nPrinting the tree LINE BY LINE");
		 bst.bfsLinebyLinePrint();
	}
	
	
	// Printing the tree line by line 
	void bfsLinebyLinePrint(){
		 bfsLevelOnLineUsingOneQueue(root);
	}
	 
	 void bfsLevelOnLineUsingOneQueue(Node root) {
		 if (root == null) return;

		 Queue<Node> q = new LinkedList<>();
		 q.add(root);
		 q.add(null);
		 int count =0;

		 while (!q.isEmpty()) {

			 Node current = q.poll();
			 if (current != null) {
				 count++;
				 System.out.print(current.data + " ");
				 if (current.left != null) {
					 q.add(current.left);
				 }
				 if (current.right != null) {
					 q.add(current.right);
				 }
			 } else {
				 System.out.println(" --> Level node count : " + count);
			 	count =0;
				 if (!q.isEmpty()) {

					 System.out.println();
					 q.add(null);
				 }
			 }
		 }
	 }
}

