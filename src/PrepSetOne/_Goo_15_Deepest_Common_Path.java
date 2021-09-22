/** 15
------------------------------------------------------------------------------------------------------
 Given a list of file paths, write a method to find the deepest common path.
 */
package PrepSetOne;
public class _Goo_15_Deepest_Common_Path {
    public static String findDeepestCommonPath(String[] listOfPaths){

        String commonPath = "";
        String[][] folders = new String[listOfPaths.length][];

        for(int i = 0; i < listOfPaths.length; i++){
            //split on file separator
             folders[i] = listOfPaths[i].split("/");
        }

        for(int col = 0; col< folders[0].length; col++){

            // idea is, pick the elements from 1st row and match with other row for same col.
            String s = folders[0][col];
            // creating a another loop for rows keeping column same
            for(int row=1; row<listOfPaths.length; row++){
                    if(!s.equals(folders[row][col])) {
                        return commonPath;
                    }
            }

                commonPath += s + "/";
        }
        return commonPath;
    }


    public static void main(String[] args){
        String[] paths = {  "/home/user1/tmp/coverage/test",
                            "/home/user1/tmp/covert/operator",
                            "/home/user1/tmp/coven/members"};
        System.out.println(findDeepestCommonPath(paths));

        String[] paths2 = { "/hame/user1/tmp/coverage/test",
                            "/home/user1/tmp/covert/operator",
                            "/home/user1/tmp/coven/members"};
        System.out.println(findDeepestCommonPath(paths2));
    }
}






