import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class entry_15364117 {
    static class IndexMinPQ {
        long[] keys;
        int[] pq;
        int[] qp;
        int n;

        IndexMinPQ(int size) {
            keys = new long[size + 1];
            pq = new int[size + 1];
            qp = new int[size + 1];
            n = 0;
            Arrays.fill(qp, -1);
        }

        void swap(int i, int j) {
            int tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
            qp[pq[i]] = i;
            qp[pq[j]] = j;
        }

        void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                swap(k, k / 2);
                k = k / 2;
            }
        }

        void sink(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && greater(j, j + 1))
                    j++;
                if (!greater(k, j))
                    break;
                swap(k, j);
                k = j;
            }
        }

        boolean greater(int i, int j) {
            return keys[pq[i]] > keys[pq[j]];
        }

        void add(int i, long k) {
            n++;
            qp[i] = n;
            pq[n] = i;
            keys[i] = k;
            swim(n);
        }

        int min() {
            int min = pq[1];
            swap(1, n--);
            sink(1);
            qp[min] = -1;
            return min;
        }

        void dk(int i, long k) {
            keys[i] = k;
            swim(qp[i]);
        }

        boolean has(int i) {
            return qp[i] != -1;
        }
    }

    static class FastScanner {
        InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= 32)
                if (c == -1)
                    return Integer.MIN_VALUE;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= 32)
                if (c == -1)
                    return Long.MIN_VALUE;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static long INF = 1000000000000000L;

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] head = new int[n + 1];
        Arrays.fill(head, -1);
        int[] to = new int[m];
        long[] w = new long[m];
        int[] next = new int[m];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            long c = in.nextLong();
            to[i] = b;
            w[i] = c;
            next[i] = head[a];
            head[a] = i;
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean[] marked = new boolean[n + 1];

        IndexMinPQ pq = new IndexMinPQ(n);
        pq.add(1, 0);

        while (pq.n != 0) {
            int x = pq.min();
            if (marked[x])
                continue;
            marked[x] = true;

            for (int e = head[x]; e != -1; e = next[e]) {
                int y = to[e];
                long wt = w[e];
                long nd = dist[x] + wt;
                if (nd < dist[y]) {
                    dist[y] = nd;
                    if (pq.has(y))
                        pq.dk(y, nd);
                    else
                        pq.add(y, nd);
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++)
            s.append(dist[i]).append(" ");
        System.out.println(s.toString());
    }
}