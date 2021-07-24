package _01_Coderust._01_Array;

public class _x_02_find_number_in_RotatedArray {


    /**
     * Works only for arrays with NO duplicates.
     * Work also for zero-shifted array, e.g fully sorted, when shift = 0 also called as Rotated array
     */

    static int searchInShiftedArr(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid; // declared outside loop to avoid constant memory allocation for this variable

        while (low <= high) {
            mid = low + ((high-low) / 2);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] <= arr[mid]) { // means first half of the array is sorted

                // deciding which pointer to move high or low -> mid
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            else {
                // deciding which pointer to move high or low -> mid
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }




    public static int rotation_Array_search(int [] arr, int start, int end, int key){

        if (start > end) {
            return -1;
        }

        int mid = start + (end-start)/2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[start] < arr[mid] && key < arr[mid] && key >= arr[start]) {
            return rotation_Array_search(arr, start, mid-1, key);
        }

        else if (arr[mid] < arr[end] && key > arr[mid] && key <= arr[end]) {
            return rotation_Array_search(arr, mid+1, end, key);
        }

        else if (arr[start] > arr[mid]) {
            return rotation_Array_search(arr, start, mid-1, key);
        }

        else if (arr[end] < arr[mid]) {
            return rotation_Array_search(arr, mid+1, end, key);
        }

        return -1;
    }





    static int binary_search_rotated(int[] arr, int key) {
        return rotation_Array_search(arr, 0, arr.length-1, key);
    }

    public static void main(String []args){
        int[] v1 = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: "+binary_search_rotated(v1, 3));
        System.out.println("Key(6) found at: "+binary_search_rotated(v1, 6));
        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: "+searchInShiftedArr(v2, 3));
        System.out.println("Key(6) found at: "+searchInShiftedArr(v2, 6));



    }
}
