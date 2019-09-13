package GooPrep;

import java.util.Arrays;

public class CircularArray {
    public static void main(String[] args) {
        int[] ar = new int[5];
        Circular c = new Circular(ar);
        c.insert(1);
        c.insert(2);
        c.insert(3);
        c.insert(4);
        c.insert(5);
        c.insert(6);
        //System.out.println(Arrays.toString(c.get()));
        c.insert(7);
        c.insert(8);

    }

}

class Circular {
    int[] ar;
    int tail = -1;

    public Circular(int[] ar) {
        this.ar = ar;
    }
    void insert(int e) {
        int size = ar.length;
        ar[++tail % size] = e;
        System.out.println(Arrays.toString(ar));
    }

    public int[] get() {
        return ar;
    }
}