/*
 * [23 c ] [Merge k sorted linked lists and return it as one sorted list]
-----------------------------------------------------------------------------------------------------
 Optimize Approach 2 by Priority Queue
 Time complexity : O(Nlog k) where k is the number of linked lists.

 The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue.
 But finding the node with the smallest value just costs O(1)O(1) time.
 There are NN nodes in the final linked list.
 */
package PrepSetOne;

import PrepSetOne.LinkedList.NodeLinkList;

import java.util.PriorityQueue;

public class _Goo_23_c_Merge_K_Sorted_LinkedList {

    public static NodeLinkList mergeKLists(NodeLinkList[] heads) {

        // some pre checks
        if(heads==null || heads.length==0)  return null;

        // create a PQ with linkList node Comparator
        PriorityQueue<NodeLinkList> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        NodeLinkList resultHead = null; //--head of result LL ..will return this
        NodeLinkList currentNode = null; //traveling node in result linkedlist

        // Step 1: Insert all K heads into PQ
        for(int i =0; i <heads.length; i++){
            if(heads[i]!=null){
                pq.offer(heads[i]);
            }
        }

        // Step 2: remove the node from pq add to result and also if removed node has next node, add next node to PQ
        while(!pq.isEmpty()){
            NodeLinkList curNode = pq.poll();

            // add the above node to result
            if(resultHead == null){ // this is just for first time
                resultHead = curNode;
                currentNode = curNode; // keep the track of last added node position of result LL so that
                                    // we don't need to traverse all the way to last to add new incoming node
            }else{
                currentNode.next=curNode;
                currentNode = currentNode.next;
            }
            //add next List Node to priority queue
            if(curNode.next!=null){
                pq.offer(curNode.next);
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
