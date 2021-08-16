/* [ _Tree_09_ ] [ Binary Tree Right Side View ]
_______________________________________________________________________________
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
                    1                 <---- 1
            ┌───────┴───────┐
            2               4         <---- 4
        ┌───┴───┐       ┌───┴
        3       5       7             <---- 7
      ┌─┘       ┴───┐
     10             12                <---- 12
      ┴───┐
          13                          <---- 13

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _Tree_09_Binary_Tree_Right_Side_View {
    //Logic:same as levelOrderTraversal, in result we just need to out last node of each level
    public static List<Integer> rightViewOfTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //List<Integer> curLevelNodes = new ArrayList<>();
            int nodesAtCurrentLevel = queue.size();
            while(nodesAtCurrentLevel --> 0) {
                TreeNode node = queue.poll();
                if(nodesAtCurrentLevel==0) //---> this line is only different from levelOrderTraversal
                    result.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //result.add(curLevelNodes);
        }
        return result;
    }
    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 4, 3, 5, 7, 9, 10};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(rightViewOfTree(p));
    }
}
