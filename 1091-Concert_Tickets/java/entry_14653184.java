//package org.example;
import java.io.*;
import java.util.*;

public class entry_14653184 {

    // Ultra-fast byte reader
    static final class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sgn = 1, x = 0;
            do { c = read(); if (c == -1) return Integer.MIN_VALUE; } while (c <= 32);
            if (c == '-') { sgn = -1; c = read(); }
            while (c > 32) {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * sgn;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        // multiset using counts
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int p = fs.nextInt();
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        StringBuilder out = new StringBuilder(m * 12); // pre-size to reduce resizes

        for (int i = 0; i < m; i++) {
            int target = fs.nextInt();
            Map.Entry<Integer, Integer> e = map.floorEntry(target);
            if (e == null) {
                out.append("-1\n");
            } else {
                int price = e.getKey();
                int cnt = e.getValue();
                out.append(price).append('\n');
                if (cnt == 1) map.remove(price);
                else map.put(price, cnt - 1);
            }
        }

        System.out.print(out);
    }
}