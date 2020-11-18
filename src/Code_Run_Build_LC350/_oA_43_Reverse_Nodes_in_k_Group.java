/* [ _0A_43 ] [ Reverse Nodes in k-Group ]
_______________________________________________________________________________
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:
Could you solve the problem in O(1) extra memory space?
You may not alter the values in the list's nodes, only nodes itself may be changed.
*/
package Code_Run_Build_LC350;
import Code_Run_Build_LC350.LinkedList.NodeLinkList;

public class _oA_43_Reverse_Nodes_in_k_Group {
    public static NodeLinkList reverseKGroup(NodeLinkList head, int k){

        if(!checkSize(head, k)) return head;

        NodeLinkList current = head;
        NodeLinkList previous = null;
        NodeLinkList next = null;

        // revers k nodes
        while (k>0) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            k--;
        }
        head.next = reverseKGroup(current, k);
        return previous;
    }

    public static boolean checkSize(NodeLinkList head, int k){
        int size =0;
        NodeLinkList current = head;
        while(current!=null){
            current=current.next;
            size++;
            if(size==k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        NodeLinkList head1 = list1.getHead();
        NodeLinkList result =reverseKGroup(head1, 3);
        LinkedList.printList(result);
    }
}
