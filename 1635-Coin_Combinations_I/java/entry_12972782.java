import java.util.*;

public class entry_12972782 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        long[] dp = new long[x + 1];
        dp[0] = 1;
        for(int i = 1; i<=x; i++){
            for(int j = 0; j<n; j++){
                if(h[j]<=i){
                    dp[i] = (dp[i]+dp[i-h[j]])%1000000007;
                }
            }
        }
        System.out.println(dp[x]);
    }
}