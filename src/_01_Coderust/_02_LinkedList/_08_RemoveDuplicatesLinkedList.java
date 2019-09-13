/*

 */

package _01_Coderust._02_LinkedList;
import _01_Coderust._02_LinkedList.LinkedList.Node;

import java.util.HashSet;


public class _08_RemoveDuplicatesLinkedList {


    static Node removeDuplicates(Node head){

        Node current = head;
        Node previous = null;

        HashSet<Integer> visitedNodes = new HashSet<Integer>();

        while(current!= null){

            if(visitedNodes.contains(current.data)){
                previous.next = current.next;

            }else{
                previous = current;
                visitedNodes.add(current.data);
            }
            current = current.next;

        }

        return head;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 1, 2, 2, 3, 3, 3, 6, 7};

        LinkedList mylist = new LinkedList(a);
        LinkedList.Node head = mylist.getHead();
        LinkedList.printList(head);

        LinkedList.Node newHead = removeDuplicates(head);
        LinkedList.printList(newHead);
    }
}
