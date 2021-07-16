/* [ _FastAndSlowPointer_07_ ] [ happy Number ]
_______________________________________________________________________________

 Input: 19
 Output: true
 Explanation:
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1

----Logic: pure math+hashSet ------------------------------------------------------------------------
 1. curNum != 0 --e.g--> 19!=0 --> we need 1^2 + 9^2 so what we can do break it into 9 and 1
       e.g sum =0, x =19
           sum + = (19%10) * (19%10) => 9*9 => 81 (first digit of x is done i.e 9)
           now update the x = 19/10 ->1
           81 += (1%10) * (1%10) => 1 => 82

2. add in set if not present if present its cycle --> return false

-----Logic: pure math+hashSet ---------------------------------------------------------------------------
We saw in the LinkedList Cycle problem that we can use the Fast & Slow pointers method to find a cycle among
a set of elements. As we have described above, each number will definitely have a cycle.
Therefore, we will use the same fast & slow pointer strategy to find the cycle and once the cycle is found,
we will see if the cycle is stuck on number ‘1’ to find out if the number is happy or not.
-------------------------------------------------------------------------------------------------------
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashSet;
import java.util.Set;

public class _FastAndSlowPointer_07_Happy_Number {
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
        /*e.g sum =0, x =19
        sum + = (19%10) * (19%10) => 9*9 => 81 (first digit of x is done i.e 9)
        now update the x = 19/10 ->1
        81 += (1%10) * (1%10) => 1 => 82 */
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
