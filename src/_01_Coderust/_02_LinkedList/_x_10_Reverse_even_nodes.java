package _01_Coderust._02_LinkedList;
import _01_Coderust._02_LinkedList.LinkedList.Node;

public class _x_10_Reverse_even_nodes {

    public static Node reverseEvenNodes( Node head){

        Node current = head;
        Node evenNodeList = null;

        // 1, 3, 5, 6, 2, 4, 6, 20, 34
        while(current!=null && current.next != null){

            //evenNode --> 3
            Node evenNode = current.next; //evenNode --> 3
            // deattaching even node from original list
            current.next = current.next.next; // 1 --> 5 --> ...

            // now attach even node to the head of evenNodeList
            evenNode.next = evenNodeList; // 3--> evenNodeList

            // move the pointers in both list
            evenNodeList = evenNode; // pointing to the head of evenNodeList
            current = current.next;  // pointing to the next element of list



        }

        return merge_alternating(head, evenNodeList);

    }

    public static Node merge_alternating( Node list1, Node list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        // 1--> 5 --> 2 --> 6 --> 34 --> null
        // 3--> 6 --> 4 --> 20 --> null
        Node head = list1;

        while(list1 != null && list2 != null){

            Node temp = list2; //3 pick the first node from list 2
            list2 = list2.next; // moved the pointer

            temp.next = list1.next; // attached the even node to list1

            list1.next = temp;
            temp = list1.next;// moved the pointer

        }
        if(list1.next == null){
            list1.next = list2;
        }

        return head;

    }


    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6};
        LinkedList list_head1 = new LinkedList(arr1);
        LinkedList.Node head1 = list_head1.getHead();
        System.out.print("Original1: ");
        LinkedList.printList(head1);

        System.out.print("\nAfter Reverse:");

        LinkedList.Node newHead = reverseEvenNodes(head1);
        LinkedList.printList(newHead);
    }
}
