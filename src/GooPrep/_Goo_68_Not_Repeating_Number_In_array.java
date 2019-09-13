/**  68 [Not Repeating Number In Array]
 ____________________________________________________________________________________________________________________
 Single Number
 Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 Input: {3,3,16,16,12,12,0,0,10}
 Output: 10

 Note:
 solution 1: we can solve using map and its count or set to add and remove(if its even, first time it will add
 and second it will remove)
 Q. Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 A: for this we need to use bit-manipulation
 known that A XOR A = 0 and the XOR operator is commutative.
 0 ^ N = N
 N ^ N = 0
 So..... if N is the single number
 N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
 = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
 = 0 ^ 0 ^ ..........^ 0 ^ N
 = N
 */

package GooPrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _Goo_68_Not_Repeating_Number_In_array {


    public static int singleNumberUsingSet(int arr[]){
        int result =0;
        Set<Integer> hs = new HashSet<>();

        for(Integer i : arr){
            //if the number already exist in the set, then delete the key
            if(hs.contains(i)){
                hs.remove(i);
            }// if the number does not exist in the set, then insert it
            else{
                hs.add(i);
            }
        }
        for(Integer i:hs){
            result=i;
        }
        return result;
    }

    //bit-manipulation : known that A XOR A = 0 and the XOR operator is commutative.

    public static int singleNumber(int A[]) {
        int result = 0;
        for (int i = 0; i<A.length; i++)
        {
            result ^=A[i];
        }
        return result;
    }

    static void testFor(int[] arr){
        System.out.print("\n input : "+Arrays.toString(arr));
        System.out.print(" output using set=> : "+singleNumberUsingSet(arr));
        System.out.print("\n input : "+Arrays.toString(arr));
        System.out.print(" output using bit=> : "+singleNumber(arr));
    }
    public static void main(String args[]){
        int[] ar  = new int[] {1,2,1,2,3};
        int[] ar1 = new int[] {1,2,3,4,1,2,3};

        testFor(ar);
        testFor(ar1);

    }


}
