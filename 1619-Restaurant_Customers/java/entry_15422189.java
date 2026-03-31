import java.io.*;

public class entry_15422189 {

    // ---------- FAST SCANNER ----------
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

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ') {
                val = val * 10 + (c - '0');
            }
            return val * sign;
        }
    }

    // ---------- RADIX SORT FOR PAIRS ----------
    // Sort events by time; event = (time<<1) | type
    // type: +1 arrival -> last bit = 1
    //       -1 leaving -> last bit = 0
    // Encoding ensures arrival is processed before leaving if same time (not needed here).
    static void radixSort(int[] a) {
        int n = a.length;
        int[] tmp = new int[n];

        for (int shift = 0; shift < 32; shift += 8) {
            int[] cnt = new int[256];

            for (int x : a)
                cnt[(x >>> shift) & 255]++;

            for (int i = 1; i < 256; i++)
                cnt[i] += cnt[i - 1];

            for (int i = n - 1; i >= 0; i--) {
                int x = a[i];
                int id = (x >>> shift) & 255;
                tmp[--cnt[id]] = x;
            }

            int[] t = a;
            a = tmp;
            tmp = t;
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] events = new int[n * 2];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            // Encode:
            // arrival: (a << 1) | 1
            // leaving: (b << 1) | 0
            events[idx++] = (a << 1) | 1;
            events[idx++] = (b << 1);
        }

        radixSort(events);

        int current = 0, max = 0;
        for (int e : events) {
            if ((e & 1) == 1) current++;  // arrival
            else current--;               // leaving
            if (current > max) max = current;
        }

        System.out.println(max);
    }
}