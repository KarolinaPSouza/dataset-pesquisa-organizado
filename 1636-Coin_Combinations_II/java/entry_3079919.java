import java.io.*;
import java.util.*;

public class entry_3079919 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int mod = (int)(1e9)+7;

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        int[] dp = new int[x+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=1;i<=x;i++){
                if(i>=coin){
                    dp[i] = (dp[i]+dp[i-coin])%mod;
                }
            }
        }
        System.out.println(dp[x]);
    }

}