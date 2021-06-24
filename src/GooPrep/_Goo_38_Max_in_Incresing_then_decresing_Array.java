/** [38]  Max in Increasing then decreasing Array
 -----------------------------------------------------------------------------------------------------------
 Maximum element in an array which is increasing and then decreasing In the given array elements are
 first increasing and then decreasing from there, we need to find the maximum element in the array.

 Method: 1 (Time complexity : O(n))
 Initialize maximum = INT_MIN.
 Traverse in the array and compare all the elements with maximum, if maximum < array[i] update maximum.
 After traversing the array completely, print maximum.

 Method:2 (Time complexity : O(logN)) solved below using binary search

 */

package GooPrep;
import java.util.Arrays;
public class _Goo_38_Max_in_Incresing_then_decresing_Array {

    public static void main (String[] args)
    {
        int arr[] = {1, 3, 50, 10, 9, 7, 6};
        int arr1[] = {2, 3, 4, 2, 2, 2, 2, 2, 2}; // binary recursion will not work on this
        int[] ar3= new int[]{1, 50, 50, 50, 50, 60};// binary recursion will not work on this
        int n = arr.length;
        System.out.println("The maximum element using recursion is :  "+ findMaximumRecursion(arr1, 0, n-1));
        System.out.println("The maximum element using normalWay is :  "+ findMaximumNormalWay(arr1));
        fMax(arr1);
    }
    static void fMax(int[] ar){
        int i = findMaximum(ar);
        if(i == -1){
            System.out.println(" max in array "+Arrays.toString(ar)+ " is not found");
        }else{
            System.out.println(" max in array "+Arrays.toString(ar)+ " is  "+ar[i]);
        }

    }
 //NOTE Recursion will not work for {2, 3, 4, 2, 2, 2, 2, 2, 2};
    public static int findMaximumRecursion(int[] arr, int low, int high) {

        /* Base Case: Only one element is present in arr[low..high]*/
        if (low == high) {
            return arr[low];
        }

        /*if two elements present, return maximum element */
        if ((high - 1 == low)) // just one index apart
        {
            if (arr[low] >= arr[high]) {
                return arr[low];
            } else {
                return arr[high];
            }
        }
        // Binary search
        int mid = (low + high) / 2;

        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) { //--> found the max
            return arr[mid];
        }
        //--> that means mid is in decreasing side of arr, mix will be left of it
        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
            return findMaximumRecursion(arr, low, mid - 1);
        } else {
            //--> that means mid is in increasing arr side, mix will be right side of it
            return findMaximumRecursion(arr, mid + 1, high);
        }
    }
    //NOTE Binary  will not work for {2, 3, 4, 2, 2, 2, 2, 2, 2};
    public static int findMaximum(int[]ar){

        int lo = 0; int hi = ar.length-1;
        int max = -1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(lo==hi){
                return lo;
            }
            if(hi-lo == 1){
                return ar[lo]>=ar[hi]?lo: hi;
            }
            System.out.println(" lo "+lo+" mid "+mid+" hi "+hi);

            //if mid is greater than left and right
            if(mid>0 && mid< ar.length-1 && ar[mid]>=ar[mid-1] && ar[mid]>ar[mid+1]){
                return mid;
            }
            if(ar[mid] < ar[lo]){
                hi = mid-1;
            }else{
                lo = mid+1; // since ar[mid]>ar[mid+1] was in the above condition
                // 50, 50 50, 60 then as per ar[mid]>ar[mid+1] mid is guranteed not the
                // biggest, so for for mid equal or greater lo mid>= lo always go
                // right is safe
            }
        }
        return -1;
    }

    public static int findMaximumNormalWay(int[]ar){
        int low = 0;
        int high = ar.length-1;

        int max = ar[high];
        int i;
        for (i = low; i < high; i++)
        {
            if (ar[i] > max)
                max = ar[i];
        }
        return max;
    }

}
