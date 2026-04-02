import java.io.*;
import java.util.*;

public class entry_7349949 {
 static List<Integer>[] adj;
 static int[] assigned;

 public static void main(String[] args) throws IOException {
  Kattio io = new Kattio();
  int n = io.nextInt();
  int m = io.nextInt();

  adj = new ArrayList[n];
  for (int i = 0; i < n; i++) {
   adj[i] = new ArrayList<>();
  }
  for (int i = 0; i < m; i++) {
   int a = io.nextInt() - 1;
   int b = io.nextInt() - 1;
   adj[a].add(b);
   adj[b].add(a);
  }

  assigned = new int[n];
  boolean valid = true;
  for (int i = 0; i < n; i++) {
   if (assigned[i] == 0) {
    assigned[i] = 1;  // Assign an arbitrary starting team
    if (!dfs(i)) {
     valid = false;
     break;
    }
   }
  }

  if (valid) {
   for (int i = 0; i < n; i++) {
    io.print(assigned[i]);
    io.print(" \n".charAt(i == n - 1 ? 1 : 0));
   }
  } else {
   io.println("IMPOSSIBLE");
  }
  io.close();
 }

 /** @return if it's possible to assign each person to a team */
 static boolean dfs(int node) {
  int curr = assigned[node];
  int neighbors = curr == 1 ? 2 : 1;  // The color the neighbors should be
  for (int u : adj[node]) {
   if (assigned[u] != 0) {
    // Check if the already existing color lines up
    if (assigned[u] != neighbors) {
     return false;
    }
   } else {
    assigned[u] = neighbors;
    if (!dfs(u)) {
     return false;  // We stop as soon as we hit a contradiction
    }
   }
  }
  return true;
 }

 static class Kattio extends PrintWriter {
  private BufferedReader r;
  private StringTokenizer st;
  // standard input
  public Kattio() { this(System.in, System.out); }
  public Kattio(InputStream i, OutputStream o) {
   super(o);
   r = new BufferedReader(new InputStreamReader(i));
  }
  // USACO-style file input
  public Kattio(String problemName) throws IOException {
   super(problemName + ".out");
   r = new BufferedReader(new FileReader(problemName + ".in"));
  }
  // returns null if no more input
  public String next() {
   try {
    while (st == null || !st.hasMoreTokens())
     st = new StringTokenizer(r.readLine());
    return st.nextToken();
   } catch (Exception e) {}
   return null;
  }
  public int nextInt() { return Integer.parseInt(next()); }
  public double nextDouble() { return Double.parseDouble(next()); }
  public long nextLong() { return Long.parseLong(next()); }
 }
}