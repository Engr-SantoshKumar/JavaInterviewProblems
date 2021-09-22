/** 42  [Sorted_Array_To_BST]
 -----------------------------------------------------------------------------------------------------------
 Convert a sorted array into a binary search tree.
 array = [0,1,2,3,4,5,6,7,8,9,10]"

 https://www.youtube.com/watch?v=VCTP81Ij-EM

 */
package PrepSetOne;
public class _Goo_42_Sorted_Array_To_BST {

    static Node root;

    /* A function that constructs Balanced Binary Search Tree
     from a sorted array */
    Node sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        _Goo_42_Sorted_Array_To_BST tree = new _Goo_42_Sorted_Array_To_BST();
        int arr[] = new int[]{1,2,3,6,7,8};
        int n = arr.length;
        root = tree.sortedArrayToBST(arr, 0, n - 1);

        //display tree
        TreePrint.print(root);
    }


}
