import java.io.*;
import java.util.*;

public class entry_15825131 {

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, res = 0;
            do c = read(); while (c <= ' ');
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        int[] a = new int[n]; // applicants
        int[] b = new int[m]; // apartments

        for (int i = 0; i < n; i++) a[i] = fs.nextInt();
        for (int i = 0; i < m; i++) b[i] = fs.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0, ans = 0;

        while (i < n && j < m) {
            if (b[j] < a[i] - k) {
                // apartment too small
                j++;
            } else if (b[j] > a[i] + k) {
                // apartment too big
                i++;
            } else {
                // match found
                ans++;
                i++;
                j++;
            }
        }

        System.out.println(ans);
    }
}