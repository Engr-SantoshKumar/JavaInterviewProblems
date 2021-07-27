/*[ _Tree_03_ ] [ Symmetric Tree ]
_______________________________________________________________________________
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Input: root = [1,2,2,3,4,4,3]
o/p true
Logic: same like Same tree problem
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.LinkedList;
import java.util.Queue;

public class _Tree_03_Symmetric_Tree {
    public static boolean isSymmetricRecursion(TreeNode root) {
        if (root== null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        if(left==null && right==null) return true; //This is a base case, but also handles being given two empty trees
        if(left==null || right==null) return false; //if at lest one null, Note that we've already ruled out equal nullity above
        if(left.value!= right.value) return false;
        return isSymmetricHelper(left.left, right.right) &&
                isSymmetricHelper(left.right, right.left);
    }

    public static boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null){
                continue;
            }else if(left == null || right == null || left.value != right.value){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String args[]) {
        int[] nodes = new int[]{1,2,2,3,4,4,3};
        TreeNode p = TreeHelper.create(nodes);

        System.out.println(isSymmetricRecursion(p));
        System.out.println(isSymmetricIterative(p));

    }
}

