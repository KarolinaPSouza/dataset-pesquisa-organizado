import java.io.*;
import java.lang.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class entry_827967 {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        final int mod = (int)1e9+7;
        int n = in.nextInt();
        int target = in.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i<n; i++) coins[i] = in.nextInt();
        shuffle(coins);
        Arrays.sort(coins);
        long[] dp = new long[target+1];
        dp[0] = 1;
//        for(int i = 1; i<=target; i++){
//            for(int j = 0; j<coins.length; j++){
//                if(coins[j]-i<0) break;
//                dp[i] = (dp[i] + dp[i-coins[j]]) % mod;
//            }
//        }
        for(int i = 0; i<coins.length; i++){
            for(int j = 1; j<=target; j++){
                if (j - coins[i] >= 0) {
                    dp[j] = (dp[j] + dp[j-coins[i]]) % mod;
                }
            }
        }
        out.println(dp[target]%mod);
        out.close();
    }
    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public boolean hasNext() {
            String next = null;
            try {
                next = reader.readLine();
            } catch (Exception e) {
            }
            if (next == null) {
                return false;
            }
            tokenizer = new StringTokenizer(next);
            return true;
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }
    }
}
