/*
you have to implement the maxMin() function which will re-arrange the elements and in such a way that the first position
will have the largest number, the second will have the smallest, and the third will have second largest and so on.
 */

package _01_Coderust._01_Array;

import java.util.Arrays;

public class _08_RearrangeSortedArray_MaxMin_Form {

    public static int[] maxMin(int[] arr){

        int left=0;
        int right=arr.length-1;
        int[] minMaxArray = new int[arr.length];

        int i=0;

        while(left < right){
            minMaxArray[i++]= arr[right--];
            minMaxArray[i++]= arr[left++];
        }

        if(left == right)
            minMaxArray[i] = arr[left];

        return minMaxArray;

    }



    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};

        System.out.println(Arrays.toString(maxMin(a)));

    }

}
