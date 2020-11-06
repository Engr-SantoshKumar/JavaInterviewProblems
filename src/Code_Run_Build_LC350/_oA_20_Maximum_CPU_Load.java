/*
 * [_oA_16 ] [Maximum CPU Load from the given list of jobs ]
_________________________________________________________________________________________________________________
Given an array of jobs with different time requirements, where each job consists of start time,end time and CPU load.
The task is to find the maximum CPU load at any time if all jobs are running on the same machine.
Examples:
Input: jobs[] = {{1, 4, 3}, {2, 5, 4}, {7, 9, 6}}
Output: 7
Explanation:
In the above-given jobs, there are two jobs which overlaps.
That is, Job [1, 4, 3] and [2, 5, 4] overlaps for the time period in [2, 4]
Hence, the maximum CPU Load at this instant will be maximum (3 + 4 = 7).
*
Logic:
 1. First sort the jobs with start time.
 2. Maintain min-heap(PQ) for the jobs on the basis of their end times
 3. Go through the sorted jobs list and Check PQ if any job is ending before the start of current job if so
    remove those jobs from PQ and update maximum CPU Load
    (current max load will be the sum of all the jobs that are present in the min-heap)
 */
package Code_Run_Build_LC350;
import java.util.*;
public class _oA_20_Maximum_CPU_Load {

    public static int maximumCPULoad(List<Process> jobs){
        //base cases check
        if(jobs.isEmpty()) return 0;
        //Step 1: First sort the jobs with start time
        Collections.sort(jobs, new Comparator<Process>(){
            public int compare(Process a, Process b) {
                return a.start - b.start;
            }
        });
        //Step 2: need Priority Queue for Process where jobs sorted on end Time
        Queue<Process> pq = new PriorityQueue<>((a,b) -> a.end-b.end);
        int maxLoad=0; int currentLoad =0;
        //Step 3: Loop through jobs and update pq as needed
        for(Process currentJob : jobs){
            //check pq and remove all those jobs ended before the start of current job
            while(!pq.isEmpty() && pq.peek().end < currentJob.start){
                currentLoad -= pq.poll().load;
            }
            pq.offer(currentJob);
            currentLoad+=currentJob.load;
            maxLoad = Math.max(currentLoad, maxLoad);
        }
        return maxLoad;
    }


    public static void main(String[] args) {
        List<Process> jobs = new ArrayList<Process>();
        jobs.add(new Process(6,7,4 ));
        jobs.add(new Process(2,4, 7));
        jobs.add(new Process(8,12, 5));
        jobs.add(new Process(3,5, 9));

        System.out.println(maximumCPULoad(jobs));
    }
}

class Process{
    int start;
    int end;
    int load;
    public Process(int s, int e, int l){
        this.start=s;
        this.end=e;
        this.load=l;
    }
}
