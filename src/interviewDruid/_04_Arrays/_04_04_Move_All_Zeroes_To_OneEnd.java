package interviewDruid._04_Arrays;

import java.util.Arrays;

public class _04_04_Move_All_Zeroes_To_OneEnd {
	
	static int[] moveZeorsToEnd(int[] arr){
		int len = arr.length;
		int R_pointer = len-1;
		int L_pointer = 0;
		while(L_pointer < R_pointer){
			/*Locate the first zero from the left*/
			while(L_pointer < len && arr[L_pointer] ==0){
				L_pointer++;
			}
			while(R_pointer >=0 && arr[R_pointer]!=0 ){
				R_pointer --;
			}
			
			//Swap the 0 from left side to right side of the array
			if(L_pointer < R_pointer){
				int temp = arr[L_pointer];
				arr[L_pointer] = arr[R_pointer];
				arr[R_pointer] = temp;
			}		
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	
	public static void main(String[] args){
		
		int [] nums = {2, 3, 0, 4, 0, 2, 0};
		System.out.println(moveZeorsToEnd(nums));
	}
	
}
