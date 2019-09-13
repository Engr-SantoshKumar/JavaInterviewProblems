/*use two pointers, pl and p2. We place them k nodes apart in the linked list by putting p2 at the beginning and moving pl k nodes into the list. 
 * Then, when we move them at the same pace, pl will hit the end of the linked list after LENGTH - k steps. 
 * At that point, p2 will be LENGTH - k nodes into the list, or k nodes from the end.
 * 
 */

package _02_CTCI_Questions.LinkList;
public class findKthtoLastElementUsingRunnerPointer {
	
	public static Node head =null;
	
	public static class Node{
		int data;
		Node next;
		public Node(int d){
			data =d;
			next=null;
			
		}
		
	}
	
	public static void printKthToLastElementUsingRunner(Node head, int k){
		
		Node p1=head;
		Node p2=head;
		
		for(int i=0; i<k;i++){
			if(p1 == null){
				System.out.println("Linked list is too small");
				break;
				}
			p1=p1.next;
		}
		
		while(p1!=null){
			p1=p1.next;
			p2=p2.next;
		}
		
		System.out.println(k + "th to last node is "+ p2.data);
		
	}
	
	
	public static void main(String[] args) {
		
		head = new Node(1);
		head.next= new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		
		printKthToLastElementUsingRunner(head, 4);

	}

}
