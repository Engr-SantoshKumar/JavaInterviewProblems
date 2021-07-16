/*
[ _oA_03 ] [ Write an algorithm to determine if a number n is "happy". ]
______________________________________________________________________________________________________________
 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy numbers.

 Return True if n is a happy number, and False if not.
 Example:
 Input: 19
 Output: true
 Explanation:
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
*/
package Code_Run_Build_LC350;

import java.util.HashSet;
import java.util.Set;

public class _oA_03_Happy_Number {
    static boolean IsHappyNumber(int x){
        if(x<10 && x!=1 ) return false;
        Set<Integer> hSet = new HashSet<>();
        while(x!=1){
            int currentNum = x;
            int sum = 0;
            while(currentNum!=0){
                sum += (currentNum % 10) * (currentNum % 10); // 82 % 10 --> 2
                currentNum = currentNum/10;                   // 82 / 10 --> 8
            }
            if(hSet.contains(sum)) return false;
            hSet.add(sum);
            x=sum;
        }
        return true;
    }


    //without using extra space : logic used circular linked list
    static boolean IsHappyNumberWithOutSpace(int num){
        if(num<10 && num!=1 ) return false;
        int slow = num; int fast = HelperSquareSumMethod(num);

        while(slow!=1 && slow!=fast){
            slow = HelperSquareSumMethod(slow);
            fast = HelperSquareSumMethod(fast);
            fast = HelperSquareSumMethod(fast);
        }
        return slow==1;
    }
    static public int HelperSquareSumMethod(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        //System.out.println(IsHappyNumberWithOutSpace(19));
        for(int i =1; i<20 ; i++){
            System.out.println(IsHappyNumber(19));
            System.out.println(IsHappyNumberWithOutSpace(i));
            System.out.println("-------------");
        }

    }
}
