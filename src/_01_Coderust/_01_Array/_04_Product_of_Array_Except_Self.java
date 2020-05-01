/*
This solution iterates over the list and calculates the product of all the numbers to the right of each element.
Then it appends the product of the product of all the elements to the right of the current element and the
product of all the elements to the left of the current element. It then calculates the product of all the
elements to the right by multiplying the current element with the ​left which gets updated.
Time Complexity	O(n)
Space Complexity	O(n)
Auxilary Space Used	O(1)
 */


package _01_Coderust._01_Array;

import java.util.Arrays;

public class _04_Product_of_Array_Except_Self {

    public static int[] findProduct(int[] arr){ 

        int len = arr.length;
        int[] resultArr = new int[len];

        resultArr[0]= 1;

         /* In this loop, temp variable contains product of elements on left side excluding arr[i] */

        for(int i=1; i < len; i++){
            resultArr[i] = arr[i-1] * resultArr[i-1];
        }


        int right =1;

        /* In this loop, temp variable contains product of elements on right side excluding arr[i] */

        for(int i = len-1; i>=0; i--){
            resultArr[i] = resultArr[i] * right;
            right = right * arr[i];
        }
        return resultArr;

    }


    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3};

        System.out.println(Arrays.toString(findProduct(a)));

    }

}
