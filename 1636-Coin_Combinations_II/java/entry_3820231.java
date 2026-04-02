import java.io.*;
import java.util.*;

public class entry_3820231 {

    static FastScanner fs = new FastScanner();
    static Scanner scn = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) {
        int n = fs.nextInt();
        int x = fs.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) c[i] = fs.nextInt();
        int[] dp = new int[x+1];
        dp[0] = 1;
        int md = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= x; j++) {
                if(c[i] <= j) {
                    dp[j] = ((dp[j] + dp[j-c[i]]) % md);
                }
            }
        }
        pw.print(dp[x]);
        pw.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next() {while (!st.hasMoreTokens()) try {st = new StringTokenizer(br.readLine());} catch (IOException e) {}return st.nextToken();}
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}
    }
}