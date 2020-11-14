/* [ _oA_37 ] [ Remove Nth Node From End of List ]
_______________________________________________________________________________
Given the head of a linked list, remove the nth node from the end of the list and return its head.

1 -> 3 -> 2 -> 6 -> 8 -> 5 -> 9
N = 3
o/p  1 -> 3 -> 2 -> 6 -> 5 -> 9  [8 removed]

*/
package Code_Run_Build_LC350;
import Code_Run_Build_LC350.LinkedList.NodeLinkList;
public class _oA_37_Remove_Nth_Node_From_End_of_List {
    public static NodeLinkList removeNthFromEnd(NodeLinkList head, int n) {
        NodeLinkList newHead = new NodeLinkList(0);
        newHead.next = head;
        NodeLinkList slow = newHead;
        NodeLinkList fast = newHead;

        //Move fast in front so that the gap between slow and fast becomes n
        while(n>0){
            fast = fast.next;
            n--;
        }

        //Move fast to the end, maintaining the gap
        while(fast.next!=null){
            fast = fast.next;
            slow=slow.next;
        }
        //remove the desired node
        slow.next = slow.next.next;
        return newHead.next;
    }
    public static void main(String[] args) {
        Integer[] a = {2, 3, 7, 4, 8, 3, 9};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        NodeLinkList headA = list1.getHead();
        LinkedList.printList(removeNthFromEnd(headA, 3));
    }
}
