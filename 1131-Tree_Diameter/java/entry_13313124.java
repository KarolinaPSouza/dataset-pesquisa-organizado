import java.io.*;
import java.util.*;

public class entry_13313124 {
 public static void main(String[] args) throws IOException {
  // Fast input and output
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(System.out);

  int n = Integer.parseInt(br.readLine());
  int[] dist = new int[n];
  ArrayList<Integer>[] adj = new ArrayList[n];
  for (int i = 0; i < n; i++) { adj[i] = new ArrayList<>(); }

  for (int i = 0; i < n - 1; i++) {
   StringTokenizer st = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken()) - 1;
   int b = Integer.parseInt(st.nextToken()) - 1;
   adj[a].add(b);
   adj[b].add(a);
  }

  // First DFS from node 0
  Arrays.fill(dist, -1);
  dist[0] = 0;
  Deque<Integer> stack = new ArrayDeque<>();
  stack.push(0);
  while (!stack.isEmpty()) {
   int curr = stack.pop();
   for (int next : adj[curr]) {
    if (dist[next] == -1) {
     dist[next] = dist[curr] + 1;
     stack.push(next);
    }
   }
  }

  int start = 0;
  for (int i = 0; i < n; i++) {
   if (dist[i] > dist[start]) start = i;
  }

  // Second DFS from farthest node
  Arrays.fill(dist, -1);
  dist[start] = 0;
  stack.push(start);
  while (!stack.isEmpty()) {
   int curr = stack.pop();
   for (int next : adj[curr]) {
    if (dist[next] == -1) {
     dist[next] = dist[curr] + 1;
     stack.push(next);
    }
   }
  }

  int maxDist = -1;
  for (int i = 0; i < n; i++) { maxDist = Math.max(maxDist, dist[i]); }

  out.println(maxDist);
  out.flush();
 }
}