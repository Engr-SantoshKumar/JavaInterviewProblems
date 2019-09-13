package leetCodeProblems;
/**
 * 
 */

/**
 * This problem is a variation of standard Longest Increasing Subsequence (LIS) problem. 
 * If input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100)
 * if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
 */
public class findMaxSumIncreasingSubsequence {
	
	public static void main(String[] args) {
		
		int[] a = {1, 101, 2, 3, 100, 4, 5};
		int ArrayLength = a.length;
		System.out.println("Sum of maximum sum increasing "+
                " subsequence is "+
		sumOfLIS(a, ArrayLength));
		

	}
	
	public static int sumOfLIS (int [] a, int ArrayLength){
		
		int [] LIS = new int [ArrayLength];
		
		int maxsum =0; 
		
		//loading the LIS with array values 
		for(int i =0; i< ArrayLength; i++)
			LIS[i]=a[i];
		
		//Compute maximum sum values
		for(int i=0; i< ArrayLength; i++ ){
			
			for(int j =0; j<i; j++){
				
				System.out.println("For i = " +i +" And j = "+j);
				System.out.println( a[i] + ">" + a[j]+ "  &&  " + LIS[i]+ " < (" + LIS[j]+ " + " +a[i]+" ) -->" + (a[i]>a[j] && LIS[i]<LIS[j]+a[i]));
				
				
				if (a[i]>a[j] && LIS[i]<LIS[j]+a[i]){
					
					LIS[i]=LIS[j]+a[i];
					System.out.println(LIS[j]+a[i]);
				}
				
			}
		}
			
		// finding the max value in LIS
		for (int i= 1; i<ArrayLength; i++){
			
				if (maxsum < LIS[i])
					maxsum = LIS[i];
			}
		
		return maxsum;
		
		
	}
	

}
