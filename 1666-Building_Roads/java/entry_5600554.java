import java.util.*;
import java.io.*;
public class entry_5600554 {
 static List<Integer>[] graph;
 static boolean[] visited;
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  PrintWriter pw = new PrintWriter(System.out);
  int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

  graph = new ArrayList[N+1];
  for(int i=0; i<=N; i++)
   graph[i] = new ArrayList<Integer>();
  for(int i=0; i<M; i++) {
   st = new StringTokenizer(br.readLine());
   int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
   graph[u].add(v);
   graph[v].add(u);
  }

  visited = new boolean[N+1];
  List<Integer> list = new ArrayList<>();
  int cnt = -1;
  for(int i=1; i<=N; i++) {
   if(!visited[i]) {
    cnt++;
    list.add(i);
    dfs(i);
   }
  }

  pw.println(cnt);
  for(int i=1; i<list.size(); i++) 
   pw.println(list.get(0) + " " + list.get(i));
  pw.close();
 }

 private static void dfs(int node) {
  visited[node] = true;
  for(int nei : graph[node]) {
   if(!visited[nei])
    dfs(nei);
  }
 }
}

