/* [ _Design_01_ ] [ LRU Cache With Map And DLinked ]
_______________________________________________________________________________
The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
One interesting property about double linked list is that the node can remove itself without other reference.
In addition, it takes constant time to add and remove nodes from the head or tail.

flow:
        put
         |---> checkIfAlreadyPresent?
         |          |---> makeMostRecent
         |
        else--> CheckIfLRUFull?
             |      |--->Delete Last from LL and key from map
             |
             |-->addToMap and addToLL

*/
package _00_Problems_Sorted_By_Patterns;
import java.util.HashMap;
import java.util.Map;

public class _Design_01_LRUCache_With_MapAndDLL {
    private final Map<Integer, ListNode> cachedMap = new HashMap<>();
    private final DoublyLinkedList cachedList = new DoublyLinkedList();
    int capacity;

    public void LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cachedMap.containsKey(key)) {
            return -1;
        }

        ListNode targetNode = cachedMap.get(key);
        cachedList.makeMostRecent(targetNode);

        return targetNode.value;
    }

    public void set(int key, int value) {
        ListNode targetNode;

        if (cachedMap.containsKey(key)) {
            targetNode = cachedMap.get(key);
            targetNode.value = value;
            cachedList.makeMostRecent(targetNode);
            return;
        }

        if (cachedMap.size() == capacity) {
            ListNode node = cachedList.removeLast();
            cachedMap.remove(node.key);
        }

        targetNode = new ListNode(key, value);
        cachedList.addFirst(targetNode);
        cachedMap.put(targetNode.key, targetNode);
    }
    //testing


    public void main(String args[]) {
        _Design_01_LRUCache_With_MapAndDLL cache = new _Design_01_LRUCache_With_MapAndDLL();
        cache.LRUCache(4);
        cache.set(1, 1);
        //cache.print();      //1 ->
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        System.out.println("Original Cache :  " );
        //cache.print();      // 4 ->3 ->2 ->1 ->
        System.out.println("Get 2 : " + cache.get(2));
        System.out.println("Cache structure after accessing 1 :  " );
        //cache.print();      // 1 ->4 ->3 ->2 ->
        cache.set(5, 5);    // evicts key 2
        System.out.println("Cache after adding 5:  " );
        //cache.print();      // 5 ->1 ->4 ->3 ->
        System.out.println("get invalid key :" + cache.get(7));    // - 1
    }


}
//node class for DLL
class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;
    public ListNode(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

//all linkedList operations
class DoublyLinkedList{
    private ListNode head = null;
    private ListNode tail = null;

    //method to add node in front of double LL
    public void addFirst(ListNode node){
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        // adding current node to leftSide(before head)
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }
    //method to remove last
    public ListNode removeLast() {
        ListNode node = tail; // store last
        if (tail.prev != null) {  // 4 <-> 5 <-> 10  [removing 10]
            tail.prev.next = null; // 10 previous 5 next is 10 = null [4 <-> 5 <-> null]
            tail = tail.prev;  // update the tail
        } else {// if only one node
            head = null;
            tail = null;
        }
        return node;
    }

    public void makeMostRecent(ListNode node) {
        if (node.prev == null) { // already most recent ..means the 1st node
            return;
        }

        node.prev.next = node.next; // removing from its org place (updating previous link)
        if (node.next == null) { // if the node is last one, update the tail
            tail = node.prev;
        } else {
            node.next.prev = node.prev;//removing from its org place (updating next link)
        }
        //adding to front of LL and updating head
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }

}

