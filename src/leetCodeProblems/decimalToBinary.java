package leetCodeProblems;

import java.util.Scanner;
import java.util.Stack;

public class decimalToBinary {

	public static void main(String[] args) {
		int n, count = 0, a;
		Stack<Integer> binary = new Stack<Integer>();
        String x = "";
        Scanner s = new Scanner(System.in);
        System.out.print("Enter any decimal number:");
        n = s.nextInt();
        while(n > 0)
        {
            a = n % 2;
            binary.push(a);
            n = n / 2;
        }
        while(!(binary.isEmpty())) {
        	System.out.print(binary.pop());
        }

   	}

}
