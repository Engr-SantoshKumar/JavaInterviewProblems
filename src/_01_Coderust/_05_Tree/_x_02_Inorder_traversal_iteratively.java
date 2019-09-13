/*
        1) Create an empty stack S.
        2) Initialize current node as root
        3) Push the current node to S and set current = current->left until current is NULL
        4) If current is NULL and stack is not empty then
        a) Pop the top item from stack.
        b) Print the popped item, set current = popped_item->right
        c) Go to step 3.
        5) If current is NULL and stack is empty then we are done.
*/



package _01_Coderust._05_Tree;

import java.util.Stack;

public class _x_02_Inorder_traversal_iteratively {

    public static void InorderIterator(Node head){

        if(head == null)
            return ;

        Stack<Node> stack = new Stack<Node>();
        Node current = head;

        while(current!=null || stack.size() > 0){

            /* get to the left most Node of the curr Node */
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            // at this point current must be null, pull last Node from stack and print it
            current = stack.pop();
            System.out.print(current.data+ " ");
            /* we have visited the node and its left subtree.  Now, it's right subtree's turn */
            current = current.right;

        }

    }

    public static void main(String[] args) {
        // to create Binary Tree use below array
        //Node root = TreePrint.create(new int[]{50,30,20,40,70,60,80, 90, 5});


        // to create BST use below array
        //Node r2 = TreePrint.create(new int[]{6, 4, 8, 2, 5, 7, 9, 1, 3});
        Node r1 = TreePrint.create(new int[]{10,5,20,3,8,15,50,1,4,6,9});

        /*      to create un-balanced tree
		Node root = new Node(5);
		root.left = new Node(6);
		root.right = new Node(7);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		TreePrint.print(root);  */
        System.out.println("\nInorder traversal iteratively of above tree \n");
        InorderIterator(r1);


    }
}
