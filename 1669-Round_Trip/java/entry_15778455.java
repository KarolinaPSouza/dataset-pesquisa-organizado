import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class entry_15778455 {
  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;
  static StringBuilder sb;

  static final int INT_MAX = (int) 1e9, INT_MIN = -INT_MAX;
  static final long LONG_MAX = (long) 1e18, LONG_MIN = -LONG_MAX;
  static final int mod = (int) 1e9 + 7;

  int n, m;
  List<Integer>[] g;
  int[] state, parent;
  boolean hasCycle = false;
  int start = -1, end = -1;

  void dfs(int u, int parent) {
    if (hasCycle) return;

    state[u] = 1;
    for (int v : g[u]) {
      if (v != parent && state[v] == 1) {
        hasCycle = true;
        start = v;
        end = u;
        return;
      }
      if (v != parent && state[v] == 0) {
        this.parent[v] = u;
        dfs(v, u);
      }
    }

    state[u] = 2;
  }

  void solve() throws IOException {
    n = parseInt(nextToken());
    m = parseInt(nextToken());
    g = new ArrayList[n];
    for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      int a = parseInt(nextToken()) - 1;
      int b = parseInt(nextToken()) - 1;

      g[a].add(b);
      g[b].add(a);
    }

    state = new int[n];
    parent = new int[n];

    for (int i = 0; i < n; i++) parent[i] = i;

    for (int i = 0; i < n; i++) {
      if (state[i] != 2) {
        dfs(i, i);
      }
    }

    if (!hasCycle) {
      sb.append("IMPOSSIBLE");
    } else {
      Stack<Integer> stack = new Stack<>();
      int curr = start;
      stack.push(end + 1);
      while (curr != end) {
        stack.push(curr + 1);
        curr = parent[curr];
      }
      stack.push(end + 1);
      sb.append(stack.size()).append('\n');
      while (!stack.isEmpty()) {
        sb.append(stack.pop()).append(' ');
      }
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new BufferedOutputStream(System.out));
    sb = new StringBuilder();
    int TC = 1;
    while (TC-- > 0) {
      new entry_15778455().solve();
      sb.append('\n');
    }
    out.print(sb);
    out.flush();
    out.close();
    br.close();
  }

  static String nextToken() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
      st = new StringTokenizer(br.readLine());
    }
    return st.nextToken();
  }
}