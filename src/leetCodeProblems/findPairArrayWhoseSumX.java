package leetCodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class findPairArrayWhoseSumX {

public static void main(String[] args) {
		
		int[] numbers = {1,0,3,4,2,1,2,4,0,6,7,8,9,10};
		pairforSIX(numbers);
		//charDublicated("harikrishna");
		//pairForFOUR(numbers);
        
    }
	
	public static  int pairForFOUR (int[] nums){
		
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
	
		for(int i: nums){
			
			if(hashmap.containsKey(i)){
				
				System.out.println("["+ i +" , "+ hashmap.get(i)+"]");
				
			}else{
				hashmap.put((4-(i)), i);
			}
			
		}
		
		System.out.println(hashmap);
		
		return 0;
		
	}
	
	public static  void pairforFIVE(int[] nums){
		
		for(int i =0; i<nums.length-1; i++){
			for(int j =i+1; j<nums.length; j++){
				
				if(nums[i]+nums[j]==5){
					System.out.println("Pair "+ nums[i]+":"+nums[j]);
				}
			}
			
			
		}
	}
	public static  void pairforSIX(int[] a) {
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i= 0; i<a.length; i++){

        	Integer required = 10 - a[i];
            Integer value = hm.get(a[i]);
            
            if (value == required){
               System.out.println("Pair"+required +":" +a[i]);
                
            }else hm.put(required,a[i]);

	}
}
}



