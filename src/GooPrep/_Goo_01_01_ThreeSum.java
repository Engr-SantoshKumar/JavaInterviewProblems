/**
 * [01-01 ] [3 Sum ]
 * -----------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.
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
        //i will move until third last position, 2nd last will be start and last will be end
        for(int i =0; i < arr.length-3; i++){
            int start = i+1;
            int end = arr.length -1;
            int target = k-arr[i];
                while(start < end){
                    if(arr[start] + arr[end] == target)
                    {
                        System.out.println("Pair : "+ arr[i] + " & " + arr[start] + " & " + arr[end]);
                        while(start < end && arr[start] == arr[start+1]) start++;
                        while(start < end && arr[end] == arr[end-1]) end--;
                        start++;
                        end --;
                    }
                    else if(arr[start]+arr[end] > target) {
                        end--;
                    }
                    else {
                        start++;
                    }
                }
            while(i < end && arr[i] == arr[i+1]) i++; // if next element is same, will move i to avoid duplicate
        }
    }
    public static void main(String[] args) {
        //int[] v = new int[]{2, 1, 8, 4, 7, 3, 0, 8, 0, 9};
        int[] v = new int[]{2, -1, 8, 4, 7, 3, 0, 8, 0, 9, -9, -10};
        threeSumWithoutExtraSpace(v, 0);
    }
}
/*
Given:  2, 1, 8, 4, 7, 3, 0, 8, 0, 9
Sorted: 0, 0, 1, 2, 3, 4, 7, 8, 8, 9
RESULT OUTPUT:
Pair : 0 & 0 & 9
Pair : 0 & 1 & 8
Pair : 0 & 2 & 7
Pair : 2 & 3 & 4
 */