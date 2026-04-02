import java.util.*;
import java.io.*;

public class entry_6335548 {
    private static final int MOD = (int)1e9 + 7;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); int x = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[x + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 0; i <= x; i++) {
            if(dp[i] != 0){
                for(int e : coins){
                    if(i + e <= x){
                        dp[i + e] = (dp[i + e] + dp[i])%MOD;
                    }
                }
            }
        }
        pw.println(dp[x]);
        pw.close();
    }   
}