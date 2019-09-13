/*
The basic idea of Kadane's algorithm is to scan the entire array and at each position
find the maximum sum of the subarray ending there.
This is achieved by keeping a current maximum for the current array index and a global maximum.
 */


package _01_Coderust._07_Dynamic_Programing;

public class _x_02_Largest_sum_subArray {

    static int find_max_sum_sub_array(int[] a) {

        if (a.length < 1){
            return 0;
        }

        int currentMaxSum = a[0];
        int globelSum = a[0];

        for(int i =1; i < a.length; i++){

            //    if current_max is less than 0, then current_max = A[i]

            if(currentMaxSum < 0){
                currentMaxSum = a[i];
            }//    otherwise current_max = current_max + A[i]
            else{
               currentMaxSum = currentMaxSum + a[i];
            }
            /* if global_max is less than current_max then global_max = current_max */
            if(globelSum < currentMaxSum){
                globelSum = currentMaxSum;
            }

        }
                return globelSum;
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 10, -1, 11, 5, -30, -7, 20, 25, -35};
        System.out.println("Sum of largest subarray: " + find_max_sum_sub_array(v));


        int[] v1 = new int[]{-15, -14, -10, -19, -5, -21, -10};
        System.out.println("Sum of largest subarray: " + find_max_sum_sub_array(v1));
    }

}
