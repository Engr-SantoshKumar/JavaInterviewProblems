/* [ _Backtracking_04_ ] [ permutations array]
_______________________________________________________________________________
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.

nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.*;
import java.util.LinkedList;

public class _Backtracking_04_Permutations_Of_Numbers {

    public static List<List<Integer>> permuteIterative(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(new ArrayList<>());
        for (int curInt : array) {
            //we will take all the existing permutations and add the current digit
            int curBatchSize = queue.size();
            while(curBatchSize --> 0){
                List<Integer> curPermutation = queue.poll();
                //creating a new permutation by adding the current digit at every position of existing
                for (int position = 0; position <= curPermutation.size(); position++) {
                    List<Integer> temp = new LinkedList<>();//new list
                    temp.addAll(curPermutation);// add current
                    temp.add(position, curInt); // (j,curInt) --> (atIndex j , add curInt)
                    queue.add(temp);

                    if (temp.size() == array.length) {
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> permuteRecursive(int[] array) {
            // init result list
            List<List<Integer>> result = new LinkedList<>();

            // convert array into list since the result is a list of lists
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (int i : array){
                arrayList.add(i);
            }
            int length = array.length;
            backtrack(length, arrayList, result, 0);
            return result;
    }
    public static void backtrack(int length, ArrayList<Integer> array, List<List<Integer>> output, int curIndex) {
        // if all integers are used up
        if (curIndex == length)
            output.add(new ArrayList<Integer>(array));
        for (int i = curIndex; i < length; i++) {
            // place i-th integer curIndex
            // in the current permutation
            Collections.swap(array, curIndex, i);
            // use next integers to complete the permutations
            backtrack(length, array, output, curIndex + 1);
            // backtrack
            Collections.swap(array, curIndex, i);
        }
    }



    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,};
        System.out.println(permuteIterative(array));
        System.out.println(permuteRecursive(array));
    }

}
