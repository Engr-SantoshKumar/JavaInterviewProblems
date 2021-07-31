package _00_Problems_Sorted_By_Patterns;/* [  ] [  ]
_______________________________________________________________________________
https://youtu.be/13m9ZCB8gjw?t=70
*/

import java.util.*;
import java.util.LinkedList;

public class _Tree_15_Lowest_Common_Ancestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode c1, TreeNode c2) {
        Map<TreeNode, TreeNode> mapGraph = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        mapGraph.put(root, null); //map(child, parent)
        queue.add(root);
        //constructing map with key as left/right node and value as root until we found BOTH child
        // same left/right node also adding to queue
        while (!mapGraph.containsKey(c1) || !mapGraph.containsKey(c2)) {
            TreeNode node = queue.poll();
            if (node != null) {
                mapGraph.put(node.left, node);
                mapGraph.put(node.right, node);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        // Now we need to find the all the node between child to root by reading from map
        Set<TreeNode> set = new HashSet<>();
        while (c1 != null) {
            set.add(c1);
            c1 = mapGraph.get(c1);
        }
        // now lets find the path for 2nd child to root using map,
        // and as soon as we find any node with was in the path of previous child that the LCA
        while (!set.contains(c2)) {
            c2 = mapGraph.get(c2);
        }
        return c2;
    }

    private static TreeNode findLCA (TreeNode root, int n1, int n2){

        if(root == null) return null;
        if(root.value == n1 || root.value == n2 ) return root; // if one of the node is root only then is obvious root is parent

        TreeNode left = findLCA(root.left, n1 , n2);
        TreeNode right = findLCA(root.right, n1, n2);
        // this means it found the both nodes, one at left side one at right side
        if(left != null && right != null) return root;

        // this when both node in same side under each other,
        // we just need to find only one as we know other one will be under it.
        if(left==null && right == null) return null;

        if(left != null)
            return left;
        else return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 8, 2, 4, 6, 7, 5};
        TreeNode root = TreeHelper.create(arr);
        System.out.println("LCA of 4 and 5 : " + findLCA(root, 4, 5).value);
        System.out.println("LCA of 2 and 5 : " + findLCA(root, 2, 5).value);
        System.out.println("LCA of 7 and 5 : " + findLCA(root, 7, 5).value);
        System.out.println("LCA of 15 and 5 : " + findLCA(root, 15, 5).value);

        System.out.println("LCA of 5 and 7 : " + lowestCommonAncestor(root, root.left.left.left, root.right.right).value);
        System.out.println("LCA of 5 and 8 : " + lowestCommonAncestor(root, root.left.left.left, root.right).value);
        System.out.println("LCA of 10 and 5 : " + lowestCommonAncestor(root, root.left, root.left.left.left).value);
    }
}
