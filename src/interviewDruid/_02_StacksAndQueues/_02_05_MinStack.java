package interviewDruid._02_StacksAndQueues;

import java.util.Stack;

@SuppressWarnings("serial")
public class _02_05_MinStack extends Stack<Integer> {
	
	Stack<Integer> mainStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
    public void push(int x){		
    	mainStack.push(x);
    	
    	if(x<=getMin()){
    		minStack.push(x);
    	}		
	}
	
	public Integer pop(){
		
		int x = mainStack.pop();
		if(x == minStack.peek()){
			minStack.pop();
		}
		return x;
	}
	
	public Integer getMin(){
		
		if (minStack == null){
			return Integer.MAX_VALUE;
		}else
		return minStack.peek();
		
	}
	

	public static void main(String[] args) {
		
		_02_05_MinStack s = new _02_05_MinStack();
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
