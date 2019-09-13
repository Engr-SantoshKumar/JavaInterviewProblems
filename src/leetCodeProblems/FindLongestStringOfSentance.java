package leetCodeProblems;

public class FindLongestStringOfSentance {

	public static void main(String[] args) {
		
		String s = "aa abcd abcde abcdef";
		
		//System.out.println(longesWordUsingSlidingWindow(s));
		System.out.println(longesWordUsingDataStructure(s));

	}
	
	public static String longesWordUsingSlidingWindow(String givenString) {
		
		
		int startingIndexOfWord =0;
		int wordlength =0;
		String longestWord = null;
		
		for(int i =0; i<givenString.length(); i++) {
			char c = givenString.charAt(i);
			
			if(c==' ') {
				String Word = givenString.substring(startingIndexOfWord, i);

				if(Word.length() > wordlength & Word.length()%2==0) {
					wordlength = Word.length();
					longestWord = Word;
				}
				
				startingIndexOfWord = i+1;
			}
			// to handle the last word ...i.e. no space after that 
			else if(i==givenString.length()-1) {
				String Word = givenString.substring(startingIndexOfWord, givenString.length());

				if(Word.length() > wordlength & Word.length()%2==0) {
					wordlength = Word.length();
					longestWord = Word;
				}
				
			}
			
		}
		
		return longestWord;
		
	}
	
	public static String longesWordUsingDataStructure(String givenString) {
		String longestWord = null;
		int length=0;
		String [] Words = givenString.split(" ");
		
		for(String word : Words) {
			if(word.length()>length & word.length()%2==0) {
				length=word.length();
				longestWord=word;
			}
			
		}
		
		
		return longestWord;
		
	}

}
























