import java.io.*;
import java.util.*;

public class entry_14849470 {
 static class Edge {
  int to;
  long weight;
  Edge(int to, long weight) {
   this.to = to;
   this.weight = weight;
  }
 }

 static int n, m;
 static List<Edge>[] adj;
 static long[] dist;
 static int[] parent;
 static int[] count;
 static boolean[] inQueue;

 public static void main(String[] args) throws IOException {
  FastScanner fs = new FastScanner(System.in);
  n = fs.nextInt();
  m = fs.nextInt();

  adj = new ArrayList[n + 1];
  for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

  for (int i = 0; i < m; i++) {
   int a = fs.nextInt();
   int b = fs.nextInt();
   long c = fs.nextLong();
   adj[a].add(new Edge(b, c));
  }

  dist = new long[n + 1];
  parent = new int[n + 1];
  count = new int[n + 1];
  inQueue = new boolean[n + 1];

  Arrays.fill(dist, 0);      // placeholder
  Arrays.fill(parent, -1);

  ArrayDeque<Integer> queue = new ArrayDeque<>();
  for (int i = 1; i <= n; i++) {
   queue.add(i);
   inQueue[i] = true;
  }

  int cycleStart = -1;

  while (!queue.isEmpty() && cycleStart == -1) {
   int u = queue.poll();
   inQueue[u] = false;

   for (Edge e : adj[u]) {
    int v = e.to;
    long w = e.weight;
    if (dist[v] > dist[u] + w) {
     dist[v] = dist[u] + w;
     parent[v] = u;
     if (!inQueue[v]) {
      queue.add(v);
      inQueue[v] = true;
      count[v]++;
      if (count[v] > n) { // negative cycle detected
       cycleStart = v;
       break;
      }
     }
    }
   }
  }

  if (cycleStart == -1) {
   System.out.println("NO");
  } else {
   // Walk back n steps to ensure we're inside the cycle
   int curr = cycleStart;
   for (int i = 0; i < n; i++) curr = parent[curr];

   // Reconstruct cycle
   ArrayList<Integer> cycle = new ArrayList<>();
   int start = curr;
   do {
    cycle.add(curr);
    curr = parent[curr];
   } while (curr != start);
   cycle.add(start);
   Collections.reverse(cycle);

   System.out.println("YES");
   StringBuilder sb = new StringBuilder();
   for (int node : cycle) sb.append(node).append(" ");
   System.out.println(sb.toString().trim());
  }
 }

 static class FastScanner {
  BufferedReader br;
  StringTokenizer st;
  FastScanner(InputStream in) { br = new BufferedReader(new InputStreamReader(in)); }
  String next() throws IOException {
   while (st == null || !st.hasMoreElements()) {
    String line = br.readLine();
    if (line == null) return null;
    st = new StringTokenizer(line);
   }
   return st.nextToken();
  }
  int nextInt() throws IOException { return Integer.parseInt(next()); }
  long nextLong() throws IOException { return Long.parseLong(next()); }
 }
}