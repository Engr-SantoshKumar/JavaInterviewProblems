/**
 * [ Goo2_25 ] [ product of K most recently inserted numbers  ]
_______________________________________________________________________________________________________________
 Question: design/implement a class that supports inserting integers and getting the product of K most
 recently inserted numbers (K is provided at the time of construction).

 Follow-up: K is not fixed, it's provided with each "getProduct" query.
 Expectations for good candidates: We're targeting constant time (per operation) and linear space
 (in K for the first problem, in #(insertions) for the second) algorithms for both problems,
 that correctly handle inserting zeroes, as well as a correct implementation for the first problem.

 https://leetcode.com/discuss/interview-question/364396

 */

package PrepSetTwo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _Goo2_25_Product_Of_Last_K_Elements {
    public static int size;
    public static int noOfZeros;
    public ArrayDeque<Integer> que;
    public Integer product;
    public List<Integer> List; //--> for followUp problem

    public _Goo2_25_Product_Of_Last_K_Elements(int k){
        size = k;
        que = new ArrayDeque<>();
        product = 1;
        List = new ArrayList<>();
    }

    public void add(int val){
        if(size<1){
            return;
        }
        //remove first element if ll size is more than K, also update noOfZero and product
        if(que.size() >= size){
            int firstNum = que.pollFirst();
            if(firstNum == 0){
                noOfZeros --;
            }else{
                product = product/firstNum;
            }
        }

        //update product
        if(val==0){
            noOfZeros++;
        }else{
            product *= val;
        }
        que.offerLast(val);
        List.add(val);
    }

    public int getProduct(){
        if (size == 0 || noOfZeros > 0) {
            return 0;
        }
        return product;
    }

    //K is not fixed, it's provided with each "getProduct" query.   ------- ?????
    public int productOfLastK(int K){
        if (List.size() < K){
            return 0;
        }
        int productOrg = 1;
        int end = List.size()-1;
        while(K>0){
            productOrg*=List.get(end);
            if(productOrg==0) return 0;
            end--;
            K--;
        }
        return product;
    }

    public static void main(String[] args) {
        _Goo2_25_Product_Of_Last_K_Elements s = new _Goo2_25_Product_Of_Last_K_Elements(2);
        s.add(2);
        s.add(2);
        s.add(4);
        System.out.println(s.getProduct());
        s.add(5);
        System.out.println(s.getProduct());
        s.add(0);
        System.out.println(s.getProduct());
        s.add(0);
        System.out.println(s.getProduct());
        s.add(4);
        System.out.println(s.getProduct());
        s.add(5);
        System.out.println(s.getProduct());

        System.out.println(s.productOfLastK(3));
        s.add(1);
        System.out.println(s.productOfLastK(3));
    }
}
