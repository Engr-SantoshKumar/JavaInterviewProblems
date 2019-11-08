/**
 * [82-01] [LRU Cache]
 * -----------------------------------------------------------------------------------------------------
 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and put.

 Please define interface for LRU Cache and implement logic
 What are the tests that you will write for this code
 */


package GooPrep;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedList;

public class _Goo_82_0_LRU_Cache {

    Set<Integer> hs;
    int limit;
    LinkedList<Integer> linkedList;

     _Goo_82_0_LRU_Cache(int limit){
        this.hs = new HashSet<>();
        this.limit = limit;
        this.linkedList = new LinkedList<>();
    }

    public void add(int key){

        if(!hs.contains(key)){
            if(linkedList.size() == limit ){
                int last = linkedList.removeLast();
                hs.remove(last);
            }
        }
        else{
            int i=0;
            int index = 0;
            Iterator<Integer> itr = linkedList.iterator();
            while(itr.hasNext()){
                if(itr.next() ==key){
                    index = i;
                }i++;
            }
            // remove from ll
            linkedList.remove(index);
            // no need to remove from hasSet as when we put it will make it most recent
        }

        linkedList.add(key);
        hs.add(key);
    }

    // display contents of cache
    public void display()
    {
        Iterator<Integer> itr = linkedList.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args)
    {
        _Goo_82_0_LRU_Cache ca = new _Goo_82_0_LRU_Cache(4);
        ca.add(1);
        ca.add(2);
        ca.add(3);
        ca.display();
        System.out.println();
        ca.add(1);
        ca.add(4);
        ca.add(5);
        ca.display();
    }
}

