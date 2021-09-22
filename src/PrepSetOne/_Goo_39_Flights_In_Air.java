/** 39  [max Planes In TheAir]
 -----------------------------------------------------------------------------------------------------------
 Given a schedule of airplane flights with takeoff and landing times,
 determine the maximum number of planes in the air at once.
 */
package PrepSetOne;
/*
Logic is simple
a. Traverse both array together in increasing order
b. Keep increasing the count of plansInAir as it takes-off and decrease as it as it is landing
 */

import java.util.Arrays;
public class _Goo_39_Flights_In_Air {


        public static void main(String[] args) {
            double takeoff[] = {9.00, 9.40, 9.50, 11.00, 15.00, 18.00};
            double landing[] = {9.10, 12.00, 11.20, 11.30, 19.00, 20.00};
            // after sorting    {9.00, 11.20, 11.30, 12.00, 19.00, 20.00};
            int c = maxPlanesInTheAir(takeoff, landing);
            System.out.println(c);
        }


        public static int maxPlanesInTheAir(double[] takeoff, double[] landing){
            int maxPlanesAirborn = 0;
            int count = 0;

            Arrays.sort(takeoff);
            Arrays.sort(landing);
            int i =0, j =0;

            while(i < takeoff.length &&  j < landing.length){

                if(takeoff[i] < landing[j]){
                    count ++;
                    i++;
                }else{
                    count --;
                    j++;
                }

                maxPlanesAirborn = Math.max(maxPlanesAirborn, count);

            }
           return maxPlanesAirborn;
        }

}
