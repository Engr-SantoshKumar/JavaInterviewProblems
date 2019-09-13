/* 
 * 
 */
package _02_CTCI_Questions.treesAndGraphs;
public class _04_06_LowestCommonAncestorInBinaryTree {

	Node findLCA (Node root, int n1, int n2){
		
		if(root == null) return null;
		if(root.data == n1 || root.data == n2 ) return root; // if data matched for current root to n1 or n2
		
		Node left = findLCA(root.left, n1 , n2);
		Node right = findLCA(root.right, n1, n2);
		
		if(left != null && right != null) return root; // this means it found the both node
		
		if(left != null)   // this when both node in same side under each other
			return left;
		else return right;

	}
	
//-------------------------------------------------------------------------------
		public static void main(String[] args) {
		_04_06_LowestCommonAncestorInBinaryTree bst = new _04_06_LowestCommonAncestorInBinaryTree();
			Node a = new Node(1);
	        a.left = new Node(2);
	        a.right = new Node(3);
	        a.left.left = new Node(4);
	        a.left.right = new Node(5);
	        a.left.right.right = new Node(7);
	        a.left.right.right.right = new Node(8);
	        
	        Node lca = bst.findLCA(a, 8, 7);
	        System.out.println(lca.data);
	        //System.out.println(bst.findLCA(a, 3, 7));

		}

		static class Node{
		int data;
		Node left, right;
		Node(int d){
			data=d;
			left=right=null;
		}

	}
	}