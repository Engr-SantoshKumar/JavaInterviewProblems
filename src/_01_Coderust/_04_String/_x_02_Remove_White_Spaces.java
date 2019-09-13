package _01_Coderust._04_String;

public class _x_02_Remove_White_Spaces {

    public static void removeSpaces( String givenString){

        int readPointer =0;
        int writePointer = 0;
        char[] charOfString = givenString.toCharArray();

        while(readPointer < charOfString.length && charOfString[readPointer]!= '\0'){
            if(!isWhiteSpace(charOfString[readPointer])){
                charOfString[writePointer] = charOfString[readPointer];
                writePointer++;
            }
            readPointer++;
        }

        String result = String.valueOf(charOfString); // creating a string from updated char[]
        System.out.println(result.substring(0,writePointer)); // substring


    }
    // created this method because we can not directly do !c= ' '
    public static boolean isWhiteSpace(char c){

        if(c == ' ' || c == '\t') {
            return true;
        }
        return false;
     }



    public static void main(String[] args){
        removeSpaces("aaaaaa bb cdd");
    }
}
