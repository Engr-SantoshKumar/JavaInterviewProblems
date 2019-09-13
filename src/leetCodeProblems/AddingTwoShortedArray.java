package leetCodeProblems;

public class AddingTwoShortedArray {

	public static void main(String[] args) {
		int [] A= {1,2,4,6};
		int [] B = {3,5,8};
		int [] C = new int[A.length + B.length];
		
		newArray(A, B, C);
		
	}
		
	
		
		static void newArray(int [] A, int [] B, int [] C) {
			
			int i = 0, j = 0, k =0;
			
			while(i<A.length && j<B.length ) {
				
				if (A[i]<B[j]) {
					C[k]+=A[i];
					k++;
					i++;
				}else {
					C[k]+=B[j];
					k++;
					j++;
				}
				
			}
			
			while(i<A.length) {
				C[k]=A[i];
				k++;
				i++;
			}
			
			while(j<B.length) {
				C[k]=B[j];
				k++;
				j++;
			}
			
			for(int a=0; a<C.length; a++)
			System.out.print(C[a]);
			
			
		
	}

	}

	
