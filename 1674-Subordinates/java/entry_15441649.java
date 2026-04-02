import java.io.*;
import java.util.*;

public class entry_15441649 {
 public static void main(String[] args) throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(br.readLine());

  // Build children adjacency list
  ArrayList<ArrayList<Integer>> g = new ArrayList<>(n);
  for (int i = 0; i < n; i++) g.add(new ArrayList<>());

  StringTokenizer st = new StringTokenizer(br.readLine());
  for (int i = 1; i < n; i++) {
   int p = Integer.parseInt(st.nextToken()) - 1;
   g.get(p).add(i);
  }

  int[] dp = new int[n];     // subtree sizes
  int[] state = new int[n];  // 0 = not processed, 1 = children pushed
  Deque<Integer> stack = new ArrayDeque<>();

  stack.push(0); // root

  while (!stack.isEmpty()) {
   int u = stack.peek();

   if (state[u] == 0) {
    // First time we see u → push its children first (like DFS)
    state[u] = 1;
    for (int v : g.get(u)) {
     stack.push(v);
    }
   } else {
    // All children processed → compute dp[u]
    stack.pop();
    int sum = 1; // count itself
    for (int v : g.get(u)) {
     sum += dp[v];
    }
    dp[u] = sum;
   }
  }

  // output dp[u] - 1
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < n; i++) {
   sb.append(dp[i] - 1);
   if (i + 1 < n) sb.append(' ');
  }
  System.out.println(sb);
 }
}