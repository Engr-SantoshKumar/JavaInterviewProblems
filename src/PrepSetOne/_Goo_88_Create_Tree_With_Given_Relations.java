/**
[ 88 ] [ Create tree with given relation  ]
_____________________________________________________________________________________________________________

 */
package PrepSetOne;
/*
Child : Parent
    H : G
    F : G
    G : D
    E : D
    A : E
    B : C
    C : E
    D : NULL
    Z : Y
    Y : X
    X: NULL
=====================================
    D
    ├── E
    |   ├── A
    │   │
    │   └── C
    |       └── B
    └── G
    |   ├── F
    |   └── H
    |
    X
    └── Y
        |
        └──Z
 */

import java.util.*;

public class _Goo_88_Create_Tree_With_Given_Relations{

    private static void createFamilyTree(String[] childList, String[] parentList){
        List<String> cList = new ArrayList<>();

        Map<String, List<String>> relationMap = new HashMap<>();

        for(int i =0; i<parentList.length; i++){
            String curParent = parentList[i];
            if(!relationMap.containsKey(curParent)){
                relationMap.put(curParent, new ArrayList<>());
            }
            relationMap.get(curParent).add(childList[i]);
        }
        //System.out.println(relationMap);

        Queue<String> queue = new ArrayDeque<>();
        queue.offer("");

        while(!queue.isEmpty()){
            String currentParent = queue.poll();
            if(currentParent == ""){
                System.out.println("This is the start of family Tree");
            }

            List<String> currentChild = relationMap.get(currentParent);
            if(currentChild !=null) {
                System.out.print("Parent " + currentParent + " with : " + currentChild.size() + " Child  --> ");
                for (String ch : currentChild) {
                    System.out.print(ch + ", ");
                    queue.add(ch);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

    String[] child = {"H", "F", "G", "E", "A", "B", "C", "D", "Z", "Y", "X"};
    String[] patent = {"G", "G", "D", "D", "E", "C", "E", "", "Y", "X", ""};

    createFamilyTree(child, patent);
    }
}