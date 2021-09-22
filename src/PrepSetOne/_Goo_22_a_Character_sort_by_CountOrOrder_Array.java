/** 21 -a  [Characters count and sorting -Array ]
 -------------------------------------------------------------------------------------------------------
 "Given a string, write a logic to find the number of occurrences of each letter and
 print them in descending order of occurrence. if the number of occurrences are same,
 then sort alphabetically for that set. Consider the string has only upper case characters and
 no spaces
 Ex: Given a string 'WOWTHISISSOGOOD'"
 */
package PrepSetOne;
import java.util.PriorityQueue;

public class _Goo_22_a_Character_sort_by_CountOrOrder_Array {

    /* using array to store count */
    static void charCountUsingArr(String S) {

        int[] chCount = new int[26];
        for (char c : S.toCharArray()) {
            chCount[c - 'A']++;
        }
        //System.out.println(Arrays.toString(chCount));

        PriorityQueue<CharAndCount> pq = new PriorityQueue<>((a,b) ->
                (((b.count == a.count)?(a.chr - b.chr):(b.count - a.count))));

        for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++){
            int count = chCount[alphabet - 'A'];
            if(count>0){
                pq.offer(new CharAndCount(alphabet, count));
            }
        }

        while (!pq.isEmpty()) {
            CharAndCount top = pq.poll();
            System.out.println(top.chr + " : " + top.count);
        }
    }

    public static void main(String args[]) {

            int i = 65;
            char c = (char) i; //--> this is called casting the char value
            System.out.println("Character value of int 65 is = " + c);
            String s = "WOWTHISISSOGOOD";
            charCountUsingArr(s);
    }

    static class CharAndCount{
        char chr;
        int count;
        public  CharAndCount(char c, int i){
            this.chr =c;
            this.count = i;
        }
    }
}

