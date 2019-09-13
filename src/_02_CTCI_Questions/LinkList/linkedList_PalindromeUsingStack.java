/* 1. Split the linked list in the middle.
 * 2. Prepare two linked list
 * 3. If odd, ignore the middle node 
 * 4. Reverse second linked list 
 * 5. Compare the two liked list
 */

package _02_CTCI_Questions.LinkList;

import java.util.Stack;

public class linkedList_PalindromeUsingStack {
	
	public static Node head =null;
	
	public static class Node{
		int data;
		Node next;
		public Node(int d){
			data =d;
			next=null;
		}
	}
	
	public static Boolean isPalandromeUsingStack(Node head){
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast!=null && fast.next!=null){
			stack.add(slow.data);
			fast=fast.next.next;
			slow=slow.next;
		
		}
		/* Has odd number of elements, so skip the middle */
		if (fast != null) { 
			slow = slow.next;
		}
		
		/* pull from stack and match with reaming linked list */
		while(slow!=null){
			if(slow.data!=stack.pop().intValue()){
				return false;
			}
			slow=slow.next;
		}
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
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(2);
		//head.next.next.next.next.next.next = new Node(1);

		displayList(head);
		
		System.out.println();
		System.out.println(isPalandromeUsingStack(head));



	}





}
