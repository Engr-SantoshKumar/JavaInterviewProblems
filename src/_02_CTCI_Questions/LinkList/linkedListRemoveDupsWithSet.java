/* make Node current = head and 
 * Create a temporary pointer pointing to null in the start, if the value not in Set it will be equal to current, else it will be erectly behind   
 * the current point
 * make temp.next = current.next to skip the duplicate  
 * 
 */


package _02_CTCI_Questions.LinkList;

import java.util.HashSet;

public class linkedListRemoveDupsWithSet {
	public static Node head = null;
	
	public static class Node{
		int data;
		Node next;
		
		public Node(int d){
			data =d;
			next = null;
		}
	}
	
	public static void removeDupsWithHashSet(Node head){
		Node current = head;
		HashSet<Integer> hSet = new HashSet<Integer>();
		Node previous = null; // step1.  temp point to null in this start 
		while(current!=null){
			if(hSet.contains(current.data)){//step 3. temp is behind 
				previous.next=current.next; // same again 
			}else{
				hSet.add(current.data);
				previous=current;// step2. temp = current
			}
			
			current=current.next;
			
		}
	}
	
	
	public static void displayList(Node head){
		
		Node current = head;
		while(current!=null){
			System.out.println(current.data);
			current=current.next;
		}
	}
	
	public static void main(String args[]){
			
		head = new Node(1);
		head.next= new Node(11);
		head.next.next = new Node(11);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node(11);
		
		displayList(head);
		
		removeDupsWithHashSet(head);
		System.out.println("-------");
		displayList(head);
	
	}
		
}
