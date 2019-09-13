package _01_Coderust._07_Dynamic_Programing;

public class _x_03_Coin_Change_DP {

    static int solve_coin_change_dp( int [] coins, int amount){

        int[] solution = new int[amount + 1];

        solution[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < (amount + 1); ++i) {
                solution[i] += solution[i - coin];
            }
        }
        return solution[solution.length - 1];

    }




    public static void main(String[] args) {

        int[] denominations = new int[] {1, 5, 10};
        System.out.println("Combinations (DP): " + solve_coin_change_dp(denominations,22));
    }
}
