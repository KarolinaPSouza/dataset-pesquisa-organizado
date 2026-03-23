import java.io.*;
import java.util.*;

public class entry_5176765 {
 static int nodes;
 static int[] dist;
 static boolean[] visited;
 static ArrayList<Integer>[] adj;
 public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  nodes = Integer.parseInt(in.readLine());
  adj = new ArrayList[nodes];

  for(int i = 0; i < nodes; i++) {
   adj[i] = new ArrayList<Integer>();
  }

  for(int i = 0; i < nodes - 1; i++) {
   StringTokenizer st = new StringTokenizer(in.readLine());
   int one = Integer.parseInt(st.nextToken())-1;
   int two = Integer.parseInt(st.nextToken())-1;
   adj[one].add(two);
   adj[two].add(one);
  }

  dist = new int[nodes];
  BFS(0);

  int max = 0;
  int pos = 0;
  for(int i = 1; i < nodes; i++) {
   if(dist[i] > max) {
    max = dist[i];
    pos = i;
   }
  }

  dist = new int[nodes];
  BFS(pos);
  max = 0;
  for(int i = 0; i < nodes; i++) {
   max = Math.max(max, dist[i]);
  }

  System.out.print(max);
 }

 public static void BFS(int start) {
  Queue<Integer> q = new LinkedList<Integer>();
  q.add(start);

  Arrays.fill(dist, -1);
  dist[start] = 0;

  while(!q.isEmpty()) {
   int curr = q.poll();
   for(int i: adj[curr]) {
    if(dist[i] == -1) {
     dist[i] = dist[curr] + 1;
     q.add(i);
    }
   }
  }
 }
}