/**
 * 
 */
package leetCodeProblems;

/**
 *Given a sorted array and a number x, find the pair in array whose sum is closest to x
 *
 */
public class findPairSumClosestToX {


	
	public static void main(String[] args) {
		int[] a = {10, 20, 28, 29, 30, 40};
		
		//pairToGetXusingTwoForLoop(a, 65);
		pairToGetX_usingOneForLoop(a, 65);
		

	}
	
	// this is O(n^2)
	public static void pairToGetXusingTwoForLoop(int [] arr, int target){
		
		int	minDiff = Integer.MAX_VALUE;
		int no1 = 0, no2 = 0;
				
		for (int i =0; i< arr.length-1; i++){
			for (int j=i+1; j<arr.length;j++){

				if(Math.abs(arr[i] + arr[j] - target) < minDiff){
					no1= arr[i];
					no2= arr[j];
					minDiff = Math.abs(arr[i] + arr[j] - target);
				}
			}
		}
		
		 System.out.println(" The closest pair is "+no1+" and "+ no2);
}
	// this is O(n)
	public static void pairToGetX_usingOneForLoop(int [] arr, int target){
		
		int pair1stNo = 0;
		int pair2ndNo = 0;
		
		int	minDiff = Integer.MAX_VALUE;
		int leftPointer = 0, RightPointer = arr.length-1;
		
		while(RightPointer > leftPointer){
			
			if(Math.abs(arr[leftPointer] + arr[RightPointer]-target) < minDiff ){
				
				pair1stNo= arr[leftPointer];
				pair2ndNo=arr[RightPointer];
				
				minDiff= Math.abs(arr[leftPointer] + arr[RightPointer]-target);
						
			}
			
			if((arr[leftPointer] + arr[RightPointer]) < target){
				leftPointer ++;
				}else{
					RightPointer --;
				}
				
		}
		
		
		System.out.println(" The closest pair is "+ pair1stNo +" and "+ pair2ndNo);	
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
