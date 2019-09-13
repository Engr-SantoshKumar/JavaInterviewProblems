/*Consider the array A = {0, 2, 8, 1, 3, 5, 4}.
The greatest number after 0 in A is maximum of {2, 8, 1, 3, 5, 4} = 8. So 0 is replaced by 8.
The greatest number after 8 in A is maximum of {1, 3, 5, 4} = 5. So 8 is replaced with 5.
4 is the last number in A. There are no more elements to its right. So 4 is replaced by an invalid number or the smallest possible number.
So the resulting array is = {8, 8, 5, 5, 5, 4, INVALID_NUMBER}.
 */

package interviewDruid._04_Arrays;

import java.util.Arrays;

public class _04_01_ReplaceEachElementWithNextGreatest {

	static int[] replaceToGreatest(int [] arr){
	
		int len = arr.length;
		// logic is to travel from back, so the gratest num will be the last on for the second last
		int currentGreatest = arr[len-1];
		arr[len -1] = Integer.MAX_VALUE;
		
		for (int i = len-2; i>=0; i--){
			int temp = arr[i];
		
			arr[i] = currentGreatest; // replacing the 2nd last int with the last element of array 
			
			//updating the currentGratest with temp if temp is gratter
			if(temp > currentGreatest)
				currentGreatest=temp;
			}
		return arr;
		}
	
	
	public static void main(String[] args) {
		
		int[] arr = {0, 2, 8, 1, 3, 5, 4};
		int [] result = replaceToGreatest(arr);
		System.out.println(Arrays.toString(result));
		
	}

}
