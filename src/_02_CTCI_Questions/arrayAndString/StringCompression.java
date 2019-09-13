package _02_CTCI_Questions.arrayAndString;

public class StringCompression {

	public static void main(String[] args) {
		String str = "aabcccccaaa";
		
		System.out.println(compress(str));

		

	}
	
	public static String compress(String s){
		StringBuilder compressedString = new StringBuilder();
		int counts = 0;
		for (int i = 0; i < s.length(); i++ ){
			counts++;
			if (i + 1 >= s.length() || s.charAt(i)!=s.charAt(i+1) ){
				compressedString.append(s.charAt(i));
				compressedString.append(counts);
				counts = 0;
			}
			
		}
		
		return compressedString.length() < s.length()? compressedString.toString() : s; 
	}

}
