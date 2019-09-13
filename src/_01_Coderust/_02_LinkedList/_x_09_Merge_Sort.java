package _01_Coderust._02_LinkedList;
import _01_Coderust._02_LinkedList.LinkedList.Node;

public class _x_09_Merge_Sort {


    public static Node mergeSort(Node head){

        if(head == null || head.next == null){
            return head;
        }

        //get the middle of list
        Node middle = findMiddle(head);
        Node headOfSecondHalf = middle.next;

        middle.next = null; // disconnect the first half of the list

        Node firstHalf = mergeSort(head);
        Node secondHalf = mergeSort(headOfSecondHalf);

        Node sortedList = sortedMerge(firstHalf, secondHalf);
        return sortedList;

    }

    static Node findMiddle(Node head){
        if(head == null) return head;
        Node slow = head;
        Node fast = head.next;

        while(fast!=null){
            fast = fast.next;
            if(fast!=null){
                fast=fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    static Node sortedMerge(Node first, Node second){
        if(first == null) return second;
        if(second == null) return first;

        Node result = null;

        if(first.data <= second.data){
            result = first;
            result.next = sortedMerge(first.next, second);
        }
        else{
            result = second;
            result.next = sortedMerge(first, second.next);
        }

        return result;
    }





    public static void main(String[] args) {
        Integer[] arr1 = {1, 3, 5, 6, 2, 4, 6, 20, 34};
        LinkedList list_head1 = new LinkedList(arr1);
        Node head1 = list_head1.getHead();
        System.out.print("Original1: ");
        LinkedList.printList(head1);

        System.out.println("\nMerged:");

        Node newHead = mergeSort(head1);
        LinkedList.printList(newHead);
    }

}
