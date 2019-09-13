package _01_Coderust._02_LinkedList;


public class _x_01_reverseLinklist {

static node head = null;

    public static node reverseLinklist(node head){
    node currentNode = head;
    node prevousNode = null;

    while(currentNode!=null){
        node nextNode = currentNode.next;//Store the next node in a temporary variable
        currentNode.next = prevousNode;  //Reverse the link

        // now move these pointers to their next
        prevousNode = currentNode;  // 1. Update the previous node to the current node
        currentNode = nextNode;      // 2. Proceed to the next node in the original linked list 2nd pointer, 3rd one nexNode at top

    }
        return prevousNode;
    }



public static void main(String[] args) {
        head = new node(1);
        head.next = new node(2);
        head.next.next = new node(3);
        head.next.next.next = new node(4);
        head.next.next.next.next = new node(5);
        head.next.next.next.next.next = new node(6);
        head.next.next.next.next.next.next = new node(7);
        head.next.next.next.next.next.next.next = new node(8);

        System.out.println("Original Linked list ");
        printList(head);
        node newStartingPoint = reverseLinklist(head);
        System.out.println("");
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(newStartingPoint);

    }


public static class node{
        int data;
        node next;
        node(int value){
            this.data = value;
            this.next= null;
        }
    }

    // prints content of linked list
public static void printList(node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }


}
