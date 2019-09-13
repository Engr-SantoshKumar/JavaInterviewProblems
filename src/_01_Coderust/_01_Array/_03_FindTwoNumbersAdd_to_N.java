package _01_Coderust._01_Array;

import java.util.Arrays;

public class _03_FindTwoNumbersAdd_to_N {

    public static int[] findSum(int[] arr, int value)

    {
        Arrays.sort(arr);

        int startPint = 0;
        int endPoint = arr.length-1;

        int[] result = new int[2];

        while(startPint != endPoint){
            if(arr[startPint]+arr[endPoint] < value )
                startPint ++;
            else if(arr[startPint]+arr[endPoint] > value)
                endPoint --;
            else {
                result[0] =arr[startPint];
                result[1] =arr[endPoint];
                return result;
            }
        }

        return arr;   // return the elements in the array whose sum is equal to the value passed as parameter 
    }

    public static void main(String[] args) {
        int[] a = {1,21,12,14,5,60,7,6};
        int b = 13;

        System.out.println(Arrays.toString(findSum(a, b)));

    }

}
