/* [ _Tree_12_ ] [ Binary Tree Vertical Order Traversal ]
_______________________________________________________________________________
Given the root of a binary tree, return the vertical order traversal of its nodes' values.
(i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

                    1
            ┌───────┴───────┐
            2               4
      ┌─────┴───────┐┌───────┴─────┐
      3            5  7            9

      o/p -[ [3] [3] [1,5,7] [4] [9] ]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.*;
import java.util.LinkedList;

public class _Tree_12_Binary_Tree_Vertical_Order_Traversal {
    public static List<List<Integer>> verticalOrderTraversal(TreeNode root){
        //we will use map to Column-->Nodes
        Map<Integer, List<Integer>> mapColNodes = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        //new two Qs one for BFS and other to track columns
        Queue<TreeNode> queue = new LinkedList<>(); // other way to create obj (Node, col) and put in Q(single Q)
        Queue<Integer> colQ = new ArrayDeque<>();
        //add the root and col 0
        queue.offer(root);
        colQ.offer(0);
        int leftMostCol = 0; // will update the leftMostCol and rightMostCol columns on fly, which we will use as key for map for iteration
        int rightMostCol = 0;

        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            int curCol = colQ.poll();
            mapColNodes.putIfAbsent(curCol, new LinkedList<>());
            mapColNodes.get(curCol).add(curNode.value);
            // Step 1: BFS, put node, col into queue at the same time
            // Step 2: Every left child access col - 1 while right child col + 1
            if(curNode.left!=null){
                queue.offer(curNode.left);
                colQ.offer(curCol-1);
                leftMostCol = Math.min(leftMostCol, curCol-1);
            }
            if(curNode.right!=null){
                queue.offer(curNode.right);
                colQ.offer(curCol+1);
                rightMostCol= Math.max(rightMostCol, curCol+1);
            }
        }
        //iteration over map to find all the list
        for(int i=leftMostCol; i<=rightMostCol; i++){
            result.add(mapColNodes.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{1, 2, 4, 3, 5, 7, 9, 10, 11, 12, 13};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(verticalOrderTraversal(p));
    }
}
/*
                1
        ┌───────┴───────┐
        2               4
    ┌───┴───┐       ┌───┴───┐
    3       5       7       9
  ┌─┘
 10
 */
