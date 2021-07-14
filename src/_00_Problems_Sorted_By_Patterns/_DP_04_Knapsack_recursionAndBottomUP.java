/* [_DP_04_ ] [ Knapsack (medium) recursion --GrookingProblem  ]
_______________________________________________________________________________
Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’.
The goal is to get the maximum profit out of the items in the knapsack. Each item can only be selected once,
as we don’t have multiple quantities of any item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit.
Here are the weights and profits of the fruits:

Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5

Let’s try to put various combinations of fruits in the knapsack, such that their total weight is not more than 5:

Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit --> best combination as it gives us the maximum profit
                                                    and the total weight does not exceed the capacity.

Logic: this solve this kind of problem
for each item i
 |      |--> create a new set which INCLUDES item i, if total weight does not exceed the capacity, and recursively process
 |      |        the remaining items i and capacity
 |      |--> create a new set WITHOUT item i, and recursively process the remaining items
 |
 |-->Return the set from above two sets with higher profit.

*/
package _00_Problems_Sorted_By_Patterns;
public class _DP_04_Knapsack_recursionAndBottomUP {
    public static int solveKnapsack(int[] profit, int[] weight, int capacity){
        return knapsackRecursion(profit, weight, capacity, 0);
    }

    private static int knapsackRecursion(int[] profit, int[] weight, int capacity, int curIdx) {
        //base case
        if(capacity <=0 || curIdx >= profit.length) return 0;

        int profitWith =0;
        //WITH: if we can include current item then Include
        if(weight[curIdx] <= capacity)
            profitWith = profit[curIdx] + knapsackRecursion(profit, weight, capacity-weight[curIdx], curIdx + 1);
        //WITHOUT
        int profitWithout = knapsackRecursion(profit, weight, capacity, curIdx + 1);

        return Math.max(profitWith, profitWithout);
    }
    public static void main(String[] args) {

        int[] weight = new int[]{2, 3, 1, 4 };
        int[] profit = new int[]{4, 5, 3, 7 };
        int capacity = 5;
        System.out.println(solveKnapsack(profit, weight, capacity));
        System.out.println(solveKnapsackTopDown(profit, weight, capacity));
    }

    //Top-down Dynamic Programming with Memoization
    /**
     Since we have two changing values (capacity and currentIndex) in our recursive function knapsackRecursive(),
     we can use a two-dimensional array to store the results of all the solved sub-problems.
     As mentioned above, we need to store results for every sub-array (i.e. for every possible index ‘i’)
     and for every possible capacity ‘c’.
     */

    public static int solveKnapsackTopDown(int[] profit, int[] weight, int capacity){
        Integer[][] dp = new Integer[profit.length][capacity+1];
        return knapsackRecursionTopDown(profit, weight, capacity, 0, dp);
    }

    private static int knapsackRecursionTopDown(int[] profit, int[] weight, int capacity, int curIndex, Integer[][] dp) {
        //base case
        if(capacity <=0 || curIndex >= profit.length) return 0;

        //if we have already solved the similar problem get the result from memory
        if(dp[curIndex][capacity]!=null){
            return dp[curIndex][capacity];
        }

        int profitWith =0;
        //WITH: if we can include current item then Include
        if(weight[curIndex] <= capacity)
            profitWith = profit[curIndex] + knapsackRecursion(profit, weight, capacity-weight[curIndex], curIndex + 1);
        //WITHOUT
        int profitWithout = knapsackRecursion(profit, weight, capacity, curIndex + 1);

        dp[curIndex][capacity] = Math.max(profitWith, profitWithout);
        return dp[curIndex][capacity];
    }
}
