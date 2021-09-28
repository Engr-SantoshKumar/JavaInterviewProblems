/* [ _004_ ] [ Missing Number ]
_______________________________________________________________________________
Given an array nums containing n distinct numbers in the range [0, n], return the only
number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Input: nums = [3,0,1]
Output: 2

Logic: one
Overflow issue with this approach: If n = Integer.MAX_VALUE it is possible that early on in the array,
e.g. arr[3] = Integer.MAX_VALUE, arr[4] = Integer.MAX_VALUE - 3.
If you subtract the index from those numbers and add them to to the sum it will overflow.

Logic: Two
Bit operation : 1 XOR 1 ---> 0
The basic idea is to use XOR operation. We all know that a^b^b =a,
which means two xor operations with the same number will eliminate the number and reveal the original number.
*/
package _00_Problems_Sorted_By_Patterns;
public class _Array_10_Missing_Number {
    public static int missingNumberSumApproach(int[] nums) {
        int len = nums.length;
        int sum = (len)*(len+1)/2; //sum of natural number is Sn = n(n+1)/2
        for(int i=0; i<len; i++)
            sum-=nums[i];
        return sum;
    }

    public static int missingNumberBitOperation(int[] nums){
        int missingNo = nums.length;

        for(int i=0; i<nums.length; i++){ //arr[0,3,2,4]
            missingNo ^= i; // --> 4^0^1^2^3^
            missingNo ^= nums[i];  // 0^3^2^4 ==> 4^0^1^2^3^0^3^2^4 ==> 1
        }
        return missingNo;

    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0,3,2,4};
        int[] arr2 = new int[]{0,1,3};
        int[] arr3 = new int[]{1,2,4,3,6,7,8, 0};

        System.out.println(missingNumberSumApproach(arr1));
        System.out.println(missingNumberSumApproach(arr2));
        System.out.println(missingNumberBitOperation(arr1));
        System.out.println(missingNumberBitOperation(arr2));
        System.out.println(missingNumberBitOperation(arr3));
    }
}

