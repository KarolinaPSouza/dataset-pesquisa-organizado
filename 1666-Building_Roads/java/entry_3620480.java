import java.util.*;
import java.io.*;

public class entry_3620480 {
 public static ArrayList<Integer> adj[];
 public static ArrayList<Integer> rep = new ArrayList<Integer>();
 public static boolean visited[];
 public static void main(String[] args) throws IOException
 {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(System.out);
  StringTokenizer st = new StringTokenizer(br.readLine());
  int N = Integer.parseInt(st.nextToken());
  int M = Integer.parseInt(st.nextToken());
  adj = new ArrayList[N+1];
  visited = new boolean[N+1];
  for (int i = 0; i <= N; i++) adj[i] = new ArrayList<Integer>();
  for (int i = 0; i < M; i++){
   st = new StringTokenizer(br.readLine());
   int u = Integer.parseInt(st.nextToken());
   int v = Integer.parseInt(st.nextToken());
   adj[u].add(v); adj[v].add(u);
  }
  int ans = count_components();
  out.println(ans-1);
  for (int i = 1; i < ans; i++){
   out.println(rep.get(i-1) + " " + rep.get(i));
  }
  out.close();
 }

 public static void dfs(int node)
 {
  visited[node] = true;
  for (int u: adj[node])
   if(!visited[u])
    dfs(u);
 }
 public static int count_components()
 {
  int count = 0;
  for (int i = 1; i <= adj.length-1; i++){
   if(!visited[i]){
    count++;
    rep.add(i);
    dfs(i);
   }
  }
  return count;
 }
}