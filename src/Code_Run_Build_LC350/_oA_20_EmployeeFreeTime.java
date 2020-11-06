/*
 * [ _oA_20_ ] [ [Pattern: Merge Intervals ] Employee Free Time ]
 _______________________________________________________________________________________________________________
 We are given a list schedule of employees, which represents the working time for each employee.
Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
*
* LOGIC:
1. sorted the meetings by start time, and for same start time sort by either largest end time or smallest (it is not matter).
2. Everytime you poll from sorted list/pq, just make sure it doesn't intersect with previous interval.
This mean that there is no common interval and everyone is free time.
 */
package Code_Run_Build_LC350;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _oA_20_EmployeeFreeTime {
    public static List<Interval> employeeFreeTime(List<Interval>schedule) {

        List<Interval> result = new ArrayList<>();
        //base cases
        if(schedule==null || schedule.size() ==0) return result;

        //load schedule to PQ or sort schedule
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (Interval e : schedule) {
            pq.offer(e);
        }

        //sorting schedule
        //Collections.sort(schedule, ((a, b) -> a.start - b.start));

        Interval current = pq.poll();

        while(!pq.isEmpty()){
            if(current.end < pq.peek().start){ // no intersection i.e there is a gap/free time
                result.add(new Interval(current.end, pq.peek().start));
                current = pq.poll();
            }else{
                // intersect or sub merged either it will be current or pq.poll which ever is lasting longer
                current = current.end < pq.peek().end ? pq.peek() : current;
                pq.poll();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Existing Intervals
        List<Interval> existingIntervals = new ArrayList<Interval>();
        existingIntervals.add(new Interval(1,5));
        existingIntervals.add(new Interval(4,6));
        existingIntervals.add(new Interval(11,15));
        existingIntervals.add(new Interval(12,13));
        existingIntervals.add(new Interval(7,9));

        List<Interval> finalList = employeeFreeTime(existingIntervals);

        /* Print final result */
        for(Interval interval : finalList){
            System.out.println(interval.start+", "+interval.end);

        }
    }
}
// Definition for an Interval.
class Interval {
    public int start;
    public int end;
    public Interval() {}
    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
