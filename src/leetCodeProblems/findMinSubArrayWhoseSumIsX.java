package leetCodeProblems;
/**
 * 
 */

/**
 * 
 *
 *
 */
public class findMinSubArrayWhoseSumIsX {


	public static void main(String[] args) {
		int [] arr = {2,3,1,2,4,3};
		int X = 7;
		
		minSubArraySum(arr, X);
		System.out.println();
		
	}
 
	public static int minSubArraySum(int [] arr, int X){
		
		if(arr==null|| arr.length==1)
		return 0;
		
	    int i=0; 
	    int j=0;
	    int sum=0;
	    int minLen = Integer.MAX_VALUE;
		
		while( i<arr.length){
			
			if(sum<X){
			 sum = sum + arr[i];
			 i++;
			}else{
				minLen = Math.min(minLen, i-j);
				if(i==i-j)
					return 1;
				sum = sum - arr[j];
				j++;
			}
			
		}
		
		while (sum >=X){
			minLen = Math.min(minLen, i-j);
			sum = sum - arr[j];
		}
		
		System.out.println(minLen);
		return minLen==Integer.MAX_VALUE? 0: minLen;
}
	
	
	public static  void minSubArraySumUsingTwoForLoop(int [] arr, int X){

	    
	    int minLen = Integer.MAX_VALUE;
	    
	    for (int i =0; i<arr.length; i++){
	    	
	    	int currentSum = 0;
	    	
	    	for(int j=i; j<i; j++){
	    		if(currentSum < X){
	    			currentSum = currentSum + arr[j];
	    			if(currentSum ==X){
	    			minLen = i-j+1;
	    			break;
	    			
	    			}
	    		}
	    		
	    		
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    
	    
		
		
		
		
	}
	
}








