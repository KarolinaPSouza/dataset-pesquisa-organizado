import java.io.*;
import java.util.*;
public class entry_14501217 {
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
    static List<List<Integer>> tree;
    static int n;
    static boolean[] isDone1;
    static boolean[] isDone2;
    static int maxDistFrom0;
    static int farthertFrom0;
    static int maxDistFromA;
    static int farthertFromA;
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        FastWriter out = new FastWriter();

        n = reader.nextInt();
        tree = new ArrayList<>();
        for(int i = 0; i < n; i++) tree.add(new ArrayList<>());

        for(int i = 0; i < n - 1; i++) {
            int u = reader.nextInt() - 1;
            int v = reader.nextInt() - 1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] dfs1 = iterativeDfs(0);
        int[] dfs2 = iterativeDfs(dfs1[1]);

        // out.println(Arrays.toString(dfs1));
        // out.println(Arrays.toString(dfs2));
        out.println(dfs2[0]);

        out.flush();
    }

    public static int[] iterativeDfs(int root) {
        int[] st = new int[n];
        int top = 0;
        st[top] = root;

        int[] dist = new int[n];
        boolean[] isVis = new boolean[n];

        while (top >= 0) {
            int c = st[top--];
            isVis[c] = true;
            // System.out.println((root + 1) + " " + (c + 1) + " " + top);
            for (int child : tree.get(c)) {
                if (isVis[child]) continue;
                st[++top] = child;
                dist[child] = dist[c] + 1;
            }
        }

        int[] maxDist = new int[2];
        for(int i = 0; i < n; i++) {
            if (dist[i] > maxDist[0]) {
                maxDist[0] = dist[i];
                maxDist[1] = i;
            }
        }

        return maxDist;
    }
}