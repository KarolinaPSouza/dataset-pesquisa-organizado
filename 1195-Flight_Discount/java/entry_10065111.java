import java.io.*;
import java.util.*;

public class entry_10065111 {
// State djikstra
    static class Pair {
        long first, second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        long n = fr.nextLong();
        long m = fr.nextLong();
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            long u = fr.nextLong();
            long v = fr.nextLong();
            long w = fr.nextLong();
            adj.get((int)u).add(new Pair(v, w));
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[][] dis = new long[(int)n + 1][2];
        for (long[] row : dis) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        dis[1][0] = 0;
        dis[1][1] = 0;
        pq.add(new long[]{0, 1, 1});
        while (!pq.isEmpty()) {
            long[] z = pq.poll();
            long dist = z[0];
            long node = z[1];
            long available = z[2];
            if (dis[(int)node][(int)available] < dist)
                continue;
            for (Pair ch : adj.get((int)node)) {
                if (available == 1) {
                    if (dis[(int)ch.first][1] > (dist + ch.second)) {
                        dis[(int)ch.first][1] = dist + ch.second;
                        pq.add(new long[]{dis[(int)ch.first][1], ch.first, 1});
                    }
                    if (dis[(int)ch.first][0] > (dist + (ch.second) / 2)) {
                        dis[(int)ch.first][0] = (dist + (ch.second) / 2);
                        pq.add(new long[]{dis[(int)ch.first][0], ch.first, 0});
                    }
                } else {
                    if (dis[(int)ch.first][0] > (dist + (ch.second))) {
                        dis[(int)ch.first][0] = (dist + (ch.second));
                        pq.add(new long[]{dis[(int)ch.first][0], ch.first, 0});
                    }
                }
            }
        }
        System.out.println(Math.min(dis[(int)n][0], dis[(int)n][1]));
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}