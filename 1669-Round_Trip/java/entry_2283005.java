import java.io.*;
import java.util.*;

public class entry_2283005 {
 public final static int MAX = 100_005;
 public static List<List<Integer>> adj;
 public static boolean[] visited;
 public static int[] parent;
 public static int cycleStart, cycleEnd;

 public static void init() {
  adj = new ArrayList<>();
  parent = new int[MAX];
  visited = new boolean[MAX];
  cycleStart = cycleEnd = -1;
  for(int i=0; i < MAX; i++) {
   adj.add(new ArrayList<>());
  }
 }

 public static void main(String[] args) throws IOException {
  Reader.init(System.in);
  StringBuilder sb = new StringBuilder();
  init();
  int n, m, a, b;
  n = Reader.nextInt();
  m = Reader.nextInt();

  for(int i=0; i<m; i++) {
   a = Reader.nextInt();
   b = Reader.nextInt();
   adj.get(a).add(b);
   adj.get(b).add(a);
  }
  findCycle(n, sb);
  System.out.print(sb);
 }

 public static boolean dfs(int u, int par) {
  visited[u] = true;
  for(int v : adj.get(u)) {
   if(v == par) continue;
   if(visited[v]) {
    cycleEnd = u;
    cycleStart = v;
    return true;
   }
   parent[v] = u;
   if(dfs(v, parent[v])) return true;
  }
  return false;
 }

 public static void findCycle(int n, StringBuilder sb) {
  for(int i=1; i <= n; i++) visited[i] = false;
  for(int i=1; i <= n; i++) parent[i] = -1;
  cycleStart = -1;

  for(int u=1; u <= n; u++) {
   if(visited[u]==false && dfs(u, parent[u])) break;
  }

  if(cycleStart == -1) {
   sb.append("IMPOSSIBLE");
   // graph is acyclic
  } else {
   List<Integer> cycle = new ArrayList<>();
   cycle.add(cycleStart);
   for(int v = cycleEnd; v != cycleStart; v = parent[v]) {
    cycle.add(v);
   }
   cycle.add(cycleStart);
   Collections.reverse(cycle);
   sb.append(cycle.size() + "\n");
   for(int v : cycle) sb.append(v + " ");
  }
 }
}


class Reader {
 static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}