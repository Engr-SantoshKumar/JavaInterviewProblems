/* [ _LinkedList_02_ ] [ 61. Rotate List ]
_______________________________________________________________________________
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Input: head = [0,1,2], k = 4
Output: [2,0,1]
Logic:
suppose the length of LinkedList is 5 and K =8,
new head will be from (k/len) end i.e 8%5 =>3rd node from end
so if we calculate tail will be at Length-8%5 => 5-8%5 => 5-3 =>2
Step 1 : find length and at same time connect tail to head to make circle p.next = head;
Step 2: now move again for len-k times, it will be pointing to the node before the break point(tail).
Then all we need to do is record the next node as head, and break the circle with p.next = null.

        1   2   3   4   5       K = 8
            ↑   ↑
            ↑   ↑→ new head
      len-k%len

*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.ListNode;

public class _LinkedList_02_Rotate_List {
    public static ListNode rotateRight(ListNode head, int k) {
        //base
        if(head==null || k==0) return head;

        //step1: find length and connect tail to head to make circular
        int len =1;
        ListNode pointer = head;
        while(pointer.next!=null){
            pointer=pointer.next;
            len++;
        }
        // pointer is at last node, so connect to head to make circle
        pointer.next = head;
        //actual rotation
        k= k%len;

        //step 2: move to len-k, that will be new tail
        for(int i=0; i<len-k; i++){
            pointer = pointer.next;
        }
        head = pointer.next;
        pointer.next=null;
        return head;
    }
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        ListNode head1 = list1.getHead();
        LinkedList.printList(head1);
        ListNode result =rotateRight(head1, 11);
        LinkedList.printList(result);
    }

}
