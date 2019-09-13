/*
Point 1: The left subtree of a node contains only nodes with keys less than the node’s key.
Point 2:  The right subtree of a node contains only nodes with keys greater than the node’s key.
• Both the left and right subtrees must also be binary search trees.
 */

package _01_Coderust._05_Tree;

import java.util.Stack;

public class _x_04_Is_Binary_Search_Tree {

    public static Boolean isBST_usingRecursion(Node current, int min, int max ){

        if( current == null)
            return true;

        if(current.data < min || current.data > max)
            return false;

        return isBST_usingRecursion(current.left, min, current.data) //--> when we go to current left will keep updating the max
                && isBST_usingRecursion(current.right, current.data, max);// --> to satisfy Point 2, keep updating the min

    }

    /*
    We can use inorder traversals property to check whether or not a given binary tree is a BST.
    Just do a regular inorder traversal and keep track of the last seen node (prev),
    then check whether the current node's value is greater than or equal to the previous (prev) node's value.
     */

    static Node previous = null;
    public static Boolean is_binary_search_tree(Node root){
        if(root == null)
            return  true;

        if(!is_binary_search_tree(root.left))
            return false;

        if(previous != null && previous.data >= root.data)
            return false;

        previous = root;

        if(!is_binary_search_tree(root.right))
            return false;

        return true;

    }


    public static Boolean isBST_Iteration(Node root){
        if (root == null)
            return true;

        Stack<Node> stack = new Stack<Node>();
        Stack<Integer> upper_limits = new Stack<Integer>();
        Stack<Integer> lower_limits = new Stack<Integer>();
        stack.add(root);
        upper_limits.add(null);
        lower_limits.add(null);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            Integer lower_limit = lower_limits.pop();
            Integer upper_limit = upper_limits.pop();
            if (current.right != null) {
                if (current.right.data > current.data) {
                    if ((upper_limit != null) && (current.right.data >= upper_limit))
                        return false;
                    stack.push(current.right);
                    lower_limits.add(current.data);
                    upper_limits.add(upper_limit);
                } else
                    return false;
            }

            if (current.left != null) {
                if (current.left.data < current.data) {
                    if ((lower_limit != null) && (current.left.data <= lower_limit))
                        return false;
                    stack.add(current.left);
                    lower_limits.push(lower_limit);
                    upper_limits.push(current.data);
                } else
                    return false;
            }
        }
        return true;



    }




    public static void main(String[] args) {
        Node r1 = TreePrint.create(new int[]{10,5,20,3,8,15,50,1,4,6,9});

        System.out.print("Is above tree is BST : ");
        System.out.println(isBST_usingRecursion(r1, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println(is_binary_search_tree(r1));
        System.out.println(isBST_Iteration(r1));

    }
}

