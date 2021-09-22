/**
[69] [Elements In array A but Not In Array B and Vice versa]
--------------------------------------------------------------------------------------------------------------
 PROBLEM STATEMENT:
 Return two arrays containing elements in A not in B and the elements in B but not A
 Example:
 Input: Two Lists e.g
 A = [1, 2, 2, 2, 3]     B = [2, 4,5 ]
 Output:
 All items in A not in B: A not B = [1, 2, 2, 3]
 All items in B not A: B not A = [4, 5]

 TIME COMPLEXITY:
 */
package PrepSetOne;

import java.util.HashMap;
import java.util.Map;

public class _Goo_69_Difference_Between_Two_SortedList {

    public static void findDiff(int[] arr1, int[]arr2){
        StringBuffer result1 = new StringBuffer();
        StringBuffer result2 = new StringBuffer();
        int i =0, j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                i++;
                j++;
            }
            else if(arr1[i] > arr2[j]){
                result2.append(", " + arr1[j]);
                j++;
            }else{
                result1.append(", " + arr1[i]);
                i++;
            }
        }
        // exhaust first
        while (i < arr1.length) {
            result1.append(", " + arr1[i++]);
        }
        // exhaust second
        while (j < arr2.length) {
            result2.append(", " + arr2[j++]);
        }
        System.out.println(" Elems in A not IN B " + result1);
        System.out.println(" Elems in B not IN A " + result2);
    }

    /**
     If Array list is not sorted then put every thing in HashMap with key and count,
     * for first array load map and for second array remove elements from map, while doing so:
     * 1. if elem not in map add to result 1 (elements in B not in A)
     * 2. what is left in map is elements in A not in B
     */
    public static void findDiffUsingMap(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        // update map with key and count for array 1
        for(int a : arr1){
            map.put(a, map.getOrDefault(a,0)+1);
        }
        // decrement map for keys in array 2
        for(int a : arr2){
            if(map.containsKey(a) && map.get(a)!=0){
                map.put(a, map.get(a)-1);
            }else{
                sb1.append(", "+a);
            }
        }
        for(Integer x : map.keySet()){
            int count = map.get(x);
            while(count--> 0) {
                sb2.append(", " + x);
            }
        }
        System.out.println(" Elems in A not IN B " + sb2);
        System.out.println(" Elems in B not IN A " + sb1);
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 2, 2, 3, 6, 7};
        int[] a2 = new int[]{2, 4, 5, 10, 12, 13, 14, 15};
        findDiff(a1, a2);
        findDiffUsingMap(a1, a2);
    }
}
