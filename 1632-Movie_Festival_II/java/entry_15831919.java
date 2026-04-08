import java.io.*;
import java.util.*;

public class entry_15831919 {

    /* ================= FAST INPUT ================= */
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder();
            do {
                c = readByte();
            } while (c <= ' ');
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }

    /* ================= CONSTANTS ================= */
    static final int MOD = 1_000_000_007;
    static final long INF = (long) 1e18;

    /* ================= SOLUTION ================= */
    static void solve(FastScanner fs, PrintWriter out) throws Exception {
        // Example: read input
        int n = fs.nextInt();
        int k = fs.nextInt();

        int[][] movies = new int[n][2];

        for(int i = 0; i < n; i++) {
            movies[i][0] = fs.nextInt();
            movies[i][1] = fs.nextInt();
        }

        Arrays.sort(movies, (a, b) -> {
            return a[1] - b[1];
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        int used = 0;

        for (int[] m : movies) {
            Integer key = map.floorKey(m[0]);

            if (key != null) {
                map.put(key, map.getOrDefault(key, 0) - 1);

                if(map.get(key) == 0) {
                    map.remove(key);
                }
                map.put(m[1], map.getOrDefault(m[1], 0) + 1);
                ans++;
            } else if (used < k) {
                map.put(m[1], map.getOrDefault(m[1], 0) + 1);
                ans++;
                used++;
            }
        }
        out.println(ans);
    }

    /* ================= MAIN ================= */
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        solve(fs, out);

        out.flush();
    }

    /* ================= UTILS ================= */

    static class FenwickTree {
        int n;
        int[] bit;

        FenwickTree(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int i, int num) {
            while (i <= n) {
                bit[i] += num;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }

        int findKth(int k) {
            int idx = 0;
            int mask = Integer.highestOneBit(n);

            while(mask > 0) {
                int next = idx + mask;

                if(next <= n && bit[next] < k) {
                    k -= bit[next];
                    idx = next;
                }

                mask = (mask >> 1);
            }

            return idx + 1;
        }
    }

    static long modAdd(long a, long b) {
        return (a + b) % MOD;
    }

    static long modMul(long a, long b) {
        return (a * b) % MOD;
    }

    static long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = modMul(res, a);
            a = modMul(a, a);
            b >>= 1;
        }
        return res;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}