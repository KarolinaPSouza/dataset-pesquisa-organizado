import java.io.*;

public class entry_12384569 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputBR = new BufferedReader(new InputStreamReader(System.in));
        String[] metadata = inputBR.readLine().split(" ");
        int n = Integer.parseInt(metadata[0]);
        int x = Integer.parseInt(metadata[1]);
        String[] temp = inputBR.readLine().split(" ");
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(temp[i]);
        }

        System.out.println(computeOrderedCombinations(coins, x));
    }

    private static int computeOrderedCombinations(int[] coins, int target) {
        final int MOD = 1000000007;

        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
        }

        return (int) dp[target];
    }
}