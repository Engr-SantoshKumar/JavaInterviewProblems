/**
 * [ Goo2_T_27_01 ] [ Recover Binary Search Tree ]
 * _____________________________________________________________________________________________________________

 Two elements of a binary search tree (BST) are swapped by mistake.
 Recover the tree without changing its structure.

 Follow up:
 A solution using O(n) space is pretty straight forward.
 Could you devise a constant space solution?  --> next program [_Goo2_27_02_T_Recover_BST]

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
          left=right=null;
      }
  }

 */
package GooPrep02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Goo2_27_01_T_Recover_BST {

    //inOrder Traversal
    public static void inOrderTraversal(Node root, List<Integer> treeNodesList){
        if(root==null) return;
        inOrderTraversal(root.left, treeNodesList);
        treeNodesList.add(root.data);
        inOrderTraversal(root.right, treeNodesList);
    }

    // find the numbers need to swap
    public static int[] findTwoSwapped(List<Integer> resultList){
        Integer FN = null;
        Integer SN = null;

        for(int i =1; i<resultList.size(); i++){
            if(resultList.get(i-1) > resultList.get(i)){
                if(FN == null){
                    FN = resultList.get(i-1);
                }
                SN = resultList.get(i);
            }
        }
        return new int[]{FN, SN};
    }

    //update treeNodes (update data of node <-> swap)
    public static void recoverTree(Node root, int count, int FN, int SN){
        if(root != null)
        {
            recoverTree(root.left, count, FN, SN);
            if(root.data == FN || root.data ==SN)
                {
                    root.data = root.data==FN? SN:FN;
                    count--;
                    if(count==0) return;
                }
            recoverTree(root.right, count, FN, SN);
        }
    }


    public static void main(String[] args) {
        //Test One
        int[] arr = new int[]{4,5,6,1,3,2,7};
        Node root = TreeHelper.create(arr);
        List<Integer> treeNodesList = new ArrayList<>();
        inOrderTraversal(root, treeNodesList);
        System.out.println("InOrderTraversal");
        System.out.println(treeNodesList);//[1, 5, 3, 4, 2, 6, 7]
        int[] swapped = findTwoSwapped(treeNodesList);
        System.out.println(Arrays.toString(swapped)); //[5, 2]
        recoverTree(root, 2, swapped[0], swapped[1]);
        TreeHelper.print(root);

        // Test Two
        int[] arr1 = new int[]{4,2,5,1,3,6,7};
        Node root1 = TreeHelper.create(arr1);
        List<Integer> treeNodesList1 = new ArrayList<>();
        inOrderTraversal(root1, treeNodesList1);
        System.out.println("InOrderTraversal");
        System.out.println(treeNodesList1);//[1, 2, 3, 4, 6, 5, 7]
        int[] swapped1 = findTwoSwapped(treeNodesList1);
        System.out.println(Arrays.toString(swapped1)); //[6, 5]
        recoverTree(root1, 2, swapped1[0], swapped1[1]);
        TreeHelper.print(root1);

    }
}
