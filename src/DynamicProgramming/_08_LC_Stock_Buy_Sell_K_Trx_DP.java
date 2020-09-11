/**
 * [ 21 ] [ DP- Maximum profit by buying and selling a share at most k times ]
 ________________________________________________________________________________________________________________
 In share trading, a buyer buys shares and sells on a future date. Given the stock price of n days,
 the trader is allowed to make at most k transactions, where a new transaction can only start after the
 previous transaction is complete, find out the maximum profit that a share trader could have made.
 Examples:

 Input:
 Price = [10, 22, 5, 75, 65, 80]
 K = 2
 Output:  87
 Trader earns 87 as sum of 12 and 75
 Buy at price 10, sell at 22, buy at
 5 and sell at 80

 Logic: Maximum profit gained by selling on ith day. In order to sell shares on ith day,
 we need to purchase it on any one of [0, i – 1] days. If we buy shares on jth day and sell it on ith day,
 max profit will be price[i] – price[j] + profit[t-1][j] where j varies from 0 to i-1.
 Here profit[t-1][j] is best we could have done with one less transaction till jth day.

 */
package DynamicProgramming;
public class _08_LC_Stock_Buy_Sell_K_Trx_DP {

    public static int maxProfitWithKTransactions(int[] prices, int days, int k){

        //table to store results of profit[K->trx][days]
        int[][] profit = new int[k+1][days+1];

        // For day 0, profit is 0
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        // profit is 0 if we don't do any transation (i.e. k =0)
        for (int j = 1; j <= days; j++)
            profit[0][j] = 0;

        for(int d =1; d<=k; d++){
            int maxSoFar = Integer.MIN_VALUE;
            for(int t=1; t<days; t++){

                // max of --> (current max what we have, [profit at t-1 trx, day -1 ] - price at d-1
                maxSoFar = Math.max(maxSoFar, profit[d-1][t-1] - prices[t-1]);
                // max of ( dont sell at all at this price i.e previous day profit , today's price+maxSoFar
                profit[d][t] = Math.max(profit[d][t-1], maxSoFar+prices[t]);
            }
        }

        return profit[k][days-1];
    }

    public static void main (String[] args) {
        int k = 3;
        int price[] = {12, 14, 17, 10, 14, 13, 12, 15};

        int n = price.length;

        System.out.println("Maximum profit is: " +
                maxProfitWithKTransactions(price, n, k));
    }
}


