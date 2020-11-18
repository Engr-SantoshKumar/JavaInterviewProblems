/* [ _oA_44 ] [ Remove Duplicates from Sorted Array ( in-place ) ]
_______________________________________________________________________________
Given a sorted array nums, remove the duplicates in-place such that each element
appears only once and returns the new length.

Do not allocate extra space for another array,
you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, which means a modification to the input
 array will be known to the caller as well.
Internally you can think of this:
    // nums is passed in by reference. (i.e., without making a copy)
        int len = removeDuplicates(nums);
    // any modification to nums in your function would be known by the caller.
    // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }

Example 1:
Input: nums = [1,1,2]
Output: 2, explanation nums = [1,2]
*/
package Code_Run_Build_LC350;
public class _oA_44_Remove_Duplicates_From_Sorted_Array {
    public static int removeDuplicates(int[] arr) {
        //base cases
        if(arr.length < 2) return arr.length;

        int j =1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){  // --> at index i its not dup
                arr[j] = arr[i];
                j++;
            }
        }
        return j; // until index j all are unique
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,2,3,4,4,4,4};
        System.out.println(removeDuplicates(arr));
    }
}
