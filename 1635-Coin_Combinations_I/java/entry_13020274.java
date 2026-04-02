import java.io.*;
import java.util.*;

public class entry_13020274 {
    static final int MOD = 1000000007;
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        long[] dp = new long[k+1];
        dp[0] = 1;
        for(int i = 1;i<=k;i++){
            for(int ele:arr){
                if(i-ele>=0){
                    dp[i] = (dp[i]+dp[i-ele])%MOD;
                }
            }
        }
        System.out.println(dp[k]);
    }
}