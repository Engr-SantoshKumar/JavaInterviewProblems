/* [ _Tree_14_ ] [ Diameter of Binary Tree ]
_______________________________________________________________________________
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
                1
        ┌───────┴───────┐
        2               4
    ┌───┴───┐           ┴───┐
    3       5              9

o/p 3->2->1->4->9 = 5
or 5->2->1->4->9 = 5
another "trap version" of "get the height of a tree"...
Pay attention that we define The diameter of a binary tree is the length of the longest path between any
two nodes in a tree in the problem, that is why we update with Max = Math.max(max, left + right);
instead of max = Math.max(max, left + right + 1)
*/
package _00_Problems_Sorted_By_Patterns;
public class _Tree_14_Diameter_of_Binary_Tree {
    //DFS
    static int diameter;
    public static int findDiameterRecursion(TreeNode root){
        if(root==null) return 0;
        int leftHeight  = findDiameterRecursion(root.left);
        int rightHeight = findDiameterRecursion(root.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, leftHeight+rightHeight);
        return Math.max(leftHeight, rightHeight)+1;
    }
    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 4, 3, 5, 7, 9, 10};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(findDiameterRecursion(p));
    }
}
