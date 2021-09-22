/**
 * [82-0] [LRU Cache]
 * -----------------------------------------------------------------------------------------------------
 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and put.

 Please define interface for LRU Cache and implement logic
 What are the tests that you will write for this code
 */

package PrepSetOne;
import java.util.*;
import java.util.LinkedList;

public class _Goo_82_0_LRU_Cache {

    Set<Integer> hs;
    int limit;
    LinkedList<Integer> linkedList;
    int curSize;

     _Goo_82_0_LRU_Cache(int limit){
        this.hs = new HashSet<>();
        this.limit = limit;
        this.linkedList = new LinkedList<>();
        this.curSize=0;
    }

    public void add(int key){

        if(!hs.contains(key)){
            if(curSize == limit ){
                int lestRecent = linkedList.removeLast();
                hs.remove(lestRecent);
                curSize--;
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
            // remove from current element from linkedList
            linkedList.remove(index);
            hs.remove(key); // optional:  no need to remove from hasSet as when we put it will make it most recent
            curSize--;

        }
        linkedList.addFirst(key);
        hs.add(key);
        curSize++;
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
        _Goo_82_0_LRU_Cache ca = new _Goo_82_0_LRU_Cache(3);
        ca.add(1);
        ca.add(2);
        ca.add(3);
        ca.display();
        System.out.println();
        ca.add(1);
        ca.display();
        System.out.println();
        ca.add(4);
        ca.add(5);
        ca.display();
    }
}

