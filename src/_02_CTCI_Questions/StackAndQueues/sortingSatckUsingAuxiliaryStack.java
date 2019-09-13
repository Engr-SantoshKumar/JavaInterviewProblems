/* Sort a stack using a temporary stack
 * Steps: 01. Create a temporary stack say tmpStack.
		  02. While input stack is empty do this:
			 - Pop an element from input stack call it x
			 - while temporary stack is not empty and top of stack is greater than x,
			 - pop from temporary stack and push it to the input stack
			 - push temp in tempory of stack
          03. The sorted numbers are in tmpStack

 */
package _02_CTCI_Questions.StackAndQueues;

import java.util.Stack;

public class sortingSatckUsingAuxiliaryStack {
	
	public static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> tempStack = new Stack<Integer>();
		while(!input.isEmpty()){
			
			int currentNum = input.pop();
			
			// while temporary stack is not empty and top of tempStack is greater than temp
			while(!tempStack.isEmpty() && currentNum > tempStack.peek()){
				
				input.push(tempStack.pop()); // pop from temporary stack and push it to the input stack
			}
			tempStack.push(currentNum);
		}
		
		return tempStack;
	}
	
	public static void main(String[] args) {
			Stack<Integer> input = new Stack<Integer>();
		    input.add(34);
		    input.add(3);
		    input.add(31);
		    input.add(98);
		    input.add(92);
		    input.add(23);
		
		    // This is the temporary stack
		    Stack<Integer> tmpStack=sortstack(input);
		    System.out.println("Sorted numbers are:");
		
		    while (!tmpStack.empty())
		    {
		        System.out.print(tmpStack.pop()+" ");
		    } 
		}



}
