import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_6429863 {

    static class Edge {
        int src;
        int des;
        int length;

        Edge(int src, int des, int length) {
            this.src = src;
            this.des = des;
            this.length = length;
        }
    }


    static List<Edge>[] graph;
    static List<Edge> edgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            token = br.readLine().split(" ");
            int src = Integer.parseInt(token[0]);
            int des = Integer.parseInt(token[1]);
            int length = Integer.parseInt(token[2]);
            Edge edge = new Edge(src, des, length);
            graph[src].add(edge);
            edgeList.add(edge);
        }

        long[] dist = new long[n + 1];
        dist[1] = 0L;
        int[] prev = new int[n + 1];

        int last = 0;
        for (int i = 1; i <= n && last != -1; i++) {
            last = -1;
            for (Edge edge : edgeList) {
                int src = edge.src, des = edge.des, length = edge.length;
                if (dist[des] > dist[src] + length) {
                    dist[des] = dist[src] + length;
                    last = des;
                    prev[des] = src;
                }
            }
        }

        if (last == -1) {
            System.out.println("NO");
            return;
        }

        Set<Integer> cycleElems = new HashSet<>();
        Stack<Integer> cycleList = new Stack<>();
        int iter = last;
        while (!cycleElems.contains(iter)) {
            cycleElems.add(iter);
            cycleList.push(iter);
            iter = prev[iter];
        }
        cycleList.push(iter);
        int start = iter;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d ", cycleList.pop()));
        while (!cycleList.isEmpty() && cycleList.peek() != start) {
            sb.append(String.format("%d ", cycleList.pop()));
        }
        sb.append(String.format("%d ", cycleList.pop()));
        System.out.println("YES");
        System.out.println(sb.toString());
        return;
    }
}