package GooPrep02;

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

    public static void quickSort(int[] a, int low, int high) {
        if (a == null || a.length == 0)
            return;
        if (low >= high) {
            return;
        }
        // pick the pivot
        int mid = (low + high) / 2;
        int pivot = a[mid];
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        // recursively sort two sub parts
        if (low < j) {
            quickSort(a, low, j);
        }

        if (high > i) {
            quickSort(a, i, high);
        }
    }


    public static void main(String[] args) {
        int[] x = {9, 2, 4, 7, 3, 7, 10};
        System.out.println("Before: " + Arrays.toString(x));
        quickSort(x, 0, x.length - 1);
        System.out.println("After: " + Arrays.toString(x));
    }
}
