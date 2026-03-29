import java.io.*;
import java.util.*;

public class entry_14093675 {
    // fast input
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Integer.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Long.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    // forward-star adjacency
    static int[] head;
    static int[] to;
    static long[] w;
    static int[] next;
    static int edgeCnt = 0;

    static void initGraph(int edgesCapacity, int nodes) {
        head = new int[nodes + 1];
        Arrays.fill(head, -1);
        to = new int[edgesCapacity];
        w = new long[edgesCapacity];
        next = new int[edgesCapacity];
        edgeCnt = 0;
    }

    static void addEdge(int u, int v, long weight) {
        to[edgeCnt] = v;
        w[edgeCnt] = weight;
        next[edgeCnt] = head[u];
        head[u] = edgeCnt++;
    }

    // custom min-heap storing (node, distAtPush) in primitive arrays
    static class MinHeap {
        int size = 0;
        int[] heapNode;
        long[] heapDist;
        MinHeap(int cap) { heapNode = new int[cap + 5]; heapDist = new long[cap + 5]; }
        void push(int node, long dist) {
            int i = ++size;
            heapNode[i] = node;
            heapDist[i] = dist;
            while (i > 1) {
                int p = i >> 1;
                if (heapDist[p] <= heapDist[i]) break;
                swap(i, p);
                i = p;
            }
        }
        int swapTempNode;
        long swapTempDist;
        void swap(int a, int b) {
            swapTempNode = heapNode[a]; heapNode[a] = heapNode[b]; heapNode[b] = swapTempNode;
            swapTempDist = heapDist[a]; heapDist[a] = heapDist[b]; heapDist[b] = swapTempDist;
        }
        boolean isEmpty() { return size == 0; }
        int peekNode() { return heapNode[1]; }
        long peekDist() { return heapDist[1]; }
        void pop() {
            heapNode[1] = heapNode[size];
            heapDist[1] = heapDist[size];
            size--;
            int i = 1;
            while (true) {
                int l = i << 1;
                int r = l + 1;
                int smallest = i;
                if (l <= size && heapDist[l] < heapDist[smallest]) smallest = l;
                if (r <= size && heapDist[r] < heapDist[smallest]) smallest = r;
                if (smallest == i) break;
                swap(i, smallest);
                i = smallest;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();
        // We'll create up to 3*m edges (u->v no coupon, u+n->v+n, u->v+n using coupon)
        int totalNodes = 2 * n;
        initGraph(3 * m + 5, totalNodes);

        int[] uu = new int[m];
        int[] vv = new int[m];
        long[] cc = new long[m];
        for (int i = 0; i < m; ++i) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            long c = fs.nextLong();
            uu[i] = a; vv[i] = b; cc[i] = c;
        }

        for (int i = 0; i < m; ++i) {
            int a = uu[i], b = vv[i]; long c = cc[i];
            // state0: node = v (1..n)
            // state1: node = v + n (n+1 .. 2n)
            addEdge(a, b, c);           // a(0) -> b(0)
            addEdge(a + n, b + n, c);   // a(1) -> b(1)
            addEdge(a, b + n, c / 2);   // use coupon on this edge: a(0) -> b(1)
        }

        final long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[totalNodes + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // start at node 1 with coupon unused (node 1)

        MinHeap heap = new MinHeap(3 * m + 5);
        heap.push(1, 0);

        while (!heap.isEmpty()) {
            int v = heap.peekNode();
            long d = heap.peekDist();
            heap.pop();
            if (d != dist[v]) continue; // stale
            // relax neighbors
            for (int e = head[v]; e != -1; e = next[e]) {
                int toNode = to[e];
                long nd = d + w[e];
                if (nd < dist[toNode]) {
                    dist[toNode] = nd;
                    heap.push(toNode, nd);
                }
            }
        }

        long ans = Math.min(dist[n], dist[n + n]);
        System.out.println(ans);
    }
}