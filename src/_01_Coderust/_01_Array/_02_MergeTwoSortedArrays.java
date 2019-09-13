package _01_Coderust._01_Array;

import java.util.Arrays;

public class _02_MergeTwoSortedArrays {


    // merge arr1 and arr2 into a new result array
    public static int[] mergeArrays(int[] arr1, int[] arr2) {

        int[] sortedArray = new int[arr1.length + arr2.length];

        int i = 0, j=0, k=0;

        while(i<arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j])
                sortedArray[k++] = arr1[i++];
            else
                sortedArray[k++] = arr2[j++];

        }

        while(i<arr1.length) {
            sortedArray[k++] = arr1[i++];
        }


        while(j < arr2.length)
            sortedArray[k++] = arr2[j++];

        return sortedArray;
    }


    public static void main(String[] args) {
        int[] a = {1,3,4,5};
        int[] b = {2,6,7,8};
        System.out.println(Arrays.toString(mergeArrays(a, b)));

    }

}
