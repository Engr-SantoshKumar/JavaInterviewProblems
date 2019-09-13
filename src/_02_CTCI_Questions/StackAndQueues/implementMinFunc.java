package _02_CTCI_Questions.StackAndQueues;

import java.util.Stack;

@SuppressWarnings("serial")
public class
implementMinFunc extends Stack<Integer> {
	
	Stack<Integer> minValueStack = new Stack<>();
	Stack<Integer> mainStack = new Stack<>();
	
	public void push(int x){
		/* push only when the incoming element of main stack is smaller 
        than or equal to top of auxiliary stack */
		if( x <= getMin() ){
			minValueStack.push(x);
		}
		mainStack.push(x);
	}
	
	public Integer pop(){
		int x = mainStack.pop();
		int y = minValueStack.pop();
		
		 /* Push the popped element y back only if it is not equal to x */
			if( y != x ){
				minValueStack.push(y);
			}		
		return x;		
	}
	                                           
	public Integer getMin(){
		if(minValueStack.isEmpty()){
			return Integer.MAX_VALUE;
			}else		
		return minValueStack.peek();				
	}
	
	public static void main(String[] args) {
		
		implementMinFunc s = new implementMinFunc();
		s.push(10);
		s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
	}

}
