/* [ _Monotone_Stack_01_ ] [ _Monotone_Stack_01_Daily_Temperatures ]
_______________________________________________________________________________
Given a list of daily temperatures T, return a list such that, for each day in the input,
tells you how many days you would have to wait until a warmer temperature.
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
your output should be [1, 1, 4, 2, 1, 1, 0, 0].

*/
package _00_Problems_Sorted_By_Patterns;
import java.util.Arrays;
import java.util.Stack;

public class _Stack_Monotone_01_Daily_Temperatures {
    /*
        temperatures = {6,4,5,7}, the next greater element for 6 is 7.
        So we will return the index difference of the next
        greater element that is at index 0 --> 6 and at index 3-->7, so we will return 3 - 0 = 3 for 6 at index 0
         */
    public static int[] dailyTemperature(int[] temperature){
        Stack<Integer> stack = new Stack<>();
        // since we are handling indexes instead of the temperatures we
        // can directly store result in result array
        int[] result = new int[temperature.length];

        for(int curIndex =0; curIndex<temperature.length; curIndex++){
            /*logic: check if the temperature at curIndex is bigger than the top of the
            stack (index) temperature[stack.peek()] if yes than do the diff of index
            and so on in the while loop */
            while(!stack.isEmpty() && temperature[curIndex] > temperature[stack.peek()]){
                //curIdx - peek =>  anything between curIdx and Peek is smaller than cur
                result[stack.peek()] =  curIndex - stack.pop();
            }
            stack.push(curIndex);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperature(temperatures)));
    }

}
