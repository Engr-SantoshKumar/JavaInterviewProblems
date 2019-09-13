package _01_Coderust._06_Graph;



/**
 * A simple undirected and unweighted graph implementation.
 *
 * @param <T> The type that would be used as vertex.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Graph_UnDirected <T> {

    HashMap<T, List<T>> Grp;

    //Graph object
    public Graph_UnDirected(){
        Grp = new HashMap();
    }


    /**
     * Add new edge between vertex. Adding new edge from u to v will
     * automatically add new edge from v to u since the graph is undirected.
     *
     * @param v Start vertex.
     * @param u Destination vertex.
     */
    public void addEdge(T v, T u) {
        if (!Grp.containsKey(v)) {
            Grp.put(v, new ArrayList<T>());

        }
        if (!Grp.containsKey(u)) {
            Grp.put(u, new ArrayList<T>());

        }
        Grp.get(v).add(u);
        Grp.get(u).add(v); //Only diff b/w directed and undirected i.e for undirected we need to add in both
    }

    public List<T> getAdj(int v){
        return Grp.get(v);
    }

    public Set<T> vertices(){
        return Grp.keySet();
    }


    public static void main(String[] args) {
        Graph_Directed<Integer> G = new Graph_Directed();
        G.addEdge(5, 6);
        G.addEdge(5, 8);
        G.addEdge(8, 6);

        List<Integer> adj =null;
        adj = G.getAdj(5);
        for(Integer t : adj) {
            System.out.println("adj of 5 "+t);
        }

        adj =null;
        adj = G.getAdj(6);
        for(Integer t : adj) {
            System.out.println("adj of 8 "+t);
        }
    }


}
