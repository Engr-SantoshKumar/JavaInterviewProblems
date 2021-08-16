/* [ _Stack_03_ ] [ permutations array]
_______________________________________________________________________________
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.

nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _Stack_03_Permutation_Of_Numbers {
    //same program solved using backtracking
    //_Backtracking_04_Permutations_Of_Numbers

    public static List<List<Integer>> combinationSumUsingStack(int[] candidates) {

        List<List<Integer>> result = new ArrayList<>();
        //need three stacks to maintain elements, sum and index at each level
        Stack<List<Integer>> resultStack = new Stack<>();

        // load each with default value
        resultStack.push(new ArrayList<Integer>());
        //construction
        while (!resultStack.isEmpty()) {
            List<Integer> curList = resultStack.pop();
            if (curList.size() == candidates.length){
                result.add(curList);
            }else{
                for (int i = 0; i < candidates.length; i++) {
                    if(curList.contains(candidates[i])) continue; //skip already used
                    List<Integer> updatedList = new ArrayList<Integer>(curList);
                    updatedList.add(candidates[i]);
                    resultStack.push(updatedList);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        System.out.println(combinationSumUsingStack(arr));
    }
}
