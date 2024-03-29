/**
 * [01-01 ] [3 Sum ]
 * -------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.
 */
package PrepSetOne;

import java.util.Arrays;

public class _Goo_01_02_ThreeSum {

    public static void threeSumWithoutExtraSpace(int[] arr, int k){

        if(arr == null || arr.length < 3){
            System.out.println("No pair found");
            return;
        }
        Arrays.sort(arr); //0, 0, 1, 2, 3, 4, 7, 8, 8, 9
        for(int i =0; i < arr.length-2; i++){
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
        int[] v1= new int[]{3, 0, 0,0};
        threeSumWithoutExtraSpace(v1, 0);
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