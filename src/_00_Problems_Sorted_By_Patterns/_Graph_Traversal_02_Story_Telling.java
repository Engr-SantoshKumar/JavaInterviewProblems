/* [ _Graph_Traversal_02_ ] [ Story_Telling ]
_______________________________________________________________________________
When a person who knows it meets any other person, they immediately share the story with them.
Initially, only person 1 knows the story. Given a list of meetings between people in a form of
(person_1_id, person_2_id, timestamp) construct a list of the persons who will know the story
at the very end.

Example: [ (1,2, 100), (4,6, 100), (3,4, 200), (1,3, 200), (2,5, 400), (6,7, 300)], p -> 1.(1 know the story in start)
Person 2 will learn the story at the moment 100, person 3, 4 — at the moment 200 from 1 and 3 respectively.
person 5 — in the moment 400. Person 6 will never learn the story(6 meet with 4 at 100 that time 4 doesn't have story).
So the answer is [1, 2, 3, 4, 5].

Eg2: [(1, 2, 100), (4, 5, 100), (2, 3, 100),] p--> 2
where the first parameter is array of the Persons meet at particular timestamp,
second parameter is the PersonId who knows the story first.
Output: [1, 2, 3]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.*;
import java.util.LinkedList;

public class _Graph_Traversal_02_Story_Telling {

    public static Collection<Integer> storyTelling(int[][] meetings, int firstPerson){
        // base
        List<Integer> result = new LinkedList<>();
        result.add(firstPerson);
        if(meetings == null || meetings.length ==0) return result;

        // we need a map to link persons e.g person 1 tells story to 2 and 3 at what times.
        // map --> (K) person1 | (V) [person2, Time] [Person3, Time]
        Map<Integer, List<int[]>> map = new HashMap<>();

        // need a set to store who all learn the sort
        Set<Integer> visited = new HashSet<>();

        //A queue to do BFS queue --> [2, 100] | [4, 200]...
        Queue<int[]> queue = new ArrayDeque<>();

        // link persons using map
        for (int[] meeting : meetings) {
            int p1 = meeting[0];
            int p2 = meeting[1];
            int t = meeting[2];
            map.putIfAbsent(p1, new LinkedList<>());
            map.get(p1).add(new int[]{p2, t});
        }
        //add firstPerson to visited
        visited.add(firstPerson);

        //initialize the queue with adding all the person with time personOne meet
        for(int[] pt : map.get(firstPerson)){
            queue.offer(pt);
        }

        //bfs : how this will work ..get personX and Time from queue, get PersonX Values from map to find with whom
        //      PersonX going to interact and at what time.. if time is after the PersonX has story at next person to Q
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curPerson = current[0];
            int curTime = current[1];
            if (visited.contains(curPerson)) continue;// trying to avoid cycle
            visited.add(curPerson);
            if(map.containsKey(curPerson)){
                for(int[] ptNext : map.get(curPerson)){
                    if(curTime <= ptNext[1]){ // add to queue only if the current person meet with other after having story
                        queue.offer(ptNext);
                    }
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        int[][] meetings = new int[][] {{1, 2, 100},
                                        {4, 6, 100},
                                        {3, 4, 200},
                                        {1, 3, 200},
                                        {2, 3, 200},
                                        {2, 5, 400},
                                        {6, 7, 300}};

        System.out.println(storyTelling(meetings, 1));
    }
}
