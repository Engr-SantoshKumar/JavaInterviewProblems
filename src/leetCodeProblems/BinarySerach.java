//Sort using bubble sort and find index of 10 using binary search
package leetCodeProblems;

import java.util.Arrays;

public class BinarySerach {

	public static void main(String[] args) {
		
		int[] givenNumbers = {2, 5, 6, 13, 7, 8,1, 11, 9, 10 };
		int x= 10;
		System.out.println(binarySearch(sortUsingBubble(givenNumbers), x));

	}
	
	public static int[] sortUsingBubble(int[] numbers) {
		
		for(int i =0; i<numbers.length; i++) {
			
			for(int j=1; j<numbers.length-i; j++ ) {
				if(numbers[j-1]>numbers[j]) {
					
					int temp = numbers[j-1];
					numbers[j-1]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(numbers));
		return numbers;
		
	}
	
	public static int binarySearch(int[] sortedArray, int x) {
		
		Arrays.sort(sortedArray);
		
		int left =0;
		int right =sortedArray.length-1;
		
		while(left<=right) {
			int mid = left+(right-left)/2;
			if (sortedArray[mid]==x) {
				return mid;
			}
			if (sortedArray[mid]<x)
				left = mid+1;
			else
				right=mid-1;
			
			
		}
		
		
		
		return -1;
		
	}

}
