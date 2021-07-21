/* [ _Graph_Traversal_02_ ] [ Topological Sort Course Schedule ]
_____________________________________________________________________________
Find the order to finish all the courses.

the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Course 0 depends on Course 1        1-->0
Input: numCourses = 2, prerequisites = [[1,0]]
o/p: true, To take course 1 you should have finished course 0. So it is possible.
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false, There are a total of 2 courses to take.
To take course 1 --> finished 0, and to take course 0 ---> finished course 1. So it is impossible

                0 ---> 1--->4
                ↑   ↗  ↑
                ↑↗     ↑
                2 ---> 3

to take course 4 u need to takeFirst 1, to take 1 u need to 0,2 and 3, course three required 2
So to finish all the courses we need to take courses in this order
2 --> 0, 3, 1 (1 required 0,2,3) so to mark 1 as done we need to check all the incoming vertex to be complete and
that's bring the concept of Topological sort, we keep the count of incoming vertex and keep reducing as visited
Logic:
    S ← Set of all nodes with no incoming edges
    while S is non-empty do
        remove a node n from S
        add n to tail of L
      for each node m with an edge e from n to m do
        remove edge e from the graph
        if (m has no other incoming edges then):
            insert m into S
    if (graph has edges then)
        return error (graph has at least one cycle)
    else
    return L (a topologically sorted order)

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.*;

public class _Graph_TopologicalSort_01_Schedule {

    //numCourses= total numberOfCourses, prerequisites = [[1,0]] currentCourse 0, depends on preCourse 1
    public static boolean courseScheduleInOrder(int numCourses, int[][] prerequisites) {

        //A map to track--> key: preCourse, Value: curCourse(e.g if completing preCourse eligible to take course in value)
        Map<Integer, List<Integer>> hashMapGraph = new HashMap<>();
        // A array to track--> indexAs node and value as NumberOfIncomingVertex
        int[] totalCoursesReqToCompleteCur = new int[numCourses];
        int[] orderOfCourse = new int[numCourses];

        for(int[] preReq :prerequisites){ //[]
            int curCourse = preReq[0];
            int preCourse = preReq[1];
            //update count of preReq for current course
            totalCoursesReqToCompleteCur[curCourse]++;
            //update map [preReq , inOrderToCompleteThese ]
            hashMapGraph.putIfAbsent(preCourse, new ArrayList<>());
            hashMapGraph.get(preCourse).add(curCourse);
        }

        /*
        Now we have hashMapGraph contains Key--> preCourse, to complete Course present in value
        Array totalCoursesReqToCompleteCur has total count of total preRequisites courses
        Now to stat with we need to find which course/courses does not have any preRequisites courses
         */
        Queue<Integer> queue = new ArrayDeque<>();
        //Scan array totalCoursesReqToCompleteCur to find nodes with 0 value
        for(int node=0; node<numCourses; node++ ){
            if(totalCoursesReqToCompleteCur[node]==0){
                queue.offer(node);
            }
        }

        int visited=0;
        //We will do BFS to access to all nodes
        while(!queue.isEmpty()){
            int curCourse = queue.poll();
            orderOfCourse[visited++] = curCourse;

            List<Integer> nextCourses = hashMapGraph.get(curCourse);
            if(nextCourses == null) continue;
            for(int nextCourse :nextCourses){
                //reduce the incoming vertex for next node
                totalCoursesReqToCompleteCur[nextCourse]--;
                //put in queue only if its incoming vertex count is 0
                if(totalCoursesReqToCompleteCur[nextCourse]==0){
                    queue.offer(nextCourse);
                }
            }
        }

        // if count != numCourses, there are cycles in the directed graph.
        System.out.println(Arrays.toString(orderOfCourse));
        return visited == numCourses;
    }

    public static void main(String[] args) {
        int[][] nodes = {{2,1},{2,0}, {3,1},{6,2},{4,2}, {4,3}, {5,4}};
        System.out.println(courseScheduleInOrder(7, nodes));
    };
}

