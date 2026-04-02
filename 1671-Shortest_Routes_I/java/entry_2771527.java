//package Concepts.CSES.Graphs;

import java.io.*;
import java.util.*;

public class entry_2771527 {

    static final long mod = (long) 1e9 + 7l;
    static List<Node>[] adj;
    static long[] dist;
    //    static PriorityQueue<Node> pq; // insert = O(logN) / delete =O(N)
    static TreeSet<Integer> tpq;  // insert / delete = O(logN)

    private static void solve(int t) throws IOException {
        _Scanner sc = new _Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        adj = new ArrayList[v];
        dist = new long[v];
//        pq = new PriorityQueue<>(new Node());
        tpq = new TreeSet<>((e1, e2) -> dist[e1] == dist[e2] ? e1 - e2 : dist[e1] < dist[e2] ? -1 : 1);
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int cost = sc.nextInt();
            adj[src].add(new Node(dest, cost));
        }
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        tpq.add(0);
        Integer currNode;
        while ((currNode = tpq.pollFirst()) != null) {
            neigboursDistance(currNode);
        }
        for (int i = 0; i < v; i++) {
            out.print(dist[i] + " ");
        }
    }

    private static void neigboursDistance(int node) {
        for (Node currNode : adj[node]) {
            long newDist = dist[node] + currNode.cost;
            if (dist[currNode.node] > newDist) {
                if (dist[currNode.node] != Long.MAX_VALUE) tpq.remove(currNode.node);
                dist[currNode.node] = newDist;
                tpq.add(currNode.node);
            }
        }
    }

    private static class Node implements Comparator<Node> {
        public int node;
        public long cost;

        public Node() {
        }

        public Node(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        fs = new FastScanner();
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        int t = 1;// fs.nextInt();
        for (int i = 1; i <= t; i++) solve(t);
        out.close();
        System.err.println(System.currentTimeMillis() - s + "ms");
    }

    static boolean DEBUG = true;
    static PrintWriter out;
    static FastScanner fs;

    static void trace(Object... o) {
        if (!DEBUG) return;
        System.err.println(Arrays.deepToString(o));
    }

    static void pl(Object o) {
        out.println(o);
    }

    static void p(Object o) {
        out.print(o);
    }

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static void sieveOfEratosthenes(int n, int factors[]) {
        factors[1] = 1;
        for (int p = 2; p * p <= n; p++) {
            if (factors[p] == 0) {
                factors[p] = p;
                for (int i = p * p; i <= n; i += p)
                    factors[i] = p;
            }
        }
    }

    static long mul(long a, long b) {
        return a * b % mod;
    }

    static long fact(int x) {
        long ans = 1;
        for (int i = 2; i <= x; i++) ans = mul(ans, i);
        return ans;
    }

    static long fastPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = fastPow(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long modInv(long x) {
        return fastPow(x, mod - 2);
    }

    static long nCk(int n, int k) {
        return mul(fact(n), mul(modInv(fact(k)), modInv(fact(n - k))));
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class _Scanner {
        InputStream is;

        _Scanner(InputStream is) {
            this.is = is;
        }

        byte[] bb = new byte[1 << 15];
        int k, l;

        byte getc() throws IOException {
            if (k >= l) {
                k = 0;
                l = is.read(bb);
                if (l < 0) return -1;
            }
            return bb[k++];
        }

        byte skip() throws IOException {
            byte b;
            while ((b = getc()) <= 32)
                ;
            return b;
        }

        int nextInt() throws IOException {
            int n = 0;
            for (byte b = skip(); b > 32; b = getc())
                n = n * 10 + b - '0';
            return n;
        }
    }
}