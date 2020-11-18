/* [ _oA_42_ ] [ Swap Nodes in Pairs recursive solution ]
_______________________________________________________________________________
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes. Only nodes itself may be changed.

Input: head = [1,2,3,4]
Output: [2,1,4,3]

*/
package Code_Run_Build_LC350;
import Code_Run_Build_LC350.LinkedList.NodeLinkList;
public class _oA_42_Swap_Nodes_in_Pairs_Recursive {
    // we can also solve with the same logic of reverse in K group
    //_Goo_37_a_Reverse_Nodes_In_K_Group_Recursive

    public static NodeLinkList swapPairs(NodeLinkList head) {

        //base cases
        if(head == null || head.next == null) return head;

        // Nodes to be swapped
        NodeLinkList first = head;
        NodeLinkList second = head.next;

        //swap
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 1, 2, 1, 2, 1, 2};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        LinkedList.NodeLinkList head1 = list1.getHead();
        LinkedList.NodeLinkList result =swapPairs(head1);
        LinkedList.printList(result);
    }

}
