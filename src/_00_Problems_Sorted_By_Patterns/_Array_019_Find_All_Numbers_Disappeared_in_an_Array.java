/* [ _006_ ] [ Find All Numbers Disappeared in an Array ]
_______________________________________________________________________________
Given an integer array nums of length n where all the integers of nums are in the range [1, n]
and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Logic: use the same logic of circular sort

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.List;

public class _Array_019_Find_All_Numbers_Disappeared_in_an_Array {
    public static List<Integer> allMissingNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        int[] arr1 = {3,4,-1,1};
        List<Integer> res = allMissingNumbers(arr);
        System.out.println(res.toString());
    }
}
