package leetCodeProblems;

import java.util.*;
import java.util.Map.Entry;


public class SortHashMapByKeyAndValue {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(5, "A");
		hashMap.put(11, "C");
		hashMap.put(4, "Z");
		hashMap.put(77, "Y");
        hashMap.put(9, "P");
        hashMap.put(66, "Q");
        hashMap.put(0, "R");
        
        sortByKEY(hashMap);
        sortByVALUE(hashMap);

	}
	
	public static void sortByKEY(Map<Integer, String> hashMap) {
		Map<Integer, String> treeMap = new TreeMap<Integer, String>(hashMap);
	    //System.out.println(treeMap);
		for (Integer Key : treeMap.keySet()) {
		    System.out.println(Key+" : "+ treeMap.get(Key) );
		}
	}
	
	public static void sortByVALUE(Map<Integer, String> hashMap) {
		
		LinkedList<Entry<Integer, String>> list = new LinkedList<Entry<Integer, String>>(hashMap.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Integer, String>>(){
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Entry<Integer, String> item :list) {
			System.out.println(item);
		}
		
	}

}
