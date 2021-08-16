/* [ _Array_02_ ] [ Rotational Cipher ]
_______________________________________________________________________________
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
*/

package _00_Problems_Sorted_By_Patterns;
public class _Array_02_Rotation_Cipher {

    static String rotationalCipher(String text, int rotationFactor) {

        // Write your code here
        StringBuilder result = new StringBuilder();
        for(char ch:text.toCharArray()){
            if(ch>='a' && ch<='z'){
                result.append((char) ((ch - 'a' + rotationFactor) % 26 + 'a'));
            }
            else if(ch>='A' && ch<='Z'){
                result.append((char) ((ch - 'A' + rotationFactor) % 26 + 'A'));
            }
            else if (ch>='0' && ch<='9'){
                result.append((char) ((ch - '0' + rotationFactor) % 10 + '0'));
            }else{
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(rotationalCipher("Zebra-493", 3));
    }
}
