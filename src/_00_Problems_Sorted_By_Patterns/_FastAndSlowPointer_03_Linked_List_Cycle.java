/* [ _FastAndSlow_03_ ] [ Linked List Cycle , Circular Linked List ]
_______________________________________________________________________________
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached
again by continuously following the next pointer. Internally, pos is used to denote the
index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.NodeLinkList;

import java.util.HashSet;

public class _FastAndSlowPointer_03_Linked_List_Cycle {

    public boolean isCircularLLUsingSET(NodeLinkList node){
        NodeLinkList current = node;
        HashSet<NodeLinkList> visited = new HashSet<>();
        while(current!=null){
            if(visited.contains(current)) return true;
            current = current.next;
        }
        return false;
    }

    public boolean isCircularLLUsingSlowFastPointer(NodeLinkList node){
        NodeLinkList slow = node;
        NodeLinkList fast = node.next;

        while(fast!=null || fast.next!=null){
            if(slow==fast) return true;
            slow = slow.next;
            fast=fast.next.next;
        }
        return false;
    }

}
