import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class entry_12115982 {

    public static void main(String[] args){

        Kattio io = new Kattio();

        int n = io.nextInt();
        long x = io.nextLong();

        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = io.nextLong();
        }

        HashMap<Long, int[]> pairs = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                long curSum = arr[i] + arr[j];
                long needed = x - curSum;

                if(pairs.containsKey(needed)){
                    int[] pair = pairs.get(needed);
                    int p = pair[0], q = pair[1];

                    if(p != i && p != j && q != i && q != j){
                        System.out.println((p + 1) + " " + (q + 1) + " " + (i + 1) + " " + (j + 1));
                        return;
                    }
                }

                if(!pairs.containsKey(curSum)){
                    pairs.put(curSum, new int[]{i, j});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
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
        public long nextLong() { return Long.parseLong(next());
        }

    }
}