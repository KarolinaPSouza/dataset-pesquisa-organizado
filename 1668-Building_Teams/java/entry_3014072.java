//package entry_3014072;
import java.util.*;
import java.io.*;

class Graph {
 Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

 public void addVertex(int v) {
  map.put(v, new LinkedList<Integer>());
 }

 public void addEdge(int s, int d) {
  if(!map.containsKey(s))
   addVertex(s);
  if(!map.containsKey(d))
   addVertex(d);
  map.get(s).add(d);
  map.get(d).add(s);
 }
}

public class entry_3014072 {
 public static void main(String []args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());

  Graph graph = new Graph();

  for(int i = 0; i < m; ++i) {
   st = new StringTokenizer(br.readLine());
   int s = Integer.parseInt(st.nextToken());
   int d = Integer.parseInt(st.nextToken());
   graph.addEdge(s, d);
  }

  Stack<Integer> stack = new Stack<Integer>();
  int visited[] = new int[n + 1];

  for(int i = 1; i <= n; ++i) {
   if(visited[i] < 1) {
    stack.push(i);
    visited[i] = 1;
   }
   while(!stack.isEmpty()) {
    int temp = stack.pop();
    if(graph.map.containsKey(temp)) {
     List<Integer> list = graph.map.get(temp);
     for(int v : list) {
      if(visited[v] == visited[temp]) {
       System.out.println("IMPOSSIBLE");
       return;
      }
      if(visited[v] < 1) {
       visited[v] = 1 + 2 - visited[temp];
       stack.push(v);
      }

     }
    }
   }
  }

  for(int i = 1; i <= n; ++i)
   bw.write(visited[i] + " ");

  bw.flush();
  bw.close();
 }
}