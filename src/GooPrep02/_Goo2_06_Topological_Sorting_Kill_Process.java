/** Goo2_06 [Kill Process]
 -------------------------------------------------------------------------------------------------------
 Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

 Each process only has one parent process, but may have one or more children processes.
 This is just like a tree structure. Only one process has PPID that is 0,
 which means this process has no parent process. All the PIDs will be distinct positive integers.

 Input:
 pid =  [3, 0, 5,  3,  5,  12, 12, 16, 16]
 ppid = [1, 3, 10, 5, 12,  13, 16, 17, 13]
 kill = 5
 Output: [5, 10, 12, 16, 17, 13]
 Explanation:
                3
              /   \
             1     5   --> kill
                 /  \
                10   12 -- 16 --17
                      \   /
                        13
 Kill 5 will also kill 10, 12, 13. in order first 13 then 12 then 10

 */
package GooPrep02;

import java.util.*;

public class _Goo2_06_Topological_Sorting_Kill_Process {

    public static HashSet<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        // some variables
        HashMap<Integer, List<Integer>> gMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        LinkedHashSet<Integer> result = new LinkedHashSet<>();

        // build the graph out of pid and pPid
        gMap = buildConnectedGraph(pid, ppid);  // {0=[3], 16=[17], 3=[1, 5], 5=[10, 12], 12=[13, 16]}

        queue.add(kill);

        //BFS
        while(!queue.isEmpty()){
            int currentProcess = queue.poll();

            if(result.contains(currentProcess)){
                result.remove(currentProcess);  // removing and adding back just to make sure if any pid as multiple
            }                                   // parent pids.. want to put in the kill list first
            result.add(currentProcess);

            List<Integer> list = gMap.get(currentProcess);
            if(list == null || list.size() == 0) continue;

            for(Integer child : list) {
                queue.offer(child);
            }
         }

        return result;
    }

    public static HashMap<Integer, List<Integer>> buildConnectedGraph(List<Integer> pid, List<Integer> ppid){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i =0; i < pid.size(); i++){
            int parentID = ppid.get(i);

            if(!graph.containsKey(parentID)){
                List<Integer> curProcess = new ArrayList<>();
                curProcess.add(pid.get(i));
                graph.put(parentID, curProcess);
            }else{
                graph.get(parentID).add(pid.get(i));
            }
        }
        return graph;
    }


    public static void main(String[] args) {
        List<Integer> pPid = new ArrayList<>();
        pPid.addAll(Arrays.asList(3, 0, 5,  3,  5,  12, 12, 16, 16 ));
        List<Integer> pid =  new ArrayList<>();
        pid.addAll(Arrays.asList (1, 3, 10, 5, 12,  13, 16, 17, 13 ));
        int kill = 5;

        HashSet<Integer> result = (HashSet<Integer>) killProcess(pid, pPid, kill);

        System.out.println(result);
    }

}

/*
OUTPUT:
                3
              /   \
             1     5------> kill
                 /  \
                10   12 -- 16 --17
                      \   /
                        13

[5, 10, 12, 16, 17, 13]
 */