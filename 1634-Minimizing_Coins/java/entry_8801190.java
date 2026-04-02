// package Week7;

import java.util.*;

public class entry_8801190 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCoins = scanner.nextInt();
        int sum = scanner.nextInt();

        int[] coinValues = new int[numCoins];
        for (int i = 0; i < numCoins; i++) {
            coinValues[i] = scanner.nextInt();
        }

        CoinChangeCalculator calculator = new CoinChangeCalculator();
        int minCoins = calculator.calculateMinCoins(coinValues, sum);
        System.out.println(minCoins);
    }
}

class CoinChangeCalculator {
    public int calculateMinCoins(int[] values, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int value : values) {
            for (int i = value; i <= target; i++) {
                if (dp[i - value] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - value] + 1);
                }
            }
        }

        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }
}
