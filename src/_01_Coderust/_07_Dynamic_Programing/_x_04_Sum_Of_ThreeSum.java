package _01_Coderust._07_Dynamic_Programing;

import java.util.Arrays;

public class _x_04_Sum_Of_ThreeSum {


    static boolean find_sum_of_two(int[] A, int val, int start_index) {

        for (int i = start_index, j = A.length - 1; i < j;) {
            int sum = A[i] + A[j];
            if (sum == val) {
                return true;
            }

            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }

        return false;
    }


    public static Boolean find_sum_of_three_v3(int arr[], int required_sum) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; ++i) {
            int remaining_sum = required_sum - arr[i];
            if (find_sum_of_two(arr, remaining_sum, i + 1)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String []args){
        int[] arr = {-25, -10, -7, -3, 2, 4, 8, 10};
        System.out.println("-8: " +find_sum_of_three_v3(arr, -8));
        System.out.println("-25: " +find_sum_of_three_v3(arr, -25));
        System.out.println("0: " +find_sum_of_three_v3(arr, 0));
        System.out.println("-42: " +find_sum_of_three_v3(arr, -42));
        System.out.println("22: " +find_sum_of_three_v3(arr, 22));
        System.out.println("-7: " +find_sum_of_three_v3(arr, -7));
        System.out.println("-3: " +find_sum_of_three_v3(arr, -3));
        System.out.println("2: " +find_sum_of_three_v3(arr, 2));
        System.out.println("4: " +find_sum_of_three_v3(arr, 4));
        System.out.println("8: " +find_sum_of_three_v3(arr, 8));
        System.out.println("7: " +find_sum_of_three_v3(arr, 7));
        System.out.println("1: " +find_sum_of_three_v3(arr, 1));
    }
}
