/**  67 [First Integer Greater Than 0 Not In Array]
 ____________________________________________________________________________________________________________________
 Given an int array A[], write a function to find the first integer that >0 and not in the A[],
 for example: [1,2,-3] return 3,
 [3,5,-1,1] return 2
 */

package GooPrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _Goo_67_First_Int_Grtr_Than_0_Not_In_Array {

    static int findFirstPositiveGrtThan0(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if(i>0) {
                set.add(i);
            }
        }
        int i = 1;
        while(set.contains(i)){
            i++;
        }
        return i;
    }

    static void testFor(int[] arr){
        System.out.print("\n input : "+Arrays.toString(arr));
        System.out.print(" output=> : "+findFirstPositiveGrtThan0(arr));
    }
    public static void main(String args[]){
        int[] ar  = new int[] {1,2,-3};
        int[] ar1 = new int[] {3, 5, -1, 1, -2};
        int[] ar2 = new int[] {1, 2, 3, 4};
        int[] ar3 = new int[] {-1, -2, -3, -4};
        testFor(ar);
        testFor(ar1);
        testFor(ar2);
        testFor(ar3);
    }
}
