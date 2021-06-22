/** 17 [Move Zeros]
-------------------------------------------------------------------------------------------------------
 Write a method that moves all the zeroes to the beginning of the array
 (while leaving the order of the other numbers intact).
  Example:
 i/o  [ 4, 5, 6, 1, 0, 6, 8, 0, 0, 8, 9, 10 ]
 o/p  [ 0, 0, 0, 4, 5, 6, 1, 6, 8, 8, 9, 10 ]
 */
package GooPrep;
import java.util.Arrays;
/*Given an integer array, move all elements that are equal to 0 to the left while maintaining the order
of other elements in the array.
* */
public class _Goo_17_Move_Zeros {

    public static int[] moveZero(int[] arr){

        int read = arr.length-1;
        int write = arr.length-1;

        while(read >=0 ){
            // if read is non zero, copy it to write and move right pointer to left
            if(arr[read]!=0){
                arr[write] = arr[read];
                write--;
            }
            // keep moving read pointer to left until find non zero
            read--;
        }
        // Now all non-zero elements have been shifted to back,
        // move writeCounter to all the way to begging
        // by replace each to zero
        while(write >= 0){
            arr[write] =0;
            write --;
        }
        return arr;
    }


    public static void main (String[]args){
        int[] v = new int[]{1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
        System.out.println("Original Array: " + Arrays.toString(v));
        System.out.println(Arrays.toString(moveZero(v)));
        }
}
