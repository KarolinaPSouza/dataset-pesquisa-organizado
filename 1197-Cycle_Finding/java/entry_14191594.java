import java.io.*;
import java.util.*;
public class entry_14191594 {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        { try {
            if (System.getProperty("ONLINE_JUDGE") == null) {
                br = new BufferedReader(new FileReader("input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        } catch (Exception e) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {st = new StringTokenizer(br.readLine());}
                catch (IOException e) {
                    e.printStackTrace();}
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() {return Double.parseDouble(next()); }
        String nextLine()
        {
            String str = "";
            try {
            str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        BufferedWriter bw;
        public FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        void print(Object o) {
            try {
                bw.write(o.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        void println(Object o) {
            try {
                bw.write(o.toString());
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        void println() {
            try {
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        void flush() {
            try {
                bw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        void close() {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // end of fast i/o code
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        FastWriter out = new FastWriter();

        int n = reader.nextInt();
        int m = reader.nextInt();

        List<Path> allPaths = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int u = reader.nextInt() - 1;
            int v = reader.nextInt() - 1;
            int w = reader.nextInt();

            allPaths.add(new Path(u, v, w));
        }

        long[] dp = new long[n];
        int[] parent = new int[n];
        int x = -1;

        for(int i = 0; i < n - 1; i++) {
            for(Path path : allPaths) {
                if (dp[path.start] == Long.MAX_VALUE) continue;
                if (dp[path.start] + path.dist < dp[path.end]) {
                    dp[path.end] = dp[path.start] + path.dist;
                    parent[path.end] = path.start;
                }
            }
        }

        long[] copyDp = Arrays.copyOf(dp, n);
        for(Path path : allPaths) {
            if (dp[path.start] == Long.MAX_VALUE) continue;
            if (dp[path.start] + path.dist < dp[path.end]) {
                dp[path.end] = dp[path.start] + path.dist;
                parent[path.end] = path.start;
            }
        }
        for(int i = 0; i < n; i++) {
            if (dp[i] < copyDp[i]) {
                x = i;
                break;
            }
        }


        if (x == -1) out.println("NO");
        else {
            out.println("YES");
            for(int i = 0; i < n; i++) x = parent[x];

            int a = x;
            List<Integer> lst = new ArrayList<>();
            while (true) {
                lst.add(x);
                x = parent[x];
                if (x == a) break;
            }
            lst.add(a);
            Collections.reverse(lst);

            for(int e: lst) out.print((e + 1) + " ");
        }

        out.flush();
    }

    public static class Path {
        int start;
        int end;
        long dist;
        public Path(int start, int end, long dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
        public void setDist(long dist) {
            this.dist = Math.max(this.dist, dist);
        }
    }
}