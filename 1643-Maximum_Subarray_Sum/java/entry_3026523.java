import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_3026523 {
 public static void main(String[]args) throws Exception {
  Kattio in = new Kattio();
  PrintWriter out = new PrintWriter(System.out);
  int N = in.nextInt();
  int[]a = in.readArray(N);
  //out.println(Arrays.toString(prefixSums));

  long currentSum = a[0];
  long maxSum = a[0];

  for (int i = 1; i < N; i ++) {
   currentSum = Math.max(currentSum + a[i], a[i]);
   maxSum = Math.max(currentSum, maxSum);
  }

  out.println(maxSum);
  out.close();
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
            super(new FileWriter(problemName + ".out"));
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

        public String readLine() throws Exception {
            return r.readLine();
        }

        public long[] readArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }

        public int[] readArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        public long[]prefixSum(int N, int[]a){
            long[]nw = new long[N];
            //a variation of this with N+1 is possible
            nw[0] = a[0];
            for (int i = 1; i < N; i ++) nw[i] = nw[i-1] + a[i];
            return nw;
        }
    }
}