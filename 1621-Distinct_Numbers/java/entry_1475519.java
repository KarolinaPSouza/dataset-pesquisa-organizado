import static java.lang.Math.*;


import java.io.*;
import java.util.*;

public class entry_1475519 {

    final static PrintWriter out = new PrintWriter(System.out);
    final static FastScanner sc = new FastScanner(System.in);

    public static void main(String[] args) throws IOException {
        entry_1475519 ob = new entry_1475519();


        ob.solve();
        out.close();
    }

    void solve() throws IOException {
        // --- code per test case starts here ---
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> h = new HashSet<>();

        for(int i=0;i<n;i++){
            h.add(in.nextInt());
        }
        System.out.println(h.size());

    }

    public static class Utility {
        static final double EPS = 10e-6;

        public static int lower_bound(int[] a, int x) {
            int left = 0, right = a.length, mid = -1;

            while (left < right) {
                mid = (left + right) / 2;
                if (a[mid] >= x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }
            return left;
        }

        public static int upper_bound(int[] arr, int x) {
            int left = 0, right = arr.length, mid = -1;
            while (left < right) {
                mid = (left + right) / 2;
                if (arr[mid] > x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public static int lcm(int a, int b) {
            return a * b / gcd(a, b);
        }

        public static long fast_pow_mod(long b, long x, int mod) {
            if (x == 0)
                return 1;
            if (x == 1)
                return b;
            if (x % 2 == 0)
                return fast_pow_mod(b * b % mod, x / 2, mod) % mod;

            return b * fast_pow_mod(b * b % mod, x / 2, mod) % mod;
        }

        public static int fast_pow(int b, int x) {
            if (x == 0)
                return 1;
            if (x == 1)
                return b;
            if (x % 2 == 0)
                return fast_pow(b * b, x / 2);

            return b * fast_pow(b * b, x / 2);
        }

        public static long choose(long n, long k) {
            k = min(k, n - k);
            long val = 1;

            for (int i = 0; i < k; ++i)
                val = val * (n - i) / (i + 1);

            return val;
        }

        public static long permute(int n, int k) {
            if (n < k)
                return 0;
            long val = 1;

            for (int i = 0; i < k; ++i)
                val = (val * (n - i));

            return val;
        }
    }

    public static class FastScanner {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar, numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        public FastScanner(String file) throws IOException {
            this.stream = new FileInputStream(file);
        }

        public int readChar() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
            }

            if (numChars == -1)
                return numChars;

            return buf[curChar++];
        }

        public int readInt() throws IOException {
            int c = readChar(), sgn = 1;

            while (isSpace(c))
                c = readChar();

            if (c == '-') {
                sgn = -1;
                c = readChar();
            }

            int res = 0;

            do {
                res = (res << 1) + (res << 3);
                res += c - '0';
                c = readChar();
            } while (!isSpace(c));

            return res * sgn;
        }

        public String readString() throws IOException {
            int c = readChar();

            while (isSpace(c))
                c = readChar();

            StringBuilder res = new StringBuilder();

            do {
                res.appendCodePoint(c);
                c = readChar();
            } while (!isSpace(c));

            return res.toString();
        }

        public double readDouble() throws IOException {
            int c = readChar(), sgn = 1;

            while (isSpace(c))
                c = readChar();

            if (c == '-') {
                sgn = -1;
                c = readChar();
            }

            double res = 0;

            while (!isSpace(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Utility.fast_pow(10, readInt());

                res *= 10;
                res += c - '0';
                c = readChar();
            }

            if (c == '.') {
                c = readChar();
                double m = 1;

                while (!isSpace(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Utility.fast_pow(10, readInt());

                    m /= 10;
                    res += (c - '0') * m;
                    c = readChar();
                }
            }

            return res * sgn;
        }

        public long readLong() throws IOException {
            int c = readChar(), sgn = 1;

            while (isSpace(c))
                c = readChar();

            if (c == '-') {
                sgn = -1;
                c = readChar();
            }

            long res = 0;

            do {
                res = (res << 1) + (res << 3);
                res += c - '0';
                c = readChar();
            } while (!isSpace(c));

            return res * sgn;
        }
        public int[] readIntArray(int n) throws IOException {
            int a[] = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = readInt();
            }
            return a;
        }

        public long[] readLongArray(int n) throws IOException {
            long a[] = new long[n];
            for (int i = 0; i < n; ++i) {
                a[i] = readLong();
            }
            return a;
        }

        public String[] readStringArray(int n) throws IOException {
            String a[] = new String[n];
            for (int i = 0; i < n; ++i) {
                a[i] = readString();
            }
            return a;
        }
        public boolean isSpace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}