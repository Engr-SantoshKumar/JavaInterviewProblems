package _01_Coderust._03_Stack_Queues;
import java.util.Arrays;
import java.util.Stack;

public class _07_NextGreaterElement_Comparator {

    public static int[] nextGreaterElement(int[] arr){

        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[arr.length];
        int result_index = 0;

        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            if (!stack.isEmpty()) {
                int top = stack.pop();
                System.out.println(top);

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
        int[] arr = {16, 17, 18, 4, 3, 5, 2};

        System.out.println(Arrays.toString(nextGreaterElement(arr)));
        System.out.println(Arrays.toString(nextGreaterElement4mRight(arr)));

    }
}
