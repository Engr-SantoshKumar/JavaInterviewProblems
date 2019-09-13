package leetCodeProblems;

public class recursionPalindrome {

	public static void main(String[] args) {
		checkPalindrome("raar");

	}
	
	
	static void  checkPalindrome(String s) {
		if (s.length()==1||s.length()==0) {
			System.out.println(" a Palindrome");
		}
		else {
			if(s.charAt(0)==s.charAt(s.length()-1)) {
				checkPalindrome(s.substring(1, s.length()-1));
				
				}else {
					System.out.println("Not a Palindrome");
				}
					
		}

		

		
		
	}

}
