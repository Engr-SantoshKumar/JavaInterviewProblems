/* [ _LinkedList_04_ ] [ 328. Odd Even Linked List ]
_______________________________________________________________________________
Given the head of a singly linked list, group all the nodes with odd indices together
followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.
Input: head =      1    2   3   4   5
                   ↑    ↑   ↑   ↑   ↑
                   o    e   o   e   o

Output:        1    3   5   2    4
               ↑    ↑   ↑   ↑    ↑
               o    o   o   e   e


Logic: we can solve this problem with the same logic as used in _LinkedList_03_Partition_List
*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.ListNode;
public class _LinkedList_04_Odd_Even_Linked_List {
    public static ListNode oddEvenPartitionList(ListNode head){
        //base
        if(head==null || head.next==null) return head;
        //dummy heads of the 1st and 2nd queues
        ListNode oddList = new ListNode(0);
        ListNode evenList = new ListNode(0);
        //current tails of the two queues;
        ListNode oCur = oddList;
        ListNode eCur = evenList;
        int i =1;
        while(head!=null){
            if(i%2==0){
                eCur.next = head;
                eCur=eCur.next;
            }else{
                oCur.next=head;
                oCur=oCur.next;
            }
            head=head.next;
            i++;
        }
        //connect small ll to big ll
        oCur.next = evenList.next; //Skipping dummy head of odd and linking to even
        eCur.next=null;
        return oddList.next;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7,8,9,10};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        ListNode head1 = list1.getHead();
        LinkedList.printList(head1);
        ListNode result = oddEvenPartitionList(head1);
        LinkedList.printList(result);
    }
}
