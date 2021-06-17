/** 21 [Stock Buy-Sell Two Transactions]
 -------------------------------------------------------------------------------------------------------
Here we're allowed to stock shares at most 2 times. The idea is to use extra space to solve this problem.
We create an auxiliary array profit[] and fill it while performing two scans of the input array which contains
the stock price information for each day.

 1. In the first scan, we update profit[i] Get the maximum profit with only one transaction
    allowed. After this loop, profit[i] contains maximum profit from price[i..n-1] using at most one trans..
 2. Traverse price[] from left to right and update profit[i] such that profit[i] stores maximum profit such
    that profit[i] contains maximum achievable profit from two transactions in subArray price[0..i].
 3. Finally, the last element of profit[] has the result.
 */
package GooPrep;

public class _Goo_21_03_Stock_Maximum_Profit_Two_Transactions {

    public static int maxProfitWithTwoTrx(int[] arr){

        int size = arr.length;
        int[] profit =  new int[arr.length];
        // initialize last element of the auxiliary array to 0, logic if buy-sell at same price, profit =0
        profit[size-1] = 0;
        // to keep track of maximum stock price on the right of current stock price
        int max_price = arr[size - 1];

        // lets fill the array from right to left
        for(int i = size - 2; i >= 0; i-- ){
            // update max stock price seen so far
            /* we can get profit[i] by taking maximum of: Logic is ..buy at current Price and sell at max
               a) previous maximum profit, i.e., profit[i+1]
               b) profit by buying at price[i] and selling at max_price */
            profit[i] = Math.max(profit[i+1], max_price - arr[i]);
            max_price = Math.max(max_price, arr[i]);
        }
        // to keep track of min stock price on the right of current stock price
        int min_price = arr[0];

        //Get the maximum profit with two transactions allowed, After this loop, profit[n-1] contains the result */
        for (int i = 1; i < size; i++){
            // update minimum stock price seen so far
            /* Maximum profit is maximum of(a,b) -->  logic is buy at min price and sell at current
                a) previous maximum, i.e., profit[i-1]
                b) (Buy, Sell) at (min_price, price[i]) and add profit of other trans. stored in profit[i] */
            profit[i] = Math.max (profit[i - 1],
                    (arr[i] - min_price) + profit[i]);

            min_price = Math.min(min_price, arr[i]);
        }
        // the last element of profit[] stores the result
        return profit[size - 1];
}
    public static void main(String[] args) {
        int[] array1 = {10, 22, 5, 75, 65, 80};
        int[] array = { 2, 4, 7, 5, 1, 3, 5 };

        System.out.println(maxProfitWithTwoTrx(array));
    }
}
