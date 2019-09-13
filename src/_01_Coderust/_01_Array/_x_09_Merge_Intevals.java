package _01_Coderust._01_Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _x_09_Merge_Intevals {

    static ArrayList<Interval> mergeIntervals(ArrayList<Interval> meetingIntervalsList ){

        if(meetingIntervalsList.size()==0 || meetingIntervalsList.size() ==1)
            return meetingIntervalsList;

        // Sort by ascending starting point using an anonymous Comparator
        Collections.sort(meetingIntervalsList, new IntervalComparator());

        Interval newInterval = meetingIntervalsList.get(0);
        int previousStart = newInterval.getStart();
        int previousEnd = newInterval.getEnd();

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(int i =1; i < meetingIntervalsList.size(); i++){

            Interval current = meetingIntervalsList.get(i);

            // Overlapping intervals: join both intervals update the end if needed
            if(current.getStart() <= previousEnd){
                previousEnd=Math.max(current.getEnd(),previousEnd);
            }else
                // Disjoint intervals: add the previous one and reset previousStart and previousEnd
            {
            result.add(new Interval(previousStart, previousEnd));
            previousStart = current.getStart();
            previousEnd = current.getEnd();
            }
        }
        // Add the last interval
        result.add(new Interval(previousStart, previousEnd));
        return result;
    }


    public static void main (String[] args) throws java.lang.Exception
    {
        ArrayList<Interval> x = new ArrayList<>();

        x.add(new Interval(1, 3));
        x.add(new Interval(2, 6));
        x.add(new Interval(8, 10));
        x.add(new Interval(15, 18));
        x.add(new Interval(17, 20));

        x = mergeIntervals(x);

        for(Interval i : x)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }
    }
}



class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2){
        return i1.getStart()-i2.getStart();
    }
}



class Interval{
    public int start;
    public int end;

    //setter methods
    Interval(int s, int e){
        this.start=s;
        this.end=e;
    }
    //getter methods
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
}