import java.io.*;
import java.util.*;

public class entry_15456302 {

    // ---- FAST BYTE READER ----
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() {
            if (ptr >= len) {
                ptr = 0;
                try {
                    len = in.read(buffer);
                } catch (IOException e) {
                    return -1;
                }
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() {
            int c;
            do {
                c = read();
                if (c == -1) return -1;
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() {
            int c;
            do {
                c = read();
                if (c == -1) return -1;
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10L + (c - '0');
                c = read();
            }
            return sign == 1 ? val : -val;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        final long INF = (long) 3e18;  // safe: INF + INF < Long.MAX

        // 1D distance matrix: dist[i][j] -> dist[i * n + j], 0-based
        int N = n;
        long[] dist = new long[N * N];

        // init
        Arrays.fill(dist, INF);
        for (int i = 0; i < N; i++) {
            dist[i * N + i] = 0;
        }

        // read edges (undirected)
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            long c = sc.nextLong();
            int ab = a * N + b;
            int ba = b * N + a;
            if (c < dist[ab]) {
                dist[ab] = c;
                dist[ba] = c;
            }
        }

        // Floyd–Warshall (heavily optimized)
        for (int k = 0; k < N; k++) {
            int kN = k * N;
            for (int i = 0; i < N; i++) {
                long dik = dist[i * N + k];
                if (dik == INF) continue;
                int iN = i * N;
                for (int j = 0; j < N; j++) {
                    long via = dik + dist[kN + j];
                    if (via < dist[iN + j]) {
                        dist[iN + j] = via;
                    }
                }
            }
        }

        while (q-- > 0) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            long ans = dist[a * N + b];
            if (ans >= INF / 2) sb.append(-1).append('\n');
            else sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}