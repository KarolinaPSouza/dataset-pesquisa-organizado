import java.util.*;
import java.io.*;

public class entry_9655786 {
    private static final long INF = (long) 1e18;

    static class Triplet {
        int u;
        long v;
        long w;

        Triplet(int x, long a, long b) {
            u = x;
            v = a;
            w = b;
        }
    }

    static class Pair {
        int u;
        long w;

        Pair(int a, long b) {
            u = a;
            w = b;
        }
    }

    public static void main(String[] args) throws IOException {
        Reader io = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = io.nextInt();
        int m = io.nextInt();

        List<Pair>[] A1 = new ArrayList[n], A2 = new ArrayList[n];
        List<Triplet> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A1[i] = new ArrayList<>();
            A2[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = io.nextInt() - 1, v = io.nextInt() - 1;
            long w = io.nextLong();
            A1[u].add(new Pair(v, w));
            A2[v].add(new Pair(u, w));
            edges.add(new Triplet(u, v, w));
        }

        long[] D1 = new long[n], D2 = new long[n];
        dijkistra(D1, A1, 0, n);
        dijkistra(D2, A2, n - 1, n);

        long min = INF;
        for (Triplet e : edges) {
            min = Math.min(min, D1[e.u] + (long) Math.floor(e.w / 2) + D2[(int) e.v]);
        }
        pw.println(min);

        pw.close();
        io.close();
    }

    static void dijkistra(long[] D, List<Pair>[] A, int src, int n) {
        boolean[] isV = new boolean[n];
        Arrays.fill(D, INF);
        D[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((i, j) -> Long.compare(i.w, j.w));

        pq.add(new Pair(src, 0l));
        while (!pq.isEmpty()) {
            Pair r = pq.poll();
            if (isV[r.u])
                continue;
            isV[r.u] = true;
            for (Pair p : A[r.u]) {
                if (!isV[p.u] && D[p.u] > r.w + p.w) {
                    pq.add(new Pair(p.u, p.w + r.w));
                    D[p.u] = p.w + r.w;
                }
            }
        }

    }

    static class Reader {

        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;

        private byte[] buffer;

        private int bufferPointer, bytesRead;

        public Reader() {

            din = new DataInputStream(System.in);

            buffer = new byte[BUFFER_SIZE];

            bufferPointer = bytesRead = 0;

        }

        private void fillBuffer() throws IOException {

            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);

            if (bytesRead == -1)
                buffer[0] = -1;

        }

        private byte read() throws IOException {

            if (bufferPointer == bytesRead)
                fillBuffer();

            return buffer[bufferPointer++];

        }

        public void close() throws IOException {

            if (din == null)
                return;

            din.close();

        }

        public int nextInt() throws IOException {

            int ret = 0;

            byte c = read();

            while (c <= ' ')
                c = read();

            boolean neg = (c == '-');

            if (neg)
                c = read();

            do {

                ret = ret * 10 + c - '0';

            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;

            return ret;

        }

        public long nextLong() throws IOException {

            long ret = 0;

            byte c = read();

            while (c <= ' ')
                c = read();

            boolean neg = (c == '-');

            if (neg)
                c = read();

            do {

                ret = ret * 10 + c - '0';

            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;

            return ret;

        }

    }
}