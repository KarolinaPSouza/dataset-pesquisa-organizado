import java.io.*;
import java.util.*;

public class entry_14524657 {
    static final int MAX_BUF = 1 << 16;
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[MAX_BUF];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c; while ((c = read()) <= ' ') { if (c == -1) return Integer.MIN_VALUE; }
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        // adjacency using edge arrays
        int[] head = new int[n + 1];
        Arrays.fill(head, -1);
        int[] to = new int[n];       // n-1 edges, allocate n for safety
        int[] next = new int[n];
        int ec = 0;
        for (int i = 2; i <= n; i++) {
            int parent = fs.nextInt();
            to[ec] = i;
            next[ec] = head[parent];
            head[parent] = ec++;
        }

        // build preorder then process in reverse = postorder
        int[] stack = new int[n];
        int top = 0;
        int[] order = new int[n];
        int ord = 0;

        stack[top++] = 1;
        while (top > 0) {
            int node = stack[--top];
            order[ord++] = node;
            // push children to stack
            for (int e = head[node]; e != -1; e = next[e]) {
                stack[top++] = to[e];
            }
        }

        int[] res = new int[n + 1];
        // process in reverse order so children are already computed
        for (int i = ord - 1; i >= 0; i--) {
            int node = order[i];
            int sum = 0;
            for (int e = head[node]; e != -1; e = next[e]) {
                int c = to[e];
                sum += res[c] + 1;
            }
            res[node] = sum;
        }

        StringBuilder sb = new StringBuilder(n * 3);
        for (int i = 1; i <= n; i++) {
            sb.append(res[i]);
            if (i < n) sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}