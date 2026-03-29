import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_12462947 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = bufferedReader.readLine().split(" ");
    int n = Integer.parseInt(inputs[0]);
    int m = Integer.parseInt(inputs[1]);
    int[][] edges = new int[m][3];
    for(int i = 0;i<m;i++) {
      String[] edgeStr = bufferedReader.readLine().split(" ");
      edges[i][0] = Integer.parseInt(edgeStr[0]);
      edges[i][1] = Integer.parseInt(edgeStr[1]);
      edges[i][2] = Integer.parseInt(edgeStr[2]);
    }
    System.out.println(minCost(n, m, edges));
  }

  private static long minCost(int n, int m, int[][] edges) {
    Queue<long[]> pq = new PriorityQueue<>((l1, l2) -> l1[0]==l2[0] ? Long.compare(l1[1], l2[1]) : Long.compare(l1[0], l2[0]));
//    Queue<long[]> pq = new ArrayDeque<>();
    Map<Integer, List<int[]>> graph = getGraph(edges, n);
    long[][] minDist = new long[n+1][2];
    for(int i = 0;i<=n;i++) {
      minDist[i] = new long[]{Long.MAX_VALUE, Long.MAX_VALUE};
    }
    pq.add(new long[]{0, 0, 1});
    minDist[1] = new long[]{0, 0};

    while (!pq.isEmpty()) {
      long[] node = pq.poll();
      int vertex = (int) node[2];
      if(node[0] > minDist[(int) node[2]][0] && node[1] > minDist[(int) node[2]][1])
        continue;
      for(int[] edge : graph.get(vertex)) {
        long[] dist = minDist[edge[0]];
        long minAppliedOld = node[0] + edge[1];
        long minAppliedNew = node[1] + edge[1]/2;
        long minApplied = Math.min(minAppliedOld, minAppliedNew);
        long notApplied = node[1] + edge[1];

        if(minApplied < dist[0] || notApplied < dist[1]) {
          dist[0] = Math.min(minApplied, dist[0]);
          dist[1] = Math.min(notApplied, dist[1]);
          pq.add(new long[]{dist[0], dist[1], edge[0]});
        }
      }
    }
    return minDist[n][0];
  }

  private static Map<Integer, List<int[]>> getGraph(int[][] edges, int n) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for(int i = 1;i<=n;i++) {
      graph.put(i, new ArrayList<>());
    }
    for(int[] edge : edges) {
      graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    return graph;
  }
}