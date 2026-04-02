// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class entry_9096852 {
 static List<Integer>[] adj;
 static boolean[] visited;
 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(r.readLine());
  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());
  visited = new boolean[n+1];
  adj = new ArrayList[n+1];
  for(int i = 1; i<n+1;i++){adj[i] = new ArrayList<>();}
  for(int i = 0;i<m;i++){
   st = new StringTokenizer(r.readLine());
   int u = Integer.parseInt(st.nextToken());
   int v = Integer.parseInt(st.nextToken());
   adj[u].add(v);
   adj[v].add(u);
  }

  Stack<Integer> s = new Stack<>();

  ArrayList<Integer> reps = new ArrayList<>();
  for(int i = 1;i<n+1;i++){
   if(!visited[i]){
    reps.add(i);
    s.push(i);
    visited[i] = true;
    while (!s.isEmpty()){
     int v = s.pop();
     for(int u : adj[v]){
      if (!visited[u]){
       visited[u] = true;
       s.push(u);
      }
     }
    }
   }
  }
  pw.println(reps.size()-1);
  for(int i = 1;i<reps.size(); i++){
   pw.println(reps.get(0)+" "+reps.get(i));
  }

  /*
   * Make sure to include the line below, as it
   * flushes and closes the output stream.
   */
  pw.close();
 }
}