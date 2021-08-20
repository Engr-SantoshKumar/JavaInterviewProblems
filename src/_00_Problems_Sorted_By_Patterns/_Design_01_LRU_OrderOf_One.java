/* [ _Design_01_ ] [ LRU Cache With Map And DLinked ]
_______________________________________________________________________________
The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
One interesting property about double linked list is that the node can remove itself without other reference. O(1)
In addition, it takes constant time to add and remove nodes from the head or tail.

flow:
        set
         |---> checkIfAlreadyPresent?
         |          |---> makeMostRecent
         |
        else--> CheckIfLRUFull?
             |      |--->Delete LastNode from DLL and also from map
             |
             |-->addFirstToDLL and addToDLL

        get
         |---> checkIfNotPresent?
         |          |---> return -1
         |--> makeItMostRecent

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.Map;

public class _Design_01_LRU_OrderOf_One {

    //why we use doubly linkedlist rather than arraylist/linked list??
    //removal from linked list is O(n). But, from double linked list it is O(1)
    private final DoublyLinkedList doublyLinkedList;
    private final Map<Integer, DllNode> hashMap;
    int capacity;

    // initialization
    public _Design_01_LRU_OrderOf_One(int capacity) {
        this.capacity = capacity;
        doublyLinkedList = new DoublyLinkedList();
        hashMap = new HashMap<>();
    }
    //set function
    public void set(int key, int value) {
        DllNode newNode;
        if (hashMap.containsKey(key)) {
            newNode = hashMap.get(key);
            newNode.value = value;
            doublyLinkedList.makeMostRecent(newNode);
            return;
        }
        if (hashMap.size() == capacity) {
            DllNode node = doublyLinkedList.removeLast();
            hashMap.remove(node.key);
        }
        newNode = new DllNode(key, value);
        doublyLinkedList.addFirst(newNode);
        hashMap.put(newNode.key, newNode);
    }

    // get function
    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        DllNode curNode = hashMap.get(key);
        doublyLinkedList.makeMostRecent(curNode);
        return curNode.value;
    }

    public static void main(String args[]) {
        _Design_01_LRU_OrderOf_One cache = new _Design_01_LRU_OrderOf_One(3);
        cache.set(1, 1); // 1 <->
        cache.set(2, 2); // 2 <-> 1 <->
        cache.set(3, 3); // 3 <-> 2 <-> 1 <->
        cache.set(4, 4); // 4 <-> 3 <-> 2 <->
        System.out.println("Get 2 : " + cache.get(2)); //2 <-> 4 <-> 3 <->
        cache.set(5, 5); //5 <-> 2 <-> 4 <->
        System.out.println("get invalid key :" + cache.get(7)); //-1
    }
}

//node class for DLL
class DllNode {
    int key;
    int value;
    DllNode prev;
    DllNode next;
    public DllNode(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

//all linkedList operations
class DoublyLinkedList{
    private DllNode head = null;
    private DllNode tail = null;

    //method to add node in front of double LL
    public void addFirst(DllNode node){
        if (head == null) {
            head = node;
            tail = node;
            print();
            return;
        }
        // adding current node to leftSide(before head)
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
        print();
    }
    //method to remove last
    public DllNode removeLast() {
        DllNode node = tail; // store last
        if (tail.prev != null) {  // 4 <-> 5 <-> 10  [removing 10]
            tail.prev.next = null; // 10 previous 5 next is 10 = null [4 <-> 5 <-> null]
            tail = tail.prev;  // update the tail
        } else {// if only one node
            head = null;
            tail = null;
        }
        print();
        return node;
    }

    public void makeMostRecent(DllNode givenNode) {
        if (givenNode.prev == null) { // already most recent ..means the 1st node
            return;
        }
        //update previous and next pointer 
        givenNode.prev.next = givenNode.next; // removing from its org place (updating previous link)
        if (givenNode.next == null) { // if the node is last one, update the tail
            tail = givenNode.prev;
        } else {
            givenNode.next.prev = givenNode.prev;//removing from its org place (updating next link)
        }
        //adding to front of LL and updating head
        head.prev = givenNode;
        givenNode.next = head;
        givenNode.prev = null;
        head = givenNode;

        print();
    }
    //testing
    void print() {
        DllNode tNode = head;
        while(tNode!=null){
            System.out.print(tNode.value + " <-> ");
            tNode = tNode.next;
        }
        System.out.println();
    }

}

