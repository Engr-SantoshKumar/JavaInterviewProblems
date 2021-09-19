/* [  ] [ Cycle Sort ]
_______________________________________________________________________________
this is same as we used in
Cycle sort is an in-place sorting Algorithm, unstable sorting algorithm,
a comparison sort that is theoretically optimal in terms of the total number of writes to the original array.

It is based on the idea that array to be sorted can be divided into cycles. Cycles can be visualized as a graph.
We have n nodes and an edge directed from node i to node j if the element at i-th index must be present at j-th index in the sorted array.
Cycle in arr[] = {2, 4, 5, 1, 3}
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;

public class _Array_18_Cyclic_Sort {
    public static void cyclicSort(int[] arr){
        for(int i =0; i<arr.length; i++){
            int current = arr[i];
            //keep swapping to move current to its correct index
            // 1. arr[index] is withing range i.e >0 && <length
            // 2. why if(arr[arr[i]-1] != arr[i]) instead of if(arr[i]-1 != i) ? Aren't they the same???
            // Almost the same, but like [3,2,3,4], when i = 0, A[0] = 3, and we should move it to position 3
            // i.e  i = 2 where there also  A[2] = 3. same digit exists
            // Thus there is no need to do swap or it will go into endless loop
            while(arr[i] > 0 && arr[i] < arr.length && arr[arr[i]-1]!=arr[i] ){
                int temp = arr[current-1];
                arr[current-1] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 4, 1};
        cyclicSort(arr);
    }
}
