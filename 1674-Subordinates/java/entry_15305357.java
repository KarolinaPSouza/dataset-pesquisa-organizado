import java.io.*;
import java.util.*;

public class entry_15305357 {
    static ArrayList<Integer>[] adj;
    static int[] sub;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        adj = new ArrayList[n + 1];
        sub = new int[n + 1];

        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            int boss = fs.nextInt();
            adj[boss].add(i);
        }

        Stack<int[]> st = new Stack<>();
        st.push(new int[]{1, 0});

        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int node = cur[0], state = cur[1];

            if (state == 0) {
                st.push(new int[]{node, 1});
                for (int child : adj[node]) st.push(new int[]{child, 0});
            } else {
                int cnt = 0;
                for (int child : adj[node]) cnt += 1 + sub[child];
                sub[node] = cnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(sub[i]).append(" ");
        System.out.print(sb);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
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
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}