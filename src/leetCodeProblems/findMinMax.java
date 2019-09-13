package leetCodeProblems;

public class findMinMax {

	public static void main(String[] args) {
		int[] givenNumbers = {2 };
		MinMax(givenNumbers);
		
	}
	
	
	
	public static void MinMax(int[] arr) {
		
		int min =arr[0];
		int max= arr[0];
		
		for(int i =0; i<arr.length; i++) {
				if(max<arr[i]) {
					max=arr[i];
					}
				if(min>arr[i]) {
					min=arr[i];
				}
			}
			
			System.out.println("Min : "+ min+ "   Max : "+ max);
		}
}

