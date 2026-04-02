import java.util.Scanner;
import java.util.Arrays;

public class entry_1712841 {

    static Scanner scanner = new Scanner(System.in);
    static final int MOD = 1_000_000_007;

    int add(final int x, final int y) {
        return (x + y) % MOD;
    }

    public static void main(String[] args) {
        final int n = scanner.nextInt(), x = scanner.nextInt();
        int[] dp = new int[x + 5], c = new int[n];
        for (int i = 0; i < n; ++i)
            c[i] = scanner.nextInt();
        Arrays.sort(c);
        dp[0] = 1;
        for (int i = 1; i <= x; ++i)
            for (int j = 0; j < n; ++j) {
                if (c[j] > i)
                    break;
                dp[i] = (dp[i] + dp[i - c[j]]) % MOD;
            }
        System.out.println(dp[x]);
    }
}