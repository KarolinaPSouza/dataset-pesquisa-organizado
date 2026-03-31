//package com.denisbogdanov.cses.problemset_4.searching;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class entry_9565520 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\bogda\\Desktop\\input.txt");
        Reader in = new Reader();


        int n = in.nextInt();
        List<Event> events = new ArrayList<>(2 * n);
        for (int i = 0; i < n; i++) {
            events.add(new Event(in.nextInt(), EventType.ENTER));
            events.add(new Event(in.nextInt(), EventType.EXIT));
        }

        events.sort(Comparator.comparingInt(e -> e.time));

        int currCount = 0;
        int result = 0;

        for (Event event : events) {
            if (event.eventType == EventType.ENTER) {
                currCount++;
                result = Math.max(result, currCount);
            } else {
                currCount--;
            }
        }

        System.out.println(result);
    }

    private static class Event {
        final int time;
        final EventType eventType;

        public Event(int time, EventType eventType) {
            this.time = time;
            this.eventType = eventType;
        }
    }

    private enum EventType {
        ENTER,
        EXIT;
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