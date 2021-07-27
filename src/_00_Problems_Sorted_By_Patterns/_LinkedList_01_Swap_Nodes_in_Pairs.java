/* [  ] [ Swap Nodes in Pairs recursive solution ]
_______________________________________________________________________________
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes. Only nodes itself may be changed.

Input: head = [1,2,3,4]
Output: [2,1,4,3]

*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.ListNode;

public class _LinkedList_01_Swap_Nodes_in_Pairs {

    // recursive approach
    public static ListNode swapPairs(ListNode head) {

        //base cases
        if(head == null || head.next == null) return head;

        // Nodes to be swapped
        ListNode first = head;
        ListNode second = head.next;

        //swap
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }

    //leaner approach
    public static ListNode swapInPairsLeaner(ListNode head){
        //base cases
        if(head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(-1);
        ListNode previous = dummyHead;

        while (head!=null){
            // Nodes to be swapped
            ListNode first = head;
            ListNode second = head.next;
            // Swapping
            previous.next=second;
            first.next = second.next;
            second.next=first;
            // Reinitializing the head and prevNode for next swap
            previous = first;
            head = first.next;//jump
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        Integer[] a = {1, 2, 1, 2, 1, 2, 1, 2};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        ListNode head1 = list1.getHead();
        ListNode result =swapPairs(head1);
        LinkedList.printList(result);
    }


}
