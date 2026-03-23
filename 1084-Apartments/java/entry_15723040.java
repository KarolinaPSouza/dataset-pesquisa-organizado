import java.io.*;
import java.util.*;

public class entry_15723040 {

    // Fast Input Reader
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') ;
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = (int) fs.nextLong();
        int m = (int) fs.nextLong();
        long k = fs.nextLong();

        long[] need = new long[n];
        for (int i = 0; i < n; i++) need[i] = fs.nextLong();

        long[] available = new long[m];
        for (int i = 0; i < m; i++) available[i] = fs.nextLong();

        Arrays.sort(need);
        Arrays.sort(available);

        int i = 0, j = 0;
        long count = 0;

        while (i < n && j < m) {
            if (available[j] >= need[i] - k && available[j] <= need[i] + k) {
                count++;
                i++;
                j++;
            } else if (available[j] < need[i] - k) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}