package _02_CTCI_Questions.LinkList;


public class LinkedListBasicOperations {	
	
	public class Node {
		int data;
		Node next;
		public Node(int data){
			this.data= data;
		}
	}
	
//LinkedList Basic Functions 	
		public class LinkedListT{
			Node head;

	/*Adding Node to the end of LinkedList
	 * 1. Check if this is the first element of LinkedList, if yes make it head. 
	 * 2. Travel the linkedList until the next node is null
	 * 3. Assign current.next to data
	 */		
			public void addNodeAtEnd(int data){
				
				if(head == null){
					head = new Node(data);
					return;
				}
					
				Node current = head;
				while(current.next != null){
					current = current.next;
				}
				current.next = new Node(data);
			}
	/*Adding Node to the Start of LinkedList
	 * 1. Create a newHead with data 
	 * 2. point newHead to current head
	 * 3. make newHead a head
	 */
			public void addNodeAtStart(int data){
	
				Node newHead = new Node(data); 
				newHead.next=head;
				head = newHead;
				
			}
		
	/*Deleting Node from the LinkedList
	 * 1. Check if LinkedList is Null
	 * 2. Check if head.data is the data you want to delete, then make head.next = head 
	 * 2. Travel through List and find the node whose next node need to delete,
	 * 3. point the current.next to current.next.next 
	 */		
			public void deleteNode(int data){
				
				if (head == null) return;
				if (head.data == data){
					head = head.next;
					return;
				}
				
				Node current = head;

				while(current.next != null){
					
					if (current.next.data == data ){
						current.next= current.next.next;
						return;
					}
					current=current.next;
				}	
			}
		
	/*Inserting a new Node after the given node in the LinkedList
	 * 1. Check if LinkedList is Null
	 * 2. Allocate the Node & Put in the data
	 * 2. Make next of new Node as next of prev_node,
	 * 3. make next of prev_node as new_node 
	 */	 
			public void insertNodeAfterData(int new_data, Node previous_node){
				Node current = head;
				while(current.next != null){
					if(current==previous_node){
						Node new_node= new Node(new_data);
						new_node.next=previous_node.next;
						current.next=new_node;
						
					}
					
				}
				
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	

}
