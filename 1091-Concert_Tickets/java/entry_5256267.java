//package com.denisbogdanov.cses.problemset_2.searching;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.TreeMap;

/**
 * https://cses.fi/problemset/task/1091
 */
public class entry_5256267 {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();

        int ticketsCount = in.nextInt();
        int customersCount = in.nextInt();

        TreeMap<Integer, Integer> ticketToCountMap = new TreeMap<>();
        for (int i = 0; i < ticketsCount; i++) {
            ticketToCountMap.merge(in.nextInt(), 1, Integer::sum);
        }

        int[] customers = new int[customersCount];
        for (int i = 0; i < customersCount; i++) {
            customers[i] = in.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int customer : customers) {
            var floorEntry = ticketToCountMap.floorEntry(customer);
            if (floorEntry == null) {
                sb.append(-1);
            } else {
                sb.append(floorEntry.getKey());
                if (floorEntry.getValue() == 1) {
                    ticketToCountMap.remove(floorEntry.getKey());
                } else {
                    ticketToCountMap.put(floorEntry.getKey(), floorEntry.getValue() - 1);
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static class Reader {
        final DataInputStream din;
        final byte[] buffer;
        final private int BUFFER_SIZE = 1 << 16;
        int bufferPointer, bytesRead;

        Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        void close() throws IOException {
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
}