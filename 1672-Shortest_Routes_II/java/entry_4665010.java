//package cronumax.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class entry_4665010 {

    static InputStream in = new BufferedInputStream(System.in);
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static int nextInt() {
        int r = 0;
        try {
            int c = in.read();
            while (c < '0' || c > '9') c = in.read();
            while (c >= '0' && c <= '9') {
                r = r * 10 + (c - '0');
                c = in.read();
            }

        } catch (Exception e) {
            // ignore
        }
        return r;
    }

    static class Edge {
        int u;
        long w;

        public Edge(int u, long w) {
            this.u = u;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int q = nextInt();

        long dist [][] = new long[n + 1][n + 1];
        for(int i = 0; i <= n; i ++){
            Arrays.fill(dist[i], (long)1e18);
            dist[i][i] = 0;
        }

        for(int i = 0; i < m; i ++){
            int u = nextInt();
            int v = nextInt();
            int w = nextInt();
            dist[u][v] = Math.min( dist[u][v], w);
            dist[v][u] = Math.min( dist[v][u], w);
        }

        int [][] query = new int [q][2];
        for(int i = 0; i < q; i++){
            query[i][0] = nextInt();
            query[i][1] = nextInt();
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <=n; i++){
                if (i == k) continue;
                for(int j = 1; j <=n; j++){
                    if (j == k) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int [] p : query){
            out.println(dist[p[0]][p[1]] == ((long)1e18) ? -1 : dist[p[0]][p[1]]);
        }
        out.flush();
    }
}