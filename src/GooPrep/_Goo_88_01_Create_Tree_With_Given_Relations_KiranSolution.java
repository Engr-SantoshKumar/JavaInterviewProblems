/**
 [ 88 ] [ Create tree with given relation  ]
 ____________________________________________________________________________________________________________________

 Build a tree out of the following relation
 (parent, child)
 (paul, adam)
 (paul, chris)
 (adam, sara)
 (null, paul)
 if parent is null that is the oldest ancestor
 =Define the input you want to work wiht
 -Define the return type you will produce
 */
package GooPrep;

import java.util.*;

public class _Goo_88_01_Create_Tree_With_Given_Relations_KiranSolution{

    public static void main(String[] args) {
        List<Pair> list = constructPairs();
        TreeNodePC parent = buildTree(list);
        printParentChildRelation(parent);
    }

    public static TreeNodePC buildTree(List<Pair> list) {
        Map<String, TreeNodePC> map = new HashMap<>();
        String ancestor = "";
        for (Pair pair : list) {
            String parentName = pair.parent;
            String childName = pair.child;
            //System.out.println(String.format("parent: %s, child: %s ",parentName,childName));
            if (parentName != null) {
                if (map.containsKey(parentName)) {
                    TreeNodePC parent = map.get(parentName);
                    TreeNodePC child = new TreeNodePC(childName);
                    parent.children.add(child);
                } else {
                    TreeNodePC parent = new TreeNodePC(parentName);
                    TreeNodePC child = new TreeNodePC(childName);
                    parent.children.add(child);
                    System.out.println(parentName+" , "+parent.children.size());
                    map.put(parentName, parent);
                }
            } else {
                ancestor = childName;
            }
        }
        TreeNodePC parentNode = map.get(ancestor);
        return parentNode;
    }

    public static List<Pair> constructPairs() {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair("paul", "adam"));
        list.add(new Pair("paul", "chris"));
        list.add(new Pair("adam", "sara"));
        list.add(new Pair(null, "paul"));
        return list;
    }

    public static void printParentChildRelation(TreeNodePC node){
        Deque<TreeNodePC> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            TreeNodePC current = queue.pop();
            if (current != null) {
                System.out.println("Parent: " + current.name);
                int i = 0;
                List<TreeNodePC> childrens = current.children;
                System.out.print("Childrens: ");
                System.out.println(childrens.size());
                while (i < childrens.size()) {
                    TreeNodePC children = childrens.get(i);
                    queue.add(children);
                    System.out.print(children.name + ",");
                    i++;
                }
                System.out.println();
            }
        }
    }
}

class TreeNodePC {
    String name;
    List<TreeNodePC> children = new ArrayList<>();

    public TreeNodePC(String name) {
        this.name = name;
    }
}

class Pair {
    String parent;
    String child;

    public Pair(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }
}