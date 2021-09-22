/** 45  [Count And Say Algorithm]
 -----------------------------------------------------------------------------------------------------------
 Create best optimized solution for "Count and Say" algorithm.

 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 12, 1121, 122111, 112213, 12221131
 Given an integer n, generate the nth sequence.

 */

package PrepSetOne;

public class _Goo_45_Count_And_Say_Algorithm {

    public static String countAndSay(int n){
        //base cases
        if(n<=0) return null;
        if(n == 1) return "1";
        String result ="1";
        for(int i = 1; i<n; i++){
            /* IMP:
             *previous character is processed in current iteration.
             * That is why a dummy character is added to make sure that loop runs one extra iteration.
             */
            result+='$';
            StringBuffer sb = new StringBuffer();
            int count =1;
            for(int j =1; j <result.length(); j++)
            {
                if(result.charAt(j) == result.charAt(j-1))
                {
                    count ++;
                }
                else{
                    sb.append(result.charAt(j-1));
                    sb.append(count);
                    // reset count
                    count =1;
                }
            }
            System.out.println(sb);
            result = sb.toString();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(8));
    }
}
