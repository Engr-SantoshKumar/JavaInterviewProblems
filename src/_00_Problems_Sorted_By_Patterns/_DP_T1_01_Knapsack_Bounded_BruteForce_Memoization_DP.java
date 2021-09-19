/* [ Type1 K-sack 02 ] [ Knapsack Bounded ]
_______________________________________________________________________________
Bottom-up Dynamic Programming #
Let’s try to populate our dp[][] array from the above solution by working in a bottom-up fashion.
Essentially, we want to find the maximum profit for every sub-array and for every possible capacity.
This means that dp[i][c] will represent the maximum knapsack profit for capacity ‘c’ calculated from the first ‘i’ items.

So, for each item at index ‘i’ (0 <= i < items.length) and
                  capacity ‘c’ (0 <= c <= capacity),
      we have two options:
       --> Without/Exclude the item at index ‘i’. In this case, we will take whatever profit
                                 from the sub-array excluding this item => dp[i-1][c]

       --> With/Include the item at index ‘i’ if its weight is not more than the capacity.
                In this case, we include its profit plus whatever profit we get from the
                remaining capacity and from remaining items => profit[i] + dp[i-1][c-weight[i]]
 */

package _00_Problems_Sorted_By_Patterns;
public class _DP_T1_01_Knapsack_Bounded_BruteForce_Memoization_DP {

     /* ===================    Method 1   Recursion BruteForce  ======================================
            ● Time complexity is O(2^n)
                ○ Branching factor is 2
                ○ Height is n
            ● Space complexity is O(n)
      */
     public static int knapsackRecursion(int[] profit, int[] weight, int capacity){
         return knapsackRecursionHelper(profit, weight, capacity, 0);
     }

    private static int knapsackRecursionHelper(int[] profit, int[] weight, int capacity, int curIdx) {
        //base case: if the left capacity is 0 or the there is no items left profit will be 0
        if(capacity <=0 || curIdx >= profit.length) return 0;

        //Exclude
        int profitWithout = knapsackRecursionHelper(profit, weight, capacity, curIdx + 1);

        //Include
        int profitWith =0;
        if(weight[curIdx] <= capacity)
            profitWith = profit[curIdx] + knapsackRecursionHelper(profit, weight, capacity-weight[curIdx], curIdx + 1);

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
            profitWith = profit[curIndex] + knapsackTopDownHelper(profit, weight, capacity-weight[curIndex], curIndex + 1, dp);
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

    public static int knapsackDP(int[] profits, int[] weight, int capacity){
        //base check
        if(capacity <=0 || profits.length==0 || weight.length!=profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity+1];

        //populate the capacity =0 column, profit =0, with no capacity--> profit is zero
        for(int i =0; i < n; i++){
            dp[i][0]=0;               //--> filling the first col zero
        }

        //if we have just one weight (just one item) we will take it if its weight less than capacity
        for(int c=0; c<=capacity; c++){
            if(weight[0] <=c )
                dp[0][c] = profits[0];
        }

        //process the subArray with for all the items (i) and all capacity (c)
        for(int i =1; i < n; i++){
            for(int c=1; c<=capacity; c++){
                int profitWith=0;
                int profitWithout=0;
                //with: include current item if its not more than capacity, we include its profit plus whatever profit
                // we get from the remaining capacity and from remaining items
                if(weight[i] <= c ){
                    profitWith = profits[i] + dp[i-1][c-weight[i]]; // same from recursive program:capacity-weight[curIndex], curIndex + 1
                }
                // Without/Exclude the item at index ‘i’. In this case, we will take whatever profit
                // from the sub-array excluding this item => dp[i-1][c]
                profitWithout = dp[i-1][c];

                //max
                dp[i][c]=Math.max(profitWith, profitWithout);
            }
        }
        return dp[n-1][capacity];
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
