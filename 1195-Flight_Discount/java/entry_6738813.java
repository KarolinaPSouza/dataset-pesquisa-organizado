import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class entry_6738813 {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int m = io.nextInt();

        long[][] cost = new long[n+1][2];

        int[] inDeg = new int[n+1];

        for (int i = 2; i < n+1; i++) {
            cost[i][0] = (long) 1e18;
            cost[i][1] = (long) 1e18;
        }

        ArrayList<ArrayList<flight>> flights = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            flights.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            flights.get(a).add(new flight(b, io.nextInt()));
            inDeg[b]++;
        }
        PriorityQueue<flight> queue = new PriorityQueue<>(Comparator.comparingLong(i -> i.c));
        queue.add(new flight(1, 0L, 0));
        while (!queue.isEmpty()) {
            int node = queue.peek().b;
            long distance = queue.peek().c;
            int type = queue.poll().type;
            if (distance != cost[node][type]) continue;
            if (type == 0) {
                for (flight next: flights.get(node)) {
                    if (cost[next.b][1] > distance + (next.c)/2) {
                        cost[next.b][1] = distance + (next.c)/2;
                        queue.add(new flight(next.b, distance + (next.c)/2, 1));
                    }
                    if (cost[next.b][0] > distance + next.c) {
                        cost[next.b][0] = distance + next.c;
                        queue.add(new flight(next.b, distance + next.c, 0));
                    }
                }
            }
            else {
                for (flight next: flights.get(node)) {
                    if (cost[next.b][1] > distance + next.c) {
                        cost[next.b][1] = distance + next.c;
                        queue.add(new flight(next.b, distance + next.c, 1));
                    }
                }
            }
        }

        io.println(cost[n][1]);
        io.close();
    }
    static class flight {
        int b;
        long c;
        int type;
        flight(int b, long c) {
            this.b = b;
            this.c = c;
        }
        flight(int b, long c, int type) {
            this.b = b;
            this.c = c;
            this.type = type;
        }
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}