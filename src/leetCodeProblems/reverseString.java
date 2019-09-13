package leetCodeProblems;

import java.io.*;
import java.util.*;
public class reverseString {


	   public static void main(String[] args) {

	      
	      reverseStringwithStringBuffer("Santosh");
	      reverseStringwithChatAt("Santosh");
	      
	   }
	   
	   public static void reverseStringwithStringBuffer(String s) {
		   String reverse = "";
		   char[] chars = s.toCharArray();
		   for(int i = chars.length-1; i>=0; i--) {
			   reverse= reverse + chars[i];
		   }
		   System.out.println(reverse);
		   
		   
	   }
	   
	   public static void reverseStringUsingArray(String input) {

		      char[] try1 = input.toCharArray();
		      for (int i = try1.length-1;i>=0;i--) 
		    	  System.out.print(try1[i]);
		   
	   }
	   
	   public static void reverseStringwithChatAt(String s) {
		   String reverse = "";

		   for(int i = s.length()-1; i>=0; i--) {
			   reverse= reverse + s.charAt(i);
		   }
		   System.out.println(reverse);
		   
		   
	   }
	   
	}


