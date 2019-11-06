package GooPrep02;

import java.util.Arrays;
import java.util.Iterator;

/**
 * [  ] [  ]
 * ____________________________________________________________________________________________________________________
 */
public class _Goo2_16_Intersection_Of_Two_Iterator implements Iterator<Integer> {

    Iterator<Integer> i1;
    Iterator<Integer> i2;
    Integer nextValue = null;
    public _Goo2_16_Intersection_Of_Two_Iterator(Iterator<Integer> i1, Iterator<Integer> i2) {
        this.i1 = i1;
        this.i2 = i2;
        nextValue = setNext();
    }

    public static void main(String[] args) {
        Integer[] a = {2, 4, 5, 6, 8, 10, 11};
        Integer[] b = {4, 6, 8, 10};
        _Goo2_16_Intersection_Of_Two_Iterator intersectionIterator =
                new _Goo2_16_Intersection_Of_Two_Iterator(Arrays.asList(a).iterator(), Arrays.asList(b).iterator());
        while (intersectionIterator.hasNext()) {
            System.out.println(intersectionIterator.next());
        }
    }

    @Override
    public boolean hasNext() {
        return nextValue != null;
    }

    @Override
    public Integer next() {
        Integer temp = nextValue;
        nextValue = setNext();
        return temp;
    }

    //Compute next intersection value.
    private Integer setNext() {
        int i = 0;
        int j = 0;
        if (i1.hasNext() && i2.hasNext()) {
            i = i1.next();
            j = i2.next();
            if (i == j)
                return i;
        }
        while (i1.hasNext() && i2.hasNext()) {
            if (i < j) {
                i = i1.next();
            } else if (i > j) {
                j = i2.next();
            } else {
                return i;
            }
        }
        return null;
    }
}