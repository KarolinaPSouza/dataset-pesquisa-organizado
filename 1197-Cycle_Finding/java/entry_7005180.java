import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class entry_7005180 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int e = sc.nextInt();
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for(int i = 0; i < e; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      int w = sc.nextInt();
      List<int[]> edges = graph.computeIfAbsent(a, l -> new ArrayList<>());
      edges.add(new int[] {b, w});
    }

    long[] weights = new long[n];
    int[] predecessor = new int[n];
    Arrays.fill(weights, Long.MAX_VALUE);
    Arrays.fill(predecessor, -1);
    for(int i = 0; i < n - 1; i++) {
      for(Integer in : graph.keySet()) {
        List<int[]> edges = graph.get(in);
        for(int[] edge : edges) {
          // handle overflow, not helpful
          if(weights[in] > 0 && weights[in] + edge[1] < 0) {
            continue;
          }
          if(weights[edge[0]] > weights[in] + edge[1]) {
            weights[edge[0]] = weights[in] + edge[1];
            predecessor[edge[0]] = in;
          }
        }
      }
    }
    for(Integer in : graph.keySet()) {
      List<int[]> edges = graph.get(in);
      for(int[] edge : edges) {
        if(weights[in] > 0 && weights[in] + edge[1] < 0) {
          continue;
        }
        if(weights[in] + edge[1] < weights[edge[0]]) {
          predecessor[edge[0]] = in;
          boolean[] visited = new boolean[n];
          visited[edge[0]] = true;
          while(!visited[in]) {
            visited[in] = true;
            in = predecessor[in];
          }
          List<Integer> cycle = new ArrayList<>();
          cycle.add(in);
          int v = predecessor[in];
          while(v != in) {
            cycle.add(v);
            v = predecessor[v];
          }
          cycle.add(v);
          System.out.println("YES");
          Collections.reverse(cycle);
          for(Integer i : cycle) {
            System.out.print((i + 1) + " ");
          }
          return;
        }
      }
    }
    System.out.println("NO");
  }
}