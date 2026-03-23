import java.io.*;
import java.util.*;

public class entry_15811936 {

    private static final byte[] buffer = new byte[1 << 16];
    private static int ptr = 0, len = 0;

    private static int read() throws IOException {
        if (ptr >= len) {
            len = System.in.read(buffer);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buffer[ptr++];
    }

    private static long nextLong() throws IOException {
        int c;
        while ((c = read()) <= ' ') ;
        long val = 0;
        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = read();
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        int n = (int) nextLong();
        int m = (int) nextLong();

        TreeMap<Integer, Integer> tickets = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int price = (int) nextLong();
            tickets.put(price, tickets.getOrDefault(price, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int customer = (int) nextLong();

            Integer key = tickets.floorKey(customer);

            if (key == null) {
                sb.append(-1).append('\n');
            } else {
                sb.append(key).append('\n');
                int cnt = tickets.get(key);
                if (cnt == 1) tickets.remove(key);
                else tickets.put(key, cnt - 1);
            }
        }

        System.out.print(sb.toString());
    }
}