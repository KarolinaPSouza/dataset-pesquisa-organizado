/*
Rohith Vishwajith
Week 1 CSES Problem 2 - Labyrinth
*/

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class entry_3963118 {

    public static void main(String[] arg) throws IOException {

        FastScanner sc = new FastScanner(System.in);
        int n = Integer.parseInt(sc.next()), m = Integer.parseInt(sc.next());
        int q = Integer.parseInt(sc.next());
        long[][] g = new long[n + 1][n + 1];
        long mod = (long) 1000000007, MAX_VALUE = 0x3f3f3f3f3f3f3f3fL;

        for (int i = 0; i <= n; i++) {
            Arrays.fill(g[i], MAX_VALUE);
            g[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(sc.next()), b = Integer.parseInt(sc.next());
            int c = Integer.parseInt(sc.next());
            g[a][b] = Math.min(g[a][b], c);
            g[b][a] = g[a][b];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    g[j][i] = g[i][j];
                }
            }
        }

        PrintWriter pw = new PrintWriter(System.out); // System too slow.
        for (int i = 0; i < q; i++) {
            int a = Integer.parseInt(sc.next()), b = Integer.parseInt(sc.next());
            pw.println(g[a][b] == MAX_VALUE ? -1 : g[a][b]);
        }
        pw.close();
    }
}

class FastScanner {

    StringTokenizer st;
    BufferedReader br;

    public FastScanner(FileReader r) {
        br = new BufferedReader(r);
    }

    public FastScanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }
}