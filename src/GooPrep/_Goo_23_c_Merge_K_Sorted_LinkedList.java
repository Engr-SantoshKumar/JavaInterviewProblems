/**
 * [23 c ] [Merge k sorted linked lists and return it as one sorted list]
-----------------------------------------------------------------------------------------------------
 Optimize Approach 2 by Priority Queue
 Time complexity : O(Nlog k) where k is the number of linked lists.

 The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue.
 But finding the node with the smallest value just costs O(1)O(1) time.
 There are NN nodes in the final linked list.
 */
package GooPrep;

import GooPrep.LinkedList.NodeLinkList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _Goo_23_c_Merge_K_Sorted_LinkedList {

    public static NodeLinkList mergeKLists(NodeLinkList[] heads) {

        // some pre checks
        if(heads==null || heads.length==0)  return null;

        // create a PQ with linklist node Comparator
        PriorityQueue<NodeLinkList> pq = new PriorityQueue<>(new Comparator<NodeLinkList>() {
            @Override
            public int compare(NodeLinkList o1, NodeLinkList o2) {
                return o1.data - o2.data;
            }
        });

        NodeLinkList resultHead = null;
        NodeLinkList currentNode = null;

        // Step 1: Insert all heads into PQ
        for(int i =0; i <heads.length; i++){
            if(heads[i]!=null){
                pq.offer(heads[i]);
            }
        }

        // Step 2: remove the node from pq add to result and also if removed node has next node, add next node to PQ
        while(!pq.isEmpty()){
            NodeLinkList mNode = pq.poll();

            // add the above node to result
            if(resultHead == null){ // this is just for first time
                resultHead = mNode;
                currentNode = mNode;
            }else{
                currentNode.next=mNode;
                currentNode = currentNode.next;
            }
            //add next List Node to priority queue
            if(mNode.next!=null){
                pq.offer(mNode.next);
            }
        }
        return resultHead;
    }

    public static void main(String[] args) {

        Integer[] a = {0, 2, 4, 5, 7, 8};
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
