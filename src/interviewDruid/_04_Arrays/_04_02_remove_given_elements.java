/*
 * Suppose the given array is A = {1, 4, 2, 1, 5, 2} and we have to remove all occurrences of 1 from it, 
 * then the result array is {4, 2, 5, 2}. The element to be removed from the array can be present in multiple locations. 
 * We can efficiently remove all occurrences of the element in O(1) space and O(n) 
 * "time in a single pass through the array by doing the following:
 */

package interviewDruid._04_Arrays;

import java.util.Arrays;

public class _04_02_remove_given_elements {
    
	static int[] removeGivenNums(int [] arr, int N){
		int j =0;
		//If current element in the array should not be deleted, then store the current element at j in the array and increment j
		
		for(int i =0; i<arr.length; i++){
			if(arr[i] != N ){
				arr[j] = arr[i];
				j++;
			}
		}
		int [] result = Arrays.copyOf(arr, j);
		System.out.println(Arrays.toString(result));
		return result;

	}
	
	public static void main(String[] args) {
		int[] arrayNums ={0,1, 0, 0, 3, };
		removeGivenNums(arrayNums, 0);
	}

}
