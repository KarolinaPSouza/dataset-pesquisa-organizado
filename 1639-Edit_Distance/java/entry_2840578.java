import java.io.*;
import java.util.*;

public class entry_2840578 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) throws IOException{
        String s = readLine(), m = readLine();
        int slen = s.length()+1, mlen = m.length()+1;
        int [][] dp = new int[slen][mlen];
        for (int i = 0; i < slen; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < slen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < mlen; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < slen; i++) {
            for (int j = 1; j < mlen; j++) {
                if (s.charAt(i-1)==m.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        System.out.println(dp[slen-1][mlen-1]);
    }


    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
    static int readLongLineInt() throws IOException{
        int x = 0, c;
        while((c = br.read()) != ' ' && c != '\n')
            x = x * 10 + (c - '0');
        return x;
    }
    static long pow (long x, long exp){
        if (exp==0) return 1;
        long t = pow(x, exp/2);
        t = t*t;
        if (exp%2 == 0) return t;
        return t*x;
    }
}