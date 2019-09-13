/*
 Step 1: first find the key in BST.
    Case 1: if key has right node/(sub tree), find the minimum node in right sub-tree
            i.e nothing but the left most node of right sub-tree
    Case 2: if key has no right node, then
            a. in-order successor is NULL if d is right most node in the BST i.e. last node in the in-order traversal
            b. in-order successor is the node with minimum value higher than d in the parent chain of d
 */

package _01_Coderust._05_Tree;

public class _x_03_Inorder_Successor_BST {

    public static Node findInOrderSuccessor(Node head, int key ) {

        if (head == null)
            return null;
        Node current = head;

        Node successor = null;
        while (current != null) {
            if (current.data < key) {
                current = current.right;

            } else if (current.data > key) {
                successor = current; //--> here will be update the successor, in cases later if later current right is null;
                current = current.left;

            } else {
                // If right child is not null
                if (current.right != null) {
                    successor = leftMostMinNode(current.right);
                }
                break;
            }

        }
        return successor;
    }

    public static Node leftMostMinNode(Node currentMin){
        if(currentMin == null)
            return null;

        while(currentMin.left != null) {
            currentMin = currentMin.left;
        }

        return currentMin;

        }



    public static void main(String[] args) {
        // to create Binary Tree use below array
        //Node root = TreePrint.create(new int[]{50,30,20,40,70,60,80, 90, 5});


        // to create BST use below array
        //Node r2 = TreePrint.create(new int[]{6, 4, 8, 2, 5, 7, 9, 1, 3});
        int [] nodes = {10, 5, 20, 3, 8, 15, 50, 1, 4, 6, 9};
        Node r1 = TreePrint.create(nodes);

        /*      to create un-balanced tree
		Node root = new Node(5);
		root.left = new Node(6);
		root.right = new Node(7);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		TreePrint.print(root);  */
        // find in-order successor for each key
        for (int key : nodes)
        {
            Node prec = findInOrderSuccessor(r1, key);

            if (prec != null) {
                System.out.println("Successor of node " + key + " is "
                        + prec.data);
            } else {
                System.out.println("Successor doesn't exists for node "
                        + key);
            }
        }

    }
}
