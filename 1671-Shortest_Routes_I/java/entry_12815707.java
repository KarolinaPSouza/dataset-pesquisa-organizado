import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;

public class entry_12815707 {
    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(new FileReader("src/input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("src/output.txt"));
                System.setOut(out);
            } catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    class Pair {
        int start, end, weight;
        boolean flag = false;

        public Pair(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (this.getClass() != o.getClass()) return false;
            Pair other = (Pair) o;
            return this.start == other.start && this.end == other.end && this.weight == other.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, weight);
        }
    }

    Random rand = new Random();

    void shuffle(long[] a, int n) {
        for (int i = 0; i < n; i++) {
            int random = rand.nextInt(n - i) + i;
            swap(a, i, random);
        }
    }


    long lcm(long a, long b) {
        long val = a * b;
        return val / gcd(a, b);
    }

    void swap(long[] a, int j, int i) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    long mod = (long) 1e9 + 7;
    FastReader in;
    PrintWriter o;

    public static void main(String[] args) throws IOException {
        new entry_12815707().run();
    }

    long[] getArray(int n) {
        long[] a = new long[n];
        for (int j = 0; j < n; j++)
            a[j] = in.nextLong();
        return a;
    }

    long fastPow(long x, long y) {
        long ans = 1;
        while (y > 0) {
            if ((y & 1) > 0) ans = (ans * x) % mod;
            x = x * x % mod;
            y >>= 1;
        }
        return ans;
    }

    void run() throws IOException {
        in = new FastReader();
        OutputStream op = System.out;
        o = new PrintWriter(op);
        int t;
        t = 1;
        //t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            helper();
        }
        o.flush();
    }

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    List<Pair>[] adj;

    public void helper() {
        int n = in.nextInt(), m = in.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt(), w = in.nextInt();
            adj[u].add(new Pair(u, v, w));
        }
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.add(new long[]{1, 0});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            if (cur[1] > dist[(int) cur[0]]) continue;
            for (Pair p : adj[(int) cur[0]]) {
                if (dist[p.end] > p.weight + cur[1]) {
                    dist[p.end] = p.weight + cur[1];
                    q.add(new long[]{p.end, dist[p.end]});
                }
            }
        }
        for (int i = 1; i <= n; i++) o.print(dist[i] + " ");

    }

}