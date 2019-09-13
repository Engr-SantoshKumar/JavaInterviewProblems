package leetCodeProblems;

public class recursionStringReverse {

	static String s2="";
	
	static String reverse(String s) {
		int l = s.length();
		
		if (s.length()<=1)
			return s;
		else 
			s2 += s.charAt(s.length()-1)+ reverse(s.substring(0, s.length()-1));
			return s2;
		
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("hsotnas"));

	}

}
