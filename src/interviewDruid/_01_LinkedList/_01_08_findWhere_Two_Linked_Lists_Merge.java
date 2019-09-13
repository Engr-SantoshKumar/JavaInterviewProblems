package interviewDruid._01_LinkedList;


public class _01_08_findWhere_Two_Linked_Lists_Merge {
	
	static node head1 = null;
	static node head2 = null;
	
	static int findLength(node head){
		int length =0;
		node current = head;
		while(current.next != null){			
			current = current.next;
			length++;
		}		
		return length;		
	}
	
	static node findMergePoint(node head1, node head2){
		/*Find the length of the two linked lists*/
	    int length1 = findLength(head1);
	    int length2 = findLength(head2);
	    node n1, n2;
	 
	    /*store head of the longer linked list in n1 and head of 
	    shorter linked list in n2*/
	    if (length1 >= length2) {
	        n1 = head1;
	        n2 = head2;
	    } else {
	        n1 = head2;
	        n2 = head1;
	    }
	 
	    /*Find the difference in length of the two linked lists. Then advance
	    n1 by the difference*/
	    int diff = Math.abs(length1 - length2);
	    while (diff > 0) {
	        n1 = n1.next;
	        --diff;
	    }
	 
	    /*Go on comparing the nodes in linked list1 starting from n1 and
	    linked list2 starting from n2 till n1 and n2 match*/
	    while (n1 != null && n2 != null && n1.data != n2.data) {	    	
	        n1 = n1.next;
	        n2 = n2.next;
	    }
	 
	    /*n1 will have the common node if it exists, otherwise n1 will be null*/
	    return n1;
	}
	
	
	
	public static void main(String[] args) {
		head1 = new node('A');
		head1.next = new node('B');
		head1.next.next = new node('C');
		head1.next.next.next = new node('X');
		head1.next.next.next.next = new node('Y');
		head1.next.next.next.next.next = new node('Z');
		
		head2 = new node('D');
		head2.next = new node('E');
		head2.next.next = new node('F');
		head2.next.next.next = new node('G');
		head2.next.next.next.next = new node('X');
		head2.next.next.next.next.next = new node('Y');
		head2.next.next.next.next.next.next = new node('Z');
		
		printList(head1);
		System.out.println();
		printList(head2);
		System.out.println();
		node x = findMergePoint(head1, head2);
		System.out.println(x.data);
		
		
	}
	
	public static class node{
		char data;
		node next;
		node(char value){
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

