package _01_Coderust._01_Array;

import java.util.Arrays;

public class _01_RemoveEvenNums {

    public static int[] removeEven(int[] arr){

        int oddCount =0;
        for (int i =0; i < arr.length; i++){
            if (arr[i]%2 != 0)
                oddCount++;
        }
        int k=0;
        int[] oddNums = new int[oddCount];
        for (int i =0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                oddNums[k++] = arr[i];
        }

        return oddNums;
    }


    public static void main(String[] args) {
        int[] a = {1,2,4,5,10,6,3};
        System.out.println(Arrays.toString(removeEven(a)));

    }
}
