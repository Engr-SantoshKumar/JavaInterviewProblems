/* [ _Goo2_30 ] [ Binary Tree Vertical Order Traversal ]
_______________________________________________________________________________
TC 314
Given the root of a binary tree, return the vertical order traversal of its nodes' values.
(i.e., from top to bottom, column by column).
If two nodes are in the same row and column, the order should be from left to right.
*/
package PrepSetTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _Goo2_30_T_Binary_Tree_Vertical_Order_Traversal {

    /* this is wrongSolution*/
    public static void printNodeInColumn(Node root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> hm = new HashMap<>();

        topToBottom(root, hm, 0);
        //result in map with key
        System.out.println(hm);

    }

    public static void topToBottom(Node root, Map<Integer, List<Integer>> hm, int key) {
        //base case
        if(root == null) {
            return;
        }

        hm.putIfAbsent(key, new ArrayList<>());
        hm.get(key).add(root.data);

        topToBottom(root.left, hm, key -1);
        topToBottom(root.right, hm, key +1);

    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 0, 1, 6, 7, 8, 9, 10, 11};
        Node r = TreeHelper.create(arr);
        printNodeInColumn(r);
    }
}
