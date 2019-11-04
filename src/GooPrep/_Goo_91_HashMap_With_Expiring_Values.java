/**
[ Goo 91 ] [ Hash Map With Expiring Values ]
_________________________________________________________________________________________________________________
 Question: you have to implement a time critical hashmap, such that you are given input as: key, value & time-limit.
 If the time limit gets over and then the hashmap must not return any value.
 This should be strictly implemented as an Object Oriented code.

 All operations implementations: https://gist.github.com/pcan/16faf4e59942678377e0

 Java HashMap is not synchronized by default. If we add/remove key-value pairs from a HashMap
 in a concurrent application where multiple threads are adding and removing pairs,
 we may end up having inconsistent state of the map. Learn to synchronize hashmap and ConcurrentHashMap in Java.

 Our first choice should always be using the ConcurrentHashMap class if we wish to use a Map in concurrent environment.
 ConcurrentHashMap support concurrent access to it’s key-value pairs by design. We do not need to perform any
 additional code modifications to enable synchronization on the map.

 Please note that iterator obtained from ConcurrentHashMap does not throw ConcurrentModificationException.
 However, iterators are designed to be used by only one thread at a time. It means each iterator we obtain
 from a ConcurrentHashMap is designed to be used by a single thread and should not be passed around.

 If we do so then there is no guarantee that one thread will see the changes to the map that the other
 thread performs (without obtaining a new iterator from the map). The iterator is guaranteed to reflect
 the state of the map at the time of it’s creation.

 Let’s take an example of working with ConcurrentHashMap.

 * */
package GooPrep;

import java.util.HashMap;
import java.util.Map;

public class _Goo_91_HashMap_With_Expiring_Values<K,V>{

    private Long limit;
    private Map<K, Pair<V,Long>> map = new HashMap<>();

    public _Goo_91_HashMap_With_Expiring_Values(Long limit){
        this.limit = limit;
    }

    public V put(K key , V value) {
        Pair<V, Long> pair
                = map.put(key ,new Pair(value, System.currentTimeMillis()));
        return pair != null ? pair.value:null;
    }

    public  V get(K key){
        if(!map.containsKey(key)) {
            return null;
        }
        Pair<V, Long>  pair = map.get(key);
        if(System.currentTimeMillis() - pair.time <= limit ) {
            System.out.println(pair.value);
            return pair.value;
        }
        map.remove(key);
        return null;
    }

    private class Pair<V,Long>{
        private V value;
        private Long time;

        public Pair(V value, Long time) {
            this.value = value;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception{
        _Goo_91_HashMap_With_Expiring_Values sExp =
                new _Goo_91_HashMap_With_Expiring_Values(System.currentTimeMillis()+10000);


        sExp.put(10, "Santosh");
        Thread.sleep(5000);
        sExp.put(11, "10");
        sExp.put(12, 100);
        sExp.put(13, 10000110);

        sExp.get(10);
        sExp.get(13);

        Thread.sleep(10000);

        sExp.get(10);
        Thread.sleep(10000);
        sExp.get(11);

    }

}
