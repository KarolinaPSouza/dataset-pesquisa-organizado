import java.util.*;
import java.io.*;

public class entry_5958385 {

    static class timePair {
        long time;
        int val;
        public timePair(long time, int val){
            this.time = time;
            this.val = val;
        }
    }

    public static void main(String[] args){
        Kattio scan = new Kattio();

        int n = scan.nextInt();
        ArrayList<timePair> times = new ArrayList<>();
        for (int i=0; i<n; i++){
            long enterTime = scan.nextLong();
            times.add(new timePair(enterTime, 1));

            long leaveTime = scan.nextLong();
            times.add(new timePair(leaveTime, -1));
        }

        times.sort(Comparator.comparingLong(c -> c.time));

        long s = 0;
        long mx = Long.MIN_VALUE;
        for (int i=0; i<times.size(); i++){
            s += times.get(i).val;

            if (s<0){
                s=0;
            }

            mx = Long.max(s, mx);
        }
        System.out.println(mx);

        scan.close();
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
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}

