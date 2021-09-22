/** 41  [Find Start End Of Element In Sorted_Array]
 -----------------------------------------------------------------------------------------------------------
Given an array of integers sorted in ascending order, find the starting and
 ending position of a given target value.

 For example,
 Given [5, 7, 7, 8, 8,8, 10] and target value 8,
 return [3, 5]
 */
package PrepSetOne;
import java.util.Arrays;
public class _Goo_41_Find_Start_End_Of_Element_In_Sorted_Array {

    public static int findTheNumber(int[]arr, int k){
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

    /* Case Lower: Search for key between 0 and currentPosition */

    public static int findLowerIndex(int[] arr, int key, int currentPosition ){
        int lo = 0;
        int hi = currentPosition;
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

    /* Case Higher: Search for key between currentPosition and end of arr */
    public static int findHigherIndex(int[] arr, int key, int currentPosition ){
        int lo = currentPosition;
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

    public static void main (String[] args) {

        int[] arr = {0, 1, 1, 1, 2, 3, 4, 4,4,4,4,4,4,4,4,4,4,4,4};
        Arrays.sort(arr);
        System.out.println("Given Array : " + Arrays.toString(arr));
        int key = 4;
        int currentPosition = findTheNumber(arr, key);
        System.out.println("First Index : " + findLowerIndex(arr,key, currentPosition));
        System.out.println("Last Index : " + findHigherIndex(arr,key, currentPosition));

    }
}
