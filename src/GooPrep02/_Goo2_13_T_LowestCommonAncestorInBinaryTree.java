/**
 * [ Goo2_13_T ] [ Lowest Common Ancestor of a Binary Tree ]
 ____________________________________________________________________________________________________________________
                        15
                 ┌───────┴───────┐
                10               8
            ┌───┴───┐       ┌───┴───┐
           2       4       6       7
         ┌─┘
         5
 LCA of 4 and 5 : 10  //  case 1: when one at left side one at right side
 LCA of 2 and 5 : 2   //  case 2: when same side under each other
 LCA of 7 and 5 : 15

 */
package GooPrep02;
import java.util.*;
public class _Goo2_13_T_LowestCommonAncestorInBinaryTree {

    public static Node lowestCommonAncestor(Node root, Node c1, Node c2) {
        Map<Node, Node> hashMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        hashMap.put(root, null);
        queue.add(root);
        //constructing map with key as left/right node and value as root until we found BOTH child
        // same left/right node also adding to queue
        while (!hashMap.containsKey(c1) || !hashMap.containsKey(c2)) {
            Node node = queue.poll();
            if (node != null) {
                hashMap.put(node.left, node);
                hashMap.put(node.right, node);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        // Now we need to find the all the node between child to root by reading from map
        Set<Node> set = new HashSet<>();
        while (c1 != null) {
            set.add(c1);
            c1 = hashMap.get(c1);
        }
        // now lets find the path for 2nd child to root using map,
        // and as soon as we find any node with was in the path of previous child that the LCA
        while (!set.contains(c2)) {
            c2 = hashMap.get(c2);
        }
        return c2;
    }

    private static Node findLCA (Node root, int n1, int n2){

        if(root == null) return null;
        if(root.data == n1 || root.data == n2 ) return root; // if data matched for current root to n1 or n2

        Node left = findLCA(root.left, n1 , n2);
        Node right = findLCA(root.right, n1, n2);
        // this means it found the both node one at left side one at right side
        if(left != null && right != null) return root;

        // this when both node in same side under each other,
        // we just need to find only one as we know other one will be under it.
        if(left != null)
            return left;
        else return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 8, 2, 4, 6, 7, 5};
        Node root = TreeHelper.create(arr);
        System.out.println("LCA of 4 and 5 : " + findLCA(root, 4, 5).data);
        System.out.println("LCA of 2 and 5 : " + findLCA(root, 2, 5).data);
        System.out.println("LCA of 7 and 5 : " + findLCA(root, 7, 5).data);

        System.out.println("LCA of 5 and 7 : " + lowestCommonAncestor(root, root.left.left.left, root.right.right).data);
        System.out.println("LCA of 5 and 8 : " + lowestCommonAncestor(root, root.left.left.left, root.right).data);
        System.out.println("LCA of 10 and 5 : " + lowestCommonAncestor(root, root.left, root.left.left.left).data);
    }
}
