import java.util.*;
import java.io.*;

public class entry_2698212 {

 static ArrayList<Integer> edges[];
 static boolean visited[];
 static int node[];

 static void dfs(int v) {
  visited[v] = true;
  for(int adj : edges[v]) {
   if(!visited[adj]) dfs(adj);
  }
 }

 public static void main(String[] args) throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  int N, M;
  StringTokenizer st = new StringTokenizer(br.readLine());

  N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

  edges = new ArrayList[N];
  for(int i = 0; i < N; i++) edges[i] = new ArrayList<Integer>();
  visited = new boolean[N];
  node = new int[N];

  for(int i = 0; i < M; i++) {
   int u, v;
   st = new StringTokenizer(br.readLine());
   u = Integer.parseInt(st.nextToken());
   v = Integer.parseInt(st.nextToken());
   u--; v--;

   edges[u].add(v);
   edges[v].add(u);
  }

  int cc = 0;
  for(int i = 0; i < N; i++) {
   if(!visited[i]) {
    dfs(i);
    node[cc] = i+1;
    cc++;
   } else {
    dfs(i);
   }
  }

  pw.println(cc-1);
  for(int i = 1; i < cc; i++) {
   pw.println(node[0] + " " + node[i]);
  }
  pw.close();
 }


}