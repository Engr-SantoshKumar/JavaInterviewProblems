/** 18 [Fibonacci]
-------------------------------------------------------------------------------------------------------
 "Create a method that returns the nth Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 Implement a method that returns the nth Fibonacci number without using recursion."

*/
package GooPrep;

public class _Goo_18_Fibonacci {

    public static void main (String args[]){
        System.out.println(" fib of 7 is " + fibonacciRec(7));
        System.out.println(" fib simple of 7 " + fibSimple(7));
        System.out.println(" fib DP of 7 " + fibDP(7));
        }

        static int fibonacciRec ( int n){
            if (n <= 1) {
                return n;
            }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
         }

        static int fibSimple ( int n){
            int p1 = 0;
            int p2 = 1;
                if (n <= 1) {
                    return n;
                }
            int next = 0;
                // this is very imp to start from 2 and <= since we calc till n
                for (int i = 2; i <= n; i++) {
                next = p1 + p2;
                p1 = p2;
                p2 = next;
            }
        return next;
        }

        static int fibDP ( int n){
        int[] fib = new int[n + 2];
        // if n=0 then fib array size is 2 meaning, when we do f[1] then no error
        //but if we keep int[n+1], array is of size 1, so when we do f[1] its index oob
        fib[0] = 0;
        fib[1] = 1;
            for (int i = 2; i <= n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
                //System.out.println(" at i= " + i + "  " + Arrays.toString(fib));
            }
        return fib[n];
    }
}

