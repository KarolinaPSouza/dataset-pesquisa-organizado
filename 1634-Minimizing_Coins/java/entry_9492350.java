import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class entry_9492350 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}
        String next(){while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());}catch (IOException e) {e.printStackTrace();}}return st.nextToken();}
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() {return Double.parseDouble(next());}
    }

    void yes() {out.println("Yes");}
    void no() {out.println("No");}
    void inArr(int[] a){for(int i=0;i<a.length;i++){a[i]=sc.nextInt();}}
    void inArr(long[] a){for(int i=0;i<a.length;i++){a[i]=sc.nextLong();}}
    void inArr(String[] a){for(int i=0;i<a.length;i++){a[i]=sc.next();}}
    void pArr(int[] a){for(int i=0; i<a.length;i++){out.print(a[i]+" ");}}
    void pArr(long[] a){for(int i=0; i<a.length;i++){out.print(a[i]+" ");}}
    void pl(){out.println();}
    long max(long a, long b){return Math.max(a, b);}
    long min(long a, long b){return Math.min(a, b);}
    int gcd(int a, int b) {while (b != 0) {int temp = b;b = a % b;a = temp;}return a;}
    public static boolean isSorted(int[] a) {for (int i = 0; i < a.length - 1; i++) {if (a[i] > a[i + 1]) {return false;}}return true;}
    public static final int MOD = 1000000000 + 7;

    FastReader sc=new FastReader();
    PrintWriter out=new PrintWriter(System.out);

    public static void main(String args[]) {
        entry_9492350 FC27 = new entry_9492350();
        FC27.solve();
    }

    /*
        DP me 4 stages are imp
        1.State
        2.Transition
        3.Base Case
        4.Final SubProblem
    */
    public void ans() {
        int n = sc.nextInt();
        int x = sc.nextInt();
        long[] a = new long[n];
        inArr(a);
        long[] dp = new long[x + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= a[j] && dp[(int)(i - a[j])] != Long.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[(int) (i - a[j])]);
                }
            }
        }
        if (dp[x] == Long.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(dp[x]);
        }
    }


    public void solve() {
        int t = 1;
        while(t-- > 0){
            ans();
        }
        out.close();
    }
}