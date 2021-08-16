/**
 [74] [Largest Subset in Sequence]
 --------------------------------------------------------------------------------------------------------------
PROBLEM STATEMENT:
 Given an array of numbers not in any sorted order, find the largest sub-array of numbers that
 are in a sequence in ascending order.
 e.g:  3,27,4,5,6,7,12,17,9,22,23,68.
 Answer is 4,5,6,7
 */
package GooPrep;

import java.util.Arrays;

public class _Goo_74_Largest_Subset_In_Sequence {


    public static int[] longestSequenceSubSetUsingTwoPointer(int[] num){
        if (num == null || num.length == 0) {
            return null;
        }
        if (num.length == 1) {
            return num;
        }
        int start = 0;
        int end = 1;
        int[] resultIndex = {start, end};
        int maxSizeTillNow = end-start;

        for (end = 1; end < num.length; end++) {

            //dup case (1, 1, 2, 2, 2)
            if (num[end - 1] == num[end]) {
                continue;

            } else if (num[end - 1] + 1 == num[end]) {
                continue;

            } else {
                int currentSize = end-start;
                if(maxSizeTillNow < currentSize) {
                    resultIndex[0] = start;
                    resultIndex[1] = end;
                    maxSizeTillNow = currentSize;
                }
                // move start counter to end
                start =end;
            }
        }
        // to catch the set if that set is longest and contains last integer
        int currentSize = end-start;
        if(maxSizeTillNow < currentSize) {
            resultIndex[0] = start;
            resultIndex[1] = end;
        }

        int startL = resultIndex[0];
        int endL = resultIndex[1];

        int[] resultArray = new int[ endL - startL ];
        int t =0;
        for(int k = startL; k<endL; k++){
            resultArray[t] = num[k];
            t++;
        }
        System.out.println(Arrays.toString(resultArray));

        return resultIndex;
    }

    //==============================================================================================

    public static int[] longestSequenceSubSet(int[] num){
        if (num == null || num.length == 0) {
            return null;
        }
        if (num.length == 1) {
            return num;
        }
        int i = 1;
        int j = 1;

        int[] result = new int[num.length];
        for (int k = 1; k < num.length; k++) {

            if (num[k - 1] == num[k]) {//dup case (1, 1, 2, 2, 2)
                continue;
            } else if (num[k - 1] + 1 == num[k]) {
                j++;

            } else {

                if(j>i) {
                    result = createSubArray(num, j, k);
                }
                i = Math.max(j, i);
                j = 1;
            }
        }
        return result;
    }

    public static int[] createSubArray(int[] num, int size, int currentPosition){

        int[] result = new int[size];
        int startPoint = currentPosition - size;
        for(int i = 0; i<size; i++){
            result[i] = num[startPoint];
            startPoint++;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }





    public static void main(String[] args) {
        int[] arr = {3,27,4,4, 4,5,5,5,6,7,12,17};
        //int[] arr = {1,2,3,4,5,7,8,9,10,11,12,13, 14, 16,17};
        System.out.println(Arrays.toString(longestSequenceSubSet(arr)));
        //longestSequenceSubSetUsingTwoPointer(arr);


    }

}
