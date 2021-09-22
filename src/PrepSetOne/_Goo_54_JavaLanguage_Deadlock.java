/**
 * What is a deadlock and how can it be avoided?
 */

package PrepSetOne;
public class _Goo_54_JavaLanguage_Deadlock {

/**
     synchronized keyword is used to make the class or method thread-safe which means only one thread can have
     lock of synchronized method and use it,
     other threads have to wait till the lock releases and anyone of them acquire that lock.
     It is important to use if our program is running in multi-threaded environment where two or more
     threads execute simultaneously. But sometimes it also causes a problem which is called Deadlock.

    Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
    Deadlock occurs when multiple threads need the same locks but obtain them in different order.
    A Java multithreaded program may suffer from the deadlock condition because the synchronized keyword causes
    the executing thread to block while waiting for the lock, or monitor, associated with the specified object.

*/

    // Detect Dead java.util.concurrent.locks.Lock condition
    // ==========================
    /*We can also detect deadlock by running this program on cmd. We have to collect Thread Dump.
    Command to collect depends on OS type. If we are using Windows and Java 8, command is jcmd $PID Thread.print
    We can get PID by running jps command.*/

    // Avoid Dead Lock condition
    /*We can avoid dead lock condition by knowing its possibilities. It’s a very complex process and not easy to catch.
    But still if we try, we can avoid this. There are some methods by which we can avoid this condition.
    We can’t completely remove its possibility but we can reduce.*/
    /**
     ---> Avoid Nested Locks :
            This is the main reason for dead lock. Dead Lock mainly happens when we give locks to multiple threads.
            Avoid giving lock to multiple threads if we already have given to one.
     ---> Avoid Unnecessary Locks :
            We should have lock only those members which are required. Having lock on unnecessarily can lead to dead lock.
     ---> Using thread join :
            Dead lock condition appears when one thread is waiting other to finish.
            If this condition occurs we can use Thread.join with maximum time you think the execution will take.

     */

}
