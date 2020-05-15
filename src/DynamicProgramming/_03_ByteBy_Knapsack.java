/**
 * [ DP_03 ] [ Knapsack ]
 * __________________________________________________________________________________________________________
 Given a list of items with weights and price, as well as a maximum bag capacity = K ,
 find the combination of items with the greatest value where the sum of the
 weights is less than the maximum weight.
 eg.
    Item 1 = (weight:2kg, Price:6$),
    Item 2= (weight:2kg, Price:10$),
    Item 3= (weight:3kg, Price: 12$)
 max bag weight capacity  = 5 Kg

 e.g: bagCapacity =5 , which items will you carry to market to sell to get the maximum profit
 o/p = item2 +item3 ==> totalWight =5 kg with 22$

 */
package DynamicProgramming;
public class _03_ByteBy_Knapsack {

    public static int knapsack(Items[] totalItems, int bagCapacity){
        //we are considering cases of 0/0 too, zero size bag zero totalItems
        int[][] dp = new int[totalItems.length + 1][bagCapacity+1];
        //now we will fill the dp with bottom up approach
        /*Logic is: a. find weight including the current item
        *           b. find weight excluding the current its
        *           max of (a,b)  */

        for(int itmNum =1 ; itmNum <=totalItems.length ; itmNum++){
            for(int bCap =1; bCap <= bagCapacity; bCap++){
                //base cases : suppose cap = 3 and your bag already have a item with weight 2
                // and next item wight is 5. so, in this cases bag can have max weight 3 only.
                // we can get that value from above cell of dp
                if(totalItems[itmNum-1].wight > bCap){
                    dp[itmNum][bCap]=dp[itmNum-1][bCap];
                }else{
                    //WeightAfterIncludingCurrentItem =  previous price + current item price
                    int priceAfterIncludingCurrentItem = dp[itmNum-1][bCap-totalItems[itmNum-1].wight]
                            + totalItems[itmNum-1].price;

                    //priceExcludingCurrentItem = maxPrice calculated till now for the current capacity bag
                    int priceWithoutIncludingCurrentItem = dp[itmNum-1][bCap];

                    //so the current max price is max of above two
                    dp[itmNum][bCap] = Math.max(priceAfterIncludingCurrentItem, priceWithoutIncludingCurrentItem);
                }
            }
        }
        return dp[totalItems.length][bagCapacity];
    }


    public static void main(String[] args) {
        Items item1 = new Items(2, 6);
        Items item2 = new Items(2, 10);
        Items item3 = new Items(3, 12);
        Items[] items = new Items[]{item1, item2, item3};

        System.out.println(knapsack(items, 5));
    }
}

class Items {
    int wight;
    int price;

    public Items(int wight, int price) {
        this.wight = wight;
        this.price = price;
    }
}
