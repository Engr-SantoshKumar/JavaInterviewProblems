/**
 * [82] [LRU Cache]
 * -----------------------------------------------------------------------------------------------------
 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and put.

 Please define interface for LRU Cache and implement logic
 What are the tests that you will write for this code
 */
package GooPrep;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
public class _Goo_82_LRU_Cache {
    public static void main(String args[]) {
        LRU cache = new LRU(4);
        cache.put(1, 1);
        cache.print();      //1 ->
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println("Original Cache :  " );
        cache.print();      // 4 ->3 ->2 ->1 ->
        System.out.println("Get 2 : " + cache.get(2));
        System.out.println("Cache structure after accessing 1 :  " );
        cache.print();      // 1 ->4 ->3 ->2 ->
        cache.put(5, 5);    // evicts key 2
        System.out.println("Cache after adding 5:  " );
        cache.print();      // 5 ->1 ->4 ->3 ->
        System.out.println("get invalid key :" + cache.get(7));    // - 1
    }
}

class LRU{
    int capacity;
    int totalItemsInCache =0;

    LinkedList<Node> linkedList = new LinkedList<>();
    HashMap<Integer, Node> hashMap = new HashMap<>();

    // set the capacity
    public LRU(int capacity){
        if(capacity <1){
            System.out.println("Invalid capacity");
        }
        this.capacity = capacity;
    }
    /* Put operation */
    public void put(int key, int value){
        if(isPresentInCache(key)){
            makeMostRecent(key);
        }else{
            if(isFull()){
                removeLRUEntryFromCache();
            }
            addToMapAndLL(key, value);
        }

    }
    /* Get operation */
    public int get(int key){
        if(isPresentInCache(key)){
            Node node = hashMap.get(key);
            makeMostRecent(key);
            return node.value;
        }
        return -1;
    }

    public boolean isPresentInCache(int key){
        return hashMap.containsKey(key);
    }

    public void makeMostRecent(int key){
        Node node = hashMap.get(key);
        linkedList.remove(node);
        linkedList.addFirst(node);
    }

    public boolean isFull(){
        return totalItemsInCache >= capacity;
    }

    public void removeLRUEntryFromCache(){
        int key = linkedList.getLast().key;
        hashMap.remove(key);
        linkedList.removeLast();
        totalItemsInCache --;
    }

    public void addToMapAndLL(int key, int value){
        Node node = new Node(key, value);
        hashMap.put(key, node);
        linkedList.addFirst(node);
        totalItemsInCache++;
    }

    void print() {
        for (Node node : linkedList) {
            System.out.print(node.value + " ->");
        }
        System.out.println();
    }

    class Node{
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

}
