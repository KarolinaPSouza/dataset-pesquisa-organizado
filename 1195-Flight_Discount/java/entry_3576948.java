import java.io.*;
import java.util.*;
public class entry_3576948 {
    static ArrayList<Edge>[] neighbors, reverseNeighbors;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        neighbors = new ArrayList[nodes];
        reverseNeighbors = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            neighbors[i] = new ArrayList<>();
            reverseNeighbors[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            neighbors[a].add(new Edge(b, c));
            reverseNeighbors[b].add(new Edge(a, c));
        }

        long[] dis1 = minDist(0, neighbors);
        long[] dis2 = minDist(nodes - 1, reverseNeighbors);
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < nodes; i++) {
            for (Edge e : neighbors[i]) {
                minCost = Math.min(minCost, dis1[i] + dis2[e.to] + e.weight / 2);
            }
        }
        System.out.println(minCost);
    }

    public static long[] minDist(int start, ArrayList<Edge>[] neighbors) {
        long[] minDist = new long[neighbors.length];
        boolean[] visited = new boolean[neighbors.length];
        PriorityQueue<Pos> frontier = new PriorityQueue<>();
        frontier.add(new Pos(start, 0));
        while(!frontier.isEmpty()) {
            Pos curr = frontier.remove();
            if (visited[curr.pos]) {
                continue;
            }
            visited[curr.pos] = true;
            minDist[curr.pos] = curr.cost;
            for (Edge e : neighbors[curr.pos]) {
                frontier.add(new Pos(e.to, curr.cost + e.weight));
            }
        }
        return minDist;
    }
}
class Edge {
    int to;
    long weight;
    Edge(int to, long weight) {
        this.to = to;
        this.weight = weight;
    }
}
class Pos implements Comparable<Pos> {
    int pos;
    long cost;
    Pos(int val, long wsf) {
        this.pos = val;
        this.cost = wsf;
    }
    public int compareTo(Pos o) {
        return (int) (this.cost - o.cost);
    }
}