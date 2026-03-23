import java.util.*;
import java.io.*;

public class entry_15632320 {

    static class FastScanner {
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;
    private final InputStream in = System.in;

    int read() throws IOException {
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
            c = read();
            if (c == -1) return Integer.MIN_VALUE;
        } while (c <= ' ');

        if (c == '-') {
            sign = -1;
            c = read();
        }

        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = read();
        }
        return val * sign;
    }
}



    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        TreeMap<Integer, Integer> tickets = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int price = fs.nextInt();
            tickets.put(price, tickets.getOrDefault(price, 0) + 1);
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int budget = fs.nextInt();

            Integer key = tickets.floorKey(budget);
            if (key == null) {
                out.append("-1\n");
            } else {
                out.append(key).append('\n');
                int cnt = tickets.get(key);
                if (cnt == 1) tickets.remove(key);
                else tickets.put(key, cnt - 1);
            }
        }

        System.out.print(out.toString());
    }
}