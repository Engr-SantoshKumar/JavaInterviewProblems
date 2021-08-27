/* [  ] [ Peeking Iterator ]
 ____________________________________________________________________________________________________________________
 Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator
 that support the peek() operation -- it essentially peek() at the element
 that will be returned by the next call to next().

 Assume that the iterator is initialized to the beginning of the list: [1,2,3].

 Call next() gets you 1, the first element in the list.
 Now you call peek() and it returns 2, the next element.
 Calling next() after that still return 2.
 You call next() the final time and it returns 3, the last element.
 Calling hasNext() after that should return false.

 LOGIC: the main logic is when we initialize members we set value for cacheMemory and we use this for next() operation.
        and when calling next() we will make cacheMemory as current, assign cacheMemory --> iterator.next and return cachePeek
*/
package _00_Problems_Sorted_By_Patterns;


import java.util.*;

public class _Design_02_Peeking_Iterator {

    static class PeekingIterator implements Iterator<Integer> {

        Integer cacheMemory;
        Iterator<Integer> iterator;
        boolean hasNoMoreElements;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            setCacheValue();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return cacheMemory; // --> use data in memory
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(cacheMemory==null){
                throw new NoSuchElementException();
            }
            int result = cacheMemory;
            setCacheValue();
            return result;
        }

        @Override
        public boolean hasNext() {
                return cacheMemory!=null;
        }

        private void setCacheValue(){
            //why can't we simply put cacheValue = iterator.next()
            // because if iterate is empty or its last one it will give NoSuchElementException
            if(iterator.hasNext()){
                cacheMemory = iterator.next();
            }else {
                cacheMemory = null;
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(3,4,5));
        Iterator itr = list1.iterator();
        PeekingIterator pk = new PeekingIterator(itr);
        System.out.println(pk.peek()); //3
        System.out.println(pk.hasNext()); // true
        System.out.println(pk.next()); // 3
        System.out.println(pk.peek()); // 4
        System.out.println(pk.next()); // 4
        System.out.println(pk.peek()); // 5
        System.out.println(pk.next()); // 5
        System.out.println(pk.peek()); //
 }

}
