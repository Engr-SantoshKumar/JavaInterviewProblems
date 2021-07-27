package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.List;

public class TreeHelper extends TreeNode {

    public static void print(TreeNode root)
    {  System.out.println("= = = = = = = = = = = Printing Tree = = = = = = = = = = = =");
        List<List<String>> lines = new ArrayList<List<String>>();

        List<TreeNode> level = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();

        //System.out.println(" adding root "+root.getText());
        level.add(root);

        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    int aa = n.value;
                    line.add(String.valueOf(aa));
                    if (String.valueOf(aa).length() > widest) widest = String.valueOf(aa).length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        //int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        int perpiece = lines.get(lines.size() - 1).size() * (widest + 2);
        if(perpiece > 100){
            perpiece = perpiece/2;
        }
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                            // c = (line.get(j) != null) ? '|' : '|';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                            //if (j < line.size() && line.get(j) != null) c = '|';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                            //System.out.print(j % 2 == 0 ? " " : "_");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        //System.out.print(j % 2 == 0 ? " " : " ");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                            //System.out.print(j % 2 == 0 ? "_" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
    public static void print(int[] ar){
        //int[] ar = new int[]{1,2,3,4,5,6,7,8,9};
        TreeHelper tp = new TreeHelper();
        TreeNode root = new TreeNode();
        root.value = ar[0];
        tp.construct(ar, root, 0);
        print(root);

    }
    public void construct(int[] ar, TreeNode root , int i){
        int N = ar.length-1;
        int leftChild = 2*i+1; int rightChild = leftChild+1;
        if(leftChild<=N){
            root.left = new TreeNode();
            root.left.value = ar[leftChild];
            //System.out.print("\n in construct root "+ root.text+" left "+root.left.text);
            construct(ar, root.left, leftChild);
        }
        if(rightChild<=N){
            root.right = new TreeNode();
            root.right.value = ar[rightChild];
            //System.out.print("\n root "+ root.text+" right "+root.right.text);
            construct(ar, root.right, rightChild);
        }
    }
    public static void main(String args[]){
        int[] ar = new int[]{1,2,3,4,5,6,7,8,9};
        new TreeHelper().print(ar);
    }

    public static TreeNode create(int[] ar){
        //int[] ar = new int[]{1,2,3,4,5,6,7,8,9};
        TreeHelper tp = new TreeHelper();
        TreeNode root = new TreeNode();
        root.value = ar[0];
        tp.construct(ar, root, 0);
        print(root);
        return root;
    }
}