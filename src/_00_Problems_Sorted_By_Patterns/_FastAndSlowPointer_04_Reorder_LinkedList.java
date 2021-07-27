/* [  ] [ Reorder List ]
_______________________________________________________________________________
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Logic:
       step 1: go to middle point (Point P2)
       step 2: reverse 2nd half (using stack or inPlace)
       step 3: merge take one from head one from P2 and move both
*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.ListNode;
public class _FastAndSlowPointer_04_Reorder_LinkedList {
    public static ListNode reorderList(ListNode head){

        if (head == null || head.next == null) return null;

        // step 1: Find the middle node
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //step 2: Reverse the second half and create the another ll from reversed 2nd half and end the firstHalf
        ListNode head2 = reverse(slow.next);
        slow.next = null; //--> 1st half ends

        //step 3: Intertwine the two halves
        merge(head, head2);     // headOne(1)-->2-->3-->4-->5 //headTwo(9)-->8-->7--6

        return head;
    }

    private static ListNode reverse(ListNode n) {
        ListNode prev = null, cur = n;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev; //--> after reverse previous will be at last and return it. now this will be head of reverse 2nd half
    }

    private static void merge(ListNode head1, ListNode head2) {
        while (head2 != null) {
            ListNode temp = head1.next;
            head1.next = head2;
            head1 = head2; //moving head1 one ahead
            head2 = temp;  //moving head2 one ahead
        }
    }

    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        ListNode headA = list1.getHead();
        LinkedList.printList(reorderList(headA));
    }
}