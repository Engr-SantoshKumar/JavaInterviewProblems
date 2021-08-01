/* [ _oA_54_ ] [ Largest Rectangular Area in a Histogram - Monotonic Stack problem]
_______________________________________________________________________________
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.

                        9            9
                      |---|       |---|
                    7 |   |       |   |
                6 |---|   | 6     |   |
              |---|   |   |---|   |   | 5
              |   |   |   |   |   |   |---| 4
            3 |   |   |   |   | 3 |   |   |---|
          |---|   |   |   |   |---|   |   |   |
          |   |   |   |   |   |   |   |   |   |
        __|___|___|___|___|___|___|___|___|___|___
     i ->   0   1   2   3   4   5   6   7   8

Above is a histogram where width of each bar is 1, given height = [3,6,7,9,6,3,9,5,4].
The largest rectangle is (length index 0 -> 8 (height 3), which has area = 9*3 = 27 unit.
the second largest rectangle (length index 1 -> 4) (height 6) , which has area = 4*6 = 24 unit.
https://www.youtube.com/watch?v=vcv3REtIvEo
*/
package _00_Problems_Sorted_By_Patterns;
import java.util.Stack;

public class _Monotone_Stack_04_Largest_Rectangular_Area_In_A_Histogram {
    public static int largestRectangleArea(int[] bars) {
        // one way to solve is create two array holding values leftSide Smaller and RightSide Smaller
        //https://youtu.be/vcv3REtIvEo?t=673
        //other way using one pass and calculating area on fly
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int cur =0; cur<bars.length; cur++){
            while(!stack.isEmpty() && bars[cur] < bars[stack.peek()]){
                //what we need to find area?? right height and left (we try to find value in this order)
                int right = cur-1; //boundary ends before cur
                int height = bars[stack.pop()];
                int left = stack.isEmpty()? 0 : stack.peek()+1;// boundary start after topOfStacks
                int length = right-left+1;
                int newArea = length*height;
                maxArea = Math.max(maxArea, newArea);
            }
            stack.push(cur);
        }
        //At this point there could be still some bars in stack which needs to process
        // e.g: [2,3,5,6] --> in this case cur incoming was never less than peek
        while(!stack.isEmpty()){
            int right = bars.length-1; //now for all remaining right boundary will be len-1;
            int height = bars[stack.pop()];
            int left = stack.isEmpty()? 0 : stack.peek()+1;// boundary start after topOfStacks
            int length = right-left+1;
            int newArea = length*height;
            maxArea = Math.max(maxArea, newArea);
        }
        return maxArea;
    }
    public static void main(String[] args)
    {
        int bars[] = new int[]{ 3,6,7,9,6,3,9,5,4};
        System.out.println("Maximum area is " + largestRectangleArea(bars));
    }
}
