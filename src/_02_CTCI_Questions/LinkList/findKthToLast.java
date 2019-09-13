

package _02_CTCI_Questions.LinkList;

public class findKthToLast {
	
	public static Node head = null;
		
	public static class Node{
			int data;
			Node next;
			
			public Node(int d){
				data =d;
				next = null;
			}
		}
	
	public  int printKthToLastElementRECURSION(Node head, int k){
		if (head == null)
			return 0;
		int index = printKthToLastElementRECURSION(head.next, k)+1;
		if (index==k){
			System.out.println(k + "th to last node is "+ head.data);
		}
		return index;
		
	}
	
	public int printKthToLastElementUsingIteration (Node head, int k){
		if (head == null) return 0;
			
		Node FirstPointer = head;
		// moving the first pointer k distance apart from head
		while(k > 0){ 
			FirstPointer = FirstPointer.next;
			k--;
		}
		
		Node SecondPointer = head;  // 2nd pointer, starting of head
		
		// now more the both pointer until 1st point reach the end, once the 1st point at end 2nd pointer will be at desire (i.e. Kth elements away from end) 
		while(FirstPointer!=null){
			FirstPointer = FirstPointer.next;
			SecondPointer = SecondPointer.next;
		}
		
		return SecondPointer.data;
		
	}
	
	public static void main(String[] args) {
		findKthToLast Kth = new findKthToLast();	
	head = new Node(1);
	head.next= new Node(2);
	head.next.next = new Node(3);
	head.next.next.next = new Node(4);
	head.next.next.next.next = new Node(5);
	head.next.next.next.next.next = new Node(6);
	head.next.next.next.next.next.next = new Node(7);
	head.next.next.next.next.next.next.next = new Node(8);
	
	Kth.printKthToLastElementRECURSION(head, 3);
	int k = Kth.printKthToLastElementUsingIteration(head, 4);
	System.out.println(k);
}

}
