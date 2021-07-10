/* [ _Backtracking_010 ] [ Subset, leetCode: 78 ]
_______________________________________________________________________________
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

General approach to backtracking questions : Subsets, Permutations, Combination Sum, Palindrome Partitioning

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Backtracking_010_Subsets {
    //General approach to backtracking questions :
    // Subsets, Permutations, Combination Sum, Palindrome Partitioning
    public static List<List<Integer>> subsetsBacktracking(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private static void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start){
        // adding current value (tempList) to result
        resultList.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++){
            // add i into the current combination
            tempList.add(nums[i]);
            // use next integers to complete the combination
            backtrack(resultList, tempList, nums, i + 1);
            // backtrack
            tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> resultList= subsetsBacktracking(nums);
        System.out.println(resultList);
    }
}
