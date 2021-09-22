/**
 [23 -C] [Merge K Sorted Arrays in Ascending or Descending depends on input ]
 -----------------------------------------------------------------------------------------------------
 PROBLEM STATEMENT: Merge k sorted array and return it as one sorted list. Analyze and describe its complexity.
 TIME COMPLEXITY: This problem can be solved by using a heap. The time complexity is kn * log(K),
 where n is the total number of elements and k is the number of arrays.
 */

package PrepSetOne;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _Goo_23_c_Merge_K_Sorted_Array_Asc_Dec {

     static int[] mergeKSortedArray(int[][] arr) {

        //Find the sorting order
        int m = arr.length;
        int n = arr[0].length;

        PriorityQueue<pqNodes> pq;

        if (arr[0][0] < arr[0][n - 1]) {
            pq = new PriorityQueue<>(m);  //Ascending
        } else {
            pq = new PriorityQueue<>(m, Collections.reverseOrder()); //Descending
        }

        int resultSize =0;

        //Step 1: add fist element from each array to pq also get the size of each array to store result
        for(int i =0; i<arr.length; i++){
            resultSize+=arr[i].length;

            if(arr[i].length >0){
                pq.add(new pqNodes(i, 0, arr[i][0] ));
            }
        }

        int[] result = new int[resultSize];

        // Step 2: remove the node from pq add to result and also add the next element of removed element's array to pq
        for(int i =0; !pq.isEmpty(); i++){
            pqNodes curNode = pq.poll();
            result [i] = curNode.value;

            // add next element to pq
            int nextIndex = curNode.index +1 ; //current index + 1
            if(nextIndex < arr[curNode.array].length){//check if its the last element
                pq.add(new pqNodes(curNode.array, nextIndex, arr[curNode.array][nextIndex]));
            }
        }
        return result;
    }

    //node class for priorityQueue with Comparable to compare its self to other pqNodes
    static class pqNodes implements Comparable<pqNodes> {
        int array;
        int index;
        int value;

        public pqNodes(int array, int index, int value){
            this.array = array;
            this.index = index;
            this.value = value;
        }
        // compare method to compare values
        public int compareTo(pqNodes n){
            return Integer.compare(value,n.value);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = { 12, 11, 10, 8, 6, 5 };
        int[] arr2 = { 7, 4, 3, 2, 0 };
        int[] arr3 = { 15, 14, 12, 3, -1 };

        int[] arr1a = { 1, 3, 5, 7 };
        int[] arr2a = { 2, 4, 6, 8 };
        int[] arr3a = { 0, 9, 10, 11 };

        int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));

        int[] result1 = mergeKSortedArray(new int[][] { arr1a, arr2a, arr3a });
        System.out.println(Arrays.toString(result1));
    }
}