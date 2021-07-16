/* [  ] [ Remove Linked List Elements ]
_______________________________________________________________________________
Given the head of a linked list and an integer val, remove all the nodes of the linked list
that has Node.val == val, and return the new head.

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.NodeLinkList;
public class _FastAndSlowPointer_05_Remove_Linked_List_Elements {

    public static NodeLinkList removeElements(NodeLinkList head, int val) {
        NodeLinkList fakeHead = new NodeLinkList(-1); //imp is the head we need to remove
        fakeHead.next = head;
        NodeLinkList curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.data == val) {
                prev.next = curr.next; // skip current
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
    public static void main(String[] args) {

        Integer[] a = {2, 2, 3, 4, 5, 2, 7, 8, 9, 2};

        LinkedList<Number> list1 = new LinkedList<Number>(a);

        NodeLinkList headA = list1.getHead();

        LinkedList.printList(removeElements(headA, 2));
    }
}
