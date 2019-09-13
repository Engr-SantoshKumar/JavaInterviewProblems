/** 41  [Find Start End Of Element In Sorted_Array]
 -----------------------------------------------------------------------------------------------------------
Given an array of integers sorted in ascending order, find the starting and
 ending position of a given target value.

 For example,
 Given [5, 7, 7, 8, 8,8, 10] and target value 8,
 return [3, 5]
 */
package GooPrep;
import java.util.Arrays;
public class _Goo_41_Find_Start_End_Of_Element_In_Sorted_Array {

    public static void main (String[] args) {

        int[] a = {0, 1, 1, 1, 3, 2, 4, 1, 4,4,4,4,4,4,4,4,4,4,4,4};
        Arrays.sort(a);
        System.out.println("Given Array : " + Arrays.toString(a));
        int key = 4;
        int currentPostion = findtheNumber(a, key);
        System.out.println("First Index : " + findLowerIndex(a,key, currentPostion));
        System.out.println("Last Index : " + findHigherIndex(a,key, currentPostion));

    }

    public static int findtheNumber(int[]arr, int k){
        int lo = 0;
        int hi = arr.length-1;
        int kPositio = 0;

        while(lo <=hi){
            int mid = (lo + hi)/2;

            if(arr[mid] == k) {
                kPositio = mid;
                break;
            }else if(arr[mid] < k){
                hi = arr[mid]-1;
            }else{
                lo = arr[mid]+1;
            }
        }
        return kPositio;
    }

    /* Case Lower: Search for key between 0 and currentPosiiton */

    public static int findLowerIndex(int[] arr, int key, int currentPosiiton ){
        int lo = 0;
        int hi = currentPosiiton;
        int currentLow = -1;

        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] > key){
                hi = mid - 1;
            }else if(arr[mid] < key){
                lo = mid  + 1;
            }else if (key == arr[mid]){
                currentLow = mid;
                hi = mid -1; // still need to search left side
            }
        }
        return  currentLow;
    }

    /* Case Higher: Search for key between currentPosiiton and end of arr */
    public static int findHigherIndex(int[] arr, int key, int currentPosiiton ){
        int lo = currentPosiiton;
        int hi = arr.length -1;
        int currentHigh = -1;

        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] > key){
                hi = mid - 1;
            }else if(arr[mid] < key){
                lo = mid  + 1;
            }else if (key == arr[mid]){
                currentHigh = mid;
                lo = mid +1; // still need to search right side
            }
        }
        return  currentHigh;
    }
}
