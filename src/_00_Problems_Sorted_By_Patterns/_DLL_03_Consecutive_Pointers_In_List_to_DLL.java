/* [  ] [  ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
*/
package _00_Problems_Sorted_By_Patterns;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _DLL_03_Consecutive_Pointers_In_List_to_DLL {
    static class Node{
        int data;
        Node next, prev;
    }
    
    public static int consecutiveNodes(Node head, List<Node> list ){
        //base
        int noOfConsecutiveNodes =0;
        Set<Node> hSet = new HashSet<>();
        if(head==null || list ==null || list.size()==0)
            return noOfConsecutiveNodes;
    
        int i =0;
        while( i<list.size()){
            Node current = list.get(i);
            if(!hSet.contains(current)){
                while(i < list.size() && current!=null && current == list.get(i) && !hSet.contains(current)){
                    hSet.add(current);
                    i++;
                    current = current.next;
                }
                noOfConsecutiveNodes ++;
            }else{
                i++;
            }
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
        List<Node> list = new ArrayList<>(9);
        createArray(head, list);
        System.out.println("DLL array: ");
        for (Node x :list){
            System.out.print(x.data + " ");
        }
        System.out.println();
        
        System.out.println("noOfConsecutiveNodes = " + consecutiveNodes(head, list));
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
    static List<Node> createArray(Node head, List<Node> list){
        Node current = head;
        while(current!=null){
            list.add(current);
            current = current.next;
        }
    
        current = head;
        list.add(2, current);
        current = current.next;
        list.add(3,current);
        current = current.next;
        list.add(4,current);
        current = current.next;
        list.add(0,current);
        current = current.next;
        list.add(1,current);
        current = current.next;
        list.add(6,current);
        current = current.next;
        list.add(7,current);
        current = current.next;
        list.add(8,current);
        current.next = null;
        return list;
    }
}
