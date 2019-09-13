package leetCodeProblems;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeProblem {

	
	public static void minChangeCoins(int [] d, int x) {
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int count =0;
		
		for(int i=d.length-1; i >=0; i--) {
			count=0;
			while(x>=d[i]) {
				x=x-d[i];
				count ++;
				hm.put(d[i], count);
				}
			}
			
		System.out.println(hm);
		
	}

	    public int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> map) {

	            if ( total == 0 ) {
	            return 0;
	        }

	        if ( map.containsKey(total) ) {
	            return map.get(total);
	        }

	        //iterate through all coins and see which one gives best result.
	        int min = Integer.MAX_VALUE;
	        for ( int i=0; i < coins.length; i++ ) {
	            
	        	//if value of coin is greater than total we are looking for just continue.
	            if( coins[i] > total ) {
	                continue;
	            }
	            
	            //recurse with total - coins[i] as new total
	            int val = minimumCoinTopDown(total - coins[i], coins, map);

	            //if val we get from picking coins[i] as first coin for current total is less than value found so far make it minimum.
	            if( val < min ) {
	                min = val;
	            }
	        }

	        //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
	        min =  (min == Integer.MAX_VALUE ? min : min + 1);

	        //memoize the minimum for current total.
	        map.put(total, min);
	        //System.out.println(min);
	        return min;
	        
	    }

	public static void main(String[] args) {
	
		int total = 13;
        int coins[] = {7, 3, 2, 6};
        CoinChangeProblem cc = new CoinChangeProblem();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int topDownValue = cc.minimumCoinTopDown(total, coins, map);
		System.out.println("MinCoines"+topDownValue);
		
		minChangeCoins(coins, total);
		

	}

}
