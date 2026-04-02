import java.io.*;
import java.util.*;

public class entry_1894889 {

 static ArrayList<Integer> adj[];
 static ArrayList<Integer> connected = new ArrayList<Integer>();
 static boolean visited[];
 static int N, M;

 static boolean colors[];
 static boolean bad;

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(br.readLine());

  N = Integer.parseInt(st.nextToken());
  M = Integer.parseInt(st.nextToken());

  adj = new ArrayList[N+1];
  visited = new boolean[N+1];

  for (int i = 1; i <= N; i++) 
   adj[i] = new ArrayList<Integer>();

  for (int i = 0; i < M; i++)
  {
   st = new StringTokenizer(br.readLine());

   int u = Integer.parseInt(st.nextToken());
   int v = Integer.parseInt(st.nextToken());
   adj[u].add(v); 
   adj[v].add(u);
  }

  colors = new boolean[N + 1];

  for(int i = 1; !bad && i<= N; i++)
  {
   if(!visited[i])
    dfs(i, true);
  }


  if (bad)
   pw.println("IMPOSSIBLE");
  else
  {
   for (int i = 1; i <= N; i++)
   {
    if (colors[i] == true)
     pw.print(1 + " ");
    else
     pw.print(2 + " ");
   }
  }

  pw.close();
  br.close();
 }

 public static void dfs(int node, boolean b)
 {
  visited[node] = true;
  colors[node] = b;

  for (int u: adj[node])
  {
   if (visited[u])
   {
    if (colors[u] == b)
     bad = true;
   }

   else
   {
    dfs(u, !b);
   }
  }
 }

}