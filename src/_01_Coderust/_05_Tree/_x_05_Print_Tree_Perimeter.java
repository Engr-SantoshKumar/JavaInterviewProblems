/*
We will print the perimeter of the binary tree in three passes:
    1st Print the root node.
    step 1: Print the left boundary in top-down order.
    step 2: Print the leaf nodes in left-right order.
    step 3: Print the right boundary in bottom-up order. We will push the node values in a stack here.
            Once we hit the leaf node, we will pop all elements of the stack while printing them.

 */


package _01_Coderust._05_Tree;

import java.util.Stack;

public class _x_05_Print_Tree_Perimeter {


    public static void findPerimeter(Node head){
        if(head != null )
            System.out.print(head.data + " ");

        //step 1
        print_left_perimeter(head.left);
        //step 2
        if(head.left!=null || head.right!=null)
            print_leaf_nodes(head);
        //step 3
        print_right_perimeter(head.right);
    }

    /*step 1: Print the left boundary in top-down order.*/
    public static void print_left_perimeter (Node current ){
        while(current != null){
            int currentData = current.data;
            if(current.left != null){
                current = current.left;
            }
            else if(current.right != null){
                current = current.right;

            }else{
                break; // --> we reached the leaf node, and we dont want to print any leaf node in this method thats why break
            }

            System.out.print(currentData + " ");
        }

    }

    /*step 2: Print the leaf nodes in left-right order.*/
    public static void print_leaf_nodes (Node current ) {

        if (current != null) {
            print_leaf_nodes(current.left);
            print_leaf_nodes(current.right);

            if (current.left == null && current.right == null)
                System.out.print(current.data + " ");
        }
    }


    /*step 3: Print the right boundary in bottom-up order*/
    public static void print_right_perimeter (Node current ){

        Stack<Integer> stack = new Stack<Integer>();

        while(current != null){
            int currentData = current.data;
            if(current.right!=null){
                current = current.right;
                }
            else if(current.left != null){
            current = current.left;
            }
            else{
                break;
            }
            stack.push(currentData);
        }
        //print stack
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }


    public static void main(String[] args) {
        Node r1 = TreePrint.create(new int[]{10, 5, 20, 3, 8, 15, 50, 1, 4, 6, 9 , 12 , 18, 40, 60});
        System.out.print("\nAbove Tree's Perimeter:\n");
        findPerimeter(r1);

        // to create un-balanced tree
		Node root = new Node(10);
		root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
		root.right = new Node(20);
		root.right.right = new Node(50);
        root.right.right.left = new Node(30);
        root.right.right.left.left = new Node(35);
        root.right.right.right = new Node(40);
		root.right.right.right.left = new Node(38);
		TreePrint.print(root);
        System.out.print("\nAbove Tree's Perimeter:\n");
        findPerimeter(root);






    }
}
