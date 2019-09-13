package _01_Coderust._01_Array;

public class _06_Firs_NonRepeating_IntegerArray {

    static int firstNonRepeatingInteger(int arr[]){

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++)
                if (i != j && arr[i] == arr[j])
                    break;
            if (j == n)
                return arr[i];
        }
        return -1;
    }



    public static int firstNonRepeting(int [] arr){

        int len = arr.length;

        boolean IsRepeting = false; // set it to false

        for(int i =0; i<len; i++){

            // inner loop will match i with j and if it matches will set the IsRepeting to true
            for(int j=0; j<len; j++){

                if(arr[i] == arr[j] && i!=j){
                    IsRepeting =true;
                }
            }
            // if the IsRepeting value is still false that mean the inner loop does not change it value and we return the i
            if(IsRepeting ==false) {
                return arr[i];
            }

            // else will reset the IsRepeting to false
            IsRepeting = false;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2,9,9,3,2,6,6,1};

        System.out.println(firstNonRepeting(a));
        System.out.println(firstNonRepeatingInteger(a));

    }

}



