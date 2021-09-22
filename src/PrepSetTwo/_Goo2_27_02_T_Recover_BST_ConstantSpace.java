/**
 * [ Goo2_T_27_02 ] [ Recover Binary Search Tree ]
 * ______________________________________________________________________________________________________

 Two elements of a binary search tree (BST) are swapped by mistake.
 Recover the tree without changing its structure.

 Follow up:
 A solution using O(n) space is pretty straight forward.
 Could you devise a constant space solution?

 Order of the Algorithm
 Time Complexity is O(n)
 Space Complexity is O(1)

 */
package PrepSetTwo;
public class _Goo2_27_02_T_Recover_BST_ConstantSpace {

    static Node firstNode= null;
    static Node secondNode= null;
    static Node previous = null;

    public static void findTwoSwapped(Node root){
        if(root==null) return;
        //go all the way left
        findTwoSwapped(root.left);

        //look for swapped node
        if(previous!=null){
            if(previous.data > root.data){
                if(firstNode==null){
                    firstNode = previous;
                }
                secondNode = root;
            }
        }
        previous = root;//update previous

        //go all the way right
        findTwoSwapped(root.right);
    }


    public static void main(String[] args) {
        //Test One
        int[] arr = new int[]{4,5,6,1,3,2,7};
        Node root = TreeHelper.create(arr);
        findTwoSwapped(root);  // 5, 2
        System.out.println("data need to swap : "+ firstNode.data + " " + secondNode.data);

        //swap the nodes data
        int temp = firstNode.data;
        firstNode.data= secondNode.data;
        secondNode.data=temp;


        TreeHelper.print(root);
    }
}

/**  OutPut
= = = = = = = Printing Tree = = = = = = = = = = = =
              4
          ┌───┴───┐
         5       6
       ┌─┴─┐   ┌─┴─┐
       1   3   2   7
 data need to swap : 5 2

 = = = = = = = Printing Tree = = = = = = = = = = = =
             4
         ┌───┴───┐
         2       6
      ┌─┴─┐    ┌─┴─┐
      1   3    5   7
 */