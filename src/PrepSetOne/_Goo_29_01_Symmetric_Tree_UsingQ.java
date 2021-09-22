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
package PrepSetOne;

import java.util.ArrayDeque;
import java.util.Queue;

public class _Goo_29_01_Symmetric_Tree_UsingQ {

    public static void symmetricTree(Node root) {
        System.out.println(isSymmetricHelp(root));
    }

    // here we need to compare extreme right to extreme left
    // so first we will go to all the way to left then all the way to right
    // (Note not the current node right main root node right)
    private static boolean isSymmetricHelp(Node root) {
        Queue<Node> qL = new ArrayDeque<>();
        Queue<Node> qR = new ArrayDeque<>();

        qL.offer(root);
        qR.offer(root);

        while (!qL.isEmpty()) {

            if (qL.size() != qR.size()) {
                return false;
            }

            Node leftNode = qL.poll();
            Node rightNode = qR.poll();

            if (leftNode.data != rightNode.data) return false;
            if (leftNode.left != null && leftNode.right != null &&
                    rightNode.right != null && rightNode.left != null) {
                if (leftNode.left.data != rightNode.right.data) return false;
                if (leftNode.right.data != rightNode.left.data) return false;

                qL.offer(leftNode.left);
                qL.offer(leftNode.right);

                qR.offer(rightNode.right);
                qR.offer(rightNode.left);
            }
        }
        return true;
    }

    public static void main(String args[]) {

        int[] nodes = new int[]{1, 2, 2, 3, 4, 4, 3};
        Node r = TreePrint.create(nodes);
        symmetricTree(r);

        int[] nodes1 = new int[]{1, 2, 2, 3, 4, 5, 3};
        Node r1 = TreePrint.create(nodes1);
        symmetricTree(r1);
    }
}
