package _02_CTCI_Questions.LinkList;

public class reversingLinkedList {
	public static Node head = null; 
	
	 public static class Node{
		 int data;
		 Node next;
		 Node(int d){
			 data =d;
			 next=null;
		 }
	 }
	 
	 public static Node reverseUsingResursion(Node head){ 			//https://www.youtube.com/watch?v=GbQT1zCUmN4
		 Node current = head;
		 			//System.out.println(current.data);
		 if(current.next==null)
			 return current;
		 Node newHead = reverseUsingResursion(current.next);
		 			//System.out.println(newHead.data);
		 current.next.next=current;
		 			//System.out.println(current.next.data);
		 current.next=null;

		 return newHead;
		 
	 }

	// prints content of double linked list
	   public static void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.data + "->");
	            node = node.next;
	        }
	    }
	
	public static void main(String[] args) {
		
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
 
        System.out.println("Original Linked list ");
        printList(head);
        Node newStartingPoint = reverseUsingResursion(head);
        System.out.println("");
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(newStartingPoint);

	}

}
