/* [ _ModifiedBinarySearch_05_ ] [ Given number start and end index in binary search ]
_______________________________________________________________________________
same as :_Goo_41_Find_Start_End_Of_Element_In_Sorted_Array
The problem follows the Binary Search pattern. Since BS helps us find a number in a sorted array efficiently,
we can use a modified version of the Binary Search to find the first and the last position of a number.

We can use a similar approach as discussed in Order-agnostic Binary Search. We will try to search for the ‘key’
in the given array; if the ‘key’ is found (i.e. key == arr[middle) we have two options:

finding 1st position of the ‘key’, we can update end = middle - 1 to see if the key is present before middle.
finding last position of the ‘key’, we can update start = middle + 1 to see if the key is present after middle.

*/
package _00_Problems_Sorted_By_Patterns;
import java.util.Arrays;

public class _ModifiedBS_05_Number_Range_startEnd_Index_in_SortedArray {
    public static int[] findStartEndIndex(int[] array, int target){
        int[] result = new int[]{-1, -1};
        //lets find the target first if its there
        result[0] = search(array, target, false); // passing false as parameter- we just look for left end 1st index
        //if target exist in input array, find 1st and last index of target
        if(result[0]!=-1){
            result[1]=search(array, target, true); // passing true as parameter- we just look for right side
        }
        return result;
    }

    private static int search(int[] array, int target, boolean findRightMost) {
        int targetIndex =-1;
        int start=0;
        int end= array.length-1;
        int mid;
        while (start <= end){
            mid = start+(end-start)/2;
            if(target < array[mid]){
                end = mid-1;
            }else if(target > array[mid]){
                start=mid+1;
            }else{ //it come to this loop if target is not either sides means mid is key
                targetIndex=mid;
                if(findRightMost){//if true means we are looking for end (rightSide of current)
                    start = mid+1;
                }else{ //false, means we got the target and still find its left end
                    end=mid-1;
                }
            }
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        int[] result = findStartEndIndex(new int[]{4,6,6,6,6,6,9,9}, 6);
        System.out.println(Arrays.toString(result));
    }
}
