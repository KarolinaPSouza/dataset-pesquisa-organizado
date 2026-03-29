import java.io.*;
import java.util.*; 
public class entry_1869940 {

 public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(in.readLine());

  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());


  Edge[] edges = new Edge[m];
  for(int i = 0; i < m; i ++) {
   st = new StringTokenizer(in.readLine());
   int a = Integer.parseInt(st.nextToken())-1;
   int b = Integer.parseInt(st.nextToken())-1;

   int c = Integer.parseInt(st.nextToken());

   edges[i] = new Edge(a, b, c);
  }



  // run Bellman Ford and store the node that each node came from (in the shortest path)

  long[] dist = new long[n];
  int[] prev = new int[n];

  long inf = (long)1e15;
  Arrays.fill(dist, inf);
  Arrays.fill(prev, -1);

  dist[0] = 0;
  prev[0] = 0;

  for(int i = 0; i < n; i ++) {
   // relief all edges
   for(Edge edge: edges) {
    int a = edge.a;
    int b = edge.b;
    long tmp = dist[a] + edge.cost;
    if(tmp < dist[b]) {
     dist[b] = tmp;
     prev[b] = a;
    }
   }
  }


  // now go through one more time and check if an edge can be relieved
  int start = -1;
  for(Edge edge: edges) {
   int a = edge.a;
   int b = edge.b;
   int c = edge.cost;

   if(dist[a] != inf) {
    long tmp = dist[a] + c;
    if(tmp < dist[b]) {
     start = b;
     break;
    }
   }
  }

  StringBuilder res = new StringBuilder();
  if(start == -1) {
   res.append("NO");
  }
  else {
   res.append("YES").append("\n");

   // make sure we are actually in cycle (a relieved node may be out of the actual cycle)
   for(int i = 0; i < n; i ++) {
    start = prev[start];
   }

   Stack<Integer> stack = new Stack<Integer>();

   stack.add(start);
   int curr = prev[start];

   while(true) {
    stack.add(curr);
    if(curr == start) {
     break;
    }
    curr = prev[curr];
   }

   while(!stack.isEmpty()) {
    res.append(stack.pop()+1).append(" ");
   }
  }

  System.out.println(res.toString());

  in.close();
 }

 static class Edge{
  int a, b;
  int cost;
  public Edge(int a, int b, int cost) {
   this.a = a;
   this.b = b;
   this.cost = cost;
  }
 }
}