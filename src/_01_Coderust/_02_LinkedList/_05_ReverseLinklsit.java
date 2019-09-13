/*
For any current node, its link with the previous node is reverse and next stores the next node in the list:

Store the current node’s nextElement in next
Set current node’s nextElement to previous (reversal)
Make the current node the new previous so that it can be used for the next iteration
Use next to move on to the next node
In the end, we simply point the head to the last node in our loop.
 */


package _01_Coderust._02_LinkedList;

import _01_Coderust._02_LinkedList.LinkedList.Node;


public class _05_ReverseLinklsit {

    static Node reverseUsingResursionUsingVariables(Node head){
        Node curNode = head;
        Node prevNode = null;

        while (curNode != null) {

            Node nextNode = curNode.next;    //Store the next node in a temporary variable
            curNode.next = prevNode;         //Reverse the link

            // now move these pointers to their next

		    prevNode = curNode; // 1. Update the previous node to the current node  1st pointer
            curNode = nextNode; // 2. Proceed to the next node in the original linked list
        }

        // Once the linked list has been reversed, prevNode will have the new head. So return it
        return prevNode;
    }




    public static void main(String[] args) {

        Integer[] a = {1,2,3, 4,};

        LinkedList firstlist = new LinkedList(a);
        Node head = firstlist.getHead();
        LinkedList.printList(head);
        Node newStartingPoint = reverseUsingResursionUsingVariables(head);
        LinkedList.printList(newStartingPoint);

    }
}
