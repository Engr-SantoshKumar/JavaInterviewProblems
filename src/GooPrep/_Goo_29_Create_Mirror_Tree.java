/**  29  [Mirror Tree]
 -------------------------------------------------------------------------------------------------------
    (1)  Call recursion for left-subtree,  this way it will get to the last node at left side
	(2)  Call recursion for right-subtree, this will get you the last right node at left side
	(3)  Swap left and right subtrees.
               50
        ┌───────┴───────┐
       30              70
    ┌───┴───┐       ┌───┴───┐
   20      40      60      80
  ┌─┴─┐
  5  10

                50
         ┌───────┴───────┐
        70              30
    ┌───┴───┐       ┌───┴───┐
   80      60      40      20
                         ┌─┴─┐
                        10   5

	e.g - in the this tree swapping will occurs in this way:  5 <->10, 20<->40, 60<->80, 30<->70
more info = https://www.youtube.com/watch?v=vdwcCIkLUQI&t=186s
*/

package GooPrep;

import java.util.ArrayDeque;
import java.util.Queue;

public class _Goo_29_Create_Mirror_Tree {

    public static void main(String args[]) {

        int[] nodes = new int[]{50, 30, 70, 20, 40, 60, 80, 5, 10};
        Node r = TreePrint.create(nodes);
        TreePrint.print(createMirrorTree(r));

        int[] nodes1 = new int[]{5,3,8,1,2,7,9,0};
        Node r1 = TreePrint.create(nodes1);
        TreePrint.print(mirror_imageWithOutRecursion(r1));
    }


    static Node createMirrorTree(Node root){

        if(root == null) return root;
        Node left = createMirrorTree(root.right);
        Node right = createMirrorTree(root.left);
        /* swap the left and right pointers */
        root.left = right;
        root.right =left;
        return root;
    }

    public static Node  mirror_imageWithOutRecursion(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        // Do BFS. While doing BFS, keep swapping
        // left and right children
        while(!queue.isEmpty()) {
            // pop top node from queue
            Node cur_node = queue.poll();

            // swap left child with right child
            Node temp = cur_node.left;
            cur_node.left = cur_node.right;
            cur_node.right = temp;

            // push left and right children
            if (cur_node.left!=null)
                queue.add(cur_node.left);
            if (cur_node.right!=null)
                queue.add(cur_node.right);
        }

        return root;
    }



}
