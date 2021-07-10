package _00_Problems_Sorted_By_Patterns;/* [  ] [  ]
_______________________________________________________________________________

class SkipIterator {
 public SkipIterator(Iterator itr);
 boolean hasNext();
 Integer next();
 void skip(int num); //--> num need to skip (its can be nextElement or somewhere in itr.
}
void skip(int num); //--> num need to skip (its can be nextElement or somewhere in itr.
skip may be called multiple times, skip(5), skip(5) means that the next two 5 are not needed.

Ideas:
1. we always keep the hasNext and nextElement in memory
2. Skip can be called multiple times, so we will use map to store the frequency of skip calls,
Map<Integer, Integer>, key is the number that needs to be skipped, and value is how many.
The frequency of skip is increased by one for each call, and the value of the key is decreased by one each time
the key is skipped.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _Design_05_Skip_Iterator_design {

    static class SkipIterator {
        private static Iterator<Integer> itr;
        private static boolean hasNext;
        private static Integer nextElement;
        private static Map<Integer, Integer> map = new HashMap<>();

        public SkipIterator(Iterator<Integer> itr) {
            this.itr = itr;
            findNext(); //set the nextElement and hasNext value (check for skipped ones)
        }

        public static boolean hasNext() {
            return hasNext; //return the previously set hasNext flag
        }

        public static Integer next() {
            if(!hasNext) return null; // use the previously set hasNext and nextElement value
            Integer tmp = nextElement;
            findNext(); // //reset the nextElement and hasNext value (check for skipped ones)
            return tmp;
        }

        /** The input parameter is an int, indicating that the next element equals 'val' needs to be skipped.
         * This method can be called multiple times in a row. skip(5), skip(5) means that the next two 5s should be
         * skipped.*/

        public static void skip(int num) {
            if(hasNext) {
                if(nextElement == num) { //if the front element is the number to be skipped then
                    findNext();          //   we need to update our hasNext&NextElement
                } else {//else store in map for future
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
        }
        private static void findNext() {
            hasNext = false;      //first make both hasNext --> false and nextElement--> null, because
            nextElement = null;   //we don't know if we have more in itr
            while(itr.hasNext()) {
                Integer nextInt = itr.next();
                /*if next element in the skip list we reduce its count, suppose we need to skip two of 5's
                 then map will like 5:2--> 5:1-->5:0 (remove from map) next 5 we will pick*/

                if(map.containsKey(nextInt)) {
                    map.put(nextInt, map.get(nextInt) - 1);
                    if(map.get(nextInt) == 0) map.remove(nextInt);
                } else {
                    // reassign the value of hasNext and nextElement
                    hasNext = true;
                    nextElement = nextInt;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,5,4,3,5};
        Iterator<Integer> iterator = Arrays.stream(arr).iterator();
        SkipIterator skipItr = new SkipIterator(iterator);
        System.out.println(SkipIterator.hasNext()); //true
        System.out.println(SkipIterator.next()); //--> o/p 1
        System.out.println(SkipIterator.next()); //--> o/p 2
        SkipIterator.skip(5);
        SkipIterator.skip(5);
        System.out.println(SkipIterator.next()); //--> o/p 3
        SkipIterator.skip(5);
        System.out.println(SkipIterator.next());//--> o/p 4
        System.out.println(SkipIterator.next()); //--> o/p 4
    }
}
