/* [  ] [  ]
_______________________________________________________________________________
As to the design of bucket, again there are several options. One could simply use another Array as bucket
 to store all the values. However, one drawback with the Array data structure is that it would take
O(N) time complexity to remove or insert an element, rather than the desired O(1).

Since for any update operation, we would need to scan the entire bucket first to avoid any duplicate,
a better choice for the implementation of bucket would be the LinkedList, which has a constant time
complexity for the insertion as well as deletion, once we locate the position to update.

Algorithm: As we discussed in the above section, here we adopt the LinkedList to implement
our bucket within the HashSet. Essentially, we are implementing a LinkedList that does not contain any duplicate.
For each of the functions of add, remove and contains, we first generate the bucket index with the hash function.
Then, we simply pass down the operation to the underlying bucket.
*/

package _00_Problems_Sorted_By_Patterns;
import java.util.LinkedList;
public class _Design_04_Implement_HashSet {
    private Bucket[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public _Design_04_Implement_HashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i)
            this.bucketArray[i] = new Bucket();
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }

    public static void main(String[] args) {
        _Design_04_Implement_HashSet myHashSet = new _Design_04_Implement_HashSet();
         myHashSet.add(1);
         myHashSet.remove(2);
        System.out.println(myHashSet.contains(1));
        myHashSet.remove(1);
        System.out.println(myHashSet.contains(1));
    }
}

class Bucket {
    private final LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<Integer>();
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean exists(Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}
