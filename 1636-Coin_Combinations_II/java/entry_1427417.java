import java.util.Scanner;

public class entry_1427417 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] firstInput = new int[2];
        for (int i = 0; i < firstInput.length; i++){
            firstInput[i] = scanner.nextInt();
        }

        int numberOfCoins = firstInput[0];
        int money = firstInput[1];

        int[] coins = new int[numberOfCoins];
        for (int i = 0; i < coins.length; i++){
            coins[i] = scanner.nextInt();
        }

        numWays(coins, money);
    }

    private static void numWays(int[] coins, int money) {

        int[] dp = new int[money+1];
        dp[0] = 1;

        final int mod = 1000000007;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= money; j++) {
                if(j-coins[i] >= 0){
                    dp[j] = (dp[j] + dp[j-coins[i]] ) % mod;
                }
            }
        }
        System.out.println(dp[money] % mod);
    }
}