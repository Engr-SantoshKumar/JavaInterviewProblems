package leetCodeProblems;

public class BSTApp {

	public static void main(String[] args) {
		
		BST bst = new BST();
		Node root =null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = bst.insert(root, 8);
		root = bst.insert(root, 3);
		root = bst.insert(root, 6);
		root = bst.insert(root, 10);
		root = bst.insert(root, 4);
		root = bst.insert(root, 7);
		root = bst.insert(root, 1);
		root = bst.insert(root, 14);
		root = bst.insert(root, 13);

	}

}

class Node{
	int data;
	Node left;
	Node right;
}

class BST {
	
	public Node createNewNode(int k) {
		
		Node node = new Node();
		node.data=k;
		node.left=null;
		node.right=null;
		return node;
	}
	
	public Node insert(Node node, int val) {
		if(node == null) {
			return createNewNode(val);
		}
		
		if(val<node.data) {
			node.left = insert(node.left, val);
		}else if (val > node.data) {
			node.right = insert(node.right, val);
		}
		
		return node;
	}
}
