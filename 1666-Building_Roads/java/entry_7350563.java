import java.io.*;
import java.util.*;

public class entry_7350563 {
 public static void main(String[] args) throws IOException {
  Kattio io = new Kattio();
  int n = io.nextInt();
  int m = io.nextInt();

  List<Integer>[] adj = new ArrayList[n];
  for (int i = 0; i < n; i++) {
   adj[i] = new ArrayList<>();
  }
  for (int i = 0; i < m; i++) {
   int a = io.nextInt() - 1;
   int b = io.nextInt() - 1;
   adj[a].add(b);
   adj[b].add(a);
  }

  boolean[] visited = new boolean[n];
        List<Integer> cityReps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
   if (visited[i]) {
    continue;
   }

   visited[i] = true;
            cityReps.add(i);
   ArrayDeque<Integer> todo = new ArrayDeque<>();
   todo.add(i);
   while (!todo.isEmpty()) {
    int curr = todo.poll();
                for (int next : adj[curr]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        todo.add(next);
                    }
                }
   }
  }

        StringBuilder ans = new StringBuilder();
        ans.append(cityReps.size() - 1).append('\n');
        for (int i = 0; i < cityReps.size() - 1; i++) {
            ans.append(cityReps.get(i) + 1).append(' ').append(cityReps.get(i + 1) + 1).append('\n');
        }
        io.println(ans);
        io.close();
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