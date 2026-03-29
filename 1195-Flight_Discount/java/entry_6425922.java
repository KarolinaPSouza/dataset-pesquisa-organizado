import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_6425922 {

    static class Edge {
        int des, cost;

        Edge(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }
    }

    static class Node {
        int node;
        long cost;
        boolean ticketUsed;

        Node(int node, long cost, boolean ticketUsed) {
            this.node = node;
            this.cost = cost;
            this.ticketUsed = ticketUsed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);
        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            token = br.readLine().split(" ");
            int src = Integer.parseInt(token[0]);
            int des = Integer.parseInt(token[1]);
            int cost = Integer.parseInt(token[2]);
            graph[src].add(new Edge(des, cost));
        }

        boolean[] visited = new boolean[n + 1];
        long[][] flightCost = new long[n + 1][2];
        flightCost[1][0] = 0;
        flightCost[1][1] = 0;
        for (int i = 1; i <= n; i++) {
            flightCost[i][0] = Long.MAX_VALUE;
            flightCost[i][1] = Long.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost < b.cost ? -1 : 1);
        pq.add(new Node(1, 0, false));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
//            System.out.printf("%d %d \n", curr.node, curr.cost);
            if (curr.ticketUsed) {
                if (flightCost[curr.node][1] != Long.MAX_VALUE) continue;
                flightCost[curr.node][1] = curr.cost;
                for (Edge next : graph[curr.node]) {
                    int dest = next.des;
                    pq.add(new Node(dest, curr.cost + next.cost, true));
                }
            } else {
                if (flightCost[curr.node][0] != Long.MAX_VALUE) continue;
                flightCost[curr.node][0] = curr.cost;
                for (Edge next : graph[curr.node]) {
                    int dest = next.des;
                    pq.add(new Node(dest, curr.cost + next.cost, false));
                    pq.add(new Node(dest, curr.cost + next.cost / 2, true));
                }
            }
        }

        System.out.println(flightCost[n][1]);
    }
}