import java.io.*;
import java.util.*;

public class entry_12519332 {
    static class Pair {
        int next;
        long ammount;

        Pair(int next, long ammount) {
            this.next = next;
            this.ammount = ammount;
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output2.txt")));
        } catch (FileNotFoundException e) {
            System.err.println("File not found, using standard input.");
        }

        FastReader sc = new FastReader();

        int n = 0, m = 0;
        try {
            n = sc.nextInt();
            m = sc.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input format. Expected two integers.");
            return;
        }

        List<List<Pair>> sgraph = new ArrayList<>();
        List<List<Pair>> rgraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            sgraph.add(new ArrayList<>());
            rgraph.add(new ArrayList<>());
        }

        int[][] ed = new int[m][3];

        for (int i = 0; i < m; i++) {
            try {
                ed[i][0] = sc.nextInt();
                ed[i][1] = sc.nextInt();
                ed[i][2] = sc.nextInt();
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid edge input at line " + (i + 1));
                return;
            }

            sgraph.get(ed[i][0]).add(new Pair(ed[i][1], ed[i][2]));
            rgraph.get(ed[i][1]).add(new Pair(ed[i][0], ed[i][2]));
        }

        long[] sd = new long[n + 1];
        long[] rd = new long[n + 1];

        Arrays.fill(sd, Long.MAX_VALUE);
        Arrays.fill(rd, Long.MAX_VALUE);

        dijkstra(1, sd, sgraph);
        dijkstra(n, rd, rgraph);

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            ans = Math.abs(Math.min(ans, sd[ed[i][0]] + rd[ed[i][1]] + ed[i][2] / 2));
        }

        System.out.println(ans);
    }

    public static void dijkstra(int start, long[] dist, List<List<Pair>> graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.ammount));
        pq.add(new Pair(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int curr = p.next;
            long ammount = p.ammount;

            if (dist[curr] < ammount) continue;

            for (Pair nextPair : graph.get(curr)) {
                int next = nextPair.next;
                long newDist = ammount + nextPair.ammount;

                if(newDist < 0) continue;

                if (dist[next] > newDist) {
                    dist[next] = newDist;
                    pq.add(new Pair(next, newDist));
                }
            }
        }
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
                    String line = br.readLine();
                    if (line == null) throw new IOException("End of input reached.");
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            String token = st.nextToken();
            return token;
        }

        int nextInt() {
            try {
                return Integer.parseInt(next());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Expected an integer but got invalid input.");
            }
        }

        long nextLong() {
            try {
                return Long.parseLong(next());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Expected a long but got invalid input.");
            }
        }
    }
}