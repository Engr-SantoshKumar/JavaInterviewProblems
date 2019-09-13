package leetCodeProblems;

import java.util.Stack;

public class balancedBracketsUsingStacks {

	public static void main(String[] args) {
		
		System.out.println(isBalanced("{}([])"));//true
		System.out.println(isBalanced("([}])"));//false
		System.out.println(isBalanced("([])"));//true
		System.out.println(isBalanced("()[]{}[][]"));//true
		System.out.println(isBalanced("[{}}]"));//false
		System.out.println(isBalanced("(((({([])}))))[[{()}]]"));//true
		
	}
	
	public static Boolean isBalanced(String s) {
		
		if (s.length() == 0) {
            throw new IllegalArgumentException("String length should be greater than 0");
        }
		
		if ((s.length() % 2) != 0) {
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
					
				}else {
					if(stack.empty() || s.charAt(i)!=stack.pop())
					return false;
				}
		}
		return true;
		
		
	}

}
