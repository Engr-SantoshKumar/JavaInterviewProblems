package _02_CTCI_Questions.LinkList;


public class llinkedListRemoveDups {
    public static Node head = null;

    public static class Node{
        int data;
        Node next;

        public Node(int d){
            data =d;
            next = null;
        }
    }

    public static void removeDups(Node head){
        Node current = head;
        while(current!=null){
            Node runner = current;
            while(runner.next!=null){
                if(runner.next.data==current.data){
                    runner.next=runner.next.next;
                }else{
                    runner=runner.next;
                }
            }
            current=current.next;
        }
    }




    public static void displayList(Node head){

        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    public static void main(String args[]){

        head = new Node(1);
        head.next= new Node(11);
        head.next.next = new Node(11);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        displayList(head);

        removeDups(head);
        System.out.println("-------");
        displayList(head);

    }

}




