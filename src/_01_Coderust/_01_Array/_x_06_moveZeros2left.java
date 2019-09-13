package _01_Coderust._01_Array;
import java.util.Arrays;

/*Given an integer array, move all elements that are equal to 0 to the left while maintaining the order
of other elements in the array.
* */
public class _x_06_moveZeros2left {
    static void move_zeros_to_left_in_array(int[] arr) {
        if (arr == null) {
            return;
        }

        int readPointer = arr.length-1;
        int writePointer = arr.length-1;

        while(readPointer>=0){

            // if read is non zero, copy it to write and move right pointer to left
            if(arr[readPointer]!=0){
                arr[writePointer]=arr[readPointer];
                writePointer--;
            }
            // keep moving read pointer to left until find non zero
            readPointer--;
        }

        // Now all non-zero elements have been shifted to back, move writeCounter to all the way to begging
        // by replace each to zero

        while(writePointer>=0){
            arr[writePointer--]=0;
        }
    }
        public static void main (String[]args){
            int[] v = new int[]{1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
            System.out.println("Original Array: " + Arrays.toString(v));
            move_zeros_to_left_in_array(v);
            for (int i = 0; i < v.length; i++) {
                System.out.print(v[i] + ", ");
            }
        }
}

