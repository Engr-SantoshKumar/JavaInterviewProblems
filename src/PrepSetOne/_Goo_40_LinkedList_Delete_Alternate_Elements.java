/** 40  [max Planes In TheAir]
 -----------------------------------------------------------------------------------------------------------
 Write a method to implement deletion of alternate elements in a linked list
 */
package PrepSetOne;
import PrepSetOne.LinkedList.NodeLinkList;
public class _Goo_40_LinkedList_Delete_Alternate_Elements {


    public static NodeLinkList deleteAlternateElement(NodeLinkList head){

        if(head == null) return null;


        NodeLinkList current = head;

        while(current.next !=null){
            current.next = current.next.next;
            if(current.next == null){
                break;
            }
            current = current.next;
        }
        return head;
  }


    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        LinkedList<Number> mylist = new LinkedList<Number>(a);
        NodeLinkList head = mylist.getHead();
        LinkedList.printList(head);

        LinkedList.printList(deleteAlternateElement(head));

    }

}
