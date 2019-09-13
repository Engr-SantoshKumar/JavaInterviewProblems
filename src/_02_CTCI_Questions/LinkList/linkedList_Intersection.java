/* 1. Get the length of the two lists.
*  2. Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
*  3. Move them together until finding the intersection point, or the end null 
*/

package _02_CTCI_Questions.LinkList;

public class linkedList_Intersection {
	
	public static Node head1, head2;
	//public static Node head2 = null;
	public static class Node{
		int data;
		Node next;
		public Node(int head){
			data=head;
			next =null;
		}
		
	}
	
	public static int findIntersection(Node head1, Node head2){

		int lenA= findSize(head1);
		int lenB= findSize(head2);

/* function to get the intersection point of two linked lists head1 and head2 where head1 has d more nodes than head2 */		
		while (lenA > lenB) {
			head1 = head1.next;
			lenA-- ;
			}
			while (lenA < lenB) {
			head2 = head2.next;
			lenB-- ;
			}

	// find the intersection until end
			while (head1.data != head2.data) {
				head1 = head1.next;
				head2 = head2.next;
				}
			return head1.data;

	}
	
	public static int findSize(Node head){
		int length = 0;
		while (head != null) {
		head = head.next;
		length++;
		}
		return length;
	}

	public static void main(String[] args) {
 
        // creating first linked list
		head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);
 
        // creating second linked list
        head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);
 
        System.out.println("The node of intersection is " + findIntersection(head1, head2));
 

	}

}
