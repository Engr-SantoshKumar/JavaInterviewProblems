/* [ _FastAndSlow_03_ ] [ Linked List Cycle II, circular linked list position  ]
_______________________________________________________________________________
Find the postion where linked list cycle circular linked list start
      0 → 1 → 2 → 4 → 5 → 6
              ↑           ↓
             11           7
              ↑           ↓
             10  ←  9  ←  8

 o/p =  2

 Logic: step 1: first find if its a circular linked list (keep the point where they meet slow==fast
        step 2: Reinitialize slow to head(beginning) and move both slow and fast once step at a time
        Step 3: where ever is slow ==fast again is the start point of circular ll

*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.ListNode;

public class _FastAndSlowPointer_03_LinkedList_Cycle_position {

    public static ListNode findStartOfCircle(ListNode head){
        if(head==null) return null;

        //step 1: first find if its a circular linked list (keep the point where they meet slow==fast
        ListNode p2 = getIntersectionPoint(head);

        //step 2: Reinitialize slow to head(beginning) and move both slow and fast once step at a time
        if(p2 !=null){
            ListNode p1 = head;
            while(p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
        }
        return p2;
    }

    private static ListNode getIntersectionPoint(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){

            slow = slow.next;
            fast = fast.next;
            if(fast!=null)fast = fast.next;
            if(slow==fast)return slow;
        }
        return null;
    }
}
