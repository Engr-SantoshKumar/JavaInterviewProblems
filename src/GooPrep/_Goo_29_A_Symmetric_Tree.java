/**
 * [  _Goo_29_A_ ] [Symmetric Tree ]
 * ______________________________________________________________________________________________________
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
             1
         ┌───┴───┐
        2        2
      ┌─┴─┐    ┌─┴─┐
      3   4    4   3

 */
package GooPrep;

import javax.swing.tree.TreeNode;

public class _Goo_29_A_Symmetric_Tree {

    public static void main(String args[]) {

        int[] nodes = new int[]{1,2,2,3,4,4,3};
        Node r = TreePrint.create(nodes);
        symmetricTree(r);
    }


    public static void symmetricTree(Node root){
        System.out.println(isSymmetricHelp(root.left, root.right));
    }

    // here we need to compare extreme right to extreme left
    // so first we will go to all the way to left then all the way to right
    // (Note not the current node right main root node right)
    private static boolean isSymmetricHelp(Node left, Node right){
        //base
        if(left==null || right==null)
            return left==right;

        if(left.data!=right.data)
            return false;

        return isSymmetricHelp(left.left, right.right) &&
                isSymmetricHelp(left.right, right.left);
    }
}
