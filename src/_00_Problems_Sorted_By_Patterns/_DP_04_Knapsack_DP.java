/* [_DP_04_ ] [ Knapsack (medium) DP ]
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
public class _DP_04_Knapsack_DP {
    public static int solveKnapsack(int[] profits, int[] weight, int capacity){
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
                    profitWith = profits[i] + dp[i-1][c-weight[i]];
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
        System.out.println(solveKnapsack(profit, weight, capacity));
    }

}
