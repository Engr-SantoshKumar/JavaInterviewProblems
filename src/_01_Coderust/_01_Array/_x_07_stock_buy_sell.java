package _01_Coderust._01_Array;

//Kadane's algorithm.
//https://www.youtube.com/watch?v=86CQq3pKSUw

/*There is a tricky linear solution of this problem that requires maintaining
current buy price (which is the smallest number seen so far), current profit and
global max profit as we iterate through the entire array of stock prices. At each iteration,
we will compare the current profit with the global profit and update the global profit accordingly.
*/

public class _x_07_stock_buy_sell {

static void find_buy_sell_stock_prices(int[] array){
    if(array == null || array.length < 2) {
        System.out.println("min two trx");;
    }

    int buy = array[0];
    int sell = array[1];
    int global_profit = sell-buy;
    int current_profit = Integer.MIN_VALUE;

    for(int i=1; i<array.length; i++){

        current_profit = array[i] - buy;
        // if current profit is grater than global profit update it and update the sell too
        if(current_profit > global_profit){
            global_profit = current_profit;
            sell = array[i];
        }
        // keep updating buy if current price is smaller than previous buy
        if(array[i] < buy){
            buy = array[i];
        }
    }
    System.out.println(String.format("Buy Price: %d Sell Price: %d", (sell - global_profit), sell));

}
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 3, 2, 1, 2, 5 };
        find_buy_sell_stock_prices(array);

        int[] array2 = {12,5,9,19,8};
        find_buy_sell_stock_prices(array2);

        int[] array3 = {20, 19, 18, 16, 12, 9};
        find_buy_sell_stock_prices(array3);
    }

}

