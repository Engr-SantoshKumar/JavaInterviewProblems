/** [ Goo2_10_T ] [ Find Leaves of Binary Tree from bottom up]
* _____________________________________________________________________________________________________________
 Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
 repeat until the tree is empty.

 Input: [1,2,3,4,5]

                     5
             ┌───────┴───────┐
             3               4
         ┌───┴───┐       ┌───┴───┐             Output: [[8,1,6,7], [0, 4], [3], [5]]
         0       1       6       7
      ┌─┘
     8
Logic: its same as traversing from bottom, we are using map/ListOfList to store all the leafs at that particular level

 */

package GooPrep02;
import java.util.*;

public class _Goo2_10_T_Find_Leaf_of_BT_bottomUP {

    public static void findLeaves(Node root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> hm = new HashMap<>();

        int maxLevel = findLeavesAtEachLevelUsingMap(root, hm);
        //result in map with key
        System.out.println(hm);

        //result in List
        findLeavesAtEachLevelUsingList(root, result);
        System.out.println(result);
    }

    //call is same like bottom-up recursively
    public static int findLeavesAtEachLevelUsingMap(Node root, Map<Integer, List<Integer>> hm){

        if(root == null) return -1;
        int leftHeight = findLeavesAtEachLevelUsingMap(root.left, hm);
        int rightHeight = findLeavesAtEachLevelUsingMap(root.right, hm);

        // since its bottomUP, first time this code is reached is when curLevel will be 0,
        int curLevel = Math.max( leftHeight, rightHeight ) +1;

        // Using curLevel as Key to store leaves
        if(!hm.containsKey(curLevel)){
            hm.put(curLevel, new ArrayList<>());
        }hm.get(curLevel).add(root.data);

        return curLevel;
    }

    // traverse the tree bottom-up recursively
    public static int findLeavesAtEachLevelUsingList(Node root, List<List<Integer>> list ) {
        if (root == null)
            return -1;

        int left = findLeavesAtEachLevelUsingList(root.left, list);
        int right = findLeavesAtEachLevelUsingList(root.right, list);
        int curr = Math.max(left, right) + 1;

        if (list.size() <= curr) {
            list.add(new ArrayList<Integer>());
        }
        list.get(curr).add(root.data);
        return curr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 0, 1, 6, 7, 8};
        Node r = TreeHelper.create(arr);
        findLeaves(r);
    }
}
