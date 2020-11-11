/*
 * [_oA_29_  ] [ Container With Most Water ]
 * _______________________________________________________________________________________________________________
 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

* Area between 8-------7
* this problem looks similar to _oA_01_Trapping_Rain_Water, difference is we are not calculating water between each
* vertical line but between which two vertical line we can store max water (e.g between 8---7) its just vertical line
* not the buildings where we store the water on top, its just two pointer L and R and Length game
 * */
package Code_Run_Build_LC350;
public class _oA_29_Container_With_Most_Water {

    public static int maxArea(int[] height) {
        //base cases
        if(height.length < 2) return 0;

        //Logic:
        // get the minimum of left and Right vertical line
        // multiply minimum to current calculate length i.e R-L
        // then move the smaller index of smaller vertical
        int maxArea =0, L=0, R= height.length-1;
        while(L<R){
            maxArea = Math.max(maxArea, Math.min(height[L],height[R])*(R-L));
            if(height[L] < height[R])
                L++;
            else
                R--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        int[] heights1 = new int[]{1,8,20,2,5,20,8,3,7};
        System.out.println(maxArea(heights));
        System.out.println(maxArea(heights1));
    }
}
