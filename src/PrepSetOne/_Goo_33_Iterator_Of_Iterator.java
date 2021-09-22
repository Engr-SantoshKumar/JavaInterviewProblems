/**
 [33] [Iterator Of Iterator Using Queue ]
 -----------------------------------------------------------------------------------------------------
 PROBLEM STATEMENT:
 [1, 2, 3],
 [4, 5],
 [6, 7, 8, 9]
 o/p --> 1 4 6 2 5 7 3 8 9
 Logic:
 Use the queue to do the cycling of the list for you. When you pull an element from an iterator,
 check to see if the iterator is empty. If the iterator is not empty, add it back to the queue.
 If it’s empty, then you’re out of elements.
 */
package PrepSetOne;
import java.util.*;
public class _Goo_33_Iterator_Of_Iterator implements Iterator {

    Queue<Iterator<Integer>> queue = new ArrayDeque<>();
    // constructor
    public _Goo_33_Iterator_Of_Iterator(ArrayList<Iterator> mainArr)
    {
        // put all the arrList into queue one by one
        for (int i = 0; i <mainArr.size(); i++) {
            Iterator<Integer> curItr = mainArr.get(i);
            queue.add(curItr);
        }
    }

    /* Remove the arrList from queue, get the first element and put back remaining
       once we put back the arrList back in queue it will move to the last of queue.
     */
    public Integer next() {
        Iterator<Integer> curList = queue.remove(); // remove list
        Integer firstInteger = curList.next();       // get the 1st element
        if(curList.hasNext()) {                     // add back the remaining
            queue.add(curList);
        }
        return firstInteger;
    }

    public boolean hasNext(){
        return queue.size()!=0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();

        list1.addAll(Arrays.asList(3,4,5,6));
        list2.addAll(Arrays.asList(7,8,9,10));
        list3.addAll(Arrays.asList(11,12));
        list4.addAll(Arrays.asList(14,15,16));

        //creating iterator of each arrayList
        Iterator it1 = list1.iterator();
        Iterator it2 = list2.iterator();
        Iterator it3 = list3.iterator();
        Iterator it4 = list4.iterator();

        ArrayList<Iterator> mainArr = new ArrayList<>();
        mainArr.add(it1);
        mainArr.add(it2);
        mainArr.add(it3);
        mainArr.add(it4);

        _Goo_93_Iterator_Of_Iterator_Using_Queue itr = new _Goo_93_Iterator_Of_Iterator_Using_Queue(mainArr);
        while(itr.hasNext()) {
            System.out.print(itr.next() + ",");
        }

    }

}
