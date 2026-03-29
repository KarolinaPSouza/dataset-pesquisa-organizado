import java.io.*;
import java.util.*;

public class entry_15467065 {

    // ---------- Fast Scanner ----------
    private static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) != -1 && c <= ' ') {
                // skip whitespace
            }
            if (c == -1) return null;
            do {
                sb.append((char) c);
            } while ((c = read()) != -1 && c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) != -1 && c <= ' ') {
                // skip
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) != -1 && c <= ' ') {
                // skip
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10L + c - '0';
                c = read();
            }
            return val * sign;
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    // ---------- entry_15467065 & solve ----------
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = 1;
        // If problem has multiple test cases, uncomment this:
        // t = fs.nextInt();

        while (t-- > 0) {
            solve(fs, out);
        }

        out.flush();
    }

    private static void solve(FastScanner fs, PrintWriter out) throws Exception {
        // TODO: write your solution logic here
        // Example:
        int n = fs.nextInt();
        int x = fs.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) price[i] = fs.nextInt();
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) pages[i] = fs.nextInt();
        int[][] dp = new int[n+1][x+1];
        for(int i = n-1; i>=0; i--){
            for(int j=1; j<=x; j++){
                int buy = 0;
                if(j-price[i]>=0) buy = pages[i]+ dp[i+1][j-price[i]];
                dp[i][j] = Math.max( buy , dp[i+1][j]);
            }
        }
        out.println(dp[0][x]);
    }

    // ---------- Some handy utilities (optional) ----------

    // Fast sort int[]
    private static void sort(int[] a) {
        Arrays.sort(a);
    }

    // Fast sort long[]
    private static void sort(long[] a) {
        Arrays.sort(a);
    }
    private static void printMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
}