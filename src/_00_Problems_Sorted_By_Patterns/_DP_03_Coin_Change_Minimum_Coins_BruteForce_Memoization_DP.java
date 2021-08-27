/* [ _DP_03_ ] [ Coin Change Problem | Minimum Num of coins required to make that amount ]
_______________________________________________________________________________
Given an integer representing a specific amount of change and a set of coin
sizes, determine the minimum number of coins required to make that amount
of change. You may assume there is always a 1 cent coin.
eg. (assuming American coins: 1, 5, 10, and 25 cents)
change(1) = 1 (1)
change(6) = 2 (5 + 1)
change(47) = 5 (25 + 10 + 10 + 1 + 1)
*/
package _00_Problems_Sorted_By_Patterns;
class _DP_03_Coin_Change_Minimum_Coins_BruteForce_Memoization_DP {

    //we are going to use the concept of knapsack: oneCall Include and oneCallExclude
    /*=============   Method 1  ====================================*/
    // O(n^c), where n is the amount of change and c is the number of coin denominations

    public static int coinChangeMinimumRecursion(int[] coins, int amount){
        return coinChangeMinimumHelper(coins, amount, 0);
    }

    private static int coinChangeMinimumHelper(int[] coins, int amount, int curIndex) {
        //base
        if (amount==0) // possible to make 0 by not including any coin
            return 0;
        if (curIndex == coins.length) // if we have no coin it will take infinity to make something
            return Integer.MAX_VALUE;

        int excluded = coinChangeMinimumHelper(coins, amount,curIndex+1);
        int included = Integer.MAX_VALUE;
        if(amount-coins[curIndex]>=0) {
            int minCoins = coinChangeMinimumHelper(coins, amount-coins[curIndex], curIndex);
            if(minCoins != Integer.MAX_VALUE)
                included = 1 + minCoins;
        }
        return Math.min(excluded,included); // keep the min from above recursive calls
    }

    public static int coinChangeMinimumDP(int[] coins, int amount) {

        // we can include a coin to make a amount or we exclude a coin

        // create a dp array of size coins and amount+1;
        int dp[][] = new int[coins.length][amount+1];

        // if amount to be formed = 0 then the we cannot add any coins
        // so make first col as 0
        for(int i=0;i<coins.length;i++)
            dp[i][0] = 0;
        // now we play include and exclude take min of exclude and include
        // exclude is from previous row and same col
        // include is 1 + dp[i][j-coins[i]]; 1 represents including that particular coin
        for(int i=0;i<coins.length;i++) {
            for(int j=1;j<=amount;j++) {
                // if i == 0 and coins[i] > j i.e amount is less than the coin
                // give random high value
                if(i==0 && coins[i] > j)
                    dp[i][j] = Integer.MAX_VALUE;

                    // in first row we cannot see any previous value only we can able to include
                else if(i == 0 && coins[i] <= j)
                    dp[i][j] = 1 + dp[i][j-coins[i]];

                    // if i != 0 and if particular coin is greater than the amount only consider the exclude value
                else if(coins[i]>j)
                    dp[i][j] = dp[i-1][j];

                    // else take min of include and exclude
                else
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i]], dp[i-1][j]);
            }
        }
        return dp[coins.length-1][amount] == Integer.MAX_VALUE ? -1:dp[coins.length-1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 6, 10};
        System.out.println(coinChangeMinimumRecursion(coins, 12));
        System.out.println(coinChangeMinimumDP(coins, 12));
    }

}
