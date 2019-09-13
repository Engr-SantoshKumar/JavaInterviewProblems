/** 39-01  [max Planes In TheAir]
 -----------------------------------------------------------------------------------------------------------
 Given a schedule of airplane flights with takeoff and landing times,
 determine the maximum number of planes in the air at once.
 */
package GooPrep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _Goo_39_01_AirPlane_In_Air_Objects {
    public static void main(String[] args) {
        double takeoff[] = {9.00, 9.40, 9.50, 11.00, 15.00, 18.00};
        double landing[] = {9.10, 12.00, 11.20, 11.30, 19.00, 20.00};
        List<Plane> list = new ArrayList<>();
        for(int i = 0; i<takeoff.length; i++){
            list.add(new Plane(takeoff[i], landing[i]));
        }
        System.out.println(maxPlanesInTheAir(list));
    }

    static int maxPlanesInTheAir(List<Plane> list){
        // take a plane object and make 2 point objects with st time 1, and end time 0
        // 1 indicates takeoff and 0 indicates landing
        List<Point> pointList = new ArrayList<>();
        for(Plane plane : list){
            Point startPoint = new Point(plane.start, 1);
            Point endPoint = new Point(plane.end, 0);
            pointList.add(startPoint);
            pointList.add(endPoint);
        }

        Collections.sort(pointList, new Comparator<Point>() {
            public int compare(Point a, Point b){
                int x = a.time.compareTo(b.time);// Since time is Double object it is possible to
                //use compareTo, else it is difficult to do that

                if(x==0){
                    return a.flag - b.flag;
                }
                return x;
            }
        });

        int count=0;
        int maxCount = 0;
        for(Point p : pointList){
            System.out.println(p);
        }
        for(Point p : pointList){
            if(p.flag == 1){
                count++;
            }else{
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
class Plane{
    double start;
    double end;

    public Plane(double start, double end) {
        this.start = start;
        this.end = end;
    }
}
class Point{
    Double time; // Important to keep this as Double because we later sort on this
    int flag; // is it landing or takeOff

    public Point(double time, int flag) {
        this.time = time;
        this.flag = flag;
    }
    public String toString(){
        return " "+time.toString()+" - "+flag;
    }
}
