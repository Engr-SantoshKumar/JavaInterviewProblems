/**
 * [ Goo_86 ] [ find the sub array with largest sum ]
 * ____________________________________________________________________________________________________________________
 Given an array of positive and negative numbers(containing at least 1 positive number)
 find the sub array with largest sum
 1, 10, -1, 6, 5, 4, -30, 7, -3, 5, 6, -3, 6, 14, -35
 ---> 32 [7, -3, 5, 6, -3, 6, 14]
 -15, -14, -10, -19, -5, -21, -10
 ----> -5  [-5]
 */
package GooPrep;
public class _Goo_86_Largest_Sum_SubArray {

    static int find_max_sum_sub_array(int[] a) {

        if (a.length < 1){
            return 0;
        }
        int currentSum = a[0];
        int globalSum = a[0];

        for(int i =1; i < a.length; i++){
            //if current_max is less than 0, then current_max = A[i]
            if(currentSum < 0){
                currentSum = a[i];
            }
            //otherwise current_max = current_max + A[i]
            else{
                currentSum = currentSum + a[i];
            }
            /* if global_max is less than current_max then global_max = current_max */
            if(globalSum < currentSum){
                globalSum = currentSum;
            }
        }
        return globalSum;
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 10, -1, 6, 5, 4, -30, 7, -3, 5, 6, -3, 6, 14, -35};
        System.out.println("Sum of largest subarray: " + find_max_sum_sub_array(v));


        int[] v1 = new int[]{-15, -14, -10, -19, -5, -21, -10};
        System.out.println("Sum of largest subarray: " + find_max_sum_sub_array(v1));
    }

}
