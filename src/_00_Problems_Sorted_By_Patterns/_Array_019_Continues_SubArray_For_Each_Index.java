/* [  ] [ Contiguous SubArrays at each index]
_______________________________________________________________________________
Contiguous SubArrays
You are given an array arr of N integers. For each index i, you are required to determine the number
of contiguous subArrays that fulfill the following conditions:
The value at index i must be the maximum element in the contiguous subArrays, and
These contiguous subArrays must either start from or end on index i.

arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]
Explanation:
For index 0 - [3] is the only contiguous subArray that starts (or ends) with 3, and the maximum value in this
subArray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]
*/
package _00_Problems_Sorted_By_Patterns;
public class _Array_019_Continues_SubArray_For_Each_Index {
}
