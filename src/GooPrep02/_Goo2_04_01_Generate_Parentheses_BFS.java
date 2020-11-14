package GooPrep02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _Goo2_04_01_Generate_Parentheses_BFS {


    public static List<String> generateParenthesisBFS(int pair) {
        List<String> result = new ArrayList<String>();
        Queue<Parenthesis> queue = new LinkedList<>();
        queue.add(new Parenthesis("", 0, 0));

        while(!queue.isEmpty()){
            Parenthesis current = queue.poll();
            if(current.openBrkt ==pair && current.closeBrkt ==pair){
                result.add(current.str);
            }
            if(current.openBrkt < pair){
                queue.add(new Parenthesis(current.str+"{", current.openBrkt+1, current.closeBrkt));
            }
            if(current.closeBrkt < current.openBrkt){
                queue.add(new Parenthesis(current.str+"}", current.openBrkt, current.closeBrkt+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesisBFS(3));
    }
}

class Parenthesis{
    String str;
    int openBrkt;
    int closeBrkt;
    public Parenthesis(String str, int openBrkt, int closeBrkt){
        this.str = str;
        this.openBrkt = openBrkt;
        this.closeBrkt = closeBrkt;
    }

}
