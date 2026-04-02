import java.util.Scanner;

public class entry_11198027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        long[] dp = new long[n];
        dp[0] = arr[0];
        long res = dp[0];

        for (int i = 1 ; i < n ; i++) {
            if (dp[i - 1] + arr[i] > arr[i]) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = arr[i];
            }

            res = Math.max(res, dp[i]);
        }

        System.out.println(res);

        sc.close();
    }
}