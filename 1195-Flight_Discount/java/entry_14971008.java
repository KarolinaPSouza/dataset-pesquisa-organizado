import java.io.*;
import java.util.*;

public class entry_14971008 {
    static class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        long dist;
        int node;
        int couponRemaining; // 1 = yes, 0 = no
        State(long dist, int node, int couponRemaining) {
            this.dist = dist;
            this.node = node;
            this.couponRemaining = couponRemaining;
        }

        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            long c = Long.parseLong(st.nextToken());
            adjList[a].add(new Edge(b, c));
        }

        long INF = (long)1e17;
        long[] dist = new long[n]; // distance with coupon available
        long[] disc = new long[n]; // distance with coupon used
        Arrays.fill(dist, INF);
        Arrays.fill(disc, INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[0] = 0;
        disc[0] = 0;
        pq.add(new State(0, 0, 1));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            long d = cur.dist;
            int v = cur.node;
            int couponRemaining = cur.couponRemaining;

            if (couponRemaining == 1) {
                if (dist[v] < d) continue;
            } else {
                if (disc[v] < d) continue;
            }

            for (Edge e : adjList[v]) {
                int neighbor = e.to;
                long n_dist = e.cost;

                if (couponRemaining == 1) {
                    // use coupon
                    if (dist[v] + n_dist / 2 < disc[neighbor]) {
                        disc[neighbor] = dist[v] + n_dist / 2;
                        pq.add(new State(disc[neighbor], neighbor, 0));
                    }

                    // preserve coupon
                    if (dist[v] + n_dist < dist[neighbor]) {
                        dist[neighbor] = dist[v] + n_dist;
                        pq.add(new State(dist[neighbor], neighbor, 1));
                    }
                } else {
                    // no coupon left
                    if (disc[v] + n_dist < disc[neighbor]) {
                        disc[neighbor] = disc[v] + n_dist;
                        pq.add(new State(disc[neighbor], neighbor, 0));
                    }
                }
            }
        }

        System.out.println(disc[n - 1]);
    }
}