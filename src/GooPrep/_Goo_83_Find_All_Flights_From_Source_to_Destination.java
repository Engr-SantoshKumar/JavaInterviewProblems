/**
 [83] [Find_All_Flights_From_Source_to_Destination ]
-----------------------------------------------------------------------------------------------------
 Given a list of routes with departure and destination airports.
 write a function to find out all flights routes from SFO to NYC
 Input :
 SFO -> LAX
 SFO -> DEN
 SFO -> NYC
 LAX -> DEN
 LAX -> IAH
 DEN -> NYC
 IAH -> NYC

 output:
 SFO -> NYC
 SFO -> DEN -> NYC
 SFO -> LAX -> NYC
 SFO -> LAX -> DEN -> NYC
 SFO -> LAX -> IAH -> NYC
 */
package GooPrep;

import java.util.*;

public class _Goo_83_Find_All_Flights_From_Source_to_Destination {

    public static void findAllRoutesBetweenGivenAirports(List<Flight> flightList, 
                                                         String source, String destination){

        // first create a map/graph from flightList
        HashMap<String, List<String>> sourceDestinationGraph = new HashMap<>();

        for(Flight flight : flightList){
            if(sourceDestinationGraph.containsKey(flight.source)){
                List<String> destinations = sourceDestinationGraph.get(flight.source);
                destinations.add(flight.Destination);
                sourceDestinationGraph.put(flight.source, destinations);
            }else{
                List<String> destinations = new ArrayList<>();
                destinations.add(flight.Destination);
                sourceDestinationGraph.put(flight.source, destinations);
            }
        }
        System.out.println(sourceDestinationGraph);
        
        // find all possible path using BFS 
        findAllRoutesBFS(sourceDestinationGraph, source, destination);
    }
    
    
    public static void findAllRoutesBFS(HashMap<String, List<String>> Graph,
                                              String source, String destination)
    {
        List<LinkedHashSet<String>> allPathsResult = new ArrayList<LinkedHashSet<String>>();
        Queue<SourceWithPath> queue = new ArrayDeque<>();

        // first put the source in Queue as (source and destination)
        LinkedHashSet<String> firstPath = new LinkedHashSet<>();
        firstPath.add(source);

        queue.add(new SourceWithPath(source, firstPath));

        while(!queue.isEmpty()){
            SourceWithPath currentPath = queue.poll();

            //if source and dest same that means we reached the dest
            if(currentPath.source == destination)
                allPathsResult.add(currentPath.path);

            // if the Graph/map doesn't contain source (i.e key) means no flight going out
            // from here and we can just skip it
            if(!Graph.containsKey(currentPath.source))
                continue;

            // visit all the dest of the current source and if the current stop is not already visited,
            // add to the current path and make current path the new source
            for(String dist: Graph.get(currentPath.source) ){
                if(currentPath.path.contains(dist))
                    continue; // skip already visited path

                //create a new object for Q with current source as source and update the path with existing+currentPath
                LinkedHashSet<String> updatedPath = new LinkedHashSet<>();
                updatedPath.addAll(currentPath.path);
                updatedPath.add(dist);
                queue.offer(new SourceWithPath(dist, updatedPath));
            }
        }

        //to print the all the path
        for(LinkedHashSet<String> ll : allPathsResult){
            System.out.println(ll);
        }
    }

    public static void main(String args[]) {
        Flight a = new Flight("SFO", "LAX");
        Flight b = new Flight("SFO", "DEN");
        Flight c = new Flight("SFO", "NYC");
        Flight d = new Flight("LAX", "DEN");
        Flight e = new Flight("LAX", "IAH");
        Flight f = new Flight("DEN", "NYC");
        Flight g = new Flight("IAH", "NYC");
        Flight gd = new Flight("IAH", "IAH");
        Flight h = new Flight("DEN", "ABC");

        List<Flight> list = new ArrayList<>();
        list.add(h); list.add(a);list.add(b);list.add(c);list.add(d);
        list.add(e); list.add(f);list.add(g);list.add(gd);

        findAllRoutesBetweenGivenAirports(list, "SFO", "NYC");
    }
}

class Flight {
    String source;
    String Destination;

    public Flight(String source, String Destination) {
        this.source = source;
        this.Destination = Destination;
    }
}
class SourceWithPath{
        String source;
        LinkedHashSet<String> path;

        public SourceWithPath(String source, LinkedHashSet path){
            this.path = path;
            this.source = source;
        }
}

