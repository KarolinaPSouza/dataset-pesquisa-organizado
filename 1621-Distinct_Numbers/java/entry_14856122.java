import java.io.*;
import java.util.*;

public class entry_14856122 {

    private static IOHandler io;

    public void solve() {
        int n = io.nextInt();
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = io.nextInt();
            s.add(x);
        }
        io.println(s.size());
    }

    public static void main(String[] args) throws IOException {
        entry_14856122.io = new IOHandler();
        int t = 1;
        // t = io.nextInt();
        for (int i = 0; i < t; i++) {
            entry_14856122 main = new entry_14856122();
            main.solve();
        }
        io.close();
    }

    static class IOHandler extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public IOHandler() {
            this(System.in, System.out);
        }

        public IOHandler(String inputFileName, String outputFileName) throws IOException {
            super(outputFileName);
            r = new BufferedReader(new FileReader(inputFileName));
        }

        public IOHandler(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public IOHandler(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String nextToken() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }

        public String nextLine() {
            try {
                return r.readLine();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() { return Integer.parseInt(nextToken()); }

        public double nextDouble() { return Double.parseDouble(nextToken()); }

        public long nextLong() { return Long.parseLong(nextToken()); }
    }
}