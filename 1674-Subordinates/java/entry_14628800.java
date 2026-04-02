import java.io.*;
import java.util.*;

public class entry_14628800 {
    static List<Integer>[] tree;
    static int[] subtree;

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            int boss = fs.nextInt();
            tree[boss].add(i);
        }

        subtree = new int[n + 1];
        iterativeDFS(1);

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            out.write((subtree[i] - 1) + " ");
        }
        out.newLine();
        out.flush();
    }

    static void iterativeDFS(int root) {
        // stack for (node, state)
        // state = 0 -> first visit, state = 1 -> after processing children
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{root, 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int u = cur[0], state = cur[1];

            if (state == 0) {
                // First time visiting
                stack.push(new int[]{u, 1}); // push back for post-processing
                for (int v : tree[u]) {
                    stack.push(new int[]{v, 0});
                }
            } else {
                // After children processed
                int size = 1;
                for (int v : tree[u]) {
                    size += subtree[v];
                }
                subtree[u] = size;
            }
        }
    }

    // Fast scanner (buffered input)
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}