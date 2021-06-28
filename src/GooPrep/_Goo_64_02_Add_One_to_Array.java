/**  64 [One Plus to array]
 ________________________________________________________________________________________________________________
 This problem is same like _Goo_59_One_Plus_One_Minus..only difference is its an array which
 makes it easier to work on
 Input: [1,2,3]  --> Output: [1,2,4]
 Input: [9, 9, 9]  --> Output: [1, 0, 0, 0]

 Explanation: The array represents the integer 123.
 */

package GooPrep;

import java.util.Arrays;

public class _Goo_64_02_Add_One_to_Array {

    public static void main(String args[]) {
        int[] ar = new int[]{8,8,9,9};
        System.out.println(Arrays.toString(plusOne(ar)));

    }

    // Here logic is: we will traverse from right to left and check we keep making current index 0
    // until we find a index which value is less than 9 ..if less than 9 increment its value and return

    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;//break nothing else to check
            }
            digits[i] = 0;
        }
        // when all digits are 9 9 9 .... just create a new array of n+1 size and place 1 at first place
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
