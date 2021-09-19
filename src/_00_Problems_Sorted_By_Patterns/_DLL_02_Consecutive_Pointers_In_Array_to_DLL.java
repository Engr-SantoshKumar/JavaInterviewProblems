/* [  ] [ consecutive pointers or sets of consecutive node matching array ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
There exists some doubly linked list;
your input is an array of pointers into that list (not the list itself);
design an algorithm to tell me how many blocks of consecutive pointers are in the input list.

← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
*/
package _00_Problems_Sorted_By_Patterns;
public class _DLL_02_Consecutive_Pointers_In_Array_to_DLL {
    static class Node{
        int data;
        Node next, prev;
    }
    
    public static int consecutiveNodes(Node head, Node[] arr){
        //base
        int noOfConsecutiveNodes =0;
        if(head==null || arr ==null || arr.length==0)
            return noOfConsecutiveNodes;
        
        int i =0;
        while( i<arr.length){
            Node current = arr[i];
            while(i < arr.length && current!=null && current == arr[i]){
                    i++;
                    current = current.next;
            }
            noOfConsecutiveNodes ++;
        }
        return noOfConsecutiveNodes;
    }
    
    // Driver code
    public static void main(String args[])
    {

        Node head = null;

        /* Create the doubly linked list:  7<->2<->10<->8<->4<->2<->5<->9 */
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);
        
        System.out.println("Original Doubly linked list: ");
        printList(head);
        System.out.println();
        Node[] arr = new Node[8];
        createArray(head, arr);
        System.out.println("DLL array: ");
        for (Node x :arr){
            System.out.print(x.data + " ");
        }
    
        System.out.println("noOfConsecutiveNodes = " + consecutiveNodes(head, arr));
    }
    
    /* Function to print nodes in a given doubly linked list */
    static void printList (Node temp){
        if (temp == null) System.out.print("Doubly Linked list empty");
            while (temp != null)        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    /* Function to insert a node at the beginning of the Doubly Linked List */
    static Node push (Node head, int new_data){
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.prev = null;
        new_node.next = head;
        if (head != null)
            head.prev = new_node;
        head = new_node;
        return head;
    }
    static Node[] createArray(Node head, Node[] arr){
        Node current = head;
        arr[2] = current;
        current = current.next;
        arr[3] = current;
        current = current.next;
        arr[4] = current;
        current = current.next;
        arr[0] = current;
        current = current.next;
        arr[1] = current;
        current = current.next;
        arr[6] = current;
        current = current.next;
        arr[7] = current;
        current = current.next;
        arr[5] = current;
         return arr;
    }
}
