/** 21 [Stock Buy-Sell Multiple Transactions]
 -------------------------------------------------------------------------------------------------------
Find the maximum profit by buying and selling multiple times

*/

package PrepSetOne;

public class _Goo_21_01_Stock_Buy_Sell_MaxProfit {

    public static void main(String args[]) {
        int[] ar = new int[]{5, 3, 8, 5, 1, 6};
        System.out.println(profitMultipleTransactions(ar));
    }
    static int profitMultipleTransactions(int[] ar){
        int buy = ar[0];
        int totalProfit=0;
        for(int i=1; i< ar.length; i++){
            int profit = ar[i] - ar[i-1];
            // if profit is more than 0, add to total profit
            if(profit>0){
                totalProfit += profit;
            }
        }
        return totalProfit;
    }
}
