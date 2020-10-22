/*
  [_oA_01] [ Trapping Rain Water]
  -----------------------------------------------------------------------------------------------------
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.

 Logic is same as leftSum RightSum _Goo_63_LeftSum_RightSum
 */
package Apple_FB_Prep;

public class _oA_01_Trapping_Rain_Water {

    public static int trapWater(int[] arr) {
        int result = 0;

        if(arr==null || arr.length<=2)
            return result;

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        //scan from left to right  --->
        left[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            left[i] = Math.max(arr[i], left[i-1]); //--> updating left array will maximum value till now
        } //[0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]

        //scan from right to left  <---
        right[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            right[i] = Math.max(arr[i], right[i+1]); //--> updating right array will maximum value till now
        } //[3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]

        //calculate total moving through arr
        for(int i=0; i<arr.length; i++){
            result+= Math.min(left[i],right[i])-arr[i];
        }
        return result;
    }

    public static int trapWaterOnePass(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftMax=0;
        int rightMax=0;

        while(a<=b){
            leftMax = Math.max(leftMax,A[a]);
            rightMax = Math.max(rightMax,A[b]);

            if(leftMax < rightMax){
                max += (leftMax-A[a]); // leftMax is smaller than rightMax, so the (leftMax-A[a]) water can be stored
                a++;
            }
            else{
                max += (rightMax-A[b]);
                b--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] towers = new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 };
        System.out.println(trapWater(towers));
        System.out.println(trapWaterOnePass(towers));

    }
}
