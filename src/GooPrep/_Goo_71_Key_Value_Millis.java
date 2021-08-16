/**
 [71] [Key Value Millis Seconds ]
 --------------------------------------------------------------------------------------------------------------
 PROBLEM STATEMENT: Create a timebased key-value store class TimeMap, that supports two operations.
 1. set(string key, string value, int timestamp)
    Stores the key and value, along with the given timestamp.
 2. get(string key, int timestamp)
     Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
     If there are multiple such values, it returns the one with the largest timestamp_prev.
     If there are no values, it returns the empty string ("").

 Complexity Analysis
    Time Complexity: O(1)O(1) for each set operation, and O(\log N)O(logN) for each get operation,
        where NN is the number of entries in the TimeMap.

    Space Complexity: O(N)O(N).



/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
package GooPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    /** Initialize your data structure here. */
    Map<String, TreeMap<Integer, String>> hMap;
    public TimeMap() {
        hMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!hMap.containsKey(key)){
            hMap.put(key, new TreeMap<>()); // create an entry with empty treeMap as value
        }
        hMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tMap = hMap.get(key);
        if(tMap == null) {
            return " ";
        }
        Integer floorValue = tMap.floorKey(timestamp);
        if(floorValue == null){
            return " ";
        }
        return tMap.get(floorValue);
    }
}

class _Goo_71_Key_Value_Millis{
    public static void main(String args[]) {

        TimeMap kv = new TimeMap();
        // store the key "foo" and value "bar" along with timestamp = 1
        kv.set("foo", "bar", 1);
        // output "bar"
        kv.get("foo", 1);
        // output "bar" since there is no value corresponding to foo
        String op = kv.get("foo", 3);
        System.out.println(" first op " + op);

        kv.set("foo", "bar2", 4);
        kv.set("foo", "bar3", 5);
        String op2 = kv.get("foo", 4); // output "bar2"
        System.out.println(" second op " + op2);
        String op3 = kv.get("foo", 5); //output "bar2"
        System.out.println(" third op " + op3);
    }
}



