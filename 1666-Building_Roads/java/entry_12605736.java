import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_12605736 {

  public static int n;//number of nodes
  public static int edge; // number of edges
  public static List<List<Integer>> adjList;
  public static boolean[] visited;

  // dfs traversal --

  public static void dfs(int node){

    visited[node] = true;

    for(int vertices: adjList.get(node)){
      if(!visited[vertices]){
        dfs(vertices);
      }
    }
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    edge = Integer.parseInt(st.nextToken());

    adjList = new ArrayList<>();

    visited = new boolean[n+1];
    for(int i=0;i<=n;i++){
      adjList.add(new ArrayList<>());
    }
    for(int i=1;i<=edge;i++){
      StringTokenizer edge = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(edge.nextToken());
      int v = Integer.parseInt(edge.nextToken());

      adjList.get(u).add(v);
      adjList.get(v).add(u);

    }
    List<Integer> ind = new ArrayList<>();    
    // traversal to find disconnected graph 
    int count = 0;
    for(int i=1;i<=n;i++){
      if(!visited[i]){

        count++;
        dfs(i);
        ind.add(i);

      }
    }
    System.out.println(count-1);
   if(ind.size() > 1){
    for(int i=1;i<ind.size();i++){
      System.out.println(ind.get(i-1)+" "+ind.get(i));
    }
  }
  }
}