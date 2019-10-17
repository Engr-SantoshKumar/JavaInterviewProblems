/**
[ Goo2 17 ] [ Find the next Biggest Element  ]
____________________________________________________________________________________________________________________
start with the first element of array Traverse the array and check each next element with the top of stack
If next element is greater than top value of stack then insert it into result.
and for next iteration push next element in stack.
 */
package GooPrep02;
import java.util.Arrays;
import java.util.Stack;
public class _Goo2_17_Next_Biggest_Element {

    public static void main (String args[]){
        int[] a = {4,6,3,2,8,1};
        //   nextGreaterElement(a);
        int[] b = {4,6,3,4,5,8,1};
        nextGreaterElement(b);
    }

    public static int[] nextGreaterElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        int result_index = 0;
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            if (!stack.isEmpty()) {
                int top = stack.pop();
                //System.out.println(String.format("top: %s, next: %s", top, next));
                while (top < next) {
                    result[result_index++] = next;
                    if (stack.isEmpty()) break;
                    top = stack.pop();
                }
                if (top > next) stack.push(top);
            }
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            stack.pop();
            result[result_index++] = -1;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

}