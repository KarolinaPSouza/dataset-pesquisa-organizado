import java.io.*;
import java.util.*;

public class entry_15838484 {

    public static final int inf = (int) 1e9;
    public static final long INF = (long) 1e18;

    static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public U getSecond() {
            return second;
        }

        public void setSecond(U second) {
            this.second = second;
        }

    }

    static class State implements Comparable<State> {
        long dist;
        int node;
        int used; // 0 = not used discount, 1 = used

        State(long dist, int node, int used) {
            this.dist = dist;
            this.node = node;
            this.used = used;
        }

        @Override
        public int compareTo(State other) {
            if(Long.compare(this.dist, other.dist)!=0) return Long.compare(this.dist, other.dist);
            if(Integer.compare(this.node, other.node)!=0) return Integer.compare(this.node, other.node);
            return Integer.compare(this.used, other.used);
        }
    }

    static void solve(FastScanner fs, int tt) throws Exception {
        int n = fs.nextInt(), m = fs.nextInt();

        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = fs.nextInt() - 1, v = fs.nextInt() - 1, w = fs.nextInt();
            adj.get(u).add(new Pair<Integer, Integer>(v, w));
        }

        PriorityQueue<State> st = new PriorityQueue<>();
        st.add(new State(0, 0, 0));
        long[][] dp = new long[2][n];
        for (int i = 0; i < 2; i++) Arrays.fill(dp[i], INF);
        dp[0][0] = dp[1][0] = 0;
        while(!st.isEmpty()) {
            var state = st.poll();
            int u = state.node, flag = state.used;
            long dist = state.dist; 
            if (dist != dp[flag][u]) continue;
            for(var p : adj.get(u)) {
                int v = p.getFirst(), w = p.getSecond();
                if(flag > 0) {
                    if(dp[1][v] > dp[1][u] + w) {
                        dp[1][v] = dp[1][u] + w;
                        st.add(new State(dp[1][v],v,flag));
                    }
                } else {
                    if(dp[0][v] > dp[0][u] + w) {
                        dp[0][v] = dp[0][u] + w;
                        st.add(new State(dp[0][v],v,0));
                    }
                    if(dp[1][v] > Math.min(dp[1][u]+w, dp[0][u]+(w/2))) {
                        dp[1][v] = Math.min(dp[1][u]+w, dp[0][u]+(w/2));
                        st.add(new State(dp[1][v],v,1));
                    }
                }
            }
        }
        if(Math.min(dp[0][n-1],dp[1][n-1]) != INF) out.println(Math.min(dp[0][n-1],dp[1][n-1]));
        else out.print("IMPOSSIBLE");
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = 1;
        // t = fs.nextInt();

        for (int tt = 1; tt <= t; tt++) {
            solve(fs, tt);
        }
        out.flush();
    }

    /* ===================== FAST IO ===================== */
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16]; // Read 64 kb in single go and store in jvm cache (OS->JVM)
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                assert c >= '0' && c <= '9';
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                assert c >= '0' && c <= '9';
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder();
            do {
                c = readByte();
            } while (c <= ' ');
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }

    static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    /* ===================== UTILS ===================== */
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}