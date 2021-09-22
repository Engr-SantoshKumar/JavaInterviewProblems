/**
 * [  ] [  ]
 * ____________________________________________________________________________________________________________________
 */

package PrepSetTwo;
import java.util.Arrays;
public class _Goo2_18_a_Mergesort {

    public static void mergeSort(int[] arr, int len){
        if (len < 2) {
            return;
        }

        int mid = len/2;
        // create two array
        int[] leftArray = new int[mid];
        int[] rightArray = new int[len-mid];

        //copy arr to new arrays
        for(int i =0; i<mid; i++){
            leftArray[i] = arr[i];
        }
        for(int i = mid; i<len; i++){
            rightArray[i-mid] = arr[i];
        }

        //call for left
        mergeSort(leftArray, leftArray.length);
        //call for right
        mergeSort(rightArray, rightArray.length);

        //merge left and right
        merge2SortedArray(arr, leftArray, rightArray);
    }

    public static void merge2SortedArray(  int[] mainArr, int[] leftArr, int[] rightArr) {

        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                mainArr[k++] = leftArr[i++];
            }
            else {
                mainArr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            mainArr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            mainArr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {

        int arr[] = {5, 1, 6, 2, 3, 4 };

        System.out.println("Given Array");
        System.out.println(Arrays.toString(arr));

        _Goo2_18_a_Mergesort ob = new _Goo2_18_a_Mergesort();
        ob.mergeSort(arr, arr.length);

        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(arr));;
    }
}


