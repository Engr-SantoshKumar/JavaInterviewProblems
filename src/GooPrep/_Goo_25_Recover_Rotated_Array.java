/** 25  [Recover Rotated Array ]
 ---------------------------------------------------------------------------------------------------------
 * input --> {4, 5, 6, 7, 7, 1, 2, 3, 3};
 * outPut -->{1, 2, 3, 3, 4, 5, 6, 7, 7}
 *
 * Logic :
 * 1. find the smallest element in array i.e is rotation point
  Create array from (lowPoint -->to--> end) + (start -->to-->lowPoint)
 */

package GooPrep;

import java.util.Arrays;

public class _Goo_25_Recover_Rotated_Array {

    static void recoverRotatedArray(int[] arr){
        int smallestElementIndex = findRotationPoint(arr);
        rotateArray(0, smallestElementIndex-1, arr);
        rotateArray(smallestElementIndex, arr.length-1, arr);
        rotateArray(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }

    static int findRotationPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        // this loop will keep on going until it will find the lowest value
        while (arr[low] > arr[high]) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static void rotateArray(int loIndex, int hiIndex, int[] arr){
        while(loIndex < hiIndex){
            int temp = arr[loIndex];
            arr[loIndex] = arr[hiIndex];
            arr[hiIndex] = temp;
            loIndex ++;
            hiIndex --;
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{4, 5, 6, 7, 7, 1, 2, 3, 3};
        recoverRotatedArray(ar);
        int[] ar1 = new int[]{7, 8, 1, 2, 3, 3};
        recoverRotatedArray(ar1);
        int[] ar2 = new int[]{7, 6 , 5, 3, 1};
        recoverRotatedArray(ar2);
        int[] ar3 = new int[]{1, 7};
        recoverRotatedArray(ar3);

    }
}

