/**  61 [LinkedList connected Components ]
___________________________________________________________________________________________________________________
Q. Given a list of nodes belonging to some doubly linked list,
 return the # of connected sub-components ("Blocks") defined by those nodes.
 A block is defined as a set of nodes that are all consecutively connected to each other,
 but not to any other nodes outside the block.

 We are given head, the head node of a linked list containing unique integer values.
 We are also given the list G, a subset of the values in the linked list.
 Return the number of connected components in G, where two values are connected if they appear
 consecutively in the linked list.

 e.g.
 linklist --> { 1->2->3->4->5->6->7-8}
 set = {2, 7, 4, 3}
 output is 2 (sets) ==> one {2,3,4} and 2nd {7}
 **/

package PrepSetOne;

import PrepSetOne.LinkedList.NodeLinkList;

import java.util.HashSet;
import java.util.Set;

public class _Goo_62_LinkedList_Connected_Components {

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        LinkedList<Number> mylist = new LinkedList<Number>(a);
        LinkedList.NodeLinkList head = mylist.getHead();
        LinkedList.printList(head);

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(7);
        set.add(4);
        set.add(3);

        System.out.println(connected(mylist, set));
    }

    public static int connected(LinkedList<Number> ll, Set<Integer> hSet){
        int count =0;

        NodeLinkList runningHead = ll.getHead();

        if(runningHead == null || hSet.size()==0) return count;

        while(runningHead != null){
            NodeLinkList startHead = runningHead;

            // check if current runningHead and its next are in set
            // as we need to count all connected as 1 for (2->3->4)
            while(runningHead!=null && hSet.contains(runningHead.data)){
                runningHead = runningHead.next;
            }
            // if the starting runningHead is not equal to currentHead that means
            // we found at least one set from the given set
            if(startHead !=runningHead){
                count++;
            }

            //if the current runningHead in not in the set, update the runningHead
            if(runningHead != null){
                runningHead = runningHead.next;
            }
        }

        return count;
    }

}
