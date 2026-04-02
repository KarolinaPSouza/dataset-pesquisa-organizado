import java.io.*;
import java.util.*;

public class entry_1726935 {

 public static ArrayList<Integer> paths[];
 public static ArrayList<Integer> newRoadcities = new ArrayList<Integer>();
 public static boolean visited[];

 public static void main(String[] args) throws Exception{

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()); 

  paths = new ArrayList[N+1];
  visited = new boolean[N+1];

  for(int i=0; i<paths.length; i++) {
   paths[i] = new ArrayList<Integer>();
  }

  for(int i=0; i<M; i++) {
   st = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()); 
   paths[a].add(b);
   paths[b].add(a);
  }

  int output = 0;

  for(int i=1; i<visited.length; i++) {
   if(!visited[i]) {
    dfs(i);
    output++;
    newRoadcities.add(i);
   }
  }

  System.out.println(output-1);

  for(int i=1; i<newRoadcities.size(); i++) {
   System.out.println(newRoadcities.get(0) + " " + newRoadcities.get(i));
  }


 }

 public static void dfs(int node) {
  visited[node] = true;
  for(int i=0; i<paths[node].size(); i++) {
   if(!visited[paths[node].get(i)]) {
    dfs(paths[node].get(i));
   }
  }
 }

}