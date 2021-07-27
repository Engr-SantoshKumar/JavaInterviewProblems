/* [ _Tree_08_ ] [ Balanced Binary Tree ]
_______________________________________________________________________________
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Logic: same as find the depth of Binary Tree
only we keep checking the differance between left and right should not be more than 1

*/
package _00_Problems_Sorted_By_Patterns;
public class _Tree_08_Balanced_Binary_Tree {
    static boolean result=true;
    public static boolean IsBalanced(TreeNode root){maxDepth(root);
        return result;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight  = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) // this is only different from max height
            result = false;
        return Math.max(leftHeight, rightHeight)+1;
    }
    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 4, 3, 5, 7, 9, 10};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(IsBalanced(p));
    }
}
