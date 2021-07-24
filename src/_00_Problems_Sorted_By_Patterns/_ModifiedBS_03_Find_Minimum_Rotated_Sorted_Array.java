/* [ _ModifiedBinarySearch_03_ ] [ Find Minimum in Rotated Sorted Array ]
_______________________________________________________________________________
Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

Logic: there could be three cases
1. 0,1,2,3,4,5,6,7  --> no rotation
2. 6,7,8,0,1,2,3,4,5  --> min in 1stHalf, arr[start] > arr[mid] --> from start to mid not ascending  6 --> 1
3. 3,4,5,6,7,8,0,1,2  --> min in 2ndHalf, arr[mid] > arr[end] --> from mid to end not ascending  7-->2
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_03_Find_Minimum_Rotated_Sorted_Array {
    public static int findMin(int[] array) {

        if (array.length == 1) return array[0];

        int left = 0, right = array.length - 1; int mid;

        //Case 1: 1 < 2 < 3 < 4 < 5 < 7. Already sorted array. A[0] --> smallest
        if (array[right] > array[0]) {
            return array[0];
        }

        // Binary search way
        while (right >= left) {
            mid = left + (right - left) / 2;

            // if the mid element is greater than its next element then mid+1 element is the smallest
            //  e.g 6,7,8,0,1,2 --> mid 8-->8>0 --> return nextOf8 i.e 0
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is the smallest
            //  e.g 7,8,0,1,2 --> mid 0-->0<8 --> return mid
            if (array[mid - 1] > array[mid]) {
                return array[mid];
            }

            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with elements
            // greater than array[0]
            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                // if array[0] is greater than the mid value then this means the smallest value is somewhere to
                // the left
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,7,8,0,1,2,3,4,5};
        System.out.println(findMin(array));
    }
}
