/* [ _FastAndSlow_06_ ] [ 9. Palindrome Linked List ]
_______________________________________________________________________________

Input: head = [1,2,2,1]
head --> 1 --> 2 --> 2 --> 1 --> null
null <-- 1 <-- 2 <-- 2 <-- 1 <-- head
Output: true

Logic:
step1: go to half of linked list
step2: reverse the 2nd half
step3: if odd move slow pointer one more (if fast is not null its odd else even)
step4: take at pointer at head (say fast) move both slow and fast together and compare
*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.ListNode;

public class _FastAndSlowPointer_06_Palindrome_Linked_List {

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null){ // odd nodes: let right half smaller
            slow = slow.next;
            }
        slow=reverse(slow); // reverse the 2nd half

        fast=head;
        while(slow!=null){
            if(!slow.data.equals(fast.data))return false;
                slow=slow.next;
                fast=fast.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode slow) {
        ListNode prev=null;
        ListNode cur=slow;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }

    public static void main(String[] args) {

        Integer[] a = {1,2,3,2,1};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        ListNode headA = list1.getHead();
        System.out.println(isPalindrome(headA));
    }
}
