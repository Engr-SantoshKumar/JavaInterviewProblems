package leetCodeProblems;

public class recursiveFictorial {

	public static void main(String[] args) {
		System.out.println(factorical(5));

	}
	
	static int factorical (int x) {
		
		if (x==0)
			return 1;
		
		else return x*factorical(x-1);
		
	}
	

}
