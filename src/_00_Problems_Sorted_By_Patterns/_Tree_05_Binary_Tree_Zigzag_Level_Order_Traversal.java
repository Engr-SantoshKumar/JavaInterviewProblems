/* [ _Tree_05_ ] [ Binary Tree Zigzag Level Order Traversal ]
_______________________________________________________________________________
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).

                        1            <-------- this way
                ┌───────┴───────┐
    -------->   2               4
            ┌───┴───┐       ┌───┴───┐
            3       5       7       9  <--------
          ┌─┘                     ┌─┘
------>  10                      15


o/p [ [1], [2,4], [9,7,5,3], [10, 15]]

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _Tree_05_Binary_Tree_Zigzag_Level_Order_Traversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean rightToLeft = true;
        while (!queue.isEmpty()) {
            List<Integer> curLevelNodes = new ArrayList<>();
            int nodesAtCurrentLevel = queue.size();
            while(nodesAtCurrentLevel --> 0){
                TreeNode node = queue.poll();
                if(rightToLeft){
                    curLevelNodes.add(0, node.value); //--> always adding to first
                }else{
                    curLevelNodes.add(node.value);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(curLevelNodes);
            rightToLeft = !rightToLeft; //--> flipping the rightToLeft after each level
        }
        return result;
    }
    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 4, 3, 5, 7, 9, 10};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(zigzagLevelOrder(p));
    }
}
