/* _Goo_13_b_Merge Interval
 -------------------------------------------------------------------------------------------------------
You are given a sorted list of disjoint intervals and an interval.
    Input:
    List=>[5,6],[8,15],[10,12],[14,18],[17,19],[20,22]
    Interval=>[5,6],[8,19],[20,22]
    Merge a sorted list of disjoint intervals with an interval."
 */

package GooPrep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _Goo_13_b_Merge_Intervals {

    public static List<Interval> mergeInterval(List<Interval> existingIntervals){
        // First sort the existingIntervals with start timing
        Collections.sort(existingIntervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        List<Interval> finalResult = new ArrayList<Interval>();

        int end = existingIntervals.size();
        int start =1;
        Interval previousInterval  = existingIntervals.get(0);

        /* looping through existing intervals and will check which one need to merge */
        while(start < end ){
            Interval curInterval = existingIntervals.get(start);

            if(curInterval.end < previousInterval.start){  // this is cases is highly unlikely because after sorting
                finalResult.add(curInterval);              //  previous start will be always less then or equal to current start as we have sorted the arrays above
            }

            else if (previousInterval.end < curInterval.start){
                finalResult.add(previousInterval);

                previousInterval = curInterval;
            }
            else{
                int nStart = Math.min(curInterval.start, previousInterval.start);
                int nEnd = Math.max(curInterval.end, previousInterval.end);
                Interval merged = new Interval(nStart, nEnd);
                previousInterval = merged;
            }
            start ++;
        }
        finalResult.add(previousInterval);
        return finalResult;
    }
    public static void main(String args[]) {
        //Existing Intervals
        List<Interval> existingIntervals = new ArrayList<Interval>();
        existingIntervals.add(new Interval(5,6));
        existingIntervals.add(new Interval(14,18));
        existingIntervals.add(new Interval(8,15));
        existingIntervals.add(new Interval(20,22));
        existingIntervals.add(new Interval(10,12));
        existingIntervals.add(new Interval(17,19));
        List<Interval> finalList = mergeInterval(existingIntervals);
        for(Interval interval : finalList){
            System.out.println(interval.start+", "+interval.end);

        }
    }
}


