/* [ _K_Way_Merge_02_ ] [ 23. Merge k Sorted Lists ]
_______________________________________________________________________________
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
*/

package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.ListNode;
import java.util.PriorityQueue;
import java.util.Queue;

public class _K_Way_Merge_02_Merge_K_Sorted_Lists {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        //pq for sorting the node in accenting order
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        //load the nodes to pq
        for(ListNode node : lists){
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
        Integer[] a = {2, 3, 7, 8, 9};
        Integer[] b = {1, 1, 6, 10};
        Integer[] c = {0, 1, 12, 13};

        LinkedList<Number> list1 = new LinkedList<Number>(a);
        LinkedList<Number> list2 = new LinkedList<Number>(b);
        LinkedList<Number> list3= new LinkedList<Number>(c);
        ListNode headA = list1.getHead();
        ListNode headB = list2.getHead();
        ListNode headC = list3.getHead();
        ListNode[] lists = new ListNode[]{headA, headB, headC};

        LinkedList.printList(mergeKLists(lists));
    }
}