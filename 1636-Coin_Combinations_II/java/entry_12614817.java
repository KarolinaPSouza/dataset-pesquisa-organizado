import java.util.Scanner;
import java.util.Arrays;

public class entry_12614817 {
    public static final int MOD = 1_000_000_000 + 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = in.nextInt();
        System.out.println(solve(target, coins));
    }

    public static int solve(int target, int[] coins) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int coin : coins) {
            for (int amt = coin; amt <= target; amt++) {
                memo[amt] = (memo[amt] + memo[amt - coin]) % MOD;
            }
        }
        return memo[target];
    }
}