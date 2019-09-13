/* nos:    -3, -2, 0, 1, 2, 5, 7, 8
 * index:   0,  1, 2, 3, 4, 5, 6, 7
 * 
 * nos:     1, 2, 2, 2, 2, 6, 7, 7, 9
 * index:   0, 1, 2, 3, 4, 5, 6, 7, 8
 */

package _02_CTCI_Questions.recursion_DynamicPrograming;
public class _08_03_MagicIndex {
	
	// the logic here is that, if the num at mid index is smaller than the index(above e.g. num < index : 1<3 ) 
	// that means magic num/index can't be before the mid index
	
	static int findMagicIndexWhenNoRepated(int [] Arr, int start, int end){
		
		if (start > end) return -1;
		
		int mid = (start+end) / 2;
		
		
		if (mid == Arr[mid]) return mid;
		
		if(mid > Arr[mid]){
			return findMagicIndexWhenNoRepated(Arr, mid+1 , Arr.length-1);
		}else{
			return findMagicIndexWhenNoRepated(Arr, 0, mid -1);
		}
		
		
	}
	
	/* for duplicates, our above logic will fails, so in that case if at index 6 we found 2, that means:
	 * at 5 --> 5 is not possible (here must be 2 or less than that as it is increasing array ) right!!
	 * at 4 --> 4 is not possible 
	 * at 3 --> 3 is not possible 
	 * at 2 --> 2 is possible ..that means we can  skip 5,4,3  
	 * 
	 * Same WAY if at index 6 we found 9, that means:
	 * at 7 --> 7 is not possible 
	 * at 8 --> 8 is not possible 
	 * at 9 --> 9 is possible ..so we can skip 7,8 
	 * 
	 *  so if index > num take min of (index, num)
	 *  if index < num take max of (index, num)
	 */
	
	static int findMagicIndexWhenRepated(int [] Arr, int start, int end){
		if (start > end) return -1;
		
		int mid = (start+end)/2;
		
		if (mid == Arr[mid]) return mid;
		
		
		int endOfLeft = Math.min(mid -1, Arr[mid]);
		int	left = findMagicIndexWhenRepated(Arr, start, endOfLeft);
			if (left >= 0) {
				return left;
			}
		int startOfRight = Math.max(mid +1, Arr[mid]);
		int right = findMagicIndexWhenRepated(Arr, startOfRight, end);
		
		return right;
	}
	
	

	public static void main(String[] args) {

		
		
		int [] numbers = {-3, -2, 0, 1, 2, 5, 7, 8};
		int [] numDup = { -1, 0, 1, 2, 3, 4, 7, 7, 9};
		
		System.out.println(findMagicIndexWhenNoRepated(numbers, 0, numbers.length-1 ));
		System.out.println(findMagicIndexWhenRepated(numDup, 0, numbers.length-1));
	}

}
