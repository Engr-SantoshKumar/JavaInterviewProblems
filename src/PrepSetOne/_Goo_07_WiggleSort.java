/** 07 [wiggle sort or wave sort]
-------------------------------------------------------------------------------------------------------
 *      Approach #1 (Sorting) + swap  ==> NlogN + N
 *      The obvious solution is to just sort the array first, then swap elements pair-wise starting
 *      from the second element. For example:
 *
 *      [1, 2, 3, 4, 5, 6]
 *          ↑  ↑  ↑  ↑
 *          swap  swap
 *
 *      Approach#2: (Best Approach)
 *      Runtime o(n)
 *      In this approach we will work on odd and even index
 *      IF even index (0,2,4,6...) --> IF (arr[i] > arr[i+1])  --> swap
 *      IF odd index (1,3,5,7....) --> IF (arr[i] < arr[i+1])  --> swap
 */
package PrepSetOne;
import java.util.Arrays;

public class _Goo_07_WiggleSort {

    // Approach 1:
    public static void wiggleSort(int [] arr){
        Arrays.sort(arr);
        for(int i =1; i<arr.length -1; i+=2){
            swap(arr, i, i+1);
        }
    }
    // Approach 2:
    public static void waveSort(int [] arr){
        for(int i =0; i<arr.length -1; i++){
            if (i % 2 == 0){
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }else{
                if(arr[i] < arr[i+1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 1, 6, 4};
        System.out.println("Before Wiggle Sort " + Arrays.toString(a));
        wiggleSort(a);
        System.out.println("After Wiggle Sort " + Arrays.toString(a));

        int[] b = {6, 1, 2, 5, 3, 4};
        System.out.println("Before Wiggle Sort " + Arrays.toString(b));
        waveSort(b);
        System.out.println("After Wiggle Sort " + Arrays.toString(b));
    }
}
