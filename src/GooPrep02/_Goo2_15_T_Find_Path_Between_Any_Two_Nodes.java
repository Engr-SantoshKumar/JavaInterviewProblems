/**
[ Goo2_15_T ] [ Distance Between 2 Nodes in BT ]
________________________________________________________________________________________________________________
Write a function that given a BST, it will return the distance (number of edges) between 2 nodes.
For example, given this tree

          5              The distance between 1 and 4 is 3: [1 -> 2 -> 3 -> 4]
         / \
        3   6             The distance between 1 and 8 is 6: [1 -> 2 -> 3 -> 5 -> 6 -> 7 -> 8]
       / \   \
      2   4   7
     /         \
    1           8

Logic:
 We can solve this problem using the concept of LCA (lowest common ancienter)
--------------------------------
Time complexity: O(h), where h is the height of the tree.
 Space complexity: O(h).
 */
package GooPrep02;

import java.sql.SQLOutput;
import java.util.*;

public class _Goo2_15_T_Find_Path_Between_Any_Two_Nodes {

    static HashMap<Node, Node> hMap = new HashMap<>();
    static Queue<Node> queue = new LinkedList<>();

    private static int findDistance(Node root, Node A, Node B){
        int count = 0;
        if(A == B) return count;

        //load into map with key as left/right node and value as root
        hMap.put(root, null);
        queue.add(root);
        // Iterate through the graph and load into the map until we find BOTH of the target node
        while(!hMap.containsKey(A) || !hMap.containsKey(B)){
            Node currentHead = queue.poll();
            hMap.put(currentHead.left, currentHead);
            hMap.put(currentHead.right, currentHead);
            queue.add(currentHead.left);
            queue.add(currentHead.right);
        }

        // Now we need to find the all the node between child to root by reading from map
        Set<Node> set1 = new HashSet<>();
        while ( A != null) {
            set1.add(A);
            A = hMap.get(A);
        }

        // same as above we need to find
        Set<Node> set2 = new HashSet<>();
        while ( B != null) {
            set2.add(B);
            B = hMap.get(B);
        }

        //Now we need to find the elements which are not common in both the sets ..and its length will be the result
        Set<Integer> result = new HashSet<>();
        for (Node el: set1) {
            if (!set2.contains(el)) {
                result.add(el.data);
            }
        }
        for (Node el: set2) {
            if (!set1.contains(el)) {
                result.add(el.data);
            }
        }
        System.out.println(result);

        return result.size();
    }


    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 8, 2, 4, 6, 7, 5};
        Node root = TreeHelper.create(arr);
        System.out.println("Distance between 5 and 7 : " + findDistance(root, root.left.left.left, root.right.right));
        System.out.println("Distance between 5 and 2 : " + findDistance(root, root.left.left.left, root.left.left));


    }


}
