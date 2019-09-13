package interviewDruid._02_StacksAndQueues;

import java.util.Stack;

public class _02_07_Parenthesis_Braces_Validate {
	
	public static Boolean isBalanced(String s) {
		// check length
		if (s.length()==0){
			throw new IllegalArgumentException("String length should be greater than 0");
        }
		// check if its not even
		if (s.length() % 2 !=0){
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='(' ) {
				if(s.charAt(i)=='[')
					stack.push(']');
				else if(s.charAt(i)=='{') 
					stack.push('}');
				
				else if(s.charAt(i)=='(') 
					stack.push(')');
				}
			    // Handling closing braces
				else {
					if(stack.empty() || s.charAt(i)!=stack.pop())
					return false;
				}
		}
		// checking if stack is empty because it can have all opening braces
		 return (stack.isEmpty()) ? true : false;
	}	

	public static void main(String[] args) {
		System.out.println(isBalanced("{}([])"));//true
		System.out.println(isBalanced("([}])"));//false
		System.out.println(isBalanced("([])"));//true
		System.out.println(isBalanced("()[]{}[][]"));//true
		System.out.println(isBalanced("[{}}]"));//false
		System.out.println(isBalanced("(((({([])}))))[[{()}]]"));//true
		System.out.println(isBalanced("){"));
	}
}
