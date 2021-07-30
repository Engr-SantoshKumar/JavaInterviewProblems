/* [ _FastAndSlowPointer_08_  ] [ Circular Array Loop ]
_______________________________________________________________________________
We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a
particular index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move
backwards ‘M’ indices. You should assume that the array is circular which means two things:

If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.

Input: [1, 2, -1, 2, 2]
Output: true
Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0

Logic: any circular we can solve using set(to store the visited) or using tow pointer slow and fast(space O(1))

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.Map;

public class _FastAndSlowPointer_08_Circular_Array_Loop {
    public static boolean isCircularArray(int[] nums){
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        //https://www.youtube.com/watch?v=2hVinjU-5SA
        for(int start=0; start<n;start++){
            //check if already visited
            if(map.containsKey(start))
                continue;

            int curr = start;
            //Check if the current index is valid
            /*First Invalid case - If the current index value and start index value has opposite sign (nums[start] * nums[curr] <0)
              Second Invalid case - If value at current index is a multiple of n. This will result in a self loop (arr[curr]%n==0)
             */
            while(isValidCycle(start, curr, nums)){

                //marking current index visited and set value as start of loop
                map.put(curr,start);

                int jump = nums[curr]%n; //steps to jump;
                //Jumping x steps backwards is same as jumping (n-x) steps forward
                curr = (curr + jump +n )%n; //going to next index;

                //value already processed
                if(map.containsKey(curr)){

                    //If equal to start then we have found a loop
                    if(map.get(curr)==start){
                        return true;
                    }
                    //Else we can break since this has already been visited hence we will get the same result as before
                    break;
                }
            }
        }
        return false;
    }


    public static boolean isValidCycle(int start, int curr, int[] arr){

        if((arr[start]>0 && arr[curr]<0 )|| (arr[start]<0 && arr[curr]>0) || (arr[curr]%arr.length==0) ){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -1, 2, 2};
        System.out.println(isCircularArray(nums));
    }
}
