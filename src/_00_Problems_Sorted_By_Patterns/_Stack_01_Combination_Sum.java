/* [ _Stack_01_ ] [ Combination Sum ]
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
import java.util.Stack;

public class _Stack_01_Combination_Sum {

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
        indexStack.push(0);
        //basic idea is we will maintain list, element and index of element
        /*  e.g [2,3,6,7]
                fist time it will go to else part and add integers as < 7 by creating individual list stack will looks like
               Step1    Step 2
                [7] --> pop == target --> result
                [6] --> 6<7 --> 6+6 > 7 break
                [3] --> [3+3] push, [3+6]--> break .. pop 3+3+3 > 7 --> break
                [2] --> [2+2] push, [2+3] push, [2+6] > 7 break

                now stack has
                [2,3] --> 2+3+6 > 7 --> break
                [2,2] --> 2+2+3 push, 2+2+6 > 7 break

                finally pop [2,2,3] == target --> result
         */

        while (!resultStack.isEmpty()) {
            List<Integer> curList = resultStack.pop();
            int curSum = sumStack.pop();
            int curIndex = indexStack.pop();
            if (curSum == target){
                result.add(curList);
            }else{
                for (int i = curIndex; i < candidates.length; i++) {
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
        int[] arr = new int[] {2,3,6,7};
        int target = 7;
        System.out.println(combinationSumUsingStack(arr, target));
    }
}
