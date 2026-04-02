import java.util.*;
public class entry_16051609 {
    static final long MOD = 1_000_000_007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] inp = new int[n];
        for(int i=0; i<n; i++) inp[i] = sc.nextInt();
        long[] dp = new long[x+1];
        dp[0] = 1;
        for(int i=0; i<n; i++){
            int coin = inp[i];
            for(int j=coin; j<=x; j++){
                dp[j]=(dp[j]+dp[j-coin])%MOD;
            }
        }
        System.out.println(dp[x]);
    }
}