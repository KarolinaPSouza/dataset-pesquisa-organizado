import java.io.*;
import java.util.*;

public class entry_15546772 {

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
            while ((c = read()) <= ' ') if (c == -1) return -1;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + c - '0';
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();

        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] to = new int[2 * m];
        int[] next = new int[2 * m];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;

            to[idx] = b;
            next[idx] = head[a];
            head[a] = idx++;

            to[idx] = a;
            next[idx] = head[b];
            head[b] = idx++;
        }

        int[] vis = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        //ArrayList<Integer> reps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                //reps.add(i);
                vis[i] = 1;
                q.add(i);

                while (!q.isEmpty()) {
                    int v = q.poll();

                    for (int e = head[v]; e != -1; e = next[e]) {
                        int u = to[e];
                        if (vis[u] == 0) {
                            if(vis[v] == 1) vis[u] = 2;
                            else vis[u] = 1;
                            q.add(u);
                        }
                        else if (vis[u] == vis[v]){
                            System.out.println("IMPOSSIBLE");
                            return;
                        }

                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(vis[i]).append(" ");
        }

        System.out.println(sb);
    }
}