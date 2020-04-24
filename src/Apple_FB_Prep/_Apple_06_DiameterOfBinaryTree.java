/**
[ Apple_06 ] [ Diameter Of BinaryTree ]
_________________________________________________________________________________________________________
 Given a binary tree, you need to compute the length of the diameter of the tree.
 The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 This path may or may not pass through the root.

 Example:
 Given a binary tree
         1
        / \
       2   3
     / \
    4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */
package Apple_FB_Prep;
public class _Apple_06_DiameterOfBinaryTree {

    static int maxDiameter =0 ;
    static int findDiameterOfBT( Node root){
        findHeight(root);
        return maxDiameter;
    }

    static int findHeight( Node node){
        if(node==null)return 0;
        int leftH = findHeight(node.left);
        int rightH = findHeight(node.right);

        maxDiameter = Math.max(maxDiameter, leftH + rightH);

        return Math.max(leftH, rightH) + 1;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,1,3,2,7,8};
        Node root = TreeHelper.create(arr);
        System.out.println(findDiameterOfBT(root));
    }


}
