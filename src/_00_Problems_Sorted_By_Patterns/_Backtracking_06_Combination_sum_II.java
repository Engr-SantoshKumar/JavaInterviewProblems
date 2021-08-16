/* [  _Backtracking_06_] [ Combination_sum_II ]
_______________________________________________________________________________
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[1,1,6],
[1,2,5],
[1,7],
[2,6]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Backtracking_06_Combination_sum_II {
    //General approach to backtracking questions :
    // Subsets, Permutations, Combination Sum, Palindrome Partitioning
    public static List<List<Integer>> combinationSumBacktracking(int[] arr, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(resultList, new ArrayList<>(), arr, 0, target);
        return resultList;
    }
    // Stack solution of this problem _Stack_01_Combination_Sum
    private static void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] arr, int start, int target){
        // adding current value (tempList) to result
        if(target ==0){
            resultList.add(new ArrayList<>(tempList));
        }
        if(target < 0) return;

        for(int i = start; i < arr.length; i++){
            // add i into the current combination
            tempList.add(arr[i]);
            // not i + 1 because we can reuse same elements
            backtrack(resultList, tempList, arr, i+1, target-arr[i]); //only change here from other backTracking
            // backtrack: remove the last added element
            tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {2,3,4,5,6,7};
        int target = 7;
        List<List<Integer>> resultList= combinationSumBacktracking(arr, target);
        System.out.println(resultList);
    }
}
