package leetCodeProblems;
import java.util.PriorityQueue;

public class findNthHighestLowestNo {

	public static void main(String[] args) {
		
		int[] numbers = {1,0,10,11,2,3,4,5,12};
		
		findNthHighest(numbers,4);
		findNthLowest(numbers,5);

	}
	
	public static Integer findNthHighest (int[] nums, int p){
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(p);
		
		for(int i : nums){
			pq.offer(i);
			
			if(pq.size()>p){
				pq.poll();
			}
			System.out.println(pq);
		}
		
		System.out.println(pq.peek());
		return pq.peek();
		
	}
	
	public static Integer findNthLowest (int[] nums, int p){
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i: nums){
			pq.offer(i);
			
				
		}
		
		//System.out.println(pq);
		
		for(int i =1; i <p; i++ ){
			pq.poll();
			//System.out.println(pq);
			}
		
		System.out.println(pq.peek());
		return pq.peek();
		
	}

}
