/* 1. Split the linkedList in the middle 
 * 2. Prepare two LinkedList 
 * 3. If odd, ignore the middle node
 * 4. Reverse the second linkedList 
 * 5. compare the linkeList  
 */
package _02_CTCI_Questions.LinkList;
// -> 1 -> 2 -> [3 -> 4] -> 32 -> 2  // 3times fast on null
//-> 1 -> 2 -> 3 -> [4] -> 32 -> 2 ->5 
public class linkedList_PalindromeBySplitingList {
	
	public static Node head = null;
	public static class Node{
		int data;
		Node next;
			public  Node(int node){
				data=node;
				next= null;
			}
	}

	public static Boolean isPalandromeUsingSplitList(Node current){
		Node slow = current;
		Node fast = current;
		Node seconH = null;
		boolean isOdd;
		boolean isEven;
		while(fast != null){
			if(fast.next == null){
				slow = slow.next;
				fast = fast.next.next;
				seconH = slow.next;
				break;
			}
			if(fast.next.next == null){
				slow = slow.next;
				fast = fast.next.next;
				isEven = true;
				seconH = slow.next;
				fast = fast.next;
				break;
				
			}
		}
		
		while(fast.next!=null && fast.next.next!=null ){
			fast= fast.next.next;
			slow=slow.next;
		}
		//System.out.println(fast.data);
		//System.out.println(slow.data);
		
		Node SecondListHead = null;
		
		// isEven
		// middle
		// iterate from middle
		
		
		if(fast!=null && fast.next==null){// odd case
			SecondListHead = slow; // the is the beginning of 2nd half linkedList
		}else {
			SecondListHead = slow.next;
		}
			
		//slow.next=null; // this is the end of 1st half of the linkedLinkst
		System.out.println(" whta is second head.."+SecondListHead.data);
		
		// call reverse list with secondlistHead 
		Node reverseHead = reverselist(SecondListHead);
		System.out.println("1st half of list ");
		displayList(current);
		System.out.println();
		System.out.println("2nd Half of the list");
		displayList(reverseHead);
		System.out.println();
		System.out.println("Is a palandrome list : ");
		return isEqual(current, reverseHead);
		
	}
	
	public static boolean isEqual(Node one, Node two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
	
	public static Node reverselist(Node current){       //nextNod--> current.next--> previous-->current-->next      wow thats a circle 
		Node nextNod = null;
		Node previousNod =null;
		while(current!=null){
			nextNod = current.next;                    
			current.next=previousNod;
			previousNod =current;
			current=nextNod;
		}
		current = previousNod;
		return current;
	}
	
	
	public static void displayList(Node head){
		
		Node current = head;
		while(current!=null){
			System.out.print(" -> "+ current.data);
			current=current.next;
		}
	}
	
	public static void main(String[] args) {
		
		head = new Node(1);
		head.next= new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(32);
		head.next.next.next.next.next = new Node(2);
		//head.next.next.next.next.next.next = new Node(1);
		displayList(head);
		System.out.println();
		System.out.println(isPalandromeUsingSplitList(head));



	}	

}
