package _02_CTCI_Questions.recursion_DynamicPrograming;

public class _08_01_TrepleSteps {

	
	// Recursion way of solving 
	int TripleSteps_Recursion(int n){
		
		if (n < 0) return 0;
		if (n == 0) return 1;
		
		int countWay = TripleSteps_Recursion(n-3) + TripleSteps_Recursion(n-2) + TripleSteps_Recursion(n-1);
		return countWay;
	}
	
	// Memoization/ dynamic programming solution 
	int TripleSteps_Memoization(int steps){
		if(steps == 0) return 1;
		 else if(steps == 1) return 1;
		 else if(steps == 2) return 2; // i.e. (1,1)(2) 
		 int[] arr = new int[steps]; // create an array and assign first base condn
		 arr[0] = 1;
		 arr[1] = 1;
		 arr[2] = 2;
		 
		 for(int j =3; j<steps; j++){ // work on remaining numbers
			 arr[j] = arr[j-3] + arr[j-2] + arr[j-1];
		 }
		 return arr[steps-1]+arr[steps-2]+arr[steps-3]; // return the sum of last three elements (steps) of an array
	 }
	
	public static void main(String[] args) {
		
		_08_01_TrepleSteps stp = new _08_01_TrepleSteps();
		System.out.println(stp.TripleSteps_Recursion(10));
		System.out.println(stp.TripleSteps_Memoization(10));
		
		
	}

}
