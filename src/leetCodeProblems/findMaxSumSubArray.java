package leetCodeProblems;

public class findMaxSumSubArray {

	public static void main(String[] args) {

		int[] v = new int[]{1, 10, -1, 11, 5, -30, -7, 20, 25, -35};
		System.out.println("Sum of largest subarray: " + find_max_sum_sub_array(v));


		int[] v1 = new int[]{-15, -14, -10, -19, -5, -21, -10};
		System.out.println("Sum of largest subarray: " + find_max_sum_sub_array(v1));


		int[] v2 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Sum of largest subarray: " + find_max_sum_sub_array(v2));

	}
	
	public static int find_max_sum_sub_array(int [] A) {
		if (A.length < 1) {
			return 0;
		}

		int curr_max = A[0];
		int global_max = A[0];
		for (int i = 1; i < A.length; ++i) {

			if (curr_max < 0) {
				curr_max = A[i];
				}
			else {
				curr_max += A[i];
			}

			if (global_max < curr_max) {
				global_max = curr_max;
			}
		}

		return global_max;
		
	}

}
