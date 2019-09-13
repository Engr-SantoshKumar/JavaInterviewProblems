/** 36  [mid  Value LinkedList]
 ---------------------------------------------------------------------------------------------------------
 Write a program to find middle element of linked list in one pass.
 */

package GooPrep;

class _07_MiddleValueLinkedList {

    public static Node head = null;



    public static int middValueLinkedList(Node head){

        if (head == null) return 0;
        if(head.next.next == null) return head.data;

        Node current = head;
        Node runner = head.next.next;

        while(runner!=null){
            current= current.next;
            runner= runner.next;
            if(runner!=null){
                runner= runner.next;
            }
        }
        return current.data;
    }


    public static void main(String[] args) {
        _07_MiddleValueLinkedList Kth = new _07_MiddleValueLinkedList();
        head = new Node(1);
        head.next= new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Midd node = "+ middValueLinkedList(head));

    }


    public static class Node{
        int data;
        Node next;

        public Node(int d){
            data =d;
            next = null;
        }
    }

}