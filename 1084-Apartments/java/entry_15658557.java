import java.io.*;
import java.util.*;

public class entry_15658557 {
    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int T = 1;
        // Uncomment if multiple test cases:
        // T = fs.nextInt();
        while (T-- > 0) {
            solve();
        }
        out.flush();
    }
    static void solve() {
        int n = fs.nextInt();
        int m = fs.nextInt();
        long k = fs.nextLong();
        long[] ar = new long[n];
        long[] br = new long[m];
        for(int i = 0; i < n; i++) ar[i] = fs.nextLong();
        for(int i = 0; i < m; i++) br[i] = fs.nextLong();
        Arrays.sort(ar);
        Arrays.sort(br);
        int p1 = 0, p2 = 0;
        long ct = 0;
        while(p1 < n && p2 < m){
            long lb = br[p2] - k;
            long ub = br[p2] + k;
            if(ar[p1] >= lb && ar[p1] <= ub){
                // its in range and that room can be allocated to the applicant
                ct++;
                p2++;
                p1++;
            }
            else if(ar[p1] < lb){
                // its lower than lb so theres a chance that we can give future chance for the applicant
                p1++;
            }
            else{
                p2++;
            }
        }
        out.println(ct);
    }
    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return a * b / gcd(a, b); }

    static long modPow(long a, long b, long m) {
        long res = 1;
        a %= m;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }
        return res;
    }

    static long modInverse(long a, long m) {
        return modPow(a, m - 2, m);
    }

    // Fast input
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                } catch (IOException e) {
                    return -1;
                }
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return null;
            }
            do {
                sb.append((char) c);
                c = read();
            } while (c > ' ');
            return sb.toString();
        }

        int nextInt() {
            int c = read();
            while (c <= ' ') c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() {
            int c = read();
            while (c <= ' ') c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        String nextLine() {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) != -1) {
                if (c == '\n') break; // stop at newline
                if (c == '\r') continue; // ignore carriage return (Windows style)
                sb.append((char) c);
            }
            return sb.toString();
        }
    }
}