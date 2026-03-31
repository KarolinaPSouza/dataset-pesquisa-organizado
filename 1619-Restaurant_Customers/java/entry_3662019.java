//package cses;

import java.io.*;
import java.util.*;

public class entry_3662019 {
    static final Kattio io = new Kattio(System.in, System.out);
    static final StringBuilder sb = new StringBuilder();
    static final String NEW_LINE = System.lineSeparator();
    static final int MODULUS = 1000000007;

    public static void main(String[] args) {
        SortedSet<int[]> events = new TreeSet<>(Comparator.comparingInt(i -> i[0]));
        int n = io.getInt() * 2;
        for (int i = 0; i < n; i += 2) {
            events.add(new int[]{io.getInt(), 0});
            events.add(new int[]{io.getInt(), 1});
        }

        int count = 0;
        int current = 0;
        for (var event: events) {
            if (event[1] == 0) current++;
            else {
                count = Math.max(count, current);
                current--;
            }
        }

        io.println(count);

        io.close();
    }

    static class Kattio extends PrintWriter {
        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }


        private final BufferedReader r;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        String line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException ignored) { /* ignored */ }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
}