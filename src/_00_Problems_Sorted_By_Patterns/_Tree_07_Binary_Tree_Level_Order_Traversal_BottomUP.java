/* [ _Tree_07_ ] [ Binary Tree Level Order Traversal bottom first ]
_______________________________________________________________________________
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
(i.e., from left to right, level by level from leaf to root).

                1
        ┌───────┴───────┐
        2               4
    ┌───┴───┐       ┌───┴───┐
    3       5       7       9
  ┌─┘
 10
[[10],[3, 5, 7, 9],[2, 4],[1]]

same as _Tree_04_Binary_Tree_Level_Order_Traversal
only differance put each level nodesList in front of existingOnes
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _Tree_07_Binary_Tree_Level_Order_Traversal_BottomUP {
    public static List<List<Integer>> levelOrderBottomUP(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevelNodes = new ArrayList<>();
            int nodesAtCurrentLevel = queue.size();
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                TreeNode node = queue.poll();
                curLevelNodes.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(0, curLevelNodes); //--> onyDiff from LevelOrderTraversal (put current list in front)
        }
        return result;
    }
    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 4, 3, 5, 7, 9, 10};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(levelOrderBottomUP(p));
    }

}
