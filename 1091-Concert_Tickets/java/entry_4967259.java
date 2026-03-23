/**
 * https://cses.fi/problemset/task/1091
 */
// package cp.java.cses;

import java.io.*;
import java.util.*;

class ConcertTickets {
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader(InputStream stream) {
            din = new DataInputStream(stream);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
    }

    static FastReader r = new FastReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    // Example
    public static void main(String[] args) throws IOException {
        int n = r.nextInt();
        int m = r.nextInt();
        // Get all tickets
        TreeMap<Integer, Integer> tickets = new TreeMap<>();
        int price;
        for (int i = 0; i < n; i++) {
            price = r.nextInt();
            if (tickets.containsKey(price)) {
                tickets.put(price, tickets.get(price) + 1);
            } else {
                tickets.put(price, 1);
            }
        }
        // Iterate over customers
        int maxPrice;
        Map.Entry<Integer, Integer> val;
        for (int i = 0; i < m; i++) {
            maxPrice = r.nextInt();
            val = tickets.lowerEntry(maxPrice + 1);
            if (val == null) {
                pw.println(-1);
            } else {
                pw.println(val.getKey());
                if (val.getValue() == 1) {
                    tickets.remove(val.getKey());
                } else {
                    tickets.put(val.getKey(), val.getValue() - 1);
                }
            }
        }
        r.close();
        pw.close();
    }
}