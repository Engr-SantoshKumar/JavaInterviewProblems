package Code_Run_Build_LC350;/* [  ] [  ]
_______________________________________________________________________________

*/

public class ArrayProblem {
    private void display(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            int min = arr[i];
            for(int j =i; j<arr.length; j++){
                System.out.println("minimum" + arr[j]);
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k] + " " );
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] argv) {
        ArrayProblem ap = new ArrayProblem();
        int[] v = {3,2,1,4};
        ap.display(v);
    }
}

