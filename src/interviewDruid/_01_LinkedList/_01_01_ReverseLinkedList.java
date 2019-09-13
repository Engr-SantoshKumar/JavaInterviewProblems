package interviewDruid._01_LinkedList;


public class _01_01_ReverseLinkedList {
	  static node head = null;
	 
	  static node reverseUsingResursionUsingVariables(node head){
		    node curNode = head;
		    node prevNode = null;
		 
		    while (curNode != null) {
		        /*Store the next node in a temporary variable*/
		        node nextNode = curNode.next;
		 
		        /*Reverse the link */
		        curNode.next = prevNode;
		 
		        /* now move all pointers to next
		         * 1. Update the previous node to the current node  1st pointer 
		        prevNode = curNode;
		 
		        /* 2. Proceed to the next node in the original linked list 2nd pointer, 3rd one nexNode at top */
		        curNode = nextNode;
		    }
		 
		    // Once the linked list has been reversed, prevNode will have the new head. So return it
		    return prevNode;
	  }
	  
	  static node reverseUsingResursionRecursion(node head){
		  node current = head;
						
			if(current.next==null){
				 return current;
			}
			
			node newHead = reverseUsingResursionRecursion(current.next);
			
			current.next.next=current;
			current.next=null;
			
			return newHead;
	  }
	  
	  
	public static void main(String[] args) {
		head = new node(1);
		head.next = new node(2);
		head.next.next = new node(3);
		head.next.next.next = new node(4);
		head.next.next.next.next = new node(5);
		head.next.next.next.next.next = new node(6);
		head.next.next.next.next.next.next = new node(7);
		head.next.next.next.next.next.next.next = new node(8);
 
        System.out.println("Original Linked list ");
        printList(head);
        node newStartingPoint = reverseUsingResursionUsingVariables(head);
        System.out.println("");
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(newStartingPoint);
        System.out.println("Reversed linked list using recursion");
        printList(head);
        node newStartingPoint1 = reverseUsingResursionRecursion(head);
        printList(newStartingPoint1);
	}
	
	public static class node{
		int data;
		node next;
		node(int value){
			this.data = value;
			this.next= null;
			
		}
	}
	// prints content of linked list
	   public static void printList(node node) {
	        while (node != null) {
	            System.out.print(node.data + "->");
	            node = node.next;
	        }
	    }

}
