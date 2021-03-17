/** 13 [Insert new Interval]
----------------------------------------------------------------------------------------------------------------
 You are given a sorted list of disjoint intervals and an interval.
 Input:
 List => [5, 10], [15, 20], [30, 40], [50, 90]
 New Interval => [32, 48]
 Merge a sorted list of disjoint intervals with an interval."
 */
package GooPrep;

import java.util.*;

public class _Goo_13_a_Insert_New_Interval_Comparator {

    public static List<Interval> mergeInterval(List<Interval> existingIntervals, Interval newInterval){

        List<Interval> finalResult = new ArrayList<Interval>();
        if(existingIntervals == null || existingIntervals.size() ==0){
            finalResult.add(newInterval);
            return finalResult;
        }

        // First sort the existingIntervals with start timing
        Collections.sort(existingIntervals, ((a, b) -> a.start -b.start));

        /** looping through existing intervals and will check where to insert the new interval */
        for(Interval curInterval: existingIntervals){
            /* Cases 1: when new interval starts after current Interval */
            if(curInterval.end < newInterval.start){
                finalResult.add(curInterval);
            }

            /* Cases 2: when new interval ends before current Interval starts */
            else if (newInterval.end < curInterval.start){
                finalResult.add(newInterval);
                // make currentInterval as newInterval else this currentInterval will be lost
                newInterval = curInterval;
            }
            /**Merge case (Both intervals are overlapping, will merge both and assign to newInterval **/
            else{
                int nStart = Math.min(curInterval.start, newInterval.start);
                int nEnd = Math.max(curInterval.end, newInterval.end);
                Interval merged = new Interval(nStart, nEnd);
                newInterval = merged; //-> now the becomes new interval
            }
        }
        /**below line is very important else the last interval will be lost****/
        finalResult.add(newInterval);
        return finalResult;
    }

    public static void main(String args[]) {
        //Existing Intervals
        List<Interval> existingIntervals = new ArrayList<Interval>();
        existingIntervals.add(new Interval(1,5));
        existingIntervals.add(new Interval(15,20));
        existingIntervals.add(new Interval(7,14));
        existingIntervals.add(new Interval(25,35));
        existingIntervals.add(new Interval(40,45));

        // new Interval to be added to existing Intervals
        Interval newInterval = new Interval(10, 16);

        List<Interval> finalList = mergeInterval(existingIntervals, newInterval);

        /* Print final result */
        for(Interval interval : finalList){
            System.out.println(interval.start+", "+interval.end);

        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(int s, int e){
        this.start = s;
        this.end =e;
    }
}