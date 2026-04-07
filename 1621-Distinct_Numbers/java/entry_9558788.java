import java.io.*;
import java.util.*;

public class entry_9558788 {
    public static void main(String[] args)
    {
        Kattio io = new Kattio();
        int N = io.nextInt();
        HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < N; i++)
        {
            result.add(io.nextInt());
        }    
        io.print(result.size());
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
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
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        // Method to read an entire line
        public String nextLine() {
            try {
                return r.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }
}