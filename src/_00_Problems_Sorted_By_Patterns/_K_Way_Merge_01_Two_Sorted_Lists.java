/* [ _oA_39_ ] [ Merge Two Sorted Lists ]
_______________________________________________________________________________
Merge two sorted linked lists and return it as a new sorted list.
The new list should be made by splicing together the nodes of the first two lists.
Example 1:

Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.ListNode;

public class _K_Way_Merge_01_Two_Sorted_Lists {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode fakeHead = new ListNode(0);
            ListNode current = fakeHead;

            while (l1 != null && l2 != null) {
                if (l1.data <= l2.data) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }
            //one of l1 and l2 can be non-null at this point, attached the remaining if any
            current.next = l1==null? l2:l1;
            return fakeHead.next;
        }

    public static void main(String[] args) {
        Integer[] a = {2, 3, 7, 8, 9};
        Integer[] b = {1, 1, 6, 10};

        LinkedList<Number> list1 = new LinkedList<Number>(a);
        LinkedList<Number> list2 = new LinkedList<Number>(b);
        ListNode headA = list1.getHead();
        ListNode headB = list2.getHead();
        LinkedList.printList(mergeTwoLists(headA, headB));
    }
}

