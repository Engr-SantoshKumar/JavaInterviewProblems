/* [ DP_07_ ] [ Knapsack unbounded ]
_______________________________________________________________________________
A simple idea is to consider all possible sequence of items that have a total weight not more than ‘W’ and find the subset which gives maximum profit.

For any item at index ‘i’ there will be two choices - either we include the item at least once or we do not include the item.
If we do not include the item, we will recursively solve for ‘N-1’ items and knapsack capacity ‘W’.
If we include the item, we will recursively solve for ‘N’ items and capacity = ‘W - weight of Nth item’ and add profit of ‘ N-th’ item to its result as we have included that.
As we can use any item multiple times, so after including ‘N-th’ item we will still solve for ‘N’ items.
The maximum value obtained from all these recursive calls will be the required profit.

Algorithm

Let UNBOUNDED_KNAPSACK( N, W, PROFIT, WEIGHT ) be our recursive function.
If no item is left or the capacity of the knapsack is 0 i.e. If ( ‘N’ = 0 or ‘W’ = 0), return 0.
If 'WEIGHT[ N - 1]' > ‘W’  i.e if the weight of the Nth item is greater than the knapsack capacity, we can not include the N-th item.
Therefore return UNBOUNDED_KNAPSACK( N - 1, W, PROFIT, WEIGHT ).
Otherwise, return maximum of the following two values
If ‘N’-th item is included
‘PROFIT’ [ N  - 1 ] + UNBOUNDED_KNAPSACK( N, W - WEIGHT [ N - 1 ] , PROFIT, WEIGHT )
If N-th item is not included
UNBOUNDED_KNAPSACK( N - 1, W, PROFIT, WEIGHT ).
*/
package _00_Problems_Sorted_By_Patterns;
public class _DP_07_Knapsack_Unbounded_Bruteforce_Memoization_DP {

    /* ===================    Method 1   Recursion BruteForce  ======================================
           ● Time complexity is O(2n)
               ○ Branching factor is 2
               ○ Height is n
           ● Space complexity is O(n)
     */
    public static int knapsackRecursion(int[] profit, int[] weight, int capacity){
        return knapsackRecursionHelper(profit, weight, capacity, 0);
    }

    private static int knapsackRecursionHelper(int[] profit, int[] weight, int capacity, int curIdx) {
        //base case: If no item is left or the capacity of the knapsack is 0 i.e. If ( ‘capacity’ = 0 or weight = 0)
        if (capacity <= 0 || curIdx >= profit.length) return 0;

        //Exclude
        int profitWithout = knapsackRecursionHelper(profit, weight, capacity, curIdx + 1);

        //Include: If we include the item, we will recursively solve for ‘N’ items and capacity = ‘W - weight of Nth item’
        // and add profit of ‘ N-th’ item to its result as we have included that.
        //As we can use any item multiple times, so after including ‘N-th’ item we will still solve for ‘N’ items.
        int profitWith = 0;
        if (weight[curIdx] <= capacity)
            profitWith = profit[curIdx] +
                    knapsackRecursionHelper(profit, weight, capacity - weight[curIdx], curIdx);
        return Math.max(profitWith, profitWithout);
    }
    /* ===================    Method 2   Memoization  ======================================
                ● Time complexity is O(n * W)
                ● Space complexity is O(n * W)
     */

    public static int KnapsackMemoization(int[] profit, int[] weight, int capacity){
        Integer[][] dp = new Integer[profit.length][capacity+1];
        return knapsackTopDownHelper(profit, weight, capacity, 0, dp);
    }

    private static int knapsackTopDownHelper(int[] profit, int[] weight, int capacity, int curIndex, Integer[][] dp) {
        //base case
        if(capacity <=0 || curIndex >= profit.length) return 0;

        //if we have already solved the similar problem get the result from memory
        if(dp[curIndex][capacity]!=null){
            return dp[curIndex][capacity];
        }

        int profitWith =0;
        //WITH: if we can include current item then Include
        if(weight[curIndex] <= capacity)
            profitWith = profit[curIndex] +
                    knapsackTopDownHelper(profit, weight, capacity-weight[curIndex], curIndex, dp);
        //WITHOUT
        int profitWithout = knapsackTopDownHelper(profit, weight, capacity, curIndex + 1, dp);

        dp[curIndex][capacity] = Math.max(profitWith, profitWithout);
        return dp[curIndex][capacity];
    }


    /* ===================    Method 3   DP ===================================================
                ● Time complexity is O(n * W)
                ● Space complexity is O(n * W)

      Logic: Turn around the solution
                ● Flip around the subproblem definition
                    ○ knapsack(W, i) is the maximum value of the first i items (items from 0 to i) that weigh less
                    than W
                ● Base cases
                    ○ W == 0. No weight means no value
                    ○ i == 0. No items means no value
      */

    public static int knapsackDP(int[] profits, int[] weight, int capacity) {
        //base check
        if (capacity <= 0 || profits.length == 0 || weight.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        //populate the capacity =0 column, profit =0, with no capacity--> profit is zero
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;               //--> filling the first col zero
        }

        //if we have just one weight (just one item) we will take it if its weight less than capacity
        for (int c = 0; c <= capacity; c++) {
            if (weight[0] <= c)
                dp[0][c] = profits[0];
        }

        //process the subArray with for all the items (i) and all capacity (c)
        //https://youtu.be/xOjtTSNSgZA?t=525
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profitWith = 0;
                int profitWithout = 0;
                //with: include current item if its not more than capacity, we include its profit plus whatever profit
                // we get from the remaining capacity and from remaining items
                if (weight[i] <= c) {
                    profitWith = profits[i] + dp[i][c - weight[i]];
                }
                // Without/Exclude the item at index ‘i’. In this case, we will take whatever profit
                // from the sub-array excluding this item => dp[i-1][c]
                profitWithout = dp[i - 1][c];

                //max
                dp[i][c] = Math.max(profitWith, profitWithout);
            }
        }
        return dp[n - 1][capacity];
    }
    public static void main(String[] args) {

        int[] weight = new int[]{2, 3, 1, 4 };
        int[] profit = new int[]{4, 5, 3, 7 };
        int capacity = 5;
        System.out.println(knapsackRecursion(profit, weight, capacity));
        System.out.println(KnapsackMemoization(profit, weight, capacity));
        System.out.println(knapsackDP(profit, weight, capacity));

    }
}
