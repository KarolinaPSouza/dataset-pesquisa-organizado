import java.io.*;
import java.util.*;
public class entry_14156973 {
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

        int[] party = new int[n];
        int[] parent = new int[n];

        boolean isAns = true;

        for(int i = 0; i < n; i++) {
            if (party[i] != 0) continue;
            party[i] = 1;
            q.add(i);
            while (!q.isEmpty()) {
                int curr = q.poll();
                List<Integer> children = graph.get(curr);
                int partNow = -1 * party[curr];
                for (int child : children) {
                    if (child == parent[curr]) continue;
                    if (party[child] != 0) {
                        if (party[child] != partNow) {
                            isAns = false;
                            break;
                        }
                        else continue;
                    }
                    parent[child] = curr;
                    party[child] = partNow;
                    q.add(child);
                }
                if (!isAns) break;
            }
            if (!isAns) break;
        }

        if (!isAns) out.println("IMPOSSIBLE");
        else {
            for(int i = 0; i < n; i++) {
                if (party[i] == -1) out.print(2 + " ");
                else out.print(1 + " ");
            }
        }

        out.flush();
    }
}