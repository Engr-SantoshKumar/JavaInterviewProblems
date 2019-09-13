package _02_CTCI_Questions.treesAndGraphs;

public class _04_04_CheckIfBalanced {
	
	Boolean isBalanced(Node root){
		if(root == null) return true;
		
		int diff = getHight(root.left) - getHight(root.right);
		if(Math.abs(diff)>1){
			return false;
		}
		else 
		return isBalanced(root.right) && isBalanced(root.left);
	}
	
	int getHight(Node root){
		if(root==null) return -1;
		return Math.max(getHight(root.left), getHight(root.right)) +1 ;
	}
	
	

	public static void main(String[] args) {
		_04_04_CheckIfBalanced tree = new _04_04_CheckIfBalanced();
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.left.right.right = new Node(7);
        a.left.right.right.right = new Node(8);
        
        if (tree.isBalanced(a) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

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
