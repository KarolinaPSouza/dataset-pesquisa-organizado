import java.io.*;
import java.util.*;

public class entry_5272232 {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        TreeMap<Integer, Integer> times = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            times.put(io.nextInt(), 1);
            times.put(io.nextInt(), -1);
        }
        int mostPpl = 0;
        int currPpl = 0;
        for (int t : times.values()) {
            currPpl += t;
            mostPpl = Math.max(mostPpl, currPpl);
        }
        io.println(mostPpl);
        io.close();


    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}