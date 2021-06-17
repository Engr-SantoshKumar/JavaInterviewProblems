/* [ oA_51 ] [ Next Biggest number from same integers  ]
_______________________________________________________________________________
Given a positive integer n, find the smallest integer which has exactly the same
digits existing in the integer n and is greater in value than n.
If no such positive integer exists, return -1.
i/p 5349763
o.p 5363467
this problem is same as _oA_50_Next_Permutation_Next_Bigger_Number
the only differance is you need to convert given number to int[] or char[]
*/
package Code_Run_Build_LC350;

import java.util.Arrays;

public class _oA_51_Next_Biggest_number_from_same_integers {
    public static int nextBiggerNumber(int n){
        char[] number = (n + "").toCharArray();

        int i, j;
        /* I) Start from the right most digit and  find the first digit that
         is smaller than the digit next to it (which breaks ascending order) */
        for (i = number.length-1; i > 0; i--)
            if (number[i-1] < number[i])
                break;

        // If no such digit is found, its the edge case 1.
        if (i == 0)
            return -1;

        /*II) Find the smallest digit on right side of (i-1)'th
         digit that is greater than number[i-1] ..We know that numbers left of i is in decreasing order
         so, if we travel from L--> R[until i+1] and look for the very first number grater than number[i-1] */
        int smallest = number[i-1];
        for( j = number.length-1; j>i; j--){
            if(number[j] > smallest) break;
        }
        /* III) Swap the above found smallest digit with number[i-1] */
        char temp = number[i-1];
        number[i-1] = number[j];
        number[i] = temp;

        /* IV) Sort the digits after (i-1) in ascending order */
        Arrays.sort(number, i, number.length);
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

    public static void main(String[] args) {
        int i = 5349763;
        System.out.println(nextBiggerNumber(i));
    }

}
