package _01_Coderust._06_Graph;

import java.util.*;
/*
            1
		   / \
		  2   3       7->8
		 / \   \
		4   5   6

*/
public class _x_02_Graph_BFS {
    static void bfs(Graph_Directed<Integer> G) {
        // get fist vertex
        int s = 1;
        bfs(G, s);
    }

    static Map<Integer, Integer> edgeTo = new HashMap<>();
    static Map<Integer, Integer> pathLength = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();

    static void bfs(Graph_Directed<Integer> G, int source) {
        //Queue<Integer> q = new LinkedList<>(); //old style
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(source);
        visited.add(source);
        pathLength.put(source,0);

        while(!q.isEmpty()) {
            System.out.println(" q at this point is "+q);
            Integer current = q.poll(); // there is no enque and deque in ArrayDQ
            List<Integer> adjList = G.getAdj(current);
            //System.out.println(" adj of .. "+v+ " are "+Arrays.toString(adj.toArray()));
            for(Integer adj : adjList) {
                if(!visited.contains(adj)) {
                    q.offer(adj);
                    visited.add(adj);
                    edgeTo.put(adj, current);
                    pathLength.put(adj, pathLength.get(current)+1);
                }
            }
        }
        for(Map.Entry<Integer, Integer> entry : edgeTo.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue()+" "+pathLength.get(entry.getKey()));
        }
    }


    static Integer getSourceVertex(Graph_Directed<Integer> G) {
        // get any edge let say the first in Graph
        Set<Integer> vertices = G.vertices();
        if(!vertices.isEmpty()) {
            return vertices.iterator().next();
        }
        return -1;
    }

    static ArrayDeque<Integer> pathToSource(int source, int dest){
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        if(!edgeTo.containsKey(dest)) {
            return null;
        }
        while(source != dest) {
            stack.push(dest);
            dest = edgeTo.get(dest);
        }
        stack.push(source);
        return stack;
    }


    public static void main(String[] args) {
        Graph_Directed<Integer> G = new Graph_Directed<>();
        G.addEdge(1, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(2, 5);
        G.addEdge(3, 6);
        G.addEdge(5, 6);
        G.addEdge(7, 7);
        G.addEdge(8, 7);
        bfs(G);
        System.out.println(visited.toString());
        for (Map.Entry<Integer, Integer> entry : edgeTo.entrySet()) {
            System.out.println(" " + entry.getKey() + " : " + entry.getValue());
        }
        // Find path between 1 and 6

        ArrayDeque<Integer> stack = pathToSource(1, 6);
        StringBuilder sb = new StringBuilder();
        while (stack != null && !stack.isEmpty()) {
            sb.append(stack.pop()).append("->");
        }
        System.out.println("path is " + sb);

    }
}
