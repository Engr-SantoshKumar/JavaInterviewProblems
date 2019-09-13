package leetCodeProblems;
/**
 * 
 */

/**
 * @author U494321
 *
 */
public class findUniqueChar {
	
	public static void main (String [] arg){
		
		String S ="asasdsfdsfjdljgedjugphreblvjrtj";
		String uniqueString = new String();
		
		
		for (int i =0; i<S.length();i++){
			
			Boolean found = false;
			for(int j = 0; j<uniqueString.length(); j++){
				
				if (S.charAt(i)==uniqueString.charAt(j)){
					found=true;
					break;
				}
				
				}
			if (found==false){
				uniqueString=uniqueString+S.charAt(i);
			}
		}
		
		System.out.println("unique string : "+ uniqueString);
		
		
		
	}

}
