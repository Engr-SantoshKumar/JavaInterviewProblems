/**
 * [71] [Key Value Millis Seconds ]
 * --------------------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 * <p>
 * e.g:
 * <p>
 * <p>
 * TIME COMPLEXITY:
 */
package GooPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _Goo_71_Key_Value_Millis_____________________ {
    public static void main(String args[]) {



        try{
            TimeMap2 kv = new TimeMap2();
            kv.set("foo", "bar", System.currentTimeMillis()+5000); // store the key "foo" and value
            Thread.sleep(4000); // now 4000 is added to current time
            String op = kv.get("foo");
            System.out.println(" after 4000 ms "+op);  // output "bar"

            Thread.sleep(2000);// now 6000 is added to current time
            op = kv.get("foo");
            System.out.println(" after 6000 ms "+op);  // output null

        }catch(InterruptedException e){

        }

    }

   /* static void keyValueTry(int[] entry, String operation){

    }*/
}

class TimeMap2 {
    Map<String, TreeMap<Long, String>> map = new HashMap<>();

    public void set(String v, String w, long ts) {
        TreeMap<Long, String> treeMap;
        if (!map.containsKey(v)) {
            treeMap = new TreeMap<>();
        } else {
            treeMap = map.get(v);
        }
        treeMap.put(ts, w);
        map.put(v, treeMap);
    }

    public String get(String v) {
        long ts = System.currentTimeMillis();
        if (map.containsKey(v)) {
            TreeMap<Long, String> tm = map.get(v);
            Long key = tm.ceilingKey(ts); // returns value of if it is >= ts
            if (key != null) {
                return tm.get(key);
            }
        }
        return null;
    }
}

