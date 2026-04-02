import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class entry_4209895 {

 static boolean[] visited;

 public static void main(String[] args) throws IOException {
  // TODO Auto-generated method stub
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(r.readLine());

  int numCities = Integer.parseInt(st.nextToken());
  int numRoads = Integer.parseInt(st.nextToken());

  ArrayList<Integer>[] adjList = new ArrayList[numCities];
  visited = new boolean[numCities];

  for(int i = 0; i < numCities; i++) {
   adjList[i] = new ArrayList<Integer>();
  }

  for(int i = 0; i < numRoads; i++) {
   st = new StringTokenizer(r.readLine());
   int road1 = Integer.parseInt(st.nextToken());
   int road2 = Integer.parseInt(st.nextToken());

   adjList[road1-1].add(road2-1);
   adjList[road2-1].add(road1-1);
  }

  int pocketCount = 0;
  ArrayList<Integer> uniNodes = new ArrayList<Integer>();

  for(int i = 0; i < numCities; i++) {
   if(!visited[i]) {
    dfs(i, adjList);
    uniNodes.add(i+1);
    pocketCount++;
   }
  }

  pw.println(pocketCount - 1);

  for(int i = 0; i < uniNodes.size()-1; i++) {
   pw.print(uniNodes.get(i));
   pw.println(" " + uniNodes.get(i+1));
  }

  pw.close();
 }

 public static void dfs(int node, ArrayList<Integer>[] adjList) {
  ArrayList<Integer> visits = adjList[node];

  visited[node] = true;
  for(int i = 0; i < visits.size(); i++) {
   if(!visited[visits.get(i)]) {
    dfs(visits.get(i), adjList);
   }
  }
 }

}