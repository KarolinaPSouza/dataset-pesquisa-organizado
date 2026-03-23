//package uk.co.mycommunityfinance.goddex.engine;

import java.io.*;
import java.util.*;

public class entry_15183236 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int n = fs.nextInt();
        int m = fs.nextInt();

        TreeMap<Long, Integer> tickets = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long price = fs.nextLong();
            tickets.put(price, tickets.getOrDefault(price, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            long customer = fs.nextLong();
            Map.Entry<Long, Integer> entry = tickets.floorEntry(customer);
            if (entry == null) {
                sb.append("-1\n");
            } else {
                long price = entry.getKey();
                sb.append(price).append('\n');
                int count = entry.getValue();
                if (count == 1) tickets.remove(price);
                else tickets.put(price, count - 1);
            }
        }

        System.out.print(sb);
    }

    // Super-fast custom scanner
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
            do c = readByte(); while (c <= ' ');
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

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}