package _01_Coderust._02_LinkedList;


import _01_Coderust._02_LinkedList.LinkedList.Node;
public class _07_MiddleValueLinkedList {

    static int middleValue(Node head){


        if(head == null) return 0;
        if(head.next == null) return head.data;

        Node current= head; //current starts at headNode
        Node runner = head.next.next; // will set the runner two step ahead

        while(runner!=null){
            current = current.next;
            runner = runner.next;
           if(runner!=null)
                runner = runner.next;
        }

        System.out.println(current.data);

        return current.data;
    }


    public static void main(String[] args) {

        Integer[] a = {1,2,3,4,5,6,7};

        LinkedList mylist = new LinkedList(a);
        LinkedList.Node head = mylist.getHead();
        LinkedList.printList(head);
        System.out.println(middleValue(head));


    }
}
