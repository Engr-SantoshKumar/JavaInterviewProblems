package _00_Problems_Sorted_By_Patterns;/* [ _Tree_02_ ] [ Same Tree / identical tree]
_______________________________________________________________________________
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
Input: p = [1,2,3], q = [1,2,3]
Output: true
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _Tree_02_Same_Tree {
    public static boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true; //This is a base case, but also handles being given two empty trees
        if(p==null || q==null) return false; //if at lest one null, Note that we've already ruled out equal nullity above
        if(p.value!= q.value) return false;
        return isSameTreeRecursion(p.left, q.left) &&
                isSameTreeRecursion(p.right, q.right);
    }

    public static boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if(f == null && s == null){
                continue;
            }else if(f == null || s == null || f.value != s.value){
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }

    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 3, 4};
        TreeNode p = TreeHelper.create(nodes);
        int[] nodes1 = new int[]{1, 2, 3, 4};
        TreeNode q = TreeHelper.create(nodes);
        System.out.println(isSameTreeRecursion(p,q));
        System.out.println(isSameTreeIterative(p,q));

    }
}
