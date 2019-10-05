/** [_Goo_04] [counter to find out how often it was incremented in the last second, minute, and the last hour.]
-------------------------------------------------------------------------------------------------------
Implement a class that manages a counter.
The counter can be incremented by 1, and we can query the counter to find out how often it was incremented in the
last second, the last minute, and the last hour.

 Logic is: We can solve this problem using 3 queue [Second Queue, Minute Queue, Hour Queue]
 1. When there is a hit put the current time in second queue, also check for any expired entry in secCounter
 (i.e is greater than 1 sec when compared to current time) move it to minCounter Queue. Do same with minCounter and
 HrCounter.

 */
package GooPrep;

import java.util.ArrayDeque;
import java.util.Queue;

public class _Goo_04_CounterManagementClass {
    static int secCounter = 0;
    static int minCounter = 0;
    static int hrCounter = 0;

    static Queue<Long> qSec = new ArrayDeque<>();
    static Queue<Long> qMin = new ArrayDeque<>();
    static Queue<Long> qhr = new ArrayDeque<>();

    static void hitCounter() {
        long currTimeSec = System.currentTimeMillis() / 1000;
        qSec.offer(currTimeSec);
        secCounter++;
        System.out.println("size " + qSec.size());
        System.out.println(qSec);
        currTimeSec = System.currentTimeMillis() / 1000;
        while (!qSec.isEmpty() && currTimeSec - qSec.peek() > 0) {
            secCounter--;
            minCounter++;
            qMin.offer(qSec.poll());
        }

        while (!qMin.isEmpty() && currTimeSec - qMin.peek() > 60) {
            minCounter--;
            hrCounter++;
            qhr.offer(qMin.poll());
        }

        while (!qhr.isEmpty() && currTimeSec - qhr.peek() > 60 * 60) {
            hrCounter--;
            qhr.poll();
        }
        System.out.println(" at this time sec counter " + qSec.size());
        System.out.println(" at this time min counter " + (qMin.size() + qSec.size()));
        System.out.println(" at this time hr counter " + (qhr.size() + qMin.size() + qSec.size()));

    }

    public static void main(String args[]) {
        System.out.println(System.currentTimeMillis());

        long start = System.currentTimeMillis();
        long end = start + 1000 * 60 * 2; //start + 2mins
        while(start < end ) {
            try {
                Thread.sleep(100); // sleep for 1/10 of sec, so gen 10 entries in 1 sec
                hitCounter();
                if(System.currentTimeMillis() - start > 1000 * 60 * 2){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

