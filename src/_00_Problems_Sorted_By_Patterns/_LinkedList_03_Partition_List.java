/* [ _LinkedList_03_ ] [ 86. Partition List ]
_______________________________________________________________________________
Given the head of a linked list and a value x, partition it such that all nodes less than x
 come before nodes greater than or equal to x.

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Logic:
1. maintain two queues, the first one stores all nodes < x , and the second queue stores all the rest nodes.
2. Then connect these two queues. 1stOneLast.next = 2ndHead
3. Remember to set the tail of second queue a null next. 2ndOneLast.next = null
    why: For this list: 5->6->1->2, x=3, at last cur2 points to 6, cur1 points to 2, we must set 6->1 to 6->null,
    otherwise there will be a cycle.
*/
package _00_Problems_Sorted_By_Patterns;
import _00_Problems_Sorted_By_Patterns.LinkedList.NodeLinkList;
public class _LinkedList_03_Partition_List {
    public static NodeLinkList partitionList(NodeLinkList head, int k){
        //base
        if(head==null || head.next==null) return head;
        //dummy heads of the 1st and 2nd queues
        NodeLinkList smallerValHead = new NodeLinkList(0);
        NodeLinkList largerValHead = new NodeLinkList(0);
        //current tails of the two queues;
        NodeLinkList sCur = smallerValHead;
        NodeLinkList gCur = largerValHead;

        while(head!=null){
            if(head.data < k){
                sCur.next = head;
                sCur=sCur.next;
            }else{
                gCur.next=head;
                gCur=gCur.next;
            }
            head=head.next;
        }
        //connect small ll to big ll
        sCur.next = largerValHead.next; //Skipping dummy head of greater and linking
        gCur.next=null;
        return smallerValHead.next;

    }

    public static void main(String[] args) {
        Integer[] a = {5, 2, 3, 4, 6, 2, 3, 9};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        NodeLinkList head1 = list1.getHead();
        LinkedList.printList(head1);
        NodeLinkList result = partitionList(head1, 4);
        LinkedList.printList(result);
    }
}
