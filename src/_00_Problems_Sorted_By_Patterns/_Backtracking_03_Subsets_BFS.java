/*[ _Backtracking_010 ] [ Subset, leetCode: 78 ]
_______________________________________________________________________________
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.*;

public class _Backtracking_03_Subsets_BFS {
    public static List<List<Integer>> subsetsBFS(int[] nums) {
        if (nums == null || nums.length <= 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(new ArrayList<Integer>()); // add the empty one to queue
        int i=0;
        Arrays.sort(nums);// required for duplicates
        while (i<nums.length) { // iterate through the size of array
            if(i>0 && nums[i]==nums[i-1]){ // skip duplicates
                i++;
                continue;
            }
            int levelSize = queue.size();
            while(levelSize --> 0) {
                List<Integer> curSet = queue.poll();
                //Logic is create two copy of current and push back one as is other with current index value
                List<Integer> firstCopy = curSet; //1st copy as is
                queue.offer(firstCopy); // --> push firstCopy asIs

                List<Integer> secondCopy = new ArrayList<>(); // 2nd copy + nums[i]
                secondCopy.addAll(curSet);
                secondCopy.add(nums[i]);
                queue.offer(secondCopy);
            }
            i++;
        }
        result.addAll(queue);
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        List<List<Integer>> resultList= subsetsBFS(nums);
        System.out.println(resultList);
    }
}
