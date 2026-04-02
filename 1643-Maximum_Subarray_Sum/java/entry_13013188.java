import java.io.*;
import java.util.*;

public class entry_13013188 {
    static int MOD= 1000000007;
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
        long[] pref = new long[n+1];
        for(int i =1;i<=n;i++){
            long x = in.nextLong();
            pref[i] = pref[i-1]+x;
        }
        long min = pref[0];
        long max = pref[1];
        for(int  i =1;i<=n;i++){
            max = Math.max(max,pref[i]-min);
            min = Math.min(min,pref[i]);
        }
        System.out.println(max);
    }
}