/*1.3 Replace all the spaces in a string with '%20'
 * Soln: 1. Get the string length, and count of spaces 
 * 		 2. Start reading the elements from string's end and copy to the end index i.e stringLength+space*2  
 * 
 */




package _02_CTCI_Questions.arrayAndString;

import java.util.Arrays;

public class replaceSpaceURLify {

	public static void main(String[] args) {
		String s = "My name is santosh kumar         ";
		char[] arry = s.toCharArray();
		int trueLength = findLastChar(arry) + 1;
		replaceSpaces(arry, trueLength);

	}
	
	public static int findLastChar(char[] str){		
		for (int i = str.length - 1; i >= 0; i--) {
		if (str[i] != ' ') {
			return i;
		}
	}
	return -1;
	}
	
	
	public static void replaceSpaces(char [] str, int l){
		int spaceCount =0, index, i;
		
		for(i =0; i<l; i++ ){
			if (str[i]==' '){
				spaceCount++;
			}
		}
		
		index = l+spaceCount*2;
		
		System.out.println(index);
		System.out.println(l);
		

		for (i = l - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
		System.out.println(Arrays.toString(str));
		
	}

}
