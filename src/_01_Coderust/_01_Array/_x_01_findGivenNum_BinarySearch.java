package _01_Coderust._01_Array;

public class _x_01_findGivenNum_BinarySearch {

    static int binarySearchRec(int[] a, int key, int low, int high){
        if(low > high) return -1; // could not find the element

        int mid = low + ((high-low) / 2);
        if (a[mid] == key) {
            return mid;
        }else if (key < a[mid]) {
            return binarySearchRec(a, key, low, mid - 1); // calling again with 1st half
        }else{
            return binarySearchRec(a, key, mid+1, high); // calling again with 2nd half
        }

    }


    /**
     * Works only for arrays with NO duplicates.
     * Work also for zero-shifted array, e.g fully sorted, when shift = 0.
     */
    static int searchInShiftedArr(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid; // declared outside loop to avoid constant memory allocation for this variable

        while (low <= high) {
            mid = low + ((high-low) / 2);
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[low] <= arr[mid]) { // means first half of the array is sorted
                if (arr[low] <= key && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // means right half of the array is sorted
                if (arr[mid] < key && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    static int binSearch(int[] a, int key) {
        return binarySearchRec(a, key, 0, a.length - 1);
    }

    public static void main(String []args){
        int[] arr1 = {1,2,4,7,8,12,15,19,24,50,69,80,100};
        System.out.println("Key(12) found at: "+binSearch(arr1,12));
        System.out.println("Key(44) found at: "+binSearch(arr1,44));
        System.out.println("Key(80) found at: "+binSearch(arr1,80));


        System.out.println("Key(12) found at: "+binSearch(arr1,12));
        System.out.println("Key(44) found at: "+binSearch(arr1,44));
        System.out.println("Key(80) found at: "+binSearch(arr1,80));
    }
}
