import java.io.*;
import java.util.*;

public class entry_10577006 {

    static class Node implements Comparable<Node> {
        int id;
        long distance;

        public Node(int id, long distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            adj.get(a).add(new Node(b, c));
        }

        long[] distance = dijkstra(adj, 1, n);

        for (int i = 1; i <= n; i++) {
            out.print(distance[i] + " ");
        }
        br.close();
        out.close();
    }

    static long[] dijkstra(List<List<Node>> adj, int start, int n) {
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.distance > distance[current.id]) {
                continue;
            }

            for (Node neighbor : adj.get(current.id)) {
                long newDistance = distance[current.id] + neighbor.distance;
                if (newDistance < distance[neighbor.id]) {
                    distance[neighbor.id] = newDistance;
                    pq.add(new Node(neighbor.id, newDistance));
                }
            }
        }
        return distance;
    }
}