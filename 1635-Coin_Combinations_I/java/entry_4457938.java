import java.util.Scanner;

public class entry_4457938 {

    private static final long MOD = (long) (1e9 + 7L);

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int total = in.nextInt();
        final int[] arr = new int[n];

        for(int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }

        final long[] dp = new long[total + 1];
        dp[0] = 1;

        for(int i = 1; i <= total; i ++) {
            long ans = 0;

            for(int num : arr) {
                if(i - num >= 0) {
                    ans = (ans + dp[i - num]) % MOD;
                }
            }
            dp[i] = ans;
        }

        System.out.println(dp[total]);
    }


}