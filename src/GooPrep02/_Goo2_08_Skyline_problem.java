/**
[ Goo2_08] [ SkyLine Problem ]
____________________________________________________________________________________________________________________
Leetcode 218. The Skyline Problem
    Time complexity is O(nlogn)
    Space complexity is O(n)
*/

package GooPrep02;

import java.util.*;

public class _Goo2_08_Skyline_problem {

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        //for all start and end of building put them into List of BuildingPoint
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index = 0;
        for(int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].xAxisPoint = building[0];
            buildingPoints[index].isStartingPoint = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].xAxisPoint = building[1];
            buildingPoints[index + 1].isStartingPoint = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);
        for(BuildingPoint bp : buildingPoints){
            System.out.println(bp.xAxisPoint+","+bp.height+","+bp.isStartingPoint);
       }

        PriorityQueue<Integer> queue1 = new PriorityQueue<>((a, b) -> b -a );
        queue1.add(0);
        int prevMaxHeight = 0;

        for(BuildingPoint bp : buildingPoints) {

            if(bp.isStartingPoint){
                queue1.add(bp.height);
            }else{
                queue1.remove(bp.height);
            }
            int currentMaxHeight = queue1.peek();

            if (prevMaxHeight != currentMaxHeight) {
                result.add(new int[]{bp.xAxisPoint, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
        _Goo2_08_Skyline_problem sd = new _Goo2_08_Skyline_problem();
        List<int[]> criticalPoints = sd.getSkyline(buildings);
        criticalPoints.forEach(cp -> System.out.println(cp[0] + " " + cp[1]));
    }

    static class BuildingPoint implements Comparable<BuildingPoint> {
        int xAxisPoint;
        int height;
        boolean isStartingPoint;

        @Override
        public int compareTo(BuildingPoint o) {
            //if two starts are compared then higher height building should be picked first
            if(this.xAxisPoint == o.xAxisPoint && this.isStartingPoint && o.isStartingPoint)
                return o.height - this.height;
            //if two ends are compared then lower height building should be picked first
            if(this.xAxisPoint == o.xAxisPoint && !this.isStartingPoint && !o.isStartingPoint)
                return this.height - o.height;
            // if 1st building's end and 2nd building start compared, 2nd building (start) should come first
            if(this.xAxisPoint == o.xAxisPoint)
                return this.isStartingPoint?-1:1;
            //
            return this.xAxisPoint - o.xAxisPoint;
        }
    }

}
