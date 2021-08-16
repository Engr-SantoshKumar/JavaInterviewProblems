/* [ _Stack_02_ ] [ Combination_Sum_II ]
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
import java.util.Stack;

public class _Stack_02_Combination_Sum_II {

    //same program solved using backtracking
    //_Backtracking_05_Combination_sum

    public static List<List<Integer>> combinationSumUsingStack(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //need three stacks to maintain elements, sum and index at each level
        Stack<ArrayList<Integer>> resultStack = new Stack<ArrayList<Integer>>();
        Stack<Integer> sumStack = new Stack<Integer>();
        Stack<Integer> indexStack = new Stack<Integer>();

        // load each with default value
        resultStack.push(new ArrayList<Integer>());
        sumStack.push(0);
        indexStack.push(-1); //put default -1 so that we start from 0
        while (!resultStack.isEmpty()) {
            List<Integer> curList = resultStack.pop();
            System.out.println(curList);
            int curSum = sumStack.pop();
            int curIndex = indexStack.pop();
            if (curSum == target){
                result.add(curList);
            }else{
                for (int i = curIndex+1; i < candidates.length; i++) { //--> this is main differance from last program
                    if(i>curIndex+1 && candidates[i] == candidates[i-1]) continue; //skip duplicates
                    int newSum = curSum + candidates[i];
                    if (newSum > target)
                        break;
                    ArrayList<Integer> updatedList = new ArrayList<Integer>(curList);
                    updatedList.add(candidates[i]);
                    resultStack.push(updatedList);
                    sumStack.push(newSum);
                    indexStack.push(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,4,5,6,7};
        int target = 7;
        System.out.println(combinationSumUsingStack(arr, target));
    }
}