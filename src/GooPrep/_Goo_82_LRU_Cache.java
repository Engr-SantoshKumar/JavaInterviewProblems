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
        System.out.println("Get 1 : " + cache.get(1));
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

    LinkedList<Node> DLL = new LinkedList<>();
    HashMap<Integer, Node> Hmap = new HashMap<>();


    public LRU(int capacity){
        if(capacity <1){
            System.out.println("Invalid capacity");
        }
        this.capacity = capacity;
    }

    public void put(int key, int value){
        if(isPresentInCache(key)){
            makeMostRecent(key);
        }else{
            if(isFull()){
                removeLRUEntryFromCache();
            }
            addNew(key, value);
        }

    }

    public boolean isPresentInCache(int key){
        return Hmap.containsKey(key);
    }

    public void makeMostRecent(int key){
        Node node = Hmap.get(key);
        DLL.remove(node);
        DLL.addFirst(node);
    }

    public boolean isFull(){
        return totalItemsInCache >= capacity;
    }

    public void removeLRUEntryFromCache(){
        int key = DLL.getLast().key;
        Hmap.remove(key);
        DLL.removeLast();
        totalItemsInCache --;
    }

    public void addNew(int key, int value){
        Node node = new Node(key, value);
        Hmap.put(key, node);
        DLL.addFirst(node);
        totalItemsInCache++;
    }

    public int get(int key){
        if(isPresentInCache(key)){
            Node node = Hmap.get(key);
            makeMostRecent(key);
            return node.data;
        }

        return -1;
    }

    void print() {
        Iterator<Node> it = DLL.iterator();
        while (it.hasNext()) {
            System.out.print(it.next().data + " ->");
        }
        System.out.println();
    }

    class Node{
        int data;
        int key;
        public Node(int data, int key){
            this.data = data;
        }
    }

}
