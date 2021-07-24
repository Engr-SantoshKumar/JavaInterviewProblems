/* [ _ModifiedBinarySearch_02_ ] [ 81. Search in Rotated Sorted Array II ]
_______________________________________________________________________________
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
For example, [0,1,2,4,4,4,5,6,6,7,8,9] might be rotated at pivot index 7 and become [4,5,6,6,7,8,9,0,1,2,4,4].
Logic:
Comparing the numbers at indices start and middle will give us two options:
If arr[start] < arr[middle], the numbers from start to middle are sorted.
Else, the numbers from middle + 1 to end are sorted.

        4,5,6,6,7,8,9,0,1,2,4,4                 6,7,8,9,0,1,2,4,4,4,5,6,
           sorted ←↑                                        ↑→ sorted
            side   ↑                                        ↑     Side
                   ↑                                        ↑
               midPoint                                 midPoint

---------------------------
NOTE SOME POINTS TO BS
1. always use start+(end-start) to fins mid, start+end will cause an overflow
2. When do you use while (start<end) , when do you use while (start<=end)?
  -->  You use while (start <= end) if you are returning the match from inside the loop.
  -->  You use while (start < end) if you want to exit out of the loop first, and then use the result
        of start or end to return the match.

*/
package _00_Problems_Sorted_By_Patterns;

public class _ModifiedBS_02_Search_In_Rotated_Array_Has_Duplicated {

    public static boolean search(int[] array, int target) {
        int start = 0, end = array.length - 1;
        int mid;// declared outside loop to avoid constant memory allocation for this variable

        //getMid, checkSorted part and decide where to go next
        while (start <= end) {
            mid = start + (end - start) / 2; //start+end will cause an overflow
            if (array[mid] == target) return true;

            //if left part is sorted, searching in sorted part
            if (array[start] < array[mid]) {
                if (target < array[start] || target > array[mid]) { // target is not in sorted part
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (array[start] > array[mid]) { //searching in unsorted part, this half is rotated

                if (target < array[mid] || target > array[end]) {//target is in rotated part
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //duplicates, we know nums[mid] != target, so nums[start] != target
                //based on current information, we can only move left pointer to skip one cell
                //thus in the worest case, we would have target: 2, and array like 11111111, then
                //the running time would be O(n)
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,7,8,9,0,1,2,4,4,4,5,6};
        System.out.println(search(arr,2));
    }
}
