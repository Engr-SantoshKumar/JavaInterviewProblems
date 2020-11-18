/* [ _oA_41_ ] [ Merge k Sorted Lists  ]
_______________________________________________________________________________
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
  1->4->5,
  1->3->4,
  2->6
merging them into one sorted list:
1->1->2->3->4->4->5->6
*/
package Code_Run_Build_LC350;

import java.util.PriorityQueue;
import java.util.Queue;
import Code_Run_Build_LC350.LinkedList.NodeLinkList;
public class _oA_41_Merge_k_Sorted_Lists {
    public static NodeLinkList mergeKLists(NodeLinkList[] lists) {
        NodeLinkList head = new NodeLinkList(0);
        NodeLinkList current = head;

        //pq for sorting the node in accenting order
        Queue<NodeLinkList> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        //load the nodes to pq
        for(NodeLinkList node : lists){
            if(node!=null)
                pq.offer(node);
        }
        //now keep refreshing the pq with next node of the pulled out node
        while(!pq.isEmpty()){
            current.next = pq.poll();
            current = current.next;
            if(current.next!=null)
                pq.offer(current.next);
        }
        return head.next;
    }
    public static void main(String[] args) {

        Integer[] a = {1, 2, 4, 5, 7, 8};
        Integer[] b = {1, 3, 4, 7, 10};
        Integer[] c = {4, 5, 11, 12};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        NodeLinkList head1 = list1.getHead();
        LinkedList<Number> list2 = new LinkedList<Number>(b);
        NodeLinkList head2 = list2.getHead();
        LinkedList<Number> list3 = new LinkedList<Number>(c);
        NodeLinkList head3 = list3.getHead();

        NodeLinkList[] lists = new NodeLinkList[] {head1, head2, head3};
        NodeLinkList result =mergeKLists(lists);
        LinkedList.printList(result);
    }

}
