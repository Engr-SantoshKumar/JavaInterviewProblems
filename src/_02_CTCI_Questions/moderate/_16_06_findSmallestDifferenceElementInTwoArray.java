package _02_CTCI_Questions.moderate;

import java.util.Arrays;

public class _16_06_findSmallestDifferenceElementInTwoArray {
	
	static int findSmallestDifference(int[] array1, int[] array2){
		Arrays.sort(array1);
		Arrays.sort(array2);
		int minDiff = Integer.MAX_VALUE;
		int i=0;
		int j=0;
		
		while( i < array1.length && j < array2.length ){
			
			if(Math.abs(array1[i] - array2[j]) < minDiff){
				minDiff = Math.abs(array1[i] - array2[j]);
			}
			// move the small value
			if(array1[i] < array2[j]){
				i++;
			}else
				j++;
		}
		
		return minDiff;
	}

	public static void main(String[] args) {
		int[] array1 = {1, 3, 15, 11, 2};
		int[] array2 = {23, 127, 234, 19, 8};
		int difference = findSmallestDifference(array1, array2);
		System.out.println(difference);
	}

}
