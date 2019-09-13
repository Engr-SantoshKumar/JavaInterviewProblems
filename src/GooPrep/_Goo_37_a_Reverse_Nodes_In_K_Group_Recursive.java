/** 37  [reverse K Group Nodes]
 ---------------------------------------------------------------------------------------------------------
 Write a program to reverse a linked list in groups of size k.
 For example, if the given linked list is 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
 and the reservable group size is 3, the output should be 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 9 -> 8 -> 7.

    Reverse a link list between begin and end exclusively
    K =3

 after while loop
     1 <- 2 <- 3   -> 4->5->6
     |         |      |
  Head     previous  current

    Now make recension call
     head.next = revers k group (with head =- current)
Note Previous will be always the 1st node after reversed in k group

 */
package GooPrep;
import GooPrep.LinkedList.NodeLinkList;
public class _Goo_37_a_Reverse_Nodes_In_K_Group_Recursive {


//=========Solution One ============================================================================
       public static NodeLinkList reverseKGroupSimpleastRecursion(NodeLinkList head, int k) {

        if(hasEnoughNods(head,k) == false) return head;

        NodeLinkList current = head;
        NodeLinkList previous = null;
        NodeLinkList next;


        int count = k;
        while (count-- > 0 ) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head.next = reverseKGroup(current, k);
        return previous;
    }

    public static boolean hasEnoughNods(NodeLinkList head, int k){
        int size =0;
        NodeLinkList current = head;
        while(current!=null){
            current=current.next;
            size++;
            if(size==k) return true;
        }
        return false;
    }

//=========Solution Two ============================================================================

    public static NodeLinkList reverseKGroup(NodeLinkList head, int k) {
        NodeLinkList curr = head;
        int count = 0;
        //
        while (curr != null && count != k) { // find the k+1th node (last node of group)
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head -> head-pointer to direct part,
            // curr -> head-pointer to reversed part;

            /*Reverse*/
            while (count > 0) {
                NodeLinkList tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
                count --;
            }
            head = curr;
        }
        return head;
    }

    public static void main(String[] args) {

        Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8 };
        LinkedList<Number> mylist1 = new LinkedList<Number>(a1);
        NodeLinkList head1 = mylist1.getHead();
        //LinkedList.printList(reverseKGroup(head1, 3));
        LinkedList.printList(reverseKGroupSimpleastRecursion(head1, 3));
    }
}
