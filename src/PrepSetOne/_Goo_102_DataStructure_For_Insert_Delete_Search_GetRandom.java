/**
[ Goo 102 ] [ Design a data structure that supports insert, delete, search and getRandom in constant time]
____________________________________________________________________________________________________________________
 insert(x): Inserts an item x to the data structure if not already present.
 remove(x): Removes an item x from the data structure if present.
 search(x): Searches an item x in the data structure.
 getRandom(): Returns a random element from current set of elements
 */
package PrepSetOne;

import java.util.*;

public class _Goo_102_DataStructure_For_Insert_Delete_Search_GetRandom {

    static class MyDataStructure{
        ArrayList<Integer> myArrayList;
        // A hash where keys are array elements and value are indexes in arr[]
        HashMap<Integer, Integer> myHashMap;

        public MyDataStructure(){
            myArrayList = new ArrayList<>();
            myHashMap = new HashMap<>();
        }

        /*
        insert(x)
            1) Check if x is already present by doing a hash map lookup.
            2) If not present, then insert it at the end of the array.
            3) Add in the hash table also, x is added as key and last array index as the index.
         */

        public void add(int x){
            //put element at the end of arr[]
            if(!myHashMap.containsKey(x)){
                int lastIndex = myArrayList.size();
                // add to map and list
                myHashMap.put(x, lastIndex);
                myArrayList.add(x);

            }
            // If element x is already present, then noting to do
            else return;
        }

        /*
        remove(x)
            1) Check if x is present by doing a hash map lookup.
            2) If present, then find its index and remove it from a hash map.
            3) Swap the last element with this element in an array and remove the last element.
                    Swapping is done because the last element can be removed in O(1) time.
            4) Update index of the last element in a hash map.
         */

        public void remove(int x){
            // Check if element is present
            Integer curElementListIndex = myHashMap.get(x);
            if (curElementListIndex == null){
                System.out.println("Not present in my DS : " + x);
                return; //--> not present
            }
            //if present remove
            myHashMap.remove(x);

            // swap xIndex <--> LastIndex
            int size = myArrayList.size();
            Integer valueOfListLastIndex = myArrayList.get(size-1);
            Collections.swap(myArrayList, curElementListIndex, size-1);

            //update map
            myHashMap.put(valueOfListLastIndex, curElementListIndex);

            // delete the last element from list
            myArrayList.remove(size-1);

            System.out.println("Removed : " + x + " from my DS");

        }

        /*
        getRandom()
            1) Generate a random number from 0 to last index.
            2) Return the array element at the randomly generated index.
         */
        public int getRandom(){
            Random randomNumberFromList = new Random();
            int index = randomNumberFromList.nextInt(myArrayList.size());
            return myArrayList.get(index);
        }

        /*
        search(x)
             Do a lookup for x in hash map.
         */

        public Integer isPresent(int x){
            return myHashMap.get(x);

        }
    }

    // test
    public static void main(String[] args) {
        MyDataStructure myDS = new MyDataStructure();
        myDS.add(10);
        myDS.add(20);
        myDS.add(30);
        myDS.add(40);
        System.out.println("Present at index : " + myDS.isPresent(30));
        myDS.remove(20);
        myDS.remove(20);
        myDS.add(50);
        System.out.println(myDS.isPresent(50));
        System.out.println(myDS.getRandom());
    }




}