/* [ _Monotone_Stack_02_ ] [ Continues_SubArray_For_Each_Index]
_______________________________________________________________________________
Contiguous SubArrays: You are given an array arr of N integers. For each index i, you are required to
determine the number of contiguous subArrays that fulfill the following conditions:
The value at index i must be the maximum element in the contiguous subArrays, and
These contiguous subArrays must either start from or end on index i.

arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]
Explanation:
For index 0 - [3] is the only contiguous subArray that starts (or ends) with 3, and the maximum value in this
subArray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]

Logic: we apply the logic of monotoneStack related problem - (daily temperature, biggest rectangle)
 you first push a 0 since index 0 is the only possible previous maximum. So, as you read
through the array forward, the stack is holding the indices of the following values:
E.g: [8,6,4,5,7,1,9,0]
i | stack   | values
0 | [0]     | [8]
1 | [0,1]   | [8,6]
2 | [0,1,2] | [8,6,4]
3 | [0,1,3] | [8,6,5] --> at this point stacks represents currentIndex and underIt is biggerThanCurIndex, so anything between is smaller
4 | [0,4]   | [8,7]   --> here any thing between 4(cur) and 0(underCur) is smaller than 4(cur)-> i.e value at index 3,2,1 are less
5 | [0,4,5] | [8,7,1]
6 | [6]     | [9]
7 | [6, 7]  | [9,1]

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;
import java.util.Stack;

public class _Stack_Monotone_06_Continues_SubArray_For_Each_Index {
    /*
    Maintain a stack such that it always contains the index for the last maximum encountered.
    If the next element is greater than the arr[stack.peek()] then pop the top of the stack till we find a equal or greater element.
    * If stack is empty then it means that the current element is the maximum of all and hence there are (current index + 1) possible arrays meeting the criteria.
    * If stack is not empty, then (current index - stack top) will be possible arrays for the index position
    Repeat the same steps from end of the array to get the final solution.
     */
    public static int[] countSubArrays(int[] arr) {
        int len = arr.length;

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        left[0] = 1; // default value 1 as there is nothing before it
        stack.push(0); //first index
        for (int curIdx = 1; curIdx < len; curIdx++) {
            //Monotone: stack will only have current and graterThanCur
            while (!stack.isEmpty() && arr[stack.peek()] < arr[curIdx]) {
                stack.pop();
            }
            // if anyTime when stack is empty (there is nothing > cur) leftSideSubArrayLessThanCur = curIdx+1
            if (stack.isEmpty()) {
                left[curIdx] = curIdx + 1;
            } else { //curIdx - peek => leftSideSubArrayLessThanCur anything between curIdx and Peek is smaller than cur
                left[curIdx] = curIdx - stack.peek();
            }
            stack.push(curIdx);//finally push the curIdx
        }
        int[] right = new int[len];
        //end value = leftSide value (as there is nothing rightOfLast(0) + leftValueAtEnd
        stack.clear();
        stack.push(len - 1);//start with last index
        // do same as above right --> left
        for (int curIndex = len - 2; curIndex >= 0; curIndex--) {
            //monotoneStack
            while (!stack.isEmpty() && arr[stack.peek()] < arr[curIndex]) stack.pop();

            // right array --> lengthOfArrayTowardsRightUntil > cur + leftArray value
            if (stack.isEmpty()) {
                right[curIndex] = (len - curIndex) + left[curIndex] - 1;
            } else {
                right[curIndex] = (stack.peek() - curIndex) + left[curIndex] - 1;
            }
            stack.push(curIndex);
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 6, 2};
        System.out.println(Arrays.toString(countSubArrays(arr)));
    }
}