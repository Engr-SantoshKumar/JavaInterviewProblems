package _02_CTCI_Questions.arrayAndString;

public class sortCharOfString {

	public static void main(String[] args) {
		System.out.println(sortString("saantosh"));

	}
	
	public static StringBuffer sortString(String s){
		System.out.println(s);
		StringBuffer newString = new StringBuffer();
		
		int [] counts = new int[128];
		
		for(int c : s.toCharArray()){
			counts[c]++;
		}
		for(int i=0; i<counts.length; i++){
			int y=counts[i];
			if(y>0){
				for(int k =0; k<y; k++){
					char b=(char)i;
					newString.append(b);
				}
			}
		}
		
		return newString;
	}

}
