package _01_Coderust._01_Array;

public class _x_05_findLowHighIndex {


    // o(n) solution
    public static void findFirstAndLast(int arr[], int x)
    {
        int n = arr.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++)
        {
            if (x != arr[i]) continue;

            if (first == -1) {
                first = i;
            }
            last = i;
        }

        if (first != -1){
            System.out.println( "First Occurrence of "+ x + " at index "  + first);
            System.out.println("Last Occurrence of "+ x + " at index "  + last);
        }
        else
            System.out.println( x + " Not Found");
    }


    // o(logn) solution using binary search

    public static int findFirstOccurrenceUsingBinarySearch(int[] arr, int x){

        int left = 0;
        int right = arr.length-1;
        int firstOccurrence = -1;

        while(left<=right){

            int mid = left + (right - left)/2;
            // there will be three condition
            //Cond A: if key is found, update the result and go on searching towards left (first occurrence)
            if(x == arr[mid]){
                firstOccurrence=mid;
                right = mid-1;
            }
            // Cond B: if key is less than the mid element, discard right half
            else if (x < arr[mid]){
                right = mid-1;

            // Cond C: if key is more than the mid element, discard left half
            }else {

                left= mid+1;
            }
        }
        // return the leftmost index or -1 if the element is not found
        return firstOccurrence;
    }

    public static int findLastOccurrenceUsingBinarySearch(int[] arr, int x){

        int left = 0;
        int right = arr.length-1;
        int lastOccurrence = -1;

        while(left<=right){

            int mid = left + (right - left)/2;
            // there will be three condition
            //Cond A: if key is found, update the result and go on searching towards RIGHT (LAST occurrence)
            // --> this is the only difference in finding first and last index
            if(x == arr[mid]){
                lastOccurrence=mid;
                left = mid+1;
            }
            else if (x < arr[mid]){
                right = mid-1;
            }else {

                left= mid+1;
            }
        }
        return lastOccurrence;
    }


    public static void main(String[] args) {
        int[] array = {1,1,1,2,2,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,6,6};

        findFirstAndLast(array, 5);
        findFirstAndLast(array, 1);
        findFirstAndLast(array, 7);

        int [] find = {1, 3, 5, 8};
        for (int i =0; i<find.length; i++){
            int key = find[i];
            int indexFirst = findFirstOccurrenceUsingBinarySearch(array, key);
            if (indexFirst != -1) {
                System.out.println("First occurrence of element " + key +
                        " is found at index " + indexFirst);
            } else {
                System.out.println("Element not found in the array");
            }

            int indexLast = findLastOccurrenceUsingBinarySearch(array, key);
            if (indexLast != -1) {
                System.out.println("Last occurrence of element " + key +
                        " is found at index " + indexLast);
            } else {
                System.out.println("Element not found in the array");
            }
        }


    }


}
