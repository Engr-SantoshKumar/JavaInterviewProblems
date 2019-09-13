/** 12-b [Most Popular Number]
-------------------------------------------------------------------------------------------------------
Idea: the most popular Number will be grater than 1/4th of the total elements
So, if any element which is greater than 1/4th of the total count with fall either of these index (at: 1/4, 1/2, 3/4)
Soln: 1. Find the element for index (1/4, 1/2, 3/4)
      2. Find the 1st index of the above
      3. find the last index of the above
      4. get the count and if count > 1/4th; return
 */

package GooPrep;

import java.util.Arrays;
public class _Goo_12_b_MostPopularNumber {

    public static int mostPopularNumber(int[] arr ){

        int len = arr.length;
        int oneFourth = len/4;
        // Case 1: Checking the count for the element at 1/4
        if(findCounts(arr, len/4, len/4 ) >= oneFourth) return arr[len/4];
        else if(findCounts(arr, len/2, len/2) >= oneFourth) return arr[len/2];
        else if (findCounts(arr, (3*len)/4, (3*len)/4) >= oneFourth) return arr[(3*len)/4];
        return -1;
    }

    public static int findCounts(int[] arr, int x, int currentPosition){

        int leftIndex = findLowerIndex(arr, arr[x], currentPosition);
        int rightIndex = findHigherIndex(arr, arr[x], currentPosition);
        int count = rightIndex - leftIndex +1;
        return count;
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

        int[] a = {0, 1, 1, 1, 3, 2, 4, 1, 4,4,4,4,4,4,4,4,4,4,4,4};
        Arrays.sort(a);
        System.out.println("Given Array : " + Arrays.toString(a));
        System.out
                .println("\nPopular(number repeated <25% of array length) \n Number in the above array is: "
                        + mostPopularNumber(a));
    }
}
