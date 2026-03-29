// Arup Guha
// Illustrates adaptation of Bellman-Ford to find negative weight cycles.

import java.util.*;

public class entry_9024206 {

 final public static long INF = 1000000000000000L;

 public static void main(String[] args) {

  Scanner stdin = new Scanner(System.in);
  int n = stdin.nextInt();
  int m = stdin.nextInt();
  ArrayList<edge> list = new ArrayList<edge>();

  // Read edges.
  for (int i=0; i<m; i++) {
   int u = stdin.nextInt();
   int v = stdin.nextInt();
   int w = stdin.nextInt();
   list.add(new edge(u,v,w));
  }

  // Here is our trick, we add vertex 0 with edges to every other vertex, so all
  // cycles in the graph are reachable from vertex 0.
  // Without this, a disconnected cycle from 0 isn't discovered.
  for (int i=1; i<=n; i++)
   list.add(new edge(0, i, 0));

  // Store shortest distances here.
  long[] dist = new long[n+1];
  Arrays.fill(dist, INF);
  dist[0] = 0;

  // Store previous nodes here.
  int[] prev = new int[n+1];
  Arrays.fill(prev, -1);
  prev[0] = 0;

  // Regular Bellman Ford on n+1 vertices.
  for (int i=0; i<n; i++) {

   // Loop through edges.
   for (edge e: list) {

    // Skip these. I can't get to the start vertex of this edge so skip.
    if (dist[e.u] == INF) continue;

    // This edge gets us a shorter path from source to v.
    if (dist[e.u] + e.w < dist[e.v]) {
     dist[e.v] = dist[e.u] + e.w;
     prev[e.v] = e.u;
    }
   }
  }

  boolean update = false;
  int cyclev = -1;

  // Now continue relaxing edges.
  for (int i=0; i<n; i++) {

   // Loop through edges.
   for (edge e: list) {

    // Skip these. I can't get to the start vertex of this edge so skip.
    if (dist[e.u] == INF) continue;

    // This edge gets us a shorter path from source to v.
    if (dist[e.u] + e.w < dist[e.v]) {
     update = true;
     cyclev = e.v;
     dist[e.v] = dist[e.u] + e.w;
     prev[e.v] = e.u;
     break;
    }
   }
   if (update) break;
  }  

  // Easy case.
  if (!update)
   System.out.println("NO");

  // Must print out cycle.
  else {

   boolean[] used = new boolean[n+1];
   int end = cyclev;
   ArrayList<Integer> res = new ArrayList<Integer>();

   // Build cycle backwards.
   while (true) {
    res.add(end);

    // This means this vertex, end, shows up twice. This is a cycle.
    if (used[end]) break;
    used[end] = true;
    end = prev[end];
   }

   // Reverse it.
   Collections.reverse(res);
   int idx = 1;
   int sz = res.size();

   // Just stop when we get back to the repeated vertex.
   while (!res.get(idx).equals( res.get(0)))
    idx++;

   // Now print it.
   System.out.println("YES");
   for (int i=0; i<=idx; i++)
    System.out.print( res.get(i) + " " );
   System.out.println();
  }
 }
}

class edge {

 public int u;
 public int v;
 public int w;

 public edge(int myu, int myv, int myw) {
  u = myu;
  v = myv;
  w = myw;
 }
}