import java.util.*;

public class entry_11225536 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        long dp[] = new long[s+1];
        int coins[] = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = in.nextInt();
        }
        dp[0] = 1;
        for(int i = 1; i <= s; i++){
            for(int c : coins){
                if(i - c >= 0){
                    dp[i] += dp[i-c];
                    dp[i] %= 1000000007;
                }
            }
        }
        System.out.println(dp[s]);
        in.close();
    }
}