package _01_Coderust._03_Stack_Queues;

import java.util.Stack;

public class _06_EvaluatePostfixExpression {

    public static int evaluatePostFix(String exp) {

        Stack<Integer> inputStack = new Stack<Integer>();

        for( char ch: exp.toCharArray()){
            if(!Character.isDigit(ch)){
                int x = inputStack.pop();
                int y = inputStack.pop();

                switch(ch){
                    case '+':
                        inputStack.push(x+y);
                        break;
                    case '-':
                        inputStack.push(x+y);
                        break;
                    case '*':
                        inputStack.push(x*y);
                        break;
                    case '/':
                        inputStack.push(x/y);
                        break;
                }
            }else{
                inputStack.push(Character.getNumericValue(ch));
            }

        }
        return inputStack.pop();
    }


        public static void main(String[] arg){
        String s = "921*-8-4+";

        System.out.println(evaluatePostFix(s));

    }
}
