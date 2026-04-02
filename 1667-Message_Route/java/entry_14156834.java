import java.io.*;
import java.util.*;
public class entry_14156834 {
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

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < m; i++) {
            int x = reader.nextInt() - 1;
            int y = reader.nextInt() - 1;

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean[] isVis = new boolean[n];
        isVis[0] = true;

        int ctr = 0;
        boolean isAnsFound = false;

        int[] parent = new int[n];

        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> children = graph.get(curr);
            for (int child : children) {
                if (child == n - 1) {
                    isAnsFound = true;
                    parent[child] = curr;
                    break;
                }
                if (isVis[child]) continue;
                parent[child] = curr;
                isVis[child] = true;
                q.add(child);
            }
            if (isAnsFound) break;
            ctr++;
        }

        if (!isAnsFound) out.println("IMPOSSIBLE");
        else {
            List<Integer> path = new ArrayList<>();
            int c = n - 1;
            while (c != 0) {
                path.add(c);
                c = parent[c];
            }
            path.add(0);

            Collections.reverse(path);

            int s = path.size();
            out.println(s);
            for(int e : path) {
                out.print((e + 1) + " ");
            }
        }

        out.flush();
    }
}