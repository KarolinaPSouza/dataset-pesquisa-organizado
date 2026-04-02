import java.io.*;
import java.util.*;

public class entry_14677593 {
    static final int MAXN = 100_000 + 5;
    static final int MAXM = 200_000 + 5;

    static int n, m;
    static int[] head = new int[MAXN];
    static int[] to = new int[MAXM];
    static int[] nxt = new int[MAXM];
    static int[] cost = new int[MAXM];
    static long[] dist = new long[MAXN];
    static boolean[] visited = new boolean[MAXN];
    static int edgeCount = 0;

    static void addEdge(int u, int v, int w) {
        to[edgeCount] = v;
        cost[edgeCount] = w;
        nxt[edgeCount] = head[u];
        head[u] = edgeCount++;
    }

    static class Node implements Comparable<Node> {
        int city;
        long dist;

        Node(int city, long dist) {
            this.city = city;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast IO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 20);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), false);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(head, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            addEdge(a, b, c);
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.city;
            if (dist[u] < curr.dist) continue;

            for (int e = head[u]; e != -1; e = nxt[e]) {
                int v = to[e];
                long nd = dist[u] + cost[e];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new Node(v, nd));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            out.print(dist[i]);
            out.print(i == n ? '\n' : ' ');
        }
        out.flush();
    }
}