import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class entry_14327543 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();

    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = sc.nextInt();
    }

    int[] dp = new int[x + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= x; i++) {
      for (int coin : coins) {
        if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    System.out.println(dp[x] == Integer.MAX_VALUE ? -1 : dp[x]);
  }

}