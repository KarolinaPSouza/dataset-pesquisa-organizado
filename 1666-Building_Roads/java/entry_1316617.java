import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_1316617 {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  int n = scn.nextInt();
  int m = scn.nextInt();
  List<Integer>[] graph = new ArrayList[n + 1];
  for (int i = 0; i < m; ++i) {
   int u = scn.nextInt();
   int v = scn.nextInt();

   if (graph[u] == null) {
    graph[u] = new ArrayList<>();
   }

   if (graph[v] == null) {
    graph[v] = new ArrayList<>();
   }

   graph[u].add(v);
   graph[v].add(u);
  }

  boolean[] visited = new boolean[n + 1];
  int count = 0;
  List<Integer> list = new ArrayList<>();
  for (int i = 1; i <= n; ++i) {
   if (!visited[i]) {
    list.add(i);
    count++;
    dfs(i, graph, visited);
   }
  }
  out.println(count - 1);
  for (int i = 1; i < list.size(); ++i) {
   int u = list.get(i);
   int v = list.get(i - 1);
   out.println(u + " " + v);
  }
  out.close();

 }

 public static void dfs(int root, List<Integer>[] graph, boolean[] visited) {
  visited[root] = true;
  if (graph[root] != null) {
   for (int nbr : graph[root]) {
    if (!visited[nbr]) {
     dfs(nbr, graph, visited);
    }
   }
  }
 }

 static FastScanner scn = new FastScanner();
 static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

 static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  int[] readArray(int n) {
   int[] a = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  long nextLong() {
   return Long.parseLong(next());
  }
 }

}