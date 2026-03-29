import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class entry_4940757 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        byte nextByte() {
            return Byte.parseByte(next());
        }

        short nextShort() {
            return Short.parseShort(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append(object + " ");
        }

        public void println(Object object) throws IOException {
            if (object != null) {
                bw.append(object + "");
            }
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static int ceil(int[] arr, int d) {
        int ceil = -1;
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) / 2;
            if (d <= arr[m]) {
                hi = m - 1;
                ceil = m;
            } else if (d > arr[m]) {
                lo = m + 1;
            }
        }
        return ceil;
    }

    static final int mod = 1000000000 + 7;

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int n = in.nextInt(), m = in.nextInt();
        int[][] edges = new int[m][3];
        for(int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt(), d = in.nextInt();
            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = d;
        }
        long[] dist = new long[n + 1];
        int[] relaxant = new int[n + 1];
        int x = -1;
        for(int i = 1; i <= n; i++) {
            x = -1;
            for(int[] edge: edges) {
                if(dist[edge[0]] + edge[2] < dist[edge[1]]) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                    x = edge[1];
                    relaxant[x] = edge[0];
                }
            }
        }

        if(x == -1) {
            out.println("NO");
        } else {
            out.println("YES");
            for(int i = 1; i <= n; i++) {
                x = relaxant[x];
            }

            LinkedList<Integer> ans = new LinkedList<>();
            int v = x;
            while(true) {
                ans.addFirst(v);
                if(v == x && ans.size() > 1)
                    break;
                v = relaxant[v];
            }
            while(!ans.isEmpty()) {
                out.print(ans.poll());
            }
        }
        out.close();
    }
}