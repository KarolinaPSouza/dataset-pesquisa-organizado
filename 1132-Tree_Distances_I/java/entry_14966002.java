import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class entry_14966002 {

 static int[] head;
 static int[] next;
 static int[] to;

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(System.out);
  int nodes = Integer.parseInt(br.readLine());
  head = new int[nodes + 1];
  to = new int[2 * nodes];
  next = new int[2 * nodes];
  Arrays.fill(head, -1);
  int edge = 0;
  for (int i = 1; i < nodes; i++) {
   StringTokenizer st = new StringTokenizer(br.readLine());
   int u = Integer.parseInt(st.nextToken());
   int v = Integer.parseInt(st.nextToken());
   addEdge(u, v, edge++);
   addEdge(v, u, edge++);
  }
  int[] maxLength = new int[nodes + 1];
  boolean[] visited = new boolean[nodes + 1];
  visited[1] = true;
  int[] stack = new int[nodes];
  int stacki = 1;
  stack[0] = 1;
  int expand = 0;
  while(expand != nodes) {
   int node = stack[expand++];
   for(int e = head[node]; e != -1; e = next[e]) {
    if(!visited[to[e]]) {
     stack[stacki++] = to[e];
     visited[to[e]] = true;
    }
   }
  }
  int edgeOne = stack[--stacki];
  visited = new boolean[nodes + 1];
  visited[edgeOne] = true;
  stack = new int[nodes];
  stacki = 1;
  stack[0] = edgeOne;
  expand = 0;
  int depth = 0;
  while(expand != nodes) {
   int end = stacki;
   for(; expand < end; expand++) {
    int node = stack[expand];
    maxLength[node] = depth;
    for(int e = head[node]; e != -1; e = next[e]) {
     if(!visited[to[e]]) {
      stack[stacki++] = to[e];
      visited[to[e]] = true;
     }
    }
   }
   depth++;
  }
  int edge2 = stack[--stacki];
  visited = new boolean[nodes + 1];
  visited[edge2] = true;
  stack = new int[nodes];
  stacki = 1;
  stack[0] = edge2;
  expand = 0;
  depth = 0;
  while(expand != nodes) {
   int end = stacki;
   for(; expand < end; expand++) {
    int node = stack[expand];
    maxLength[node] = Math.max(depth, maxLength[node]);
    for(int e = head[node]; e != -1; e = next[e]) {
     if(!visited[to[e]]) {
      stack[stacki++] = to[e];
      visited[to[e]] = true;
     }
    }
   }
   depth++;
  }
  StringBuilder sb = new StringBuilder();
  for(int i = 1; i <= nodes; i++) {
   sb.append(maxLength[i]);
   sb.append(" ");
  }
  out.print(sb.toString());
  out.flush();
 }

 private static void addEdge(int u, int v, int edge) {
  to[edge] = v;
  next[edge] = head[u];
  head[u] = edge;

 }
}