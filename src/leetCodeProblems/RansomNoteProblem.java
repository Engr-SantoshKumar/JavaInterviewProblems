package leetCodeProblems;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteProblem {

	public static void main(String[] args) {
		
		String magazine = "one two three";
		String note = "four";
		
		RansomNoteProblem ransomNoteProblem = new RansomNoteProblem();
		ransomNoteProblem.ransomNote(magazine,note);
		

	}
	
	public String ransomNote(String m, String n) {
		
		Map<String,Integer> hm = new HashMap<String, Integer>();
		Integer count =null;
		String result = null;
		String [] magazineWords = m.split(" ");//stored each word of magazine in magazinbeWords array
		String [] noteWords = n.split(" ");//stored each word of note in noteWords array

		//load hashMap hm with magazineWords along with their counts
		for(String S: magazineWords) {
				count =hm.get(S);
				hm.put(S, count!=null? count+1 :1); 
		}

		//checking the hashmap for noteWords and updating counts 
		for(String S : noteWords) {
			count =hm.get(S);
			if(count == null || count ==0) {
				//System.out.println("Note is NOT possible !");
				result = "NO";
				return result;
				
				}
			else {
				hm.put(S, count-1);
			}
		}
		//System.out.println("This Note is possible !");
		result = "YES";
		return result;
	}

}
