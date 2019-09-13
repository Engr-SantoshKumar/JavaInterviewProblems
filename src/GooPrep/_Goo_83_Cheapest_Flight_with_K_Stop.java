/**
[83] [Cheapest Flights Within K Stops]
-----------------------------------------------------------------------------------------------------
 There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 Now given all the cities and flights, together with starting city src and the destination dst,
 your task is to find the cheapest price from src to dst with up to k stops.
 If there is no such route, output -1.

 Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]] --> [source, destination, cost]
 src = 0, dst = 2, k = 1
 Output: 200

 Complexity Analysis

 Time Complexity: O(E + n \log n)O(E+nlogn), where E is the total number of flights.
 Space Complexity: O(n)O(n), the size of the heap.

  */
package GooPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _Goo_83_Cheapest_Flight_with_K_Stop {

    public static int findCheapestPrice(int nodes, int[][] flights, int source, int destination, int noOfStops)
    {
        // first create a map/graph with given flights
        Map<Integer, HashMap<Integer, Integer>> mapWithSrcPrice = new HashMap<>();

        for(int[] src : flights){
            if(!mapWithSrcPrice.containsKey(src[0])){
                mapWithSrcPrice.put(src[0], new HashMap<>());
            }
            mapWithSrcPrice.get(src[0]).put(src[1], src[2]);
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] {0, source, noOfStops+1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == destination)
                return price;

            if (stops > 0) {
                Map<Integer, Integer> adj = mapWithSrcPrice.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
            if (city == 1) printQueue(pq);
        }
        return -1;
    }

    public static void printQueue(Queue<int[]> pq) {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            System.out.println("City:" + top[1] + ",Cost:" + top[0] + ",Stop:" + top[2]);
        }
    }

    public static void main(String[] args) {
        int noOfAirPorts = 3;
        int[][] flights = new int[][] {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0, dst = 2, k = 1;
        findCheapestPrice(noOfAirPorts, flights, src, dst, k);
    }


}
