package _01_Coderust._07_Dynamic_Programing;

public class _x_01_Fibonacci_Numbers {

    static int get_fibonacci(int n){

        if( n==0 || n ==1){
            return n;
        }

        int n1=0; //(n-2)
        int n2=1; //(n-1)

        int result = 0;

        for(int i =2; i<=n; i++){
            result = n1+n2;

            n1 = n2;
            n2 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("get_fib(5) = "+ get_fibonacci(5)); // 5
        System.out.println("get_fib(5) = "+ get_fibonacci(9)); // 34
    }
}
