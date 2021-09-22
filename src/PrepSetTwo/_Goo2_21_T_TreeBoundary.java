/**
 * [ Goo2_21_T ] [Boundary of Binary Tree  ]
______________________________________________________________________________________________________
 Input:
           ____1_____
          /          \
         2            3
        / \          /
       4   5        6
         / \      / \
        7   8   9  10

 Ouput:
 [1,2,4,7,8,9,10,6,3]

 Explanation:
 The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 The leaves are node 4,7,8,9,10.
 The right boundary are node 1,3,6,10. (10 is the right-most node).
 So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].

 */
package PrepSetTwo;
public class _Goo2_21_T_TreeBoundary {

    public static void boundaryOfBinaryTree(Node root) {

        System.out.print(root.data + " - ");

        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

    }
    public static void leftBoundary(Node root) {
        if(root == null || (root.left == null && root.right == null)) return;

        //--> print statement first, so in the case of leaf node compiler will not get to print line
        // call will return from above if condition as leaf node left and right are empty
        System.out.print(root.data + " - ");

        if(root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }

    public  static void leaves(Node root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            System.out.print(root.data + " - ");   //--> print statement middle
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

    public static void rightBoundary(Node root) {
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null)rightBoundary(root.left);
        else rightBoundary(root.right);
        System.out.print(root.data + " - ");    //--> print statement last, because its going from bottom to top
    }


    public static void main(String[] args) {
        int[] arr = new int[]{9, 4, 13, 2, 6, 11, 15, 1, 3, 5, 7, 10, 12, 14, 16, 8};
        Node root = TreeHelper.create(arr);
        boundaryOfBinaryTree(root);

    }

}
