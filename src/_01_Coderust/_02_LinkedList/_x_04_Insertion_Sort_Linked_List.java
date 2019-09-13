package _01_Coderust._02_LinkedList;

public class _x_04_Insertion_Sort_Linked_List {

     static node head;
     static node sortedListCurrent;

       static node insertionSort(node head){

           if(head == null || head.next == null){
               return head;
           }

           sortedListCurrent = null; // Initialize sorted linked list
           node currentNode = head;

           // Traverse the given linked list and insert every node to sort
           while(currentNode!=null){

               node nextNode = currentNode.next;

               placeNewNodeAtCorrectPlace(currentNode);

               currentNode =nextNode;

           }
            return sortedListCurrent;

         }

         static void placeNewNodeAtCorrectPlace(node newNode){

           // case: when newNode is smallest i.e newNode is going to be new Head for sorted list
           if(sortedListCurrent == null || sortedListCurrent.data >= newNode.data ){
               // placing newNode at front : newNode --> SortedList --> null;
               newNode.next = sortedListCurrent;
               // updating the head pointer
               sortedListCurrent = newNode;

           }
           else
           {
               node currentNodeOfSortedList = sortedListCurrent;
                //finding the correct place to insert the newNode
               while(currentNodeOfSortedList.next!=null &&
                       currentNodeOfSortedList.next.data < newNode.data){
                   currentNodeOfSortedList = currentNodeOfSortedList.next;
               }
               // inserting the new node in sorted list
               newNode.next = currentNodeOfSortedList.next;
               currentNodeOfSortedList.next = newNode;

           }

         }

     public static void printList(node node){

        while(node!=null){
            System.out.print(node.data + "->");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        head = new node(30);
        head.next = new node(2);
        head.next.next = new node(40);
        head.next.next.next = new node(14);
        head.next.next.next.next = new node(25);
        head.next.next.next.next.next = new node(6);
        head.next.next.next.next.next.next = new node(7);
        head.next.next.next.next.next.next.next = new node(28);

        System.out.println("Original Linked list ");
        printList(head);
        System.out.println("");
        System.out.println("sorted linked list ");
        printList(insertionSort(head));

    }

static class node{
    int data;
    node next;

    node(int data){
        this.data = data;
        this.next = null;
    }


}




}
