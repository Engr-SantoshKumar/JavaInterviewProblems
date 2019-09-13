package leetCodeProblems;

public class recursiveFibonacci {

	public static void main(String[] args) {
		int x=10;
		for(int i=0; i<=x; i++) {
		System.out.print(fibonacci(i)+" ");
		}
	}
	
	static int fibonacci(int x) {
		//System.out.println("fibonacci current call "+ x);
		if(x==0)
			return 0;
		else if(x==1)
			return 1;
		else
			return(fibonacci(x-1)+fibonacci(x-2));
		
		
	}

}
