/* [ _Graph_Dijkstra_01_ ] [ Network Delay Time ..Minimum time to visit all nodes ]
_______________________________________________________________________________
Dijkstra's original algorithm found the shortest path between two given nodes,
but a more common variant fixes a single node as the "source" node and finds shortest paths from
the source to all other nodes in the graph, producing a shortest-path tree.

Problem:
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times
as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and
wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
If it is impossible for all the n nodes to receive the signal, return -1.

                            [ 1 ] → → → → → → → → → → [ 3 ]
                          ↙  ↓  ↑  ↘        3           ↓   ↘
                     5 ↙     ↓  ↑    ↘                  ↓     ↘6
                     ↙       ↓  ↑      ↘                ↓        ↘
                [ 0 ]        ↓  ↑         ↘             ↓           [ 5 ]
                    ↘      2 ↓  ↑ 3         ↘ 20        ↓          ↗
                      ↘      ↓  ↑             ↘         ↓ 2      ↗ 1
                    1   ↘    ↓  ↑               ↘       ↓     ↗
                          ↘  ↓  ↑                 ↘     ↓  ↗
                             [ 2 ]→ → → → → → →→ → → [ 4 ]
                                            12


Input: times =[source, destination, time ]
[0]--1-->[2]--3-->[1]--3-->[3]--2-->[4]--1-->[5] == 10 sec

Complexity Analysis:
Time Complexity: O(N^2 + E)m where E is the length of times in the basic implementation,
and O(E logE) in the heap implementation, as potentially every edge gets added to the heap.

Space Complexity: O(N + E), the size of the graph O(E), plus the size of the other objects used O(N).
*/
package _00_Problems_Sorted_By_Patterns;
import java.util.*;

public class _Graph_Dijkstra_01_Network_Delay_Time {

    public static int networkDelayTime(int[][] graph, int totalNodes, int source) {
        // need map to link the nodes
        Map<Integer, List<int[]>> hashMapGraph = new HashMap();
        for (int[] edge : graph) {  //--> edge [source, destination, time]
            hashMapGraph.putIfAbsent(edge[0], new ArrayList<int[]>());
            hashMapGraph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        //pq [distNode, time] --> priority on time
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        //initially load pq with the source, toGetToSourceFromSource ->0
        pq.offer(new int[]{source, 0});

        // need another map to keep track of destinationNode and timeTaken
        Map<Integer, Integer> distMap = new HashMap();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curTime = current[1];
            //if visited --> skip, as we are using PQ so the least time node will process first and
            // so if the node is already visited means we get there already with smaller time
            if (distMap.containsKey(curNode)){
                continue;
            }
            distMap.put(curNode, curTime);
            //find the neighbours and add to qp time will be curTime + newTime
            if (hashMapGraph.containsKey(curNode))
                for (int[] edge : hashMapGraph.get(curNode)) {
                    int newNode = edge[0], newTime = edge[1];
                    if (!distMap.containsKey(newNode))
                        pq.offer(new int[]{newNode, curTime+newTime});
                }
        }
        // to check if we visited all nodes or not we check distMap size to given totalNode
        if (distMap.size() != totalNodes) return -1;
        int ans = 0;
        //loop map for max value
        for (int time: distMap.values())
            ans = Math.max(ans, time);
        return ans;
    }

    public static void main(String[] args) {
        int[][] nodes = {
                            {0,1,5}, {0,2,1},
                            {1,2,2}, {1,3,3}, {1,4,20},
                            {2, 1, 3}, {2,4,12},
                            {3,4,2}, {3,5,6},
                            {4,5,1}
                        };
        System.out.println(networkDelayTime(nodes, 6, 0));
    }
}