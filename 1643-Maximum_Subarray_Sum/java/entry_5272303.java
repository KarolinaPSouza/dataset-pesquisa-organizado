import java.io.*;
import java.util.*;

public class entry_5272303 {
   public static void maximum_subarray_sum(int[] a, PrintWriter out) {
        long sum = Long.MIN_VALUE;
        long cur = 0;
        for (int i = 0; i < a.length; ++i) {
            cur += a[i];
            sum = Math.max(cur, sum);
            cur = Math.max(cur, 0);
        }
        out.println(sum);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = sc.nextInt();
        maximum_subarray_sum(a, out);
        out.flush();
        out.close();
    }

    static class Scanner
    {
        BufferedReader in;
        StringTokenizer st;

        public Scanner() { this.in = new BufferedReader(new InputStreamReader(System.in)); }

        public Scanner(FileReader f) { this.in = new BufferedReader(f); }

        public String nextToken()
        {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        public int nextInt() { return Integer.parseInt(nextToken()); }

        public long nextLong() { return Long.parseLong(nextToken()); }

        public double nextDouble() { return Double.parseDouble(nextToken()); }

        public void close() throws IOException { in.close(); }
    }
}