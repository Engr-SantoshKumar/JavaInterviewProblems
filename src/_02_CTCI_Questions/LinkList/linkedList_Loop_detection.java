package _02_CTCI_Questions.LinkList;


public class linkedList_Loop_detection {
	
	public static Node head = null;
	public static class Node{
		int data;
		Node next;
			public  Node(int node){
				data=node;
				next= null;
			}
	}
	
	public static void isLoop(Node head){
		Node fast= head;
		Node slow = head;
		boolean flag = false;
		while(slow!=null && fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
				if(slow==fast){
					System.out.println("found loop");
					flag = true;
					break;
				}
		}
		if(!flag){
			System.out.println("there is no loop");
		}
		
			
	}
	
	
	public static void main(String[] args) {
		
		head = new Node(1);
		head.next= new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next = head.next.next.next;
		isLoop(head);



	}	
	
	
	

}
