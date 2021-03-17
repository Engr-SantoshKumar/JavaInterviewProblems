/** 01  [Two Sum]
-------------------------------------------------------------------------------------------------------
 *
 * Program to solve the 2 sum problem
 * Problem statement - Given an array of integers, find two numbers such that they add up target
 *
*/

package GooPrep;

import java.util.*;

public class _Goo_01_01_TwoSum {

    static void twoSum(int[] arr, int target){
        if(arr == null || arr.length < 2){
            System.out.println("No pair found");
            return;
        }

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for(int currentNo : arr){
            if(hashMap.containsKey(currentNo)){
                System.out.println("Pair --> " + hashMap.get(currentNo) + " : " + currentNo);
            }else{
                hashMap.put(target-currentNo, currentNo);
            }
        }
    }

    static void twoSumUsingSet(int[] arr, int target){
        if(arr == null || arr.length < 2){
            System.out.println("No pair found");
            return;
        }

        Set<Integer> hSet = new HashSet<>();

        for(int currentNo : arr){
            if(hSet.contains(currentNo)){
                System.out.println("Pair: " + (target-currentNo) + " : " + currentNo);
            }else{
                hSet.add(target-currentNo);
            }
        }
    }
    static void twoSumWithoutSpace(int[] arr, int target){
        if(arr == null || arr.length < 2 ){
            System.out.println("No pair found");
            return;
        }

        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            if(arr[start] + arr[end] == target)
            {
                System.out.println("Pair : "+ arr[start] + " & " + arr[end]);

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

    public static void main(String[] args) {
        int[] v = new int[]{2, 1, 8, 4, 7, 3, 0, 8};
        twoSum(v, 8);
        twoSumUsingSet(v, 8);
        twoSumWithoutSpace(v, 9);
    }
}

