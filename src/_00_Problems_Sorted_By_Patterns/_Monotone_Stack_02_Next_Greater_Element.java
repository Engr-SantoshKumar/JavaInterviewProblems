/* [ _oA_53 ] [ Next Greater Element -  Monotonic Stack problem]
_______________________________________________________________________________
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _Monotone_Stack_02_Next_Greater_Element {
    public static int[] nextGraterToRight(int[] findNumbers, int[] numbers){
        /*Logic: We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek()
          we pop all elements less than x and for all the popped ones, their next greater element is x
          For example   [9, 8, 7, 5, 2, 1, 6]
          stack contain [9, 8, 7, 5, 2, 1] and
          then we see 6 which is greater than 1 so we pop 1 and then 2, 5 whose next greater element should be 6 */
        Stack<Integer> stack = new Stack<>();

        /* Now we will use map to track the grater element of the current one
         for e.g. above when we see 6 is grater of element 1 and same way for 2 and 5
         [Key: Val] --> [1:6] [2:6] [5:6] */
        Map<Integer, Integer> map = new HashMap<>();

        //create map with the above logic
        for(int curElement : numbers){
            while(!stack.isEmpty() && curElement > stack.peek()){
                map.put(stack.pop(), curElement); // this while loop will create entry [1:6] [2:6] [5:6]
            }
            stack.push(curElement);
        }
        //go through findNumber array and look for the value present in map
        for(int i =0; i < findNumbers.length; i++){
            findNumbers[i] = map.getOrDefault(findNumbers[i], -1);
        }
        return findNumbers;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{4,1,2};
        int[] num2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGraterToRight(num1, num2)));
    }
}
