import java.io.*;
import java.util.*;

public class entry_15739911 {
    private static final FastScanner fs = new FastScanner(System.in);

    public static void main(String[] args) {
        int n = fs.nextInt();
        int m = fs.nextInt();

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = fs.nextInt();
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int t = fs.nextInt();
            Map.Entry<Integer, Integer> e = mp.floorEntry(t);
            if (e == null) {
                sb.append("-1\n");
            } else {
                sb.append(e.getKey()).append('\n');
                if (e.getValue() == 1) mp.remove(e.getKey());
                else mp.put(e.getKey(), e.getValue() - 1);
            }
        }
        System.out.print(sb);
    }

    // 🔥最快输入工具
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() {
            if (ptr >= len) {
                ptr = 0;
                try {
                    len = in.read(buffer);
                } catch (IOException ignored) {}
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() {
            int c, sign = 1, val = 0;
            do c = read(); while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}