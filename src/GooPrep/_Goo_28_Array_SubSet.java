/** 28  [Array Subset]
 ---------------------------------------------------------------------------------------------------------
 "Given two array of integers, write a function which returns true or false if
    second array is subset of first array.
 "
 */
package GooPrep;

import java.util.HashSet;

public class _Goo_28_Array_SubSet{

    static boolean isSubset(int[] arr1, int[] arr2) {
        HashSet<Integer> hset = new HashSet<>();

        // hset stores all the values of arr1
        for (int i = 0; i < arr1.length; i++) {
            if (!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        }

        // loop to check if all elements of arr2 also
        // lies in arr1
        for (int i = 0; i < arr2.length; i++) {
            if (!hset.contains(arr2[i]))
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        int[] arr1 = new int[]{1, 2, 3, 4, 6};
        int[] arr2 = new int[]{3, 4, 5};
        System.out.println(isSubset(arr1, arr2));

    }

}
