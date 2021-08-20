/* [ _Design_01_L ] [ RU_OrderOf_N ]
_______________________________________________________________________________
 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and put.

 Please define interface for LRU Cache and implement logic
 What are the tests that you will write for this code
*/
package _00_Problems_Sorted_By_Patterns;
import java.util.*;

public class _Design_01_LRU_OrderOf_N {

    Set<Integer> hset = new HashSet<>();
    int limit;
    List<Integer> arrayList = new ArrayList<>();
    int curSize;

    _Design_01_LRU_OrderOf_N(int limit){
        this.limit = limit;
    }

    public void add(int key){
        if(!hset.contains(key)){
            if(hset.size() == limit ){
                int lestRecent = arrayList.remove(limit-1);
                hset.remove(lestRecent);
            }
        }
        else{
            // remove from current element from arrayList.. how to remove we need to find its index
            /* Iterator<Integer> itr = arrayList.listIterator();
            int index=0;
            while(itr.hasNext()){
                if(itr.next() == key){
                    break;
                }index++;
            }
            arrayList.remove(index); */

           for(int i=0; i<arrayList.size(); i++){
                if(arrayList.get(i) ==key){
                    arrayList.remove(i);
                    break;
                }
           }
        }
        arrayList.add(0,key);
        hset.add(key);
    }

    // display contents of cache
    public void display()
    {
        Iterator<Integer> itr = arrayList.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args)
    {
        _Design_01_LRU_OrderOf_N ca = new _Design_01_LRU_OrderOf_N(3);
        ca.add(1);
        ca.add(2);
        ca.add(3);
        ca.add(4);
        ca.display(); //4 3 2
        System.out.println();
        ca.add(1);
        ca.display(); //1 4 3
        System.out.println();
        ca.add(4);
        ca.display(); //4 1 3
        System.out.println();
        ca.add(5);
        ca.display(); //5 4 1
    }
}