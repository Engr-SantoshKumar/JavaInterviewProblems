package _01_Coderust._06_Graph;

public class Testing_Graph_functions {


    public static void main(String[] args) {
        Graph<Integer> grp = new Graph<>();
        int[] v = {2, 4, 6, 8, 9, 10, 15};
        for(int i: v){
            grp.addVertex(i);
        }

        System.out.println(" === getAllVertices ===");
        System.out.println(grp.getAllVertices());

        grp.addEdge(2,8);
        grp.addEdge(8,10);
        grp.addEdge(2,10);
        grp.addEdge(2,15);

        System.out.println(" === getNeighbors ===");
        System.out.println(grp.getNeighbors(2));
        System.out.println(grp.getNeighbors(6));

        System.out.println(" === removeEdge ===");
        grp.removeEdge(2,15);

        System.out.println(" === getNeighbors ===");
        System.out.println(grp.getNeighbors(2));

        System.out.println(" === removeVertex ===");
        grp.removeVertex(15);

        System.out.println(" === getAllVertices ===");
        System.out.println(grp.getAllVertices());

    }
}

