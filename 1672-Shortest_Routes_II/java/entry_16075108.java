//package com.paypal.cloud.event.graph;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class entry_16075108 {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int cities = in.nextInt(), roads = in.nextInt(), queries = in.nextInt();
        long[][] graph = new long[cities + 1][cities + 1];
        for (int i = 1; i <= cities; i++) {
            Arrays.fill(graph[i], -1);
        }

        for (int i = 0; i < roads; i++) {
            int ii = in.nextInt(), jj = in.nextInt();
            long value = in.nextLong();
            if (graph[ii][jj] == -1) {
                graph[ii][jj] = value;
                graph[jj][ii] = value;
            } else if (value < graph[ii][jj]) {
                graph[ii][jj] = value;
                graph[jj][ii] = value;
            }
        }

        // diagonal
        for (int i = 0; i <= cities; i++) {
            graph[i][i] = 0;
        }

        for (int k = 1; k <= cities; k++) { // for every intermediate node

            for  (int i = 1; i <= cities; i++) {
                for (int j = 1; j <= cities; j++) {
                    // check if k is really an intermediate for i and j
                    /*
                             i
                          j     k
                          if k is intermediate to i and j then for [i][k] [k][j]
                          should not be -1
                    * */
                    if (graph[i][k] == -1 || graph[k][j] == -1) {
                        continue;
                    }
                    // k has intermediate but no direct edge
                    if (graph[i][j] == -1) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    } else {
                        graph[i][j] = Math.min (graph[i][j],//direct or via intermediate
                                graph[i][k] + graph[k][j]);
                    }
                }
            }

        }
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < queries; i++) {
            int ii = in.nextInt(), jj = in.nextInt();
            output.append(graph[ii][jj])
                    .append("\n");
        }
        System.out.println(output);
    }

    static class FastScanner {
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
            int c;
            do c = read(); while (c <= ' '); // skip spaces
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            do c = read(); while (c <= ' '); // skip spaces
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return sign == 1 ? val : -val;
        }
    }
}