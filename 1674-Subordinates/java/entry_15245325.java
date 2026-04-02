import java.io.*;
import java.util.*;

public class entry_15245325 {

    static ArrayList<Integer>[] tree;
    static int[] subCount;

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            int boss = fs.nextInt();
            tree[boss].add(i);
        }

        subCount = new int[n + 1];
        dfsIterative(1); //  iterative DFS avoids recursion overhead

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(subCount[i]).append(' ');
        System.out.println(sb);
    }

    //  Iterative DFS (to avoid recursion overhead)
    static void dfsIterative(int root) {
        int n = tree.length - 1;
        int[] stack = new int[n];
        int[] state = new int[n + 1];
        int top = 0;
        stack[top] = root;

        while (top >= 0) {
            int node = stack[top];
            if (state[node] == 0) {
                state[node] = 1;
                for (int child : tree[node]) {
                    stack[++top] = child;
                }
            } else {
                // All children processed, calculate subordinates
                int total = 0;
                for (int child : tree[node]) total += 1 + subCount[child];
                subCount[node] = total;
                top--;
            }
        }
    }

    // Super-fast input reader (about 3x faster than BufferedReader)
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = System.in.read(buffer);
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