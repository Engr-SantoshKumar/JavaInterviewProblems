/* [ _Tree_04_ ] [ Binary Tree Level Order Traversal ]
_______________________________________________________________________________
                1
        ┌───────┴───────┐
        2               4
    ┌───┴───┐       ┌───┴───┐
    3       5       7       9
  ┌─┘
 10
[[1], [2, 4], [3, 5, 7, 9], [10]]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _Tree_04_Binary_Tree_Level_Order_Traversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(curLevelNodes);
        }
        return result;
    }
    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 4, 3, 5, 7, 9, 10};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(levelOrder(p));
    }

}
