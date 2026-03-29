import java.io.*;
import java.util.*;
public class entry_3576915 {
    static ArrayList<ArrayList<Edge>> neighbors = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> reverseNeighbors = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int cityNum = Integer.parseInt(st.nextToken());
        int flightNum = Integer.parseInt(st.nextToken());
        for (int c = 0; c < cityNum; c++) {
            neighbors.add(new ArrayList<>());
            reverseNeighbors.add(new ArrayList<>());
        }

        for (int i = 0; i < flightNum; i++) {
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            neighbors.get(from).add(new Edge(to, cost));
            reverseNeighbors.get(to).add(new Edge(from, cost));
        }

        long[] dis1 = minDist(0, neighbors);
        long[] dis2 = minDist(cityNum - 1, reverseNeighbors);
        long minCost = Long.MAX_VALUE;
        for (int c = 0; c < cityNum; c++) {
            for (Edge e : neighbors.get(c)) {
                minCost = Math.min(minCost, dis1[c] + dis2[e.to] + e.weight / 2);
            }
        }
        System.out.println(minCost);
    }

    public static long[] minDist(int start, ArrayList<ArrayList<Edge>> neighbors) {
        long[] minDist = new long[neighbors.size()];
        boolean[] visited = new boolean[neighbors.size()];
        PriorityQueue<Pos> frontier = new PriorityQueue<>();
        frontier.add(new Pos(start, 0));
        while(!frontier.isEmpty()) {
            Pos curr = frontier.remove();
            if (visited[curr.pos]) {
                continue;
            }
            visited[curr.pos] = true;
            minDist[curr.pos] = curr.cost;
            for (Edge e : neighbors.get(curr.pos)) {
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