package _02_CTCI_Questions.recursion_DynamicPrograming;

public class biggestProfit {
	
	static int maxProfit(int [] stockPrice){
		
		if(stockPrice.length < 2) return -1;
		
		int minPrice = stockPrice[0];
		int maxProfit = stockPrice[1] - stockPrice[0];
		
		System.out.println("minPrice: "+ minPrice + "  maxProfit" + maxProfit );
		
		for(int i=1; i<stockPrice.length; i++){
			int currentPrice = stockPrice[i];
			int currentGain = currentPrice - minPrice;
			maxProfit = Math.max(maxProfit, currentGain);
			minPrice = Math.min(minPrice, currentPrice);
			
			System.out.println("currentPrice : "+ currentPrice + "   minPrice : " + minPrice + "  maxProfit : "+ maxProfit  + "   currentGain : " + currentGain);
		}
		
		
		return maxProfit;
	}

	public static void main(String[] args) {
		int [] stocksPrice = { 6, 5, 8, 2, 4, 7, 1, 3};
		System.out.println(maxProfit(stocksPrice));
	}

}
