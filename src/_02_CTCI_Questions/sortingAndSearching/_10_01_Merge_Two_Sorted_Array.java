/* You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
 * 
 */

package _02_CTCI_Questions.sortingAndSearching;

import java.util.Arrays;

public class _10_01_Merge_Two_Sorted_Array {

	static int[] mergeArray(int[] a, int[] b, int lastA, int lastB)  {
		int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
		int indexA = lastA - 1; /* Index of last element in array b */
		int indexB = lastB - 1; /* Index of last element in array a */
	
		/* Merge a and b, starting from the last element in each */
		while (indexB >= 0) {
			if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
				a[indexMerged] = a[indexA]; // copy element
				indexA--; 
			} else {
				a[indexMerged] = b[indexB]; // copy element
				indexB--;
			}
			indexMerged--; // move indices			
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 4, 6, 7, 7};
		int NoOfRealEleamentsInA = 8;
		int NoOfRealEleamentsInB = 6;
		mergeArray(a, b, NoOfRealEleamentsInA, NoOfRealEleamentsInB);
		System.out.println(Arrays.toString(mergeArray(a, b, NoOfRealEleamentsInA, NoOfRealEleamentsInB)));

	}

}
