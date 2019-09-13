package GooPrep;
import java.util.*;
import java.util.LinkedList;

public class _Goo_93_Flatten_Iterator_Of_Iterator implements Iterator {

    LinkedList list1 = new LinkedList<>();

    public _Goo_93_Flatten_Iterator_Of_Iterator(ArrayList<Iterator> mainArr) {
        int i=0;
        while(i < 15) {
            Iterator itr = mainArr.get(i % mainArr.size());
            //while(itr.hasNext()) {
                if(!itr.hasNext()) {
                    mainArr.remove(itr);
                } else {
                    list1.add(itr.next());
                }
            //}
            i++;
        }
    }

    @Override
    public boolean hasNext() {
        return !list1.isEmpty();
    }

    @Override
    public Integer next() {
        return (Integer) list1.removeFirst();
    }


    public static void main(String[] args) {
        // child arraylist which will be part of main arrayList
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();

        list1.addAll(Arrays.asList(3,4,5,6));
        list2.addAll(Arrays.asList(7,8,9,10));
        list3.addAll(Arrays.asList(11,12));
        list4.addAll(Arrays.asList(14,15,16));

        //creating iterator of each arraylist
        Iterator it1 = list1.iterator();
        Iterator it2 = list2.iterator();
        Iterator it3 = list3.iterator();
        Iterator it4 = list4.iterator();

        ArrayList<Iterator> mainArr = new ArrayList<>();
        mainArr.add(it1);
        mainArr.add(it2);
        mainArr.add(it3);
        mainArr.add(it4);

        _Goo_93_Flatten_Iterator_Of_Iterator itr = new _Goo_93_Flatten_Iterator_Of_Iterator(mainArr);
        while(itr.hasNext()) {
            System.out.print(itr.next() + ",");
        }

    }
}

