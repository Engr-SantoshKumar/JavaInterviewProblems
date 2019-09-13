package _01_Coderust._06_Graph;

import java.util.*;
/*
            1
		   / \
		  2   3       7->8
		 / \   \
		4   5   6

*/
public class _x_01_Graph_DFS {

    static Set<Integer> visited = new HashSet<>();
    static Map<Integer, Integer> edgeToMap = new HashMap<>();


    /*
        We will get a map like below from the dfs method

         w  | v
       ----------
         2  |  1
         3  |  1
         4  |  2
         5  |  2
         6  |  3

     */

    public static void dfs(Graph_UnDirected<Integer> G, Integer v){
        visited.add(v);
        for(Integer w : G.getAdj(v)){
            if(!visited.contains(w)){
                edgeToMap.put(w, v);
                dfs(G, w);
            }
        }
    }


    /*
     how pathToSource method works
     1. starts with the destination, get the value of dest:  6(key) -->  3 (value) from the above map
     2. now we make 3 as destinations and get the its value: 3(key) -->  1 (value)
     3. will put these values in stack and once the start pulling the values top most will
        be the source and last will be destination
    */


    public static ArrayDeque<Integer> pathToSource (int source, int dest){

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        if(!edgeToMap.containsKey(dest))
            return null;

        while(source != dest){
            stack.push(dest);
            dest = edgeToMap.get(dest);
        }
        stack.push(source);
        return stack;

    }



    public static void main(String[] args) {
        Graph_UnDirected<Integer> G = new Graph_UnDirected<>();
        G.addEdge(1, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(2, 5);
        G.addEdge(3, 6);
        G.addEdge(7, 7);
        G.addEdge(8, 7);
        dfs(G, 1);
        System.out.println(visited.toString());
        for(Map.Entry<Integer, Integer> entry : edgeToMap.entrySet()) {
            System.out.println(" "+ entry.getKey()+" : "+entry.getValue());
        }
        // Find path between 1 and 6

        ArrayDeque<Integer> stack = pathToSource(1,6);
        StringBuilder sb = new StringBuilder();
        while(stack != null && !stack.isEmpty()) {
            sb.append(stack.pop()).append("->");
        }
        System.out.println("path is "+sb);
    }
	/*Other way to find path
	StringBuilder sb = new StringBuilder();
	int dest=8; int source = 1;
	while(dest!=source) {
		sb.append(dest).append("->");
		System.out.println(" new dest "+dest);
		dest = edgeToMap.get(dest);
		if(dest == edgeToMap.get(dest)) {
			break;
		}
	}
	sb.append(source);
	*/
}
