import java.util.*;

public class entry_11485958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] c = new int[n];
        for(int i = 0; i < n; i ++) {
            c[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        Arrays.fill(dp, 1000001);
        dp[0] = 0;
        for(int i = 1; i <= x; i ++) {
            for(int j = 0; j < n; j ++) {
                if(c[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c[j]]);
                }
            }
        }

        System.out.println((dp[x] == 1000001 ? -1 : dp[x]));
    }
}