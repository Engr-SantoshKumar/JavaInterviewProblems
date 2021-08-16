/* [ _Backtracking_05_ ] [ Combination Sum ]
_______________________________________________________________________________
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
*/
package _00_Problems_Sorted_By_Patterns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Backtracking_05_Combination_sum {

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
            backtrack(resultList, tempList, arr, i, target-arr[i]); //only change here from other backTracking
            // backtrack: remove the last added element
            tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {2,3,4,6,7};
        int target = 7;
        List<List<Integer>> resultList= combinationSumBacktracking(arr, target);
        System.out.println(resultList);
    }
}
