package _02_CTCI_Questions.recursion_DynamicPrograming;

public class biggestLostInTrading {
	
	static void maxLost(int [] stocksPrice){
		
		if(stocksPrice.length < 2) {
			System.out.println("minimum two trx");
			return;
		}
		
		int highestBuy = stocksPrice[0]; 
		int maxLost = stocksPrice[1] - highestBuy;
		
		//these variables required to print buy & sell price 
		int buyAT = 0, sellAT =0;
		
		for(int i = 1 ; i < stocksPrice.length; i++){
			 
			int currentPrice = stocksPrice[i];  
			int currentLost = currentPrice - highestBuy;
			highestBuy = Math.max(highestBuy, currentPrice);
			//maxLost = Math.min(maxLost, currentLost);
			// to print at what price to buy & sell 
			if(maxLost > currentLost){
				maxLost = currentLost;
				buyAT = highestBuy;
				sellAT = currentPrice;		
			}
		}
		System.out.println("buyAT: " + buyAT  + " &  sellAT: " + sellAT + " maxLost : " + maxLost);
		
	}
	
	public static void main(String[] args) {
		int [] stocksPrice = { 6, 5, 8, 2, 4, 7, 1, 3};
		maxLost(stocksPrice);

	}

}
