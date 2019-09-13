package leetCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class HacakrankSample {

	public static void main(String[] args) {
		int [] A= {1,2,4,6};
		//System.out.println(findNumber(A, 5));
		
		oddNumbers1(1, 10);
		

	}
	
	
	static  String findNumber(int[] arr, int k) {
		String response = null;
        
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]==k) {
        		response = "YES";
        		break;
        	} else {
        		response = "NO";
        	}
        
        	
		
	}
		return response;
}
	
	static int[] oddNumbers(int l, int r) {
		
		int odds[]=new int[(r-l)/2+1];
		int K=0;
		
		
		for(int i=l; i<=r; i++) {
			if(i%2==1) {
			odds[K]=i;
			K++;

			
		}
		}
		
		for(int j=0; j<odds.length;j++) {
			System.out.println(odds[j]);
	
	
			
		}
		return odds;
		
    
		 
	
	
	
}
	
	
	static Integer[] oddNumbers1(int l, int r) {
	    List <Integer> res = new ArrayList <Integer>();

	        for (int i = l; i <= r; i++) {
	            if (i % 2 == 1) {
	                res.add(i);
	            }
	        }
	        System.out.println(res);
	        Integer res2[] = new Integer[res.size()];
	        return res.toArray(res2);

	    } 









}
