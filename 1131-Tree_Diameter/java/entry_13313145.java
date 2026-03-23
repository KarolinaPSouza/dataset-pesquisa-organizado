import java.io.*;
import java.util.*;

public class entry_13313145 {
 private static ArrayList<Integer>[] adj;
 private static int[] height;
 private static int diameter = 0;

 static class State {
  public int node, parent, phase;
  State(int node, int parent, int phase) {
   this.node = node;
   this.parent = parent;
   this.phase = phase;
  }
 }

 // iterative DFS necessary in order to AC; recursive TLEs on final case
 static void calculateDiameter(int start) {
  Deque<State> stack = new ArrayDeque<>();
  // start from node 0, no parent, pre-processing phase
  stack.push(new State(start, -1, 0));

  while (!stack.isEmpty()) {
   State curr = stack.pop();
   int u = curr.node;
   int p = curr.parent;
   int phase = curr.phase;

   if (phase == 0) {
    // convert current state to post-processing
    stack.push(new State(u, p, 1));

    for (int v : adj[u]) {
     if (v != p) { stack.push(new State(v, u, 0)); }
    }
   } else {
    // post-processing: calculate heights and update diameter
    int max1 = 0, max2 = 0;
    for (int v : adj[u]) {
     if (v == p) continue;
     int h = height[v] + 1;
     if (h > max1) {
      max2 = max1;
      max1 = h;
     } else if (h > max2) {
      max2 = h;
     }
    }
    height[u] = max1;
    // diameter will equal the max of the sum of the heights of the two
    // tallest subtrees
    diameter = Math.max(diameter, max1 + max2);
   }
  }
 }

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(br.readLine());

  adj = new ArrayList[n];
  for (int i = 0; i < n; i++) { adj[i] = new ArrayList<>(); }
  for (int i = 0; i < n - 1; i++) {
   StringTokenizer st = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken()) - 1;
   int b = Integer.parseInt(st.nextToken()) - 1;
   adj[a].add(b);
   adj[b].add(a);
  }

  height = new int[n];
  diameter = 0;
  calculateDiameter(0);

  System.out.println(diameter);
 }
}