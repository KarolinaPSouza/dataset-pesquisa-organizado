import java.util.*;

public class entry_2424364 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MOD = (int) Math.pow(10, 9) + 7;
        int n = sc.nextInt();
        int amt = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; ++i)
            coins[i] = sc.nextInt();
        int[] dp = new int[amt + 1];
        dp[0]= 1;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j <= amt; ++j)
                if (j -  coins[i] >= 0)
                    dp[j] = (dp[j] + dp[j - coins[i]])%MOD;
        System.out.println(dp[amt]);
    }
}