/**
 [Goo_79] [Search_Item_And_Iterator]
--------------------------------------------------------------------------------------------------------------
 PROBLEM STATEMENT:
 Given a String (the search term) and an Iterator (the search space), write a function with the following signature
 that returns true if the search term is contained in the search space were it to be concatenated,
 or false otherwise:
 boolean contains(String term, Iterator space)

 */
package GooPrep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _Goo_79_Search_Item_And_Iterator_________________ {

    static String space = "";

    static boolean isExists(String s, Iterator<String> searchSpace){
        while(searchSpace.hasNext()){
            String current = searchSpace.next();
            space += current;
            System.out.println("current value of space: "+space);
            if(space.contains(s)){
                return true;
            }
            space = space.substring(getLastMisMatchIndex(space, s));  // need to implement pattern match algo
                                                                      // _Goo_24_03_String_Pattern_Matching_KMP
        }
        return false;
    }

    public static int getLastMisMatchIndex(String space, String s){
        int index = -1;
        for(int i=0, j=0; i < space.length(); i++){
            if(space.charAt(i)!=s.charAt(j)){
                index = i;
            } else{
                j++;
            }
        }
        if(index == -1){
            return 0;
        }
        return index+1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        //list.add("sa");
        //list.add("nto");
        list.add("san");
        list.add("to");
        list.add("sh");
        list.add("mo");
        list.add("on");
        list.add("done");

        String search = "santosh";  /*This is half working Solution*/


        boolean exist = isExists(search, list.iterator());
        System.out.println("Is given word "+ search + " Exist : " +  exist);

    }


}
