/**  59 [Selective Iterator ]
 ____________________________________________________________________________________________________________________
Implement a "selective iterator" in Java
 Selection iterators traverse the elements in an aggregate data structure such as a list and return only
 those elements that meet a particular criteria. describe an abstract internal list iterator class that performs an
 operation on each element that satisfies some criteria. The criteria is implemented in concrete sub-classes by
 overriding the method that performs the test.
 */

package GooPrep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class _Goo_66_Selective_Iterator_Using_List{
    public static void main(String args[]){
        ArrayList<Number> al = new ArrayList<>();
        al.add(2.5D);
        al.add(4L);
        al.add(1);
        al.add(2);
        al.add(3);
        SelectionListIterator sl = new SelectionListIterator(al);
        while(sl.hasNext()){
            System.out.println(sl.next());
        }
    }
}

class SelectionListIterator implements Iterator<Number> {
        ArrayList<Number> al;
        Iterator<Number> it;
        Number curr;
        public SelectionListIterator(ArrayList<Number> al) {
            this.al = al;
            it = al.iterator();
            ofSameType();
        }

        @Override
        public boolean hasNext(){
            return curr != null;
        }

        @Override
        public Integer next(){
            if(curr == null) {
                throw new NoSuchElementException();
            }
            Integer temp = (Integer) curr;
            curr = null; // This is very imp, as for last element curr will hold 3 and when u go to
            ofSameType();  // advance method here then it will not nullify curr, making infinite loop
            return temp;
        }

        void ofSameType(){
            while(it.hasNext()){
                Number t = it.next();
                if(checkIfIntegerType(t)){
                    curr = t;
                    break;
                }
            }
        }
        // return true as i is instance of class Integer
        boolean checkIfIntegerType(Number n){
            return n instanceof Integer;
        }
}

