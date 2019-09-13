/**
 * [01-01 ] [3Sum ]
 * -----------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

 TIME COMPLEXITY:
 Given array nums = [-1, 0, 1, 2, -1, -4],
 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
package GooPrep;

import java.util.Arrays;

public class _Goo_01_01_ThreeSum {

    public static void threeSumWithoutExtraSpace(int[] arr, int k){

        if(arr.length < 3 || arr == null){
            System.out.println("There are no pair");
            return;
          }
        Arrays.sort(arr); //0, 0, 1, 2, 3, 4, 7, 8, 8, 9

        for(int i =0; i < arr.length-2; i++){

            if(i>0 && arr[i] == arr[i-1]) continue;

            int start = i+1;
            int end = arr.length -1;
            int target = k-arr[i];

            while(start < end){
                if(arr[i] + arr[start] + arr[end] == target)
                {
                    System.out.println("Pair : "+ arr[i] + " & " + arr[start] + " & " + arr[end]);

                    while(start < end && arr[start] == arr[start+1]) start++;
                    while(start < end && arr[end] == arr[end-1]) end--;
                    start++;
                    end --;
                }
                else if(arr[start]+arr[end] > target)
                {
                    end--;
                }
                else
                {
                    start++;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] v = new int[]{2, 1, 8, 4, 7, 3, 0, 8, 0, 9};
        threeSumWithoutExtraSpace(v, 9);
    }
}
