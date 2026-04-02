// AUTHOR: UNIVERSAL ADMIN

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class entry_15601501 {
    public static void main(String[] args) {
        new Thread(null, ()-> {
            new Main2().start();
        }, "", 1 << 27).start();
    }
}
//----------------------------------------------------------------------------------------------------------------------------------------------
class Main2 {
    void start() {
        int t = 1;
        while(t-- > 0)
            solve();

        w.close();
    }

    void solve() {
        long INF = 1L<<60;
        int n = ni(), edges = ni(), q = ni();
        long[][] dist = new long[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int i = 0; i < edges; i++) {
            int a = ni() - 1, b = ni() - 1;
            long cost = ni();
            if(cost < dist[a][b]) {
                dist[a][b] = cost;
                dist[b][a] = cost;
            }
        }

        for(int through = 0; through < n; through++) {
            for(int a = 0; a < n; a++) {
                if(dist[a][through] == INF) continue;
                long distAThrough = dist[a][through];
                for(int b = a+1; b < n; b++) {
                    long currDist = distAThrough + dist[through][b];
                    if(currDist < dist[a][b]) {
                        dist[a][b] = currDist;
                        dist[b][a] = currDist;
                    }
                }
            }
        }

        while(q-- > 0) {
            int a = ni() - 1, b = ni() - 1;
            long ans = dist[a][b];
            p((ans == INF) ? -1 : ans);
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------
    long lma = Long.MAX_VALUE, lmi = Long.MIN_VALUE;
    int ima = Integer.MAX_VALUE, imi = Integer.MIN_VALUE;
    long mod = 1000000007;
    //    long mod = 998244353;

    //--------------------------------------------------------------------------------------
    PrintWriter w = new PrintWriter(System.out);
    void p(int i) {w.println(i);} void p(long l) {w.println(l);}
    void p(double d) {w.println(d);} void p(String s) { w.println(s);}
    void pr(int i) {w.print(i);} void pr(long l) {w.print(l);}
    void pr(double d) {w.print(d);} void pr(String s) { w.print(s);}
    void pl() {w.println();}

    //--------------------------------------------------------------------------------------
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");
    String next() {
        while (!st.hasMoreTokens()) {
            try { st = new StringTokenizer(br.readLine());} catch (IOException e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }

    int ni() { return Integer.parseInt(next()); }
    long nl() { return Long.parseLong(next()); }
    double nd() { return Double.parseDouble(next()); }
    String ns() { return next(); }

    int[] na(long n) {int[]ret=new int[(int)n]; for(int i=0;i<n;i++) ret[i]=ni(); return ret;}
    long[] nal(long n) {long[]ret=new long[(int)n]; for(int i=0;i<n;i++) ret[i]=nl(); return ret;}
    Integer[] nA(long n) {Integer[]ret=new Integer[(int)n]; for(int i=0;i<n;i++) ret[i]=ni(); return ret;}
    Long[] nAl(long n) {Long[]ret=new Long[(int)n]; for(int i=0;i<n;i++) ret[i]=nl(); return ret;}
}