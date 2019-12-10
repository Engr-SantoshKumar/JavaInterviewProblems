/**
 * [ _Goo2_26 ] [ Search in Rotated Sorted Array ]
 * _____________________________________________________________________________________________________________
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 Your algorithm's runtime complexity must be in the order of O(log n).
 Example 1:
 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4


 Complexity Analysis

 Time complexity : O(log(N)).
 Space complexity : O(1).
 */
package GooPrep02;
public class _Goo2_26_Search_In_Rotated_Sorted_Array {

    public static int search(int[] arr, int target){
    int start = 0, end = arr.length - 1;
    while (start < end) {
        int mid = (start + end) / 2;
        if (arr[mid] > arr[end]) {  // eg. 3,4,5,6,1,2
            if (target > arr[mid] || target <= arr[end]) {  // --->  OR
                start = mid + 1;
            } else {
                end = mid;
            }
        } else {                    // eg. 5,6,1,2,3,4
            if (target > arr[mid] && target <= arr[end]) {  // --> &&
                start = mid + 1;
            } else {
                end = mid;
            }
        }
    }
    if (start == end && target != arr[start]) return -1;
    return start;
}

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int[] arr1 = {9,8,7,6,5,4,3,2,1,0};
        int[] arr2 = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
        System.out.println(search(arr1, 0));
        System.out.println(search(arr2, 3));
    }
}

