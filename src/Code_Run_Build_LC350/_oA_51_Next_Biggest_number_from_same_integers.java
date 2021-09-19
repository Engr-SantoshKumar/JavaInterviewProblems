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
        char[] arr = (n + "").toCharArray();
        
        /* I) Start from the right most digit and  find the first digit that
         is smaller than the digit next to it (which breaks ascending order) */
        int i, j;
        for (i = arr.length-1; i > 0; i--)
            if (arr[i-1] < arr[i]){
                break;
            }
            

        // If no such digit is found, its the edge case 1.
        if (i == 0)
            return -1;

        /*II) Find the smallest digit on right side of (i-1)'th digit that is greater than number[i-1] */
        int smallest = arr[i-1];

        for( j = arr.length-1; j>i; j--){
            if(arr[j] > smallest) break;
        }
        
        /* III) Swap the above found smallest digit with number[i-1] */
        char temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        /* IV) Sort the digits after (i-1) in ascending order */
        //Arrays.sort(number, i, number.length); //nLog(n)
        reverse(arr, i, arr.length-1); //O(n)
        
        long val = Long.parseLong(new String(arr));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
    
    private static void reverse(char[] arr, int s, int e) {
        while(s < e){
            char temp = arr[s];
            arr[s] =arr[e];
            arr[e] = temp;
            s++; e--;
        }
    }

    public static void main(String[] args) {
        int i = 5349763;
        System.out.println(nextBiggerNumber(i));
        System.out.println(nextBiggerNumber(1234));
        System.out.println(nextBiggerNumber(10010));
    }

}
