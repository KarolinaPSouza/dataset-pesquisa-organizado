import java.io.*;
import java.util.*;

public class entry_15884156 {

    static ArrayList<Integer>[] tree;
    static int[] sub;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        tree = new ArrayList[n + 1];
        sub = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            int boss = fs.nextInt();
            tree[boss].add(i);
        }

        // Iterative DFS (Post-order)
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> order = new Stack<>();

        stack.push(1);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            order.push(node);
            for (int child : tree[node]) {
                stack.push(child);
            }
        }

        // Process in reverse order (children first)
        while (!order.isEmpty()) {
            int node = order.pop();
            for (int child : tree[node]) {
                sub[node] += 1 + sub[child];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sub[i]).append(" ");
        }
        System.out.print(sb.toString());
    }

    // Fast Input
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
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
                c = read();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}