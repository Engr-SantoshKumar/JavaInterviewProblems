/* Recursion : Recursive algorithms can be very space inefficient. Each recursive call adds a new layer to the stack, which
 *             means that if your algorithm recurses to a depth of n, it uses at least O ( n) memory
 * Top-Down Dynamic Programming (or Memoization or recursion with Memoization) : 
 * 			here we try to eliminate the repeating calculation done in recursion call 
 * 			by saving the calculated result and use it in further down steps
 * Bottom-Up Dynamic Programming: here we are using the logic to calculate the next steps from previous calculated steps (no recursion call)
 * 
 */


package _02_CTCI_Questions.recursion_DynamicPrograming;

public class _00_Basic_Recursion_DynamicPrograming {
    
	// this is normal recursion program 
	int findFibUsingResursion(int i){
		 if (i <= 2){
			 return 1;
		 }
		 int fib = findFibUsingResursion(i-1) + findFibUsingResursion(i-2);
		 return fib; 
	}
	
   //  Memoization : will use the recursion and keep saving its output is array to use further 
	 int findFibUsingMemoization(int [] arr, int i){
		 if (i<=2) return 1;
		 
		 else if (arr[i] != 0){
			 return arr[i];
		 }else {
			 int fib = findFibUsingMemoization( arr, i-1) + findFibUsingMemoization(arr, i-2);
			 arr[i] = fib;
			 return fib;
		 }

	 }
	//Dynamic Programming : 
	 int findFibUsingDynamicPrograming(int i){
		 
		 if(i == 0) return 0;
		 else if(i == 1) return 1;
		 
		 int[] arr = new int[i]; // create an array and assign first base condn
		 arr[0] = 0;
		 arr[1] = 1;
		 
		 for(int j =2; j<i; j++){ // work on remaining numbers
			 arr[j] = arr[j-1] + arr[j-2];
		 }
		 return arr[i-1]+arr[i-2]; // return the sum of last two elements of an array
	 }

	public static void main(String[] args) {
		int [] arr = new int [100] ;
		
		_00_Basic_Recursion_DynamicPrograming rdp = new _00_Basic_Recursion_DynamicPrograming();
		
		long preTime=System.currentTimeMillis();
		System.out.println(rdp.findFibUsingResursion(10));
		long postTime=System.currentTimeMillis();
		System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
		
		preTime=System.currentTimeMillis();
		System.out.println(rdp.findFibUsingMemoization(arr, 10));
		postTime=System.currentTimeMillis();
		System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
		 
		
		preTime=System.currentTimeMillis();
		  System.out.println(rdp.findFibUsingDynamicPrograming(10));
		  postTime=System.currentTimeMillis();
			System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
			 
		  
	}

}
