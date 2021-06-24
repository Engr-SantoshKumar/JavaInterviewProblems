/** 40  [max Planes In TheAir]
 -----------------------------------------------------------------------------------------------------------
 Write a method to implement deletion of alternate elements in a linked list
 */
package GooPrep;
import GooPrep.LinkedList.NodeLinkList;
public class _Goo_40_01_Circular_LinkedList_Delete_Alternate_Element {


    public static NodeLinkList CircularLinkedList_deleteAlternateElement(NodeLinkList head){

        if(head == null) return null;


        NodeLinkList runner = head;

        while(runner.next!=null){
            runner.next = runner.next.next;
            runner = runner.next;
            //  checking circular
            if(runner==head || runner.next == head){
                break;
            }
        }
        return head;
    }


    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        LinkedList<Number> mylist = new LinkedList<Number>(a);
        NodeLinkList head = mylist.getHead();
        LinkedList.printList(head);

        LinkedList.printList(CircularLinkedList_deleteAlternateElement(head));

    }

}
