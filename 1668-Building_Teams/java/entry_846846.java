import java.io.*;
import java.util.*;

public class entry_846846 {

 public static boolean[] marked;
 public static boolean[] team;
 public static boolean isCyclic;

 public static void main(String[] args) throws IOException {
  BufferedReader bufferedInput = new BufferedReader(new InputStreamReader(System.in));

  StringTokenizer firstLine = new StringTokenizer(bufferedInput.readLine());
  int n = Integer.parseInt(firstLine.nextToken());
  int m = Integer.parseInt(firstLine.nextToken());

  Graph friendships = new Graph(n + 1);

  for(int i = 0; i < m; ++i)
  {
   StringTokenizer friendship = new StringTokenizer(bufferedInput.readLine());
   int a = Integer.parseInt(friendship.nextToken());
   int b = Integer.parseInt(friendship.nextToken());
   friendships.addEdge(a, b);
  }

  marked = new boolean[n + 1];
  team = new boolean[n + 1];
  isCyclic = false;

  for(int v = 1; v < friendships.V; ++v)
  {
   if(!marked[v] && !isCyclic)
   {
    bfs(friendships, v);
   }
   else if(isCyclic)
    break;
  }

  if(isCyclic)
   System.out.println("IMPOSSIBLE");
  else
  {
   StringBuilder builder = new StringBuilder(200000);
   for(int i = 1; i < team.length - 1; ++i)
   {
    if(team[i])
     builder.append("1" + " ");
    else
     builder.append("2" + " ");
   }
   if(team[team.length - 1])
    builder.append("1");
   else
    builder.append("2");
   System.out.println(builder.toString());
  }
  System.out.flush();
 }

 public static class Graph
 {
  public final int V;
  public ArrayList<Integer>[] adj;

  public Graph(int V)
  {
   this.V = V;
   adj = (ArrayList<Integer>[]) new ArrayList[V];
   for(int v = 0; v < V; v++)
    adj[v] = new ArrayList<Integer>();
  }

  public void addEdge(int v, int w)
  {
   adj[v].add(w);
   adj[w].add(v);
  }
 }

 public static void bfs(Graph G, int s)
 {
  ArrayDeque<Integer> queue = new ArrayDeque<Integer>(100000);

  marked[s] = true;
  team[s] = true;

  queue.addLast(s);
  while(!queue.isEmpty() && !isCyclic)
  {
   int v = queue.removeFirst();
   for(int w :G.adj[v])
   {
    if(!marked[w])
    {
     marked[w] = true;
     team[w] = !team[v];
     queue.addLast(w);
    }
    else if(team[w] == team[v])
    {
     isCyclic = true;
     break;
    }
   }
  }

 }

}