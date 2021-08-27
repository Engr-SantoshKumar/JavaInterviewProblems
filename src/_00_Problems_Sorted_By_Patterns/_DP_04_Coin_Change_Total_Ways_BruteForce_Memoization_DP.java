/* [ _DP_04_ ] [ Coin Change Problem | Total ways to make Sum from given coins ]
_______________________________________________________________________________
You are given an integer array coins representing coins of different denominations
and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount.
If that amount of money cannot be made up by any combination of the coins, return 0.

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.Map;

public class _DP_04_Coin_Change_Total_Ways_BruteForce_Memoization_DP {

    /*=============   Simplest Way ====================================*/
    public static int coinChangeTotalWaysRecursionSimple(int[] coins, int amount) {
        // if the total is 0, return 1
        if (amount == 0) return 1;

        // return 0 if total becomes negative
        if (amount < 0) return 0;

        // initialize the total number of ways to 0
        int result = 0;

        // do for each coin
        for (int coin : coins) {
            // recur to see if total can be reached by including current coin `coins[i]`
            result += coinChangeTotalWaysRecursionSimple(coins, amount - coin);
        }
        // return the total number of ways
        return result;
    }

    //we are going to use the concept of knapsack: oneCall Include and oneCallExclude
    /*=============   Method 1  ====================================*/
    // O(n^c), where n is the amount of change and c is the number of coin denominations

    public static int coinChangeTotalWaysRecursion(int[] coins, int amount){
        return coinChangeMinimumHelper(coins, amount, coins.length-1);
    }
    public static int coinChangeMinimumHelper(int[] coins, int amount, int curIndex){
        // if the total is 0, return 1 (solution found)
        if (amount == 0) {
            return 1;
        }

        // return 0 (solution does not exist) if total becomes negative, no elements are left
        if (amount < 0 || curIndex < 0 || curIndex>= coins.length) {
            return 0;
        }

        // Case 1. Include current coin `coins[curIndex]` in solution and recur
        // with remaining change `N-coins[curIndex]` with the same number of coins
        int include = coinChangeMinimumHelper(coins, amount - coins[curIndex], curIndex);

        // Case 2. Exclude current coin `coins[curIndex]` from solution and recur
        // for remaining coins `curIndex-1`
        int excluded = coinChangeMinimumHelper(coins, amount, curIndex - 1);

        // return total ways by including or excluding current coin
        return include + excluded;
    }



    // sub problem solutions are memoized rather than computed and again
    /*=============   Method 2 [Memoization] =====================================================
    O(n.N), where n is the total number of coins and N is the total change required.
    The auxiliary space required by the program is O(n.N).
    */

    public static int coinChangeTotalWaysMemoization(int[] coins, int amount){
        Map<String, Integer> hMap = new HashMap<>();
        int index =coins.length-1;
        return helperMemoization(coins, amount, index, hMap);
    }

    public static int helperMemoization(int[] coins,int amount, int index,  Map<String, Integer> hMap){
        // if the total is 0, return 1 (solution found)
        if (amount == 0) return 1;

        // return 0 (solution does not exist) if total becomes negative, no elements are left
        if (amount < 0 || index < 0) return 0;

        // construct a unique map key from dynamic elements of the input
        String key = index + "|" + amount;

        // if the sub problem is seen for the first time, solve it and store its result in a map
        if (!hMap.containsKey(key)){
            // Case 1. Include current coin `coins[index]` in solution and recur
            // with remaining change `amount-coins[index]` with the same number of coins
            int include = helperMemoization(coins, amount - coins[index], index,hMap);

            // Case 2. Exclude current coin `coins[index]` from solution and recur
            // for remaining coins `index-1`
            int exclude = helperMemoization(coins, amount, index - 1, hMap);

            // assign total ways by including or excluding current coin
            hMap.put(key, include + exclude);
        }

        // return solution to the current subProblem
        return hMap.get(key);
    }


    /*=============   Method 3 [DP] ===== bottom-up version of the above ========================*/

    public static int coinChangeTotalWaysDP(int[] coins, int amount) {
        int n = coins.length;

        int dp[][] = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                // if i != 0 and if particular coin is greater than the amount only consider the exclude value
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    // else take sum of include and exclude
                    // exclude is from previous row and same col dp[i - 1][j]
                    // include is 1 + dp[i][j-coins[i-1]]; 1 represents including that particular coin
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }

    /*=============   Method 3 [DP] ===== bottom-up version of the above ========================*/
    /*The time and space complexity of the above bottom-up solution remains the same as the memoized
    recursive solution. However, the space complexity can be reduced to O(amount) using the simplified algorithm below:
    */
    public static int coinChangeTotalWaysDPEasy(int[] coins, int amount)
    {
        int dp[] = new int[amount+1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }



    public static void main(String[] args) {
        int[] coins = {3,6};
        System.out.println(coinChangeTotalWaysRecursionSimple(coins, 12));
        System.out.println(coinChangeTotalWaysRecursion(coins, 12));
        System.out.println(coinChangeTotalWaysMemoization(coins, 12));
        System.out.println(coinChangeTotalWaysDP(coins, 12));
        System.out.println(coinChangeTotalWaysDPEasy(coins, 12));
    }
}
