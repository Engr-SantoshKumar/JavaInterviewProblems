/* [ _Graph_Traversal_04_ ] [ Graph Valid Tree]
_______________________________________________________________________________
You have a graph of n nodes labeled from 0 to n - 1.
You are given an integer n and a list of edges where edges[i] = [ai, bi]
indicates that there is an undirected edge between nodes ai and bi in the graph.
Return true if the edges of the given graph make up a valid tree, and false otherwise.

                0                                   0                   0 --> 1
        ┌───────┴──                         ┌───────┴                   2---> 3      --> false
        1                                   1   ┌───┴
    ┌───┴───┐        ----> true             ┴─┐─┴   --> false
    2       3                                 3
  ┌─┘
 4

*/
package _00_Problems_Sorted_By_Patterns;
import java.util.*;
public class _Graph_Traversal_04_Graph_Valid_Tree {
    public static boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] current : edges){
            map.putIfAbsent(current[0], new ArrayList<>());
            map.get(current[0]).add(current[1]);
        }
        Set<Integer> hSet = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0); // given a graph of n nodes labeled from 0 to n - 1.

        while(!queue.isEmpty()){
            int cur = queue.poll();
            hSet.add(cur);
            List<Integer> currentList = map.get(cur);
            if(map.containsKey(cur)){
                for(int i: currentList){
                    if(hSet.contains(i))
                        return false;
                    hSet.add(i);
                    queue.add(i);
                }
            }
        }
        return hSet.size()==n;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] { {0,1},{2,4},{1,2}, {1,3}};
        System.out.println(validTree(5, edges));
    }
}

