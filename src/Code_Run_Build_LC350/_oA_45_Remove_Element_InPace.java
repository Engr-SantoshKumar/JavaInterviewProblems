/* [  _oA_45_ ] [Remove Element InPlace ]
_______________________________________________________________________________
Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the
input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3]
*/
package Code_Run_Build_LC350;
public class _oA_45_Remove_Element_InPace {
    public static int removeElement(int[] arr, int k){
        //base cases
        if(arr.length<2) return 1;

        // we can you the same logic of _Goo_17_Move_Zeros
        // move zero to one side using two pointer
        int read =0, write =0;
        while(read < arr.length){
            if(arr[read] != k){
                arr[write++] = arr[read++];
            }else{
                read++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
    }
}
