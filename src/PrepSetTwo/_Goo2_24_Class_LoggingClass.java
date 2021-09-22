package PrepSetTwo;

import java.util.*;

/**
 * [  ] [Logging requests sorted by their start time  ]
 * _______________________________________________________________________________________________
 *
 * interface Logger {
 * void started(long timestamp, String requestId);
 * void finished(long timestamp, String requestId);
 *
 */
public class _Goo2_24_Class_LoggingClass {
    Queue<request> queue;
    Map<String, request> hm;

    public _Goo2_24_Class_LoggingClass(){
        //queue = new ArrayDeque<>((a,b) -> a.start - b.start);
        hm= new HashMap<>();
    }

    void started(String requestId, long timestamp){
        hm.put(requestId, new request(requestId, timestamp, -1));
        queue.offer(new request(requestId, timestamp, -1));
    }

    void finish(String requestId, long EndTimestamp){
        request curRequest = hm.get(requestId);
        hm.put(requestId, new request(requestId, curRequest.start,  EndTimestamp));

        while(hm.get(queue.peek().id).end!=-1){

            request cur = hm.remove(queue.poll().id);
            System.out.println(cur.id + " " + cur.start + " " + cur.end);
        }

    }

}
class request{
    String id;
    long start;
    long end;

    public request(String id, long start, long end){
        this.id = id;
        this.start = start;
        this.end =end;
    }
}