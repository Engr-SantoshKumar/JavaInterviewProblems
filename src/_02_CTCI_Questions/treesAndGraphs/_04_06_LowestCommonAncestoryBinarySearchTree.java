package _02_CTCI_Questions.treesAndGraphs;

public class _04_06_LowestCommonAncestoryBinarySearchTree {

	Node findLCAofBST (Node root, int n1, int n2){
		if(root.data > Math.max(n1, n2)) 
			return findLCAofBST(root.left, n1, n2);
		else if(root.data > Math.min(n1, n2)) 
			return findLCAofBST(root.right, n1, n2);
		else 
			return root;	
		
		
	}
	

//-------------------------------------------------------------------------------
		public static void main(String[] args) {
			_04_06_LowestCommonAncestoryBinarySearchTree bst = new _04_06_LowestCommonAncestoryBinarySearchTree();
			Node a = new Node(1);
	        a.left = new Node(2);
	        a.right = new Node(3);
	        a.left.left = new Node(4);
	        a.left.right = new Node(5);
	        a.left.right.right = new Node(7);
	        a.left.right.right.right = new Node(8);
	        
	        Node lca = bst.findLCAofBST(a, 2, 7);
	        System.out.println(lca.data);

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
