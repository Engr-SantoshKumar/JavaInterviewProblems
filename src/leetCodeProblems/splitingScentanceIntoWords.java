package leetCodeProblems;

import java.util.Stack;

public class splitingScentanceIntoWords {

	public static void main(String[] args) {
		String s = "This is a sample sentence";
		reverseUsingForLoop(s);
		System.out.println();
		reverseStringUsingStack(s);
		System.out.println();
		reverseStringUsingStringBuffer(s);
	}
		
	public static void reverseUsingForLoop(String s) {	
		System.out.println(s);
		String[] words = s.split(" ");
		
		for(String w: words ) {
			int length = w.length();
			for(int i =length-1; i>=0; i--) {
				System.out.print(w.charAt(i));
			}
			System.out.print(" ");
			}

	}
	
	public static void reverseStringUsingStack(String s) {

	      Stack<Character> theStack = new Stack<Character>();
	      
			String[] words = s.split(" ");
			
			for(String w: words ) {
	      for (int j = 0; j < w.length(); j++) {
	         char ch = w.charAt(j);
	         theStack.push(ch);
	      } 
	      while (!theStack.isEmpty()) {
	         char ch = theStack.pop();
	         System.out.print(ch);
	      }
	      System.out.print(" ");
	      
		}
	}
	
	public static void reverseStringUsingStringBuffer(String s) {
		
		StringBuilder input1 = new StringBuilder();
		 
        input1.append(s);
 
        input1 = input1.reverse();
 
        for (int i=0; i<input1.length(); i++)
            System.out.print(input1.charAt(i));
		
	}
	
	
	
}
