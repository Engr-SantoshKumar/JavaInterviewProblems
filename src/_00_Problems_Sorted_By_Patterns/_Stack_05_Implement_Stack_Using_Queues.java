/* [ _Stack_05_ ] [ Implement_Stack_Using_Queues ]
_______________________________________________________________________________
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayDeque;
import java.util.Queue;

public class _Stack_05_Implement_Stack_Using_Queues {

    static Queue<Integer> queue;
    /** Initialize your data structure here. */
    public _Stack_05_Implement_Stack_Using_Queues() {
        this.queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public static void push(int x) {
        queue.offer(x);
        //basic idea is we need to move new incoming to front of queue
        for(int i=0; i<queue.size()-1; i++){ // removing except the lastAdded
            queue.offer(queue.poll());  // coming out from front and adding to back
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public static int pop() {
        return queue.isEmpty()? -1:queue.poll();
    }

    /** Get the top element. */
    public static int top() {
        return queue.isEmpty()? -1:queue.peek();
    }

    /** Returns whether the stack is empty. */
    public static boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        _Stack_05_Implement_Stack_Using_Queues myStack = new _Stack_05_Implement_Stack_Using_Queues();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.top()); // return 1
        System.out.println(myStack.empty()); // return False
    }
}
