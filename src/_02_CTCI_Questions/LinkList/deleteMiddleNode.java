/* copy the target.next Node to temp Node
 * replace the target node data with temp node data
 * delete the target.next node --> target.next = target.next.next
 * 
 */


package _02_CTCI_Questions.LinkList;


public class deleteMiddleNode {
	
	public static Node head =null;
	
	public static class Node{
		int data;
		Node next;
		public Node(int d){
			data =d;
			next=null;
			
		}
		
	}
	
	public static Boolean removeMiddleNode(Node n){
		if (n == null || n.next == null) {
			System.out.println("This is an EDGE Node");
			return false; // Failure
		}

		Node current = n;
        Node previous = current;
		Node runner = n.next.next;

		while(runner!=null){
		    previous = current;
		    current = current.next;
		    runner = runner.next;
		    if(runner!=null){
		        runner = runner.next;
            }
		}
        System.out.println("\n\nDelete mid node : " + previous.next.data);
        previous.next = previous.next.next;
		return true;
	}
	
	public static void displayList(Node head){
		
		Node current = head;
		while(current!=null){
			System.out.print(current.data);
			System.out.print(" -> ");
			current=current.next;
		}
	}
	
	
	public static void main(String[] args) {
		
		head = new Node(1);
		head.next= new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		//head.next.next.next.next.next.next.next = new Node(8);
		
		displayList(head);
		
		removeMiddleNode(head.next.next.next.next.next.next.next);
		System.out.println();
		displayList(head);
		removeMiddleNode(head);
		System.out.println();
		displayList(head);

	}



}
