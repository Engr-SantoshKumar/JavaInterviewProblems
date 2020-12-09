/* [ _oA_50_ ] [Next Permutation next bigger number ]
_______________________________________________________________________________
This problem is same as find the next grater number using the same digits
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order
(i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.
Input: nums = [1,2,3]
Output: [1,3,2]
Input: nums = [3,2,1]
Output: [1,2,3]
*/
package Code_Run_Build_LC350;

import java.util.Arrays;

public class _oA_50_Next_Permutation_Next_Bigger_Number {
    public static int[] nextPermutation(int[] nums) {
        //Step 1: find first number which breaks ascending order(from R-->L)
        // (e.g. 7 5 9 6 3 2) 5 breaks the descending order
        //         ^
        int i = nums.length-1;
        int end = nums.length-1;
        int k;
        while(i>0){
            if(nums[i -1] < nums[i]){
                break;
            }
            i--;
        }
        /* if i =0 that means its the largest number formed by the combination e.g 4 3 2 1 is the largest
         number can be formed using 1 2 3 4  */
        if(i==0){
            reverseSort(nums, 0, nums.length-1);
        }
        else{
            //Step 2: One we have the number from step 1,
            // Exchange this number with the least number that's greater than this number.
            // ( 7 5 9 6 3 2) ---> ( 7  6  9  5  3  2)
            //     ^   ^                ^ <-> ^
            for(k = end; k>i; k--){
                if(nums[k] > nums[i]) break;
            }
            swap(nums, i, k);
            //Step 3: Reverse sort the numbers after the exchanged number.
            // reverse sort (9  5  3  2) --> 2 3 5 9
            //o/p   7  6  2  3  5  9
            reverseSort(nums, i+1, end);
        }
        return nums;

    }
    public static void reverseSort(int[] num, int start, int end){
        while(start<end){
            swap(num,start++,end--);
        }
    }

    public static void swap(int[] num, int i, int j){
        int temp=0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {7, 5, 9, 6, 3, 2};
        int[] nums1 = new int[] {1,2,3};
        System.out.println(Arrays.toString(nextPermutation(nums)));
        System.out.println(Arrays.toString(nextPermutation(nums1)));

    }
}
