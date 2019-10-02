/** Goo2_01 [Design HashMap]
 -------------------------------------------------------------------------------------------------------
 Design a HashMap without using any built-in hash table libraries.
 put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

 Logic:
     1 we define arraylist of size n (say 31), and put dummy node of the linkedlist at each index
     2 use key % 31 to get index of dummy node of linkedlist which contains (key, value) pair
     3 begin from the dummy node to get, set, or remove node which contains (key, value) pair

 */

package GooPrep02;

import java.util.ArrayList;
import java.util.List;

public class _Goo2_01_HM_Implement_HashMap {

    // create a list of 31 Linked List and initiate it with dummy head
    List<hmNode> list = null;
    public void MyHashMap() {
        list = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            // add dummy node
            list.add(new hmNode());
        }
    }

    /*to PUT new node, we will find the hashCode by calculating = (key % 31) and then add (key, value) next to dummy node
    if same (key, value) already present in list we return else create new node and add */
    public void put(int key, int value) {
        int hCode = key % 31;
        hmNode head = list.get(hCode);  //--> this will return the dummy hmNode

        while(head.next != null){
                head = head.next;
                // case: if key already present, update value
                if(head.key == key) {
                    head.value = value;
                    return;
                }
        }
        //ADD the new (key, Value) at the end of List
        head.next = new hmNode(key, value);
        System.out.println("Key: "+ key + " and Value: "+value+" add to hashMap");
    }

     /* GET : fist go to the Linked List represented by hashCode i.e key%31
        and loop through the Linked List to find key */
    public int get(int key) {
        hmNode head = list.get(key % 31);
            while(head.next != null){
                head = head.next;
                if(head.key == key){
                    return head.value;
                }
            }
        System.out.println("Key: "+ key + " Key not Present");
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hmNode head = list.get(key%31);

        while(head.next != null){
            if(head.next.key == key){
                head.next = head.next.next;
                return;
            }
            head = head.next;
        }
        System.out.println("Key: "+ key + "Removed from hashMap");
    }

    public static void main(String[] args) {
        _Goo2_01_HM_Implement_HashMap hashMap = new _Goo2_01_HM_Implement_HashMap();
        hashMap.MyHashMap();
        hashMap.put(1, 101);
        hashMap.put(2, 202);
        System.out.println("key 1: value: " + hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 203);          // update the existing value
        System.out.println("key 1: value: " + hashMap.get(2));            // returns 1
        hashMap.remove(2);               // remove the mapping for 2
        System.out.println(hashMap.get(3));   // returns -1 (not found)
    }


class hmNode{
    int key;
    int value;
    hmNode next;
    public hmNode(){
    }
    public hmNode(int key, int value){
        this.key= key;
        this.value = value;
    }

}
}


