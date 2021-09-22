/**  21 [max gain and max loss ]
 --------------------------------------------------------------------------------------------------------------
 There is an array of doubles that contains the closing price of a stock for each trading day.
 Write a function that determines the biggest drop in value
 between any two dates and displays the amount of the drop.

 For example, given the array:
 double[] prices = { 21.0, 24.0, 26.0, 25.0, 24.0, 23.0, 24.0, 22.0, 27.0 }
 The function should return 4.0 (the drop from 26.0 to 22.0)
 */
package PrepSetOne;
public class _Goo_21_02_Stock_Price_Max_Profit_Loss_SingleTrx {

    static void findMaxProfit(double[] array){
        if(array == null || array.length < 2) {
            System.out.println("min two trx");;
        }
        double buy = array[0];
        double sell = array[1];
        double global_profit = sell-buy;
        double current_profit;

        for(int i=1; i<array.length; i++){

            current_profit = array[i] - buy;
            // if current profit is grater than global profit update it
            // and update the sell too
            if(current_profit > global_profit)
            {
                global_profit = current_profit;
                sell = array[i];
            }
            // keep updating buy if current price is smaller than previous buy
            if(array[i] < buy){
                buy = array[i];
            }
        }
        System.out.println(String.format( "Buy Price:      " + (sell - global_profit) +
                                        "\nSell Price:     " + sell +
                                        "\nglobal_profit : " + global_profit));
    }
    static void findMaxDrop_Loss(double[] array){
        if(array == null || array.length < 2) {
            System.out.println("min two trx");;
        }

        double buy = array[0];
        double sell = array[1];
        double global_loss = sell-buy;
        double current_sell = Integer.MAX_VALUE;

        for(int i=1; i<array.length; i++){

            current_sell = array[i] - buy;
            // if current profit is grater than global profit update it and update the sell too
            if(current_sell < global_loss){
                global_loss = current_sell;
                sell = array[i];
            }
            // keep updating buy if current price is smaller than previous buy
            if(array[i] > buy){
                buy = array[i];
            }
        }
        System.out.println(String.format( "Buy Price:      " + (sell - global_loss) +
                                        "\nSell Price:     " + sell +
                                        "\nglobal_profit : " + global_loss));
    }
    public static void main(String args[]) {
        double[] prices = {11.0, 24.0, 26.0, 25.0, 24.0, 5.00, 23.0, 24.0, 22.0, 12.0, 1.0, 1.0};
        findMaxProfit(prices);
        System.out.println("\n");
        findMaxDrop_Loss(prices);
    }
}
