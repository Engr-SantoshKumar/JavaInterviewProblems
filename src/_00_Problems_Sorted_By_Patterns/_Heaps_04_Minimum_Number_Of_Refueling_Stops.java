/* [ _Heaps_04_ ] [ Minimum Number of Refueling Stops ]
_______________________________________________________________________________
    A car travels from a starting position to a destination which is target miles east of the starting position.
    There are gas stations along the way.
    The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that
    the ith gas station is positioni miles east of the starting position and has fueli liters of gas.
    The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
    It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel,
    transferring all the gas from the station into the car.
    Return the minimum number of refueling stops the car must make in order to reach its destination.
    If it cannot reach the destination, return -1.
    Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
    If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

 ●  Input: target = 100, startFuel = 35, Stations = [(10, 25), (20, 12), (30,21), (40, 5), (50,3)]
 ●  Output: 2
   
    Start at 0, with start fuel = 35
    Stations = [(10, 25), (20, 12), (30,21), (40, 5), (50,3)]
    35.......25.......12.......21.......5........3................... (fuel)
    |--------|--------|--------|--------|--------|------------------> (stations)
    0.......10.......20.......30........40.......50.................. (distance)
    
    Obviously, with 0 steps, the max distance we can reach is 35.
    The question now is with 1 steps, what is the max distance we can reach?
    
    35.......25.......12.......21.......5........3................... (fuel)
    |--------|--------|--------|--------|--------|------------------> (stations)
    0.......10.......20.......30...|....40.......50.................. (distance)
    ...............................|.................................
    ...............................35................................ (max distance can reach after 0 step)
    
    When we reach 35, we pass by 3 stations [10, 20, 30]. It means we can possibly refuel at these stations.
    
    Refuel at 10: max distance = 10 + (35 - 10 + 25) = 35 + 25 = 60
    Refuel at 20: max distance = 20 + (35 - 20 + 12) = 35 + 12 = 47
    Refuel at 30: max distance = 30 + (35 - 30 + 21) = 35 + 21 = 56
  ●    We notice that apparently the max distance does not depends on the station's position, but the station's fuel.
    Apparently, the maximum distance of k+1 steps = maximum distance of k steps + maximum fuel of stations that
    the car has passed by (counting from the last station that makes the previous maximum distance)
    
    35......[25]......12.......21.......5........3................... (fuel)
    |--------|--------|--------|--------|--------|------------------> (stations)
    0.......[10]......20.......30...|...40.......50.................. (distance)
    ...............................|....................|............
    ...............................35...................|............ (max distance can reach after 0 step)
    ....................................................60........... (max distance can reach after 1 step)
    
    When we reach 60, we reach more 2 stations [40, 50], so if :
    
    Refuel at 20: max distance = 10 + (60-10) - (20-10) + (20-10) + 12 = 60 + 12 = 72
    Refuel at 30: max distance = 10 + (60-10) - (30-10) + (30-10) + 21 = 60 + 21 = 81
    Refuel at 40: max distance = 10 + (60-10) - (40-10) + (40-10) + 5 = 60 + 5 = 65
    Refuel at 50: max distance = 10 + (60-10) - (50-10) + (50-10) + 3 = 60 + 3 = 63
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.PriorityQueue;
import java.util.Queue;

public class _Heaps_04_Minimum_Number_Of_Refueling_Stops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        //we don't have to stop if the start is enough
        if(startFuel>target) return 0;
        int maxDistance = startFuel;
        int i=0, noOfStops=0;
        int totalStations = stations.length;
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        while(maxDistance < target){
            //put all the stations fuel in pq within the current range
            while(i<totalStations && maxDistance >= stations[i][0]){
                pq.offer(stations[i][1]);
                i++;
            }
            //if nothing in pq means we did not able to reach the next station
            if(pq.isEmpty()) return -1;

            //update max distance and noOfStops
            maxDistance += pq.poll();
            noOfStops++;
        }
        return noOfStops;
    }

    public static void main(String[] args) {
        int[][] stations = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        int startFuel = 10;
        int target = 100;
        //System.out.println(minRefuelStops(target,startFuel,stations));
        System.out.println(minRefuelStops(target,50,new int[][]{{50, 50}}));
    }
}
