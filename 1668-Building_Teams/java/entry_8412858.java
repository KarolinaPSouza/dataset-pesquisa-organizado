import java.io.*;
import java.util.*;

public class entry_8412858 {
 public static ArrayList<Integer>[] adj;
 public static int[] visited;

 public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(in.readLine());
  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());
  adj = new ArrayList[n+1];
  visited = new int[n+1];
  for(int i = 1; i <= n; i++)
   adj[i] = new ArrayList<>();
  for(int i = 0; i < m; i++)
  {
   st = new StringTokenizer(in.readLine());
   int a = Integer.parseInt(st.nextToken());
   int b = Integer.parseInt(st.nextToken());
   adj[a].add(b);
   adj[b].add(a);
  }

  boolean possible = true;
  for(int i = 1; i <= n; i++)
  {
   if(visited[i] == 0)
   {
    visited[i] = 1;
    if(!dfs(i))
    {
     possible = false;
     break;
    }
   }
  }
  if(possible)
   for(int i = 1; i <= n; i++)
    System.out.print(visited[i] + " ");
  else
   System.out.println("IMPOSSIBLE");
 }

 public static boolean dfs(int node)
 {
  int count = visited[node] == 1 ? 2:1;
  for(int n: adj[node])
  {
   if(visited[n] == 0)
   {
    visited[n] = count;
    if(!dfs(n))
     return false;
   }
   else if(visited[n] != count)
    return false;
  }
  return true;
 }
}