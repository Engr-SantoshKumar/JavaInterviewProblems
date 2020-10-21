/**
[ Apple_10 ] [ Product of Array Except Self ]
________________________________________________________________________________________________________________
 Note: Please solve it without division and in O(n).
 This solution iterates over the list and calculates the product of all the numbers to the right of each element.
 Then it appends the product of the product of all the elements to the right of the current element and the
 product of all the elements to the left of the current element. It then calculates the product of all the
 elements to the right by multiplying the current element with the ​left which gets updated.
 Time Complexity	O(n)
 Space Complexity	O(n)
 Auxiliary Space Used	O(1)
 */
package Apple_FB_Prep;

import java.util.Arrays;

public class _oA_10_Product_of_Array_Except_itSelf {
    static int[] productOfArray(int[] arr){
        int[] result = new int[arr.length];
        //we can solve this problem with the same concept of leftSumRightSum
        //Logic: move L -> R and fill result array with previously  visited values
        result[0] =1; // there are no elements to the left, so L[0] would be 1
        for(int i =1 ; i<arr.length; i++){
            result[i] = arr[i-1] * result[i-1];
        }
        // now R -> L : save the product in rightHandProduct and keep updating the result array
        int rightHandProduct =1;
        for(int i = arr.length-1; i>=0; i--){
            result[i] = result[i] * rightHandProduct;
            rightHandProduct *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productOfArray(arr)));
    }
}
