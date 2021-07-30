/* [ _ModifiedBS_06_ ] [ _ModifiedBS_06_Rotation_Count ]
_______________________________________________________________________________
Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
You can assume that the array does not have any duplicates.
Input: [10, 15, 1, 3, 8]
Output: 2 ----> the array has been rotated 2 times.
Logic:
We can use a similar strategy as discussed in Search in Rotated Array.
After calculating the middle, we can compare the number at index middle with its previous and next number.
This will give us two options:
    If arr[middle] > arr[middle + 1], then the element at middle + 1 is the smallest.
    If arr[middle - 1] > arr[middle], then the element at middle is the smallest.
To adjust the ranges we can follow the same approach as discussed in Search in Rotated Array.
Comparing the numbers at indices start and middle will give us two options:

If arr[start] < arr[middle], the numbers from start to middle are sorted.
Else, the numbers from middle + 1 to end are sorted.
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_06_Rotation_Count {

    // same as find smallest, only differance this returns index not valve
    public static int rotationCount(int[] array){
        int start =0;
        int end = array.length-1;
        int mid;
        while (start<=end){
            mid=start+(end-start)/2;
            // sorted 10, 15, 1, 3, 8, 9
            if(mid < end && array[mid] > array[mid+1]){
                return mid+1;
            }
            if(mid > start && array[mid-1]>array[mid]){
                return mid;
            }
            if(array[start]<array[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,7,8,0,1,2,3,4,5};
        System.out.println(rotationCount(array));
    }
}
