import java.io.*;
import java.util.StringTokenizer;

public class entry_7867857 {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        long n = io.nextLong();
        int k = io.nextInt();
        long[] ks = new long[k];
        for (int i = 0; i < k; i++) {
            ks[i] = io.nextLong();
        }
        long answer = 0;
        for (int i = 1; i < (1 << k); i++) {
            long number = i;
            long addition = n;
            int count = 0;
            for (int j = 0; j < k; j++) {
                if (number % 2 == 1) {
                    addition /= ks[j];
                    count++;
                }
                number /= 2;
            }
            if (count % 2 == 1) {
                answer += addition;
            }
            else {
                answer -= addition;
            }
        }
        io.println(answer);
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