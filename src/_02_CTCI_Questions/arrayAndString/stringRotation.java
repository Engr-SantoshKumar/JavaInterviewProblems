package _02_CTCI_Questions.arrayAndString;

public class stringRotation {

	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotationString(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
	
	public static boolean isRotationString(String s1, String s2){
		
		
		/* check that s1 and s2 are equal length and not empty */
		if(s1.length()==s2.length() && s1.length()>0){
		//concatenate s1 and s1	
			String bigString = s2+s2;
			System.out.println(bigString);
			System.out.println(s1);
			System.out.println("bigString.indexOf(s1) --> " + bigString.indexOf(s1));
			/*
			str.indexOf(abc) start looking for the character ‘abc’ in string str
			returns -1 if the specified char/substring is not found in the particular String.
			 */
			if(bigString.indexOf(s1)>=1){
				return true;
			}
			
		}
		return false;
		
	}

}
