package leetCodeProblems;

public class findPalindrome {

	public static void main(String[] args) {

		System.out.println(isPalindrome("racecar"));

	}
	
	public static boolean isPalindrome(String s) {
		
	
		int j=s.length();
		int med = j/2;
		for(int i = 0; i<med; i++) {
			if(s.charAt(i)!=s.charAt(j-i-1)) {
				return false;
			}
		}
		
		
		return true;
		


}
}

