import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_9156984 {
 static int[] visited;

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());

  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());
  ArrayList<Integer>[] adj = new ArrayList[n + 1];
  for (int i = 0; i <= n; i++) {
   adj[i] = new ArrayList<Integer>();
  }

  for (int i = 0; i < m; i++) {
   st = new StringTokenizer(br.readLine());
   int x = Integer.parseInt(st.nextToken());
   int y = Integer.parseInt(st.nextToken());
   adj[x].add(y);
   adj[y].add(x);
  }

  boolean flag = isBipartite(n + 1, adj);
  if (flag) {
   for (int i = 1; i < n + 1; i++) {
    System.out.print(visited[i] + 1 + " ");
   }
  } else {
   System.out.println("IMPOSSIBLE");
  }
  br.close();
 }

 public static boolean isBipartite(int V, ArrayList<Integer>[] adj) {
  visited = new int[V];
  for (int i = 0; i < V; i++) {
   visited[i] = -1;
  }

  for (int i = 1; i < V; i++) {
   if (visited[i] == -1) {
    if (bfs(adj, visited, i) == false) {
     return false;
    }
   }
  }
  return true;
 }

 public static boolean bfs(ArrayList<Integer>[] adj, int[] visited, int src) {
  Queue<Integer> queue = new ArrayDeque<Integer>();
  queue.add(src);
  visited[src] = 0;

  while (!queue.isEmpty()) {
   int u = queue.poll();
   for (int i = 0; i < adj[u].size(); i++) {
    int v = adj[u].get(i);
    if (visited[v] == -1) {
     visited[v] = 1 - visited[u];
     queue.add(v);
    } else if (visited[u] == visited[v]) {
     return false;
    }
   }
  }
  return true;
 }
}