import java.util.Scanner;

public class entry_9886527 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        dp[0] = 1; // Base case: There's one way to make 0 with 0 coins

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= x; j++) {
                dp[j] = (dp[j] + dp[j - arr[i]]) % 1_000_000_007;
            }
        }

        System.out.println(dp[x]);
    }
}