/**
 * [ DP_01 ] [ Coin Change Problem ]
 * ____________________________________________________________________________________________________________________
 Given an integer representing a specific amount of change and a set of coin
 sizes, determine the minimum number of coins required to make that amount
 of change.
 Counterexample: change(12), coins: {1, 6, 10}
 The greedy algorithm returns 3 (10 + 1 + 1)
 The optimal result is 2 (6 + 6)
 ● c comparisons for each iterative step
 ● Time complexity is O(n * c)
 ● Space complexity is O(n)

 */
package DynamicProgramming;
public class _01_ByteBy_Coin_Change_Problem {

    public static int coinChangeBottomUp(int[] coins, int K){
        if (K == 0) return 0;
        int[] dp = new int[K+1];
        //Lo
        for(int i = 1; i<=K; i++){
            int currentMin = Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin >= 0){
                    currentMin = Math.min(currentMin, dp[i-coin]);
                }
            }
            dp[i] = currentMin+1;
        }
        return dp[K];
    }

    public static void main(String[] args) {
        int[] coins = {1, 6, 10};
        System.out.println(coinChangeBottomUp(coins, 12));

    }

}
