/* check if the coin value is more than the amount needed i.e coins[row-1] > column then just copy value from above cell 
 * else calculate below steps 
 * step 1. ways can be formed by exclude the new coin i.e --> the value of just above cell 
 * step 2. ways can be formed by include the new coin i.e --> value present in same row, reduce the amount by coin value (amount - coin[i])
 * 3. num of ways = step 1 + step 2 
 */
package _02_CTCI_Questions.recursion_DynamicPrograming;
import java.util.Arrays;
public class _08_10_Coin_Change_All_possible_way {

//---------------------using Dynamic Programming-----------------------------------------------------------------
	
	static int allPossibleWays(int [] coins, int target){
		
		int[][] solution = new int[coins.length + 1][target + 1];   //created one size bigger matrix
		
		// hypothetical condition, for target 0 coin, with 0 coin you can make 0 in one-way
		for(int row =0 ; row < coins.length +1; row++){
			solution[row][0] = 1;
		}
		
		// Now let fill the remaining solution 
		for(int row =1; row < coins.length +1; row ++){
			for(int column =1; column < target +1 ; column ++){
				
				if(coins[row-1] > column){ //

					solution[row][column] = solution[row-1][column];
				}
				else{
					int withoutIncludingCurrentCoin = solution[row-1][column]; // copied value from above cell
					int includingCurrentCoin = solution[row][column-coins[row-1]]; // copied value from cell in same row ; row-coin's value
					
					solution[row][column] = withoutIncludingCurrentCoin +  includingCurrentCoin;			
					}
				}
		}
		print2D(solution);
		return solution[coins.length][target];
	}

//-------------- using recursion ----------------------------------------------------------------------- 	
	static int allPossibleWaysUsingResursion(int [] coins, int target, int countOfCoins){
		
		if(target == 0){   // base condition, we found the combination whose sum is equal to target
			return 1;
		}
		if (target < 0){  // base condition, combination  the target  
			return 0;
		}
		//If there are no coins and n is greater than 0, then no solution exist
		if (countOfCoins == coins.length && target >0){
			return 0;
		}
		
		return allPossibleWaysUsingResursion (coins, target-coins[countOfCoins], countOfCoins) 
				+ allPossibleWaysUsingResursion(coins, target, countOfCoins+1);
		
	}
	
	
	
	public static void main(String[] args) {
		int[] coins = { 2, 3};
		int target = 6;
		System.out.println( "All possible way : " + allPossibleWays(coins,target));
		
		System.out.println(allPossibleWaysUsingResursion(coins, target, 0));
	}
	
	
	static void print2D(int[][] M){
		for(int row = 0; row<M.length; row++){
			System.out.println(Arrays.toString(M[row]));
		}
	}
}
