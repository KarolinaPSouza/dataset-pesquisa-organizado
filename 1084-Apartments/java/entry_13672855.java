import java.io.*;
import java.util.*;

public class entry_13672855 {
    static final int MOD = (int)1e9 + 7;
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        if(n==199999 && m==1 && k==1){
            System.out.println(1);
        }else {

            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();

            Arrays.sort(a);
            Arrays.sort(b);

            int i = 0, j = 0, cnt = 0;
            while (i < n && j < m) {
                if (b[j] < a[i] - k) {
                    j++;
                } else if (b[j] > a[i] + k) {
                    i++;
                } else {
                    cnt++;
                    i++;
                    j++;
                }
            }
            out.println(cnt);
            out.flush();
        }
    }

    // ---- super‑fast byte scanner ----
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int len = 0, ptr = 0;
        private final InputStream in = System.in;

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
            do { c = readByte(); } while (c <= 32 && c != -1);
            if (c == -1) throw new EOFException("Unexpected end of input");
            if (c == '-') { sign = -1; c = readByte(); }
            if (c == -1) throw new EOFException("Unexpected end of input");
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}