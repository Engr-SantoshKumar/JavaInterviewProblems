
package leetCodeProblems;

public class findClosestSmallerAndLargerOfGivenNo {

	public static void main(String[] args) {
		int [] arr = {2,3,1,2,4,3,13,8,10,};
		int x = 6;
		
		NosCloasestToGivenNo(arr, x);
		System.out.println();

	}
	
	public static void NosCloasestToGivenNo(int [] arr, int x ){
		
		int floor = Integer.MAX_VALUE;
		int Roof = Integer.MAX_VALUE;
		int floorSideInt = 0; int RoofSideInt = 0;
		
		for(int c: arr){
			if(c<x){
				if(Math.abs(x-c)<floor){
					floorSideInt = c;
					floor = Math.abs(x-c);
				}
			}else{
				if(Math.abs(x-c)<Roof){
					RoofSideInt = c;
					Roof = Math.abs(x-c);
				}
			}
		}

		System.out.println("FloorValuer : "+floorSideInt+" And RoofValue : "+RoofSideInt);
	}

}
