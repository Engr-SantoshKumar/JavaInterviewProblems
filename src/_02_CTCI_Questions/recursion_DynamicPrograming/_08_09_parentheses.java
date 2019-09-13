package _02_CTCI_Questions.recursion_DynamicPrograming;

public class _08_09_parentheses {
		
	static void makeParan(int left, int right, String result){
		if(left ==0 && right==0){
			System.out.println(result);
			return;
		}
		
		// since above we are checking both l & r are 0 not individuals
		if(left > 0){ 	
			makeParan(left-1, right,result+ "(" );
		}       
		if(right > left && right > 0){
			makeParan(left, right-1,result+ ")" );
		}
		        
	}
		
	public static void main(String[] args) {
			makeParan(3, 3, "");

			}
		
}


