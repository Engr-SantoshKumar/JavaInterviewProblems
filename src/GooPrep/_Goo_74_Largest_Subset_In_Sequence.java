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

    public static int[] longestSequenceSubSet(int[] num){
        if (num == null || num.length == 0) {
            return null;
        }
        if (num.length == 1) {
            return num;
        }
        int count = 1;
        int max = 1;
        int[] result = new int[num.length];
        for (int i = 1; i < num.length; i++) {

            if (num[i - 1] == num[i]) {//dup case (1, 1, 2, 2, 2)
                continue;
            } else if (num[i - 1] + 1 == num[i]) {
                count++;

            } else {

                if(count>max) {
                    result = createSubArray(num, count, i);
                }
                max = Math.max(count, max);
                count = 1;
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


    public static int[] longestSequenceSubSetUsingTwoPointer(int[] num){
        if (num == null || num.length == 0) {
            return null;
        }
        if (num.length == 1) {
            return num;
        }
        int j = 0;
        int i = 1;
        int[] result = new int[]{j, i};
        int globSize = i-j;
        for (i = 1; i < num.length; i++) {

            //dup case (1, 1, 2, 2, 2)
            if (num[i - 1] == num[i]) {
                j=i;// if we are not considering repeated integer
                continue;

            } else if (num[i - 1] + 1 == num[i]) {
                continue;

            } else {
                int currentSize = i-j;
                if(globSize < currentSize) {
                    result[0] = j;
                    result[1] = i;
                    globSize = currentSize;

                }
                j =i;

            }
        }
        int start = result[0];
        int end = result[1];
        int[] resultArray = new int[ end - start ];
        int t =0;
        for(int k = start; k<end; k++){
            resultArray[t] = num[k];
            t++;
        }
        System.out.println(Arrays.toString(resultArray));

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {3,27,4,5,6,7,12,17,9,22,23,68};
        System.out.println(Arrays.toString(longestSequenceSubSet(arr)));
        longestSequenceSubSetUsingTwoPointer(arr);

    }

}
