/* [ _Tree_01_ ] [ Binary Tree Inorder Traversal ]
_______________________________________________________________________________
Given the root of a binary tree, return the inorder traversal of its nodes' values.

*/
package _00_Problems_Sorted_By_Patterns;

import GooPrep.Node;
import GooPrep.TreePrint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _Tree_01_Binary_Tree_Inorder_Traversal {
    static List<Integer> result = new LinkedList<>();
    public static List<Integer> inorderTraversalRecursion(TreeNode root) {
        findInOrder(root);
        return result;
    }
    static void findInOrder(TreeNode root) {
        if(root==null) return;
        findInOrder(root.left);
        result.add(root.value);
        findInOrder(root.right);
    }

    //iteration BFS
    /*
        We push all the left children of root into the stack until there's no more nodes.
        Then we pop from the stack which we'd call cur.
        Add cur to result list
        Recursively call pushAllLeft() on cur's right child.
     */
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { //push all the left children of root
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.value);  //add to result
            cur = cur.right; // goRight
        }
        return result;
    }

    public static void main(String args[]) {
        int[] nodes = new int[]{1,2,3,4,5,6,7,8,9};
        TreeNode r = TreeHelper.create(nodes);
        System.out.println(inorderTraversalRecursion(r));
        System.out.println(inorderTraversalIterative(r));
    }
}
