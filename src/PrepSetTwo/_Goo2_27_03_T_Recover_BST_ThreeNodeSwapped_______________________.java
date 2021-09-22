/**
 * [ Goo2_T_27_03 ] [ Recover Binary Search Tree ]
 * ______________________________________________________________________________________________________

 Three elements of a binary search tree (BST) are swapped by mistake.
 Recover the tree without changing its structure.

                4                                       4
            ┌───┴───┐                               ┌───┴───┐
            6       5              ---->            2       6
          ┌─┴─┐   ┌─┴─┐                           ┌─┴─┐   ┌─┴─┐
          1   3   2   7                           1   3   5   7

swapped data : 6 5 2
InOrder: 1,6,3,4,2,5,7   --->  1,2,3,4,5,6,7  ---> [6 <-> 2] [5 <-> 6] [2 <-> 6]

 */
package PrepSetTwo;
public class _Goo2_27_03_T_Recover_BST_ThreeNodeSwapped_______________________ {


    public static void findTwoSwapped(Node root){
        if(root==null) return;

        /*
        Need To Code
         */


    }


    public static void main(String[] args) {
        //Test One
        int[] arr = new int[]{4,5,6,1,3,2,7};
        Node root = TreeHelper.create(arr);
        findTwoSwapped(root);

    }
}