import java.util.*;

import java.io.*;

public class entry_3963103 {

    public static void main(String[] arg) throws IOException {

        FastScanner sc = new FastScanner(System.in);
        int n = Integer.parseInt(sc.next()), m = Integer.parseInt(sc.next());
        int q = Integer.parseInt(sc.next());
        long[][] g = new long[n + 1][n + 1];
        long mod = (long) 1000000007, INF = 0x3f3f3f3f3f3f3f3fL;

        for (int i = 0; i <= n; i++) {
            Arrays.fill(g[i], INF);
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
            pw.print(g[a][b] == INF ? -1 + "\n" : g[a][b] + "\n");
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