import java.io.*;
import java.util.*;

public class entry_14509273 {

    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastReader() {
            in = System.in;
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
            } while (c <= ' ' && c != -1);
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
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int m = fr.nextInt();

        TreeMap<Integer, Integer> tickets = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int price = fr.nextInt();
            tickets.put(price, tickets.getOrDefault(price, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int offer = fr.nextInt();
            Integer floor = tickets.floorKey(offer);
            if (floor == null) {
                sb.append("-1\n");
            } else {
                sb.append(floor).append("\n");
                int count = tickets.get(floor) - 1;
                if (count == 0) tickets.remove(floor);
                else tickets.put(floor, count);
            }
        }
        System.out.print(sb);
    }
}