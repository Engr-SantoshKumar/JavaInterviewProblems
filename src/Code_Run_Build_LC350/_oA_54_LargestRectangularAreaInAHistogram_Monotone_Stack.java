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
*/
package Code_Run_Build_LC350;

import java.util.Stack;

public class _oA_54_LargestRectangularAreaInAHistogram_Monotone_Stack {
    public static int largestRectangleArea(int[] bars) {
        int maxArea =0;
        int curIndex;
        int topOfStackIndex;
        int areaWithTopOfStackIndex;
        Stack<Integer> stack = new Stack<>();

        for(curIndex=0; curIndex< bars.length;){
            // If this bar is higher than the bar on top stack, push it to stack
            if(stack.isEmpty() || bars[curIndex] > bars[stack.peek()]){
                stack.push(curIndex);
                curIndex ++; // move index only when we push to stack
            }
            // If this currentBar is lower than top of stack, then calculate area of rectangle to so that we need boundaries
            /*Right Boundary: at curIndex = 4, barSize 6, is the first bar that is lower than previous bars[3] ofHeight 9,
                              so the right boundary is (curIndex - 1).
            Height = pop(not peek) the top, here it will be bar[3]-->9; 9 is height
            Left Boundary: bars[2] ofHeight 7, which is the top in stack after bar[3]-->9 is popped, is the first
                            bar that is lower than bar[3] on its left, so the left boundary is (stack.peek() + 1).

            Now we have found both left and right boundaries, then let's get the width of the rectangle.
            The width = index of right boundary - index of left boundary + 1
                      = (curIndex - 1) - (stack.peek() + 1) + 1
                      = curIndex - stack.peek() - 1.          */

            else
                {
                    int height = bars[stack.pop()]; // height of top of stack
                    int rightBoundary = curIndex -1;
                    int leftBoundary =  stack.isEmpty()? 0 : stack.peek()+1;
                    int width = rightBoundary - leftBoundary + 1 ;

                    // Calculate the area with stack[top] stack as smallest bar
                    areaWithTopOfStackIndex = height*width;
                    maxArea = Math.max(maxArea, areaWithTopOfStackIndex);
                }
        }

        // Now pop the remaining bars from stack and calculate area with every popped bar in our example
        // bars[0] --> 3 is sitting there all the time
        while (!stack.empty())
        {
            int height = bars[stack.pop()]; // height of top of stack
            int rightBoundary = curIndex -1;
            int leftBoundary =  stack.isEmpty()? 0 : stack.peek()+1;
            int width = rightBoundary - leftBoundary + 1 ;

            // Calculate the area with stack[top] stack as smallest bar
            areaWithTopOfStackIndex = height*width;
            maxArea = Math.max(maxArea, areaWithTopOfStackIndex);
        }
        return maxArea;
    }
    public static void main(String[] args)
    {
        int bars[] = new int[]{ 3,6,7,9,6,3,9,5,4};
        System.out.println("Maximum area is " + largestRectangleArea(bars));
    }

}
