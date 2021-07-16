/* [ _FastAndSlowPointer_02_ ] [ Remove Duplicates from Sorted List ]
_______________________________________________________________________________
Given the head of a sorted linked list, delete all duplicates such that each element
appears only once. Return the linked list sorted as well.

Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.NodeLinkList;
public class _FastAndSlowPointer_02_Remove_Duplicates_From_Sorted_List {

    public static NodeLinkList removeDuplicatesFromSortedLL(NodeLinkList head){
        NodeLinkList current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Integer[] a = {1, 1, 1, 2, 3, 4, 4,4, 4,4, 4};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        NodeLinkList headA = list1.getHead();
        LinkedList.printList(removeDuplicatesFromSortedLL(headA));
    }

}
