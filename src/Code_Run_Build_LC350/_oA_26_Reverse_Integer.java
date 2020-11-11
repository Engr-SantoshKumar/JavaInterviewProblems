/*
 [_oA_26_  ] [Reverse Integer]
____________________________________________________________________________________________________________________
 Given a 32-bit signed integer, reverse digits of an integer.
Example 1:
Input: x = 123
Output: 321

* Example 2:
Input: x = -123
Output: -321

 * */
package Code_Run_Build_LC350;
public class _oA_26_Reverse_Integer {
    public static int reverse(int number) {
        int sign = number < 0 ? -1 : 1;
        number = Math.abs(number);
        int result = 0;
        while(number > 0){
            int reminder = number % 10;
            int newResult = result*10 + reminder;
            //If overflow exists, the new result will not equal previous one.
            if((newResult-reminder)/10 != result){
                return 0;
            }
            result = newResult;
            number = number/10;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
