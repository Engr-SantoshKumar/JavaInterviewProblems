package GooPrep02;

import java.util.Arrays;

/**
 * [ Goo2 18  ] [ Quick Sort  ]
 * ____________________________________________________________________________________________________________________
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