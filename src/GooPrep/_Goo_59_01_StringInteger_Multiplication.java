/**
[64-01] [String Integer Multiplication]
--------------------------------------------------------------------------------------------------------------
PROBLEM STATEMENT:
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
also represented as a string.
 Input: num1 = "123", num2 = "456"
 Output: "56088"
----------------------------
 If we break it into steps, it will have the following steps.
 1. compute products from each pair of digits from num1 and num2.
 2. carry each element over.
 3. output the solution.

 Things to note:
 The product of two numbers cannot exceed the sum of the two lengths. (e.g. 99 * 99 cannot be five digit)
 int d1 = num1.charAt(i) - '0';
 int d2 = num2.charAt(j) - '0';
 products[i + j + 1] += d1 * d2;

 */
package GooPrep;

import java.util.Arrays;

public class _Goo_59_01_StringInteger_Multiplication {
    public static String multiply(String s1, String s2) {

        int[] result = new int[s1.length() + s2.length()]; // maximum can be

       /*compute products from each pair of digits from num1 and num2*/
        for(int i=s1.length()-1; i>=0; i--){
            for(int j=s2.length()-1; j>=0; j--){
                int x1 = s1.charAt(i) - '0';
                int x2 = s2.charAt(j) - '0';
                result[i+j+1] += x1*x2;
            }
        }
        System.out.println(Arrays.toString(result));
        // result --> [0, 4, 13, 28, 27, 18]

        /*carry each element over.*/
        int carry =0;
        for(int i = result.length-1; i>=0; i--){
            int temp = (result[i]+carry) % 10; //18 % 10 --> 8
            carry = (result[i]+carry) / 10;
            result[i] = temp;
        }// result --> [0, 5, 6, 0, 8, 8]

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;

        // keep moving i until arr value is non zero
        while(i < result.length && result[i] == 0) i++;
        if(i >= result.length) return "0"; //if every element is zero in the result array

        //create a string from actual result (00000123)-->(123)
        for(int j = i; j < result.length; j++) {
            stringBuilder.append(result[j]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
