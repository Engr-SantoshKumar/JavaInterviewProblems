/* [ _oA_55_ ] [ Trapping Rain Water Monotone Stack ]
_______________________________________________________________________________
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.
                        7
                      |---|         6
                    5 |   | 5     |---|
                  |---|   |---|   |   |
            3     |   |   |   | 3 |   |
          |---|   |   |   |   |---|   |     2
          |   |   |   |   |   |   |   |   |---|
        __|___|___|___|___|___|___|___|___|___|___
     i ->   0   1   2   3   4   5   6   7   8
total water trapped = 3 unit above 1 + 1 unit above 4 + 3 unit above 5 + 2 unit above 7 = 9 units
Logic: we will use the concept of Monotone Stack same as in last few problems


*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Stack;

public class _Monotone_Stack_03_Trapping_The_RainWater_Monotone_Stack {

    public static int rainWater(int[] bars) {
    int totalWater = 0;
    Stack<Integer> stack = new Stack<>();
    // since we are handling indexes instead of the temperatures we can directly store result in result array
    for (int curIndex = 0; curIndex < bars.length; curIndex++) {
        //logic: check if the barHeight at curIndex is bigger than the top of the
        // stack index bratHeight [stack.peek()]
        while (!stack.isEmpty() && bars[curIndex] > bars[stack.peek()]) {
            int curBarHeight = bars[stack.pop()]; // height of top of stack
            if (!stack.isEmpty()) {
                int rightHeight = bars[curIndex];
                int leftHeight = bars[stack.peek()];
                int minHeight = Math.min(rightHeight, leftHeight);
                totalWater += (minHeight - curBarHeight) * (curIndex - stack.peek() - 1);
            }
        }
        stack.push(curIndex);
    }
    return totalWater;
}

    public static void main(String[] args) {
        //int[] bars = new int[]{3, 0, 5, 7, 5, 3, 6, 0, 2};
        int[] bars = new int[]{3, 0, 5};
        System.out.println(rainWater(bars));
    }
}
