package _01_Coderust._05_Tree;

public class _x_08_Delete_Zero_Sum_Sub_Trees {


    public static int delete_zero_sum_subtree_rec(Node root){

        if(root == null)
            return 0;


        int leftSum = delete_zero_sum_subtree_rec(root.left);
        int rightSum = delete_zero_sum_subtree_rec(root.right);

        if(leftSum == 0){
            root.left = null;
        }
        if(rightSum ==0){
            root.right = null;
        }

        return root.data + leftSum + rightSum;

    }




    public static void main(String[] args) {
        int[] arr = {7, 5, 6, -3, -2, 4, 8, 4, -4, -10, 10, 1, -5};
        Node r1 = TreePrint.create(arr);
        System.out.print("\nDelete Zero Sum Sub-Trees:\n");
        delete_zero_sum_subtree_rec(r1);
        TreePrint.print(r1);


    }
}
