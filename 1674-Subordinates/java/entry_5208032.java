import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_5208032 {
    static int n;
    static int[] bosses;
    static int[] appearances;
    static Queue<Integer> zeroes = new LinkedList<>();
    static int[] subordinates;
    public static void main(String[] args) throws IOException {

        Kattio io = new Kattio();
        n = io.nextInt();
        bosses = new int[n - 1];
        appearances = new int[n];
        subordinates = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int k = io.nextInt();
            bosses[i] = k;
            appearances[k - 1]++;

        }

        for (int i = 0; i < n; i++) {
            if (appearances[i] == 0) {
                zeroes.add(i);
            }
        }

        while (zeroes.peek() != 0) {
            int index = zeroes.peek() + 1;
            int boss = bosses[index-2];
            appearances[boss - 1]-=1;
            subordinates[boss - 1] += subordinates[index - 1]+1;
            zeroes.remove();
            if (appearances[boss - 1] == 0) {
                zeroes.add(boss - 1);
            }


        }

        for (int i = 0; i < n; i++) {
            io.print(subordinates[i]);
            io.print(" ");
        }
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