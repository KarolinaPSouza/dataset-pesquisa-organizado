import java.io.*;
import java.util.*;

public class entry_15712259 {

    // -------- FAST IO --------
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

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
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
    // --------------------------

    public static void main(String args[]) throws Exception {
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<HashMap<Integer, Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashMap<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int dist = sc.nextInt();

            adj.get(u).put(v, Math.min(
                    adj.get(u).getOrDefault(v, Integer.MAX_VALUE),
                    dist
            ));
        }

        long[] ans = new long[n];
        Arrays.fill(ans, Long.MAX_VALUE);
        ans[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[1], b[1])
        );

        pq.add(new long[]{0, 0}); // {city, distance}

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int city = (int) cur[0];
            long distSoFar = cur[1];

            // 🔥 IMPORTANT: skip outdated state
            if (distSoFar > ans[city]) continue;

            for (Map.Entry<Integer, Integer> e : adj.get(city).entrySet()) {
                int next = e.getKey();
                long edgeDist = e.getValue();

                if (ans[next] > distSoFar + edgeDist) {
                    ans[next] = distSoFar + edgeDist;
                    pq.add(new long[]{next, ans[next]});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == Long.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (long d : ans) sb.append(d).append(" ");
        System.out.println(sb);
    }
}