package _01_Coderust._02_LinkedList;
import _01_Coderust._02_LinkedList.LinkedList.Node;

public class _x_08_Merge_Two_Sorted_Linked_Lists {



    public static Node merge_two_list (Node list_head1, Node list_head2){
        // if any one of the list is null
        if(list_head1 == null){
            return list_head2;
        }
        if(list_head2 == null){
            return list_head1;
        }
        // start with the linked list whose head data is the least
        if (list_head1.data < list_head2.data)
            return mergeUtil(list_head1, list_head2);
        else
            return mergeUtil(list_head2, list_head1);

    }

    public static Node mergeUtil(Node list_head1, Node list_head2 ){



        //if only one node in first list simply point its head to second list
        if(list_head1.next == null){
            list_head1.next=list_head2;
            return list_head1;
        }

        // Initialize current and next pointers of both given lists

        Node currentNodelist1 = list_head1, nextNodelist1= list_head1.next;
        Node currentNodelist2 = list_head2, nextNodelist2= list_head2.next;

        while(nextNodelist1 != null && nextNodelist2 != null){

            // if current Node of list2 is in middle of current and next of list1
            // than will do :  currentNodelist1 --> currentNodelist2 --> nextNodelist1
            if(currentNodelist2.data >= currentNodelist1.data && currentNodelist2.data <= nextNodelist1.data){

                // moving list 2 pointer to one node ahead as later in
                // step2: we are setting current node of list 2 to its next
                nextNodelist2 = currentNodelist2.next;

                //STEP 1: currentNodelist1 --> currentNodelist2 --> nextNodelist1
                currentNodelist1.next = currentNodelist2;
                currentNodelist2.next = nextNodelist1;

                // STEP 2: now let curr1 and curr2 to point to their immediate next pointers

                currentNodelist1 = currentNodelist2;
                currentNodelist2 = nextNodelist2;

            }
            else
            {   // if more nodes in first list: will move current and next pointer to one step ahead
                if(nextNodelist1.next != null){
                    nextNodelist1 = nextNodelist1.next;
                    currentNodelist1 = currentNodelist1.next;


                }
                 else{//if more in 2nd list : last node of list1 --> remaining of list2
                    nextNodelist1.next = currentNodelist2;
                    return list_head1;
                }
            }

        }
        return list_head1;
    }



    public static void main(String[] args) {
        Integer[] arr1 = {1, 3, 5, 6};
        Integer[] arr2 = {2, 4, 6, 20, 34 }; //

        LinkedList list_head1 = new LinkedList(arr1);
        Node head1 = list_head1.getHead();
        System.out.print("Original1: ");
        LinkedList.printList(head1);

        LinkedList list_head2 = new LinkedList(arr2);
        Node head2 = list_head2.getHead();
        System.out.print("Original2: ");
        LinkedList.printList(head2);

        System.out.println("\nMerged:");

        Node newHead = merge_two_list(head1, head2);
        LinkedList.printList(newHead);
    }

}
