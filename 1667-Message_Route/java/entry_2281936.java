import java.io.*;
import java.util.*;

public class entry_2281936 {
  private static int[] d;
  private static int[] p;
  private static boolean[] visited;
  public static void main (String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    List<List<Integer>> adj = new ArrayList<>(n);
    for(int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());
    }
    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(reader.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj.get(a - 1).add(b - 1);
      adj.get(b - 1).add(a - 1);
    }
    d = new int[n];
    p = new int[n];
    Arrays.fill(p, -1);
    Arrays.fill(d, -1);
    visited = new boolean[n];
    bfs(adj);
    if(!visited[n - 1]) {
      writer.println("IMPOSSIBLE");
    } else {
      writer.println(d[n - 1]);
      LinkedList<Integer> path = new LinkedList<>();
      for(int v = n - 1; v != -1; v = p[v]) {
        path.addFirst(v + 1);
      }
      for(int x : path) {
        writer.print(x + " ");
      }
      writer.println();
    }
    writer.close();                                  
  }

  private static void bfs(List<List<Integer>> adj) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.offer(0);
    d[0] = 1;
    p[0] = -1;
    visited[0] = true;
    while(!queue.isEmpty()) {
      int u = queue.poll();
      for(int v : adj.get(u)) {
        if(!visited[v]) {
          visited[v] = true;
          d[v] = d[u] + 1;
          p[v] = u;
          queue.offer(v);
        }
      }
    }
  }

}
