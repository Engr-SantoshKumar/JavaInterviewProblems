 /*Given a binary tree and a sum, find if there is a path from root to leaf
 * which sums to this sum.
 * 
 * Solution
 * Keep going left and right and keep subtracting node value from sum.
 * If leaf node is reached check if whatever sum is remaining same as leaf node data.
 * 
 * Time complexity is O(n) since all nodes are visited.
 */

package _02_CTCI_Questions.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class _04_09_FindTheAll_K_Sum_Paths {
	
	public Boolean findPath(int sum, List<Node> Path){
		return printPath(root, sum, Path);
	}

	public boolean printPath(Node root, int sum, List<Node> path){
        if(root == null){
            return false;
        }
        // check if current node is leaf node, if yes than check 
        if(root.left == null && root.right == null){
            if(root.data == sum){
                path.add(root);
                return true;
            }else{
                return false;
            }
        }
        // keep adding to list and subtract current root from sum 
        if(printPath(root.left, sum-root.data, path)){
            path.add(root);
            return true;
        }
        if(printPath(root.right, sum - root.data, path)){
        	path.add(root);
        	return true;
        }
        return false;
    }


	
//-----------------------------------------------------------------------------
	public static void main(String[] args) {
		_04_09_FindTheAll_K_Sum_Paths bst = new _04_09_FindTheAll_K_Sum_Paths();
		/* Let us create following BST
		        20
		     /     \
		    10      30
		   /  \    /  \
		 5    15  25   35
		         / \     \
		        21  27    45
		              \
		               28    
*/
				 bst.insert(20);
				 bst.insert(10);
				 bst.insert(30);
				 bst.insert(5);
				 bst.insert(15);
				 bst.insert(25);
				 bst.insert(35);
				 bst.insert(21);
				 bst.insert(27);
				 bst.insert(45);
				 bst.insert(28);
				 
			        List<Node> result = new ArrayList<>();
			        boolean r = bst.findPath(130, result);
			        if(r){
			            result.forEach(node -> System.out.print(node.data + " "));
			        }else{
			            System.out.println("No path for sum " + 130); 
			        } 
				 
	}
	
	Node root =null;
	
	class Node{
		int data;
		Node left, right;
		public Node(int d){
			data =d;
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
		   else if(value > root.data ) root.right=insertNodeToBST(root.right, value);
		   return root;
		 }
}
