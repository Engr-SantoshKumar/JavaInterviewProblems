// https://www.youtube.com/watch?v=3YH0SZYAzOQ
package _02_CTCI_Questions.recursion_DynamicPrograming;


public class _08_06_TowersOfHanoi {
	
	static void move(int disks, String origin, String destination, String buffer){
		if(disks ==1){
			System.out.println("Move disk 1 from  " +  origin + " to  " + destination);
            return;
		}
		/* move top n - 1 disks from origin to buffer, using destination as a buffer. */
		move(disks-1, origin, buffer, destination );
		System.out.println("Move disk " + disks + " from  " +  origin + " to  " + destination);
		/* move top n - 1 disks from buffer to destination, using origin as a buffer. */
		move(disks-1, buffer, destination, origin );
	}
	
	public static void main(String[] args) {

		int disks = 3;
		move(disks, "origin", "destination", "buffer");
			
		}
		
}

