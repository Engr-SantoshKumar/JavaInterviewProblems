package _02_CTCI_Questions.sortingAndSearching;

import java.util.Arrays;

public class _10_01_Mearge_Sorted_array {
	
	static int [] mergeArray(int[] arr1, int [] arr2){
		
		
		int[] finalArray = new int[arr1.length + arr2.length];
		
		int i =0, j =0 , k = 0;
		
		while( i < arr1.length && j < arr2.length){
			if(arr1[i] < arr2[j]){
				finalArray[k++] = arr1[i++];
			}else{
				finalArray[k++] = arr2[j++];
			}
		
		}
		while( i< arr1.length){
			finalArray[k++] = arr1[i++];
		}
		while( j< arr2.length){
			finalArray[k++] = arr2[j++];
		}	

		return finalArray;
	}
	

	
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100};
		int[] b = {1, 4, 4, 6, 7, 7};
		System.out.println(Arrays.toString(mergeArray(a, b)));

	}
	
}

