/**  59 [One Plus One Minus to Given No]
 ____________________________________________________________________________________________________________________
Given a number (positive or negative), e.g., 95, as an array ['9','5']
 increment it: change it to ['9','6']. The input array can be arbitrarily large.

 // char to integer c-'0'
 // integer to char c+'0'
 char t = '9';
 print t -->o/p--> 9
 int i = t;
 print i -->o/p--> 57 [ascii value][when directly assign char to int]
 int k = t-'0';
 print k -->o/p---> 9

 examples:
 input:   char[] [‘9’, ‘5’]
 output:  char[] [‘9’, ‘6’]

 input:   char[] [‘-’, ‘9’, ‘5’]
 output:  char[] [‘-’, ‘9’, ‘4’]
  */

package GooPrep;
import java.util.Arrays;

public class _Goo_59_One_Plus_One_Minus_StringInteger {
    public static void plusOne(char[] ch) {

        char[] result = new char[ch.length + 1];
        int addToCur = 1;
        int i = ch.length-1;
        while(i>=0){
            int a = ch[i] - '0'; //get the last cha & convert to int value

            int newDigit = a+addToCur;

            int newDigitAtIndexI = newDigit%10; // --> 12%10 = 2, 8%10 = 8
            int carryOver = newDigit/10; // --> 12/10 = 1, 8/10 = 0

            addToCur = carryOver;
            result[i+1] = (char)(newDigitAtIndexI +'0');
            i--;
        }
        result[0] = (char)(addToCur + '0');
        System.out.println(Arrays.toString(result));
    }

    public static void minusOne(char[] ch) {
        char[] result = new char[ch.length];
        int minusToChar = 1;
        int i = ch.length-1;

        while(i>=0){
            int a = ch[i] -'0'; //get the last cha & convert to int value
            int newDigit = a-minusToChar;
            if(newDigit==-1){
                result[i] = 9 +'0';
                minusToChar = 1;
                i--;
            }else{
                result[i] = (char)(newDigit+'0');
                minusToChar =0;
                i--;
            }
        }
        if(minusToChar!=0){
            System.out.println("[-1]");

        }else {
            System.out.println(Arrays.toString(result));
        }
    }

    public static void main(String args[]) {
        char[] ch = new char[]{'1', '9', '3', '9'};
        //plusOne(ch);
        plusOne(new char[]{'9', '9'});
        minusOne(new char[]{'1', '0'});
        minusOne(new char[]{'4', '3'});
        minusOne(new char[]{'0', '0'});
        minusOne(new char[]{'2', '0'});
    }
}
