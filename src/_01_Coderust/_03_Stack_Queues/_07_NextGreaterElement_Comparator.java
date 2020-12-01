/*
In this problem, you have to implement int[] nextGreaterElement(int[] arr) method.
For each element in an array, it finds the next greater element in that array.

Note: The next greater element is the first element towards the right,
which is greater than the current element. For example, in the array [1, 3, 8, 4, 10, 5],
the next greater element of 3 is 8, and the next greater element for 8 is 10.
 To keep it simple, the next greater element for the last or maximum value in the array is -1

 */
package _01_Coderust._03_Stack_Queues;
import java.util.Arrays;
import java.util.Stack;

public class _07_NextGreaterElement_Comparator {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int resultIndex = 0;
        Stack<Integer> stack = new Stack<>();
        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                result[i] = -1;
            } else{
                result[i]  = stack.peek();
            }

            stack.push(arr[i]);
        }
        return result;
    }

    public static int[] nextGreaterElement4mRight(int[] arr){

        int size = arr.length;

        // Initialize the next greatest element
        int max_from_right =  arr[size-1];

        // The next greatest element for the rightmost
        // element is always -1
        arr[size-1] = -1;

        // Replace all other elements with the next greatest
        for (int i = size-2; i >= 0; i--)
        {
            // Store the current element (needed later for
            // updating the next greatest element)
            int temp = arr[i];

            // Replace current element with the next greatest
            arr[i] = max_from_right;

            // Update the greatest element, if needed
            if(max_from_right < temp)
                max_from_right = temp;
        }

        return arr;
    }

    public static void main(String[] arg){
        int[] arr = {4,6,3,2,8,1};

        System.out.println(Arrays.toString(nextGreaterElement(arr)));
        System.out.println(Arrays.toString(nextGreaterElement4mRight(arr)));

    }
}
