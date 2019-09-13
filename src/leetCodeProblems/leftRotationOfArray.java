package leetCodeProblems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class leftRotationOfArray {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Totel no of elements: ");
        int n = in.nextInt();
        
        System.out.print("Totel no of rotations: ");
        int k = in.nextInt();
        
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
        	System.out.print("Please enter "+ a_i+ " element");
            a[a_i] = in.nextInt();
        }
        
        int [] a1 = {1,2,3,4,5,6,7};
        int k1 = 3;
//        NthLeftRotation(a,k);
        NthLeftRotation(a1,k1);
    }
    
    public static void NthLeftRotation(int [] a, int k) {
    	
    	for(int j=0; j<k;j++) {
    		for(int i=0; i<a.length-1; i++) {
        		int temp = a[i];
        		a[i]=a[i+1];
        		a[i+1]=temp;        		
        	}
    		
    	}
    	
    	for(int i=0; i<a.length; i++) {
    		System.out.print(a[i]+" ");
    	}
    	
        
    }
}