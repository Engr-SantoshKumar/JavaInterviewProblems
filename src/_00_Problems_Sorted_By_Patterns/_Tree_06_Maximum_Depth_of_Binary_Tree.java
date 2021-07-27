/* [ _Tree_06_ ] [  Maximum Depth of Binary Tree ]
_______________________________________________________________________________
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
farthest leaf node.
                1
        ┌───────┴───────┐
        2               4
    ┌───┴───┐       ┌───┴───┐
    3       5       7       9
  ┌─┘
 10

 o/p --> 4
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.LinkedList;
import java.util.Queue;

public class _Tree_06_Maximum_Depth_of_Binary_Tree {
    //DFS
    public static int findDepthRecursion(TreeNode root){
        if(root==null) return 0;
        int leftHeight  = findDepthRecursion(root.left);
        int rightHeight = findDepthRecursion(root.right);

        return Math.max(leftHeight, rightHeight)+1;
       }

    //BFS
    public static int findDepthIteration(TreeNode root) {
            if(root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size-- > 0) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                depth++;
            }
            return depth;
    }

    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 4, 3, 5, 7, 9, 10};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(findDepthRecursion(p));
        System.out.println(findDepthIteration(p));
    }
}
