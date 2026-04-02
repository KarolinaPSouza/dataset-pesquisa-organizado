import java.io.*;
import java.util.*;
public class entry_12012289 {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int numCities = in.nextInt();
        int connections = in.nextInt();
        //Map<Integer, List<Edge>> graph = new HashMap<>();
        List<Edge>[] graph = new ArrayList[numCities + 1];
        for (int i = 1; i <= numCities; i++) {
            //graph.put(i, new ArrayList<>());
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph[a].add(new Edge(b, c));
        }

        dijkstra(1, numCities, connections, graph);

    }

    public static void dijkstra(int start, int n, int m, List<Edge>[] graph) {
        long[] distances = new long[n + 1];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.cost));

        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int vertex = curr.dest;
            long cost = curr.cost;

            if (cost > distances[vertex]) {
                continue;
            }
            for (Edge e: graph[vertex]) {
                if (distances[vertex] + e.cost < distances[e.dest]) {
                    distances[e.dest] = distances[vertex] + e.cost;
                    pq.add(new Edge(e.dest, distances[e.dest]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            //System.out.print(distances[i] + " ");
            sb.append(distances[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    static class Edge {
        private int dest;
        private long cost;

        Edge(int dest, long cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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