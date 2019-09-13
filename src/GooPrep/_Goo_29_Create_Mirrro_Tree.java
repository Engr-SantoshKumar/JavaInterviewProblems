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

	e.g - in the this tree swapping will occurs in this way: 20<->40 , 75<->85, 60<->80, 30<->70
more info = https://www.youtube.com/watch?v=vdwcCIkLUQI&t=186s
*/

package GooPrep;

public class _Goo_29_Create_Mirrro_Tree {

    public static void main(String args[]) {

        int[] nodes = new int[]{50, 30, 70, 20, 40, 60, 80, 5, 10};
        Node r = TreePrint.create(nodes);
        TreePrint.print(createMirrorTree(r));
    }


    static Node createMirrorTree(Node root){

        if(root == null) return root;
        Node right = createMirrorTree(root.right);
        Node left = createMirrorTree(root.left);


        /* swap the left and right pointers */
        root.left = right;
        root.right =left;

        return root;

    }
}
