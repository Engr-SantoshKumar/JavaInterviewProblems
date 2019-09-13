/**  58 [Print shortest path to print a string on screen]
 ____________________________________________________________________________________________________________________
 * Given screen containing alphabets from A-Z and input string, by using remote we can go from one character
 * to another character, remote contains only left, right, top and bottom keys.
 * write a function that will find the shortest path to type all the charcters of given string using remote
 *
LOGIC : Take ascii value and divide the ascii value by 5(gives row value) and take %5(gives column value).
 For e.g A(97) would give row:int((65-65)/5)=0 and (65-65)%5=0
 '%' -->  Modulus (also called remainder)

 Screen
 A B C D E
 F G H  I  J
 K L M N O
 P Q R S  T
 U V W X Y
 Z
*/

package GooPrep;

public class _Goo_58_01_Remote_Problem_Shortest_Path_To_Print_String_On_Screen {

    public static void findPath(String inputStr){

        int i = 0;
        int curRow =0, curCol =0;

        while( i < inputStr.length())
        {

            //Take ascii value and divide the ascii value by 5(gives row value) and take %5(gives column value).
            //For e.g N(78) would give row:int((78-65)/5)=> 13/5=2 and col=> 13%5=3(remainder)

                int nextRow = (inputStr.charAt(i) - 'A') / 5; // 13/5=2
                //int nextRow = Character.getNumericValue(inputStr.charAt(i))/ 5; --> this same as above
                int nextCol = (inputStr.charAt(i) - 'A') % 5; // 13%5=3 because 13%5 =3 with a remainder of 3

                // Move down if destination is below
                while(curRow < nextRow ){
                    System.out.println("Move Down ");
                    curRow ++;
                }

                // Move Up if destination is above
                while(curRow > nextRow){
                    System.out.println("Move Up");
                    curRow --;
                }

                // Move Left if destination is to the Right
                while(curCol < nextCol){
                    System.out.println("Move Right");
                    curCol ++;
                }

                // Move Left if destination is to the left
                while(curCol > nextCol){
                    System.out.println("Move Left");
                    curCol --;
                }

                // At this point, destination is reached
            System.out.println("Press OK");
            i++;
        }
    }

    public static void main (String[] args)
    {
        String str = "HOME";
        findPath(str);
    }
}
