import java.util.Scanner;

public class entry_7590943 {

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int x = s.nextInt();

    long[] dp = new long[x + 1];

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    for (int j = 0; j < x + 1; j++) {
      dp[j] = Integer.MAX_VALUE;
    }

    dp[0] = 0;
    for (int j = 0; j < x + 1; j++) {
      for (int i = 0; i < n; i++) {
        if (j >= arr[i]) {
          dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
        }
      }
    }

    System.out.println(dp[x] >= Integer.MAX_VALUE ? -1 : dp[x]);

  }
}