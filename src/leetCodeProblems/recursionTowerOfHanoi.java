package leetCodeProblems;

public class recursionTowerOfHanoi {

	public static void tower(int noOfDisk, char start, char temp, char end) {
		
		if (noOfDisk ==1) {
			System.out.println("Disk "+noOfDisk+ " from "+ start +" to "+ end);
			i++;
		}
			
		else { tower(noOfDisk-1, start, end, temp);
			System.out.println("Disk "+noOfDisk+ " from "+ start +" to "+ end);
			i++;
			tower(noOfDisk-1, temp, start, end);
		}
		
		
	}

	
	static int i=0;
	public static void main(String[] args) {
		tower(10, 'A', 'B', 'C');
		System.out.println(i);
	}
	
	

}
