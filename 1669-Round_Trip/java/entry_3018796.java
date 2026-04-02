//package entry_3018796;
import java.io.*;
import java.util.*;

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

public class entry_3018796 {
 public static void main(String []args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());

  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());

  Graph graph = new Graph();

  for(int i = 0; i < m; ++i) {
   st = new StringTokenizer(br.readLine());
   graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
  }

  int visited[] = new int[n + 1];
  Arrays.fill(visited, -1);

  Stack<Integer> stack = new Stack<Integer>();
  int final_node = -1;
  int initial_node = -1;
  outerloop:
  for(int i = 1; i < n; ++i) {
   if(visited[i] >= 0)
    continue;
   if(!graph.map.containsKey(i)) {
    visited[i] = 0;
    continue;
   }
   stack.push(i);
   visited[i] = 0;
   while(!stack.isEmpty()) {
    int temp = stack.pop();
    List<Integer> list = graph.map.get(temp);
    for(int node : list) {
     if(visited[node] >= 0 && visited[temp] != node) {
      initial_node = temp;
      final_node = node;
      break outerloop;
     }
     else if(visited[node] < 0) {
      visited[node] = temp;
      stack.push(node);
     }
    }
   } 
  }
  if(initial_node == -1)
   System.out.println("IMPOSSIBLE");

  else {
   StringBuffer res = new StringBuffer();
   res.append(visited[final_node] + " ");
   res.append(final_node + " ");
   int count = 2;
   while(visited[final_node] != initial_node) {
     res.append(initial_node + " ");
     count++;
     initial_node = visited[initial_node];
   }
   res.append(initial_node);
   System.out.println(count + 1);
   System.out.println(res);
  }
 }
}