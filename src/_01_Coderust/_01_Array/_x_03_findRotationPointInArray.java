/*
* Rotation Point is nothing but finding the minimum element in shorted array
* this is also know as "Ternary search"
* https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
*
* */

package _01_Coderust._01_Array;
import java.util.*;
public class _x_03_findRotationPointInArray {

    static int findMinimum(Integer[] arr) {
        int low = 0;
        int high = arr.length - 1;
        // this loop will keep on going until it will find the lowest value
        while (arr[low] > arr[high]) {
            int mid = low+(high-low)/2;
            //System.out.println("Mid-index->"+mid+ "  MidValue->"+ arr[mid]);
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }




    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // must be in sorted order, allowing rotation, and contain no duplicates

        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr));
            int minIndex = findMinimum(arr);
            System.out.println(" Min is " + arr[minIndex] + " at " + minIndex);
            Collections.rotate(Arrays.asList(arr), 1);
        }


    }
}
