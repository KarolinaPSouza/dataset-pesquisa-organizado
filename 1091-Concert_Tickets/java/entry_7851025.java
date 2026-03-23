//package SortedSets.cses;

import java.io.*;
import java.util.*;

public class entry_7851025 {

    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
//        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = input.nextInt();
        int m = input.nextInt();

        TreeMap<Integer, Integer> tickets = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int h = input.nextInt();
            tickets.put(h, tickets.getOrDefault(h, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            int t = input.nextInt();
            Map.Entry<Integer, Integer> entry = tickets.floorEntry(t);
            if (entry == null) {
                pw.println(-1);
            } else {
                int key = entry.getKey();
                int value = entry.getValue();
                pw.println(key);
                if (value == 1) {
                    tickets.remove(key);
                } else {
                    tickets.put(key, value - 1);
                }
            }
        }

        input.close();
        pw.close();
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }
    }
}