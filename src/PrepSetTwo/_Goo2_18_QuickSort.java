package PrepSetTwo;

import java.util.Arrays;

/**
 * [ Goo2 18  ] [ Quick Sort  ]
 * _______________________________________________________________________________________________________________
 QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array
 around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.

 Always pick first element as pivot.
 Always pick last element as pivot (implemented below)
 Pick a random element as pivot.
 Pick median as pivot.
 The key process in quickSort is partition(). Target of partitions is, given an array and an element x
 of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x)
 before x, and put all greater elements (greater than x) after x. All this should be done in linear time.

 Pseudo Code for recursive QuickSort function :

 /** low  --> Starting index,  high  --> Ending index
        quickSort(arr[], low, high)
                {
                if (low < high)
                    {
                    /* pi is partitioning index, arr[pi] is now at right place

                    pi = partition(arr, low, high);

                    quickSort(arr, low, pi - 1);  // Before pi
                    quickSort(arr, pi + 1, high); // After pi
                    }
                }

 */
public class _Goo2_18_QuickSort {

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        //swap the pivot point index value too
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }


    public static void main(String[] args) {
        int[] x = {9, 2, 4, 7, 3, 7, 10};
        System.out.println("Before: " + Arrays.toString(x));
        quickSort(x, 0, x.length - 1);
        System.out.println("After: " + Arrays.toString(x));
    }
}
