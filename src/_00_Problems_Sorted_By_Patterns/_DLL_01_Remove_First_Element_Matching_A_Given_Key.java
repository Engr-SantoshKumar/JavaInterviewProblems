/* [ 01 Double LinkedList ] [ Remove the first element matching a given key from a doubly linked list ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
*/
package _00_Problems_Sorted_By_Patterns;
public class _DLL_01_Remove_First_Element_Matching_A_Given_Key<V> {
    // a node of the doubly linked list
    public class Node {
        V value;
        Node next, prev;
        public Node(V data){
            this.value = data;
        }
    }
    Node head;
    _DLL_01_Remove_First_Element_Matching_A_Given_Key(){
        head = null;
    }
    
    void deleteFirstOccurrenceOfX(V x) {
        // base case
        Node current = head; //always safe to use current
        if (head == null || x == null)
            return;
        
        Node del = null;
        while(current!=null && current.next!=head){ //cur.next !=head  ---> avoiding to go in ∞ loop if its circular dll
            if(current.value ==x){
                del = current;
                break;
            }
            current = current.next;
        }
        if(del == null) return; // key x does not exit
        
        /* If node to be deleted is head node UPDATE Head*/
        if (head == del)
            head = del.next;

        /* updating nextNode previous connection, required for if it is 1stNode or mid node for last node
         as last node.next is null and there is no connection from null to previous  */
        if (del.next != null)
            del.next.prev = del.prev;

         /* updating previousNode next connection, required for if its a mid node or last node, NOT for 1st Node
         as first node.previous is null and there is no connection from null to next  */
        if (del.prev != null)
            del.prev.next = del.next;
        
        del = null;
        
    }
    
    /* function to delete all occurrences of the given key 'x' */
     void deleteAllOccurOfX(V x) {
        // if list is empty
        if (head == null)
            return;
        
        Node current = head;
        Node next;
        
        /* traverse the list up to the end */
        while (current != null) {
            // if node found with the value 'x'
            if (current.value == x) {
                next = current.next;
                head = deleteNode(head, current);
                current = next;
            } else
                current = current.next;
            
        }
     }

    /* Function to delete a node in a Doubly Linked List. head_ref --> pointer to head node pointer. del --> pointer to node to be deleted. */
     Node deleteNode(Node head, Node del)
    {
        // base case
        if (head == null || del == null)
            return null;
        
        /* If node to be deleted is head node */
        if (head == del)
            head = del.next;

        /* Change next only if node to be deleted is NOT the last node */
        
        if (del.next != null)
            del.next.prev = del.prev;

        /* Change prev only if node to be deleted is NOT the first node */
        if (del.prev != null)
            del.prev.next = del.next;
        
        del = null;
        
        return head;
    }
  
    // Driver code
    public static void main(String args[])
    {
        _DLL_01_Remove_First_Element_Matching_A_Given_Key<java.io.Serializable> dll = new _DLL_01_Remove_First_Element_Matching_A_Given_Key<>();
        /* Create the doubly linked list:
        7<->2<->10<->8<->4<->2<->5<->9 */
        dll.push(9);
        System.out.println("Original Doubly linked list: ");
        dll.printList();
        System.out.println();
        System.out.println("Doubly linked list after deletion of first occurrence of 50 :");
        dll.deleteFirstOccurrenceOfX(50);
        System.out.println("Doubly linked list after deletion of first occurrence of 50 :");
        dll.printList();
        System.out.println();
        dll.deleteFirstOccurrenceOfX(9);
        System.out.println("Doubly linked list after deletion of first occurrence of 9 :");
        dll.printList();
        System.out.println();
        
        dll.push(5);
        dll.push(2);
        dll.push('A');
        dll.push(8);
        dll.push(10);
        dll.push(2);
        dll.push(7);
        
        System.out.println("Original Doubly linked list: ");
        dll.printList();
        System.out.println();

        dll.deleteFirstOccurrenceOfX(7);
        System.out.println("Doubly linked list after deletion of first occurrence of 7 :");
        dll.printList();
        System.out.println();
    
        dll.deleteFirstOccurrenceOfX('A');
        System.out.println("Doubly linked list after deletion of first occurrence of A :");
        dll.printList();
        System.out.println();
    
        dll.deleteFirstOccurrenceOfX(5);
        System.out.println("Doubly linked list after deletion of first occurrence of 5 :");
        dll.printList();
        System.out.println();

        // delete all occurrences of 'x'
        dll.deleteAllOccurOfX(2);
        System.out.println("Doubly linked list after deletion of all occurrence of 2 :");
        dll.printList();
    }
    
    /* Function to print nodes in a given doubly linked list */
     void printList ()
    {
        Node temp = head;
        if (temp == null)
            System.out.print("Doubly Linked list empty");
        
        while (temp != null)
        {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    
    /* Function to insert a node at the beginning of the Doubly Linked List */
     void push (V new_data)
    {
        // allocate node
        Node new_node = new Node(new_data);
        
       
        /* since we are adding at the beginning, prev is always NULL */
        new_node.prev = null;
        
        // link the old list off the new node
        new_node.next = head;
        
        // change prev of head node to new node
        if (head != null)
            head.prev = new_node;
        
        // move the head to point to the new node
        head = new_node;
        
        //return head;
    }
}

