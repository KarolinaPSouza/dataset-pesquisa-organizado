import java.io.*;
import java.util.*;

public class entry_14727000 {
 static int n, m;
 static List<List<Integer>> adj;
 static int[] parent, dist;

 static void bfs(int start) {
  // TODO: implement BFS and fill dist[] + parent[]

  Queue<Integer> q = new LinkedList();
  int level = 1;

  q.add(start);

  parent[start] = start;

  while(!q.isEmpty()){

   int curr = q.poll();

   if(curr == n){
    return;
   }

   for(int c : adj.get(curr)){
    if(parent[c] != -1)
     continue;
    parent[c] = curr;
    q.add(c);
   }

  }


 }

 public static void main(String[] args) throws IOException {
  FastScanner fs = new FastScanner(System.in);
  n = fs.nextInt();
  m = fs.nextInt();

  adj = new ArrayList<>();
  for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

  parent = new int[n + 1];
  dist = new int[n + 1];
  Arrays.fill(parent, -1);

  for (int i = 0; i < m; i++) {
   int a = fs.nextInt();
   int b = fs.nextInt();
   adj.get(a).add(b);
   adj.get(b).add(a);
  }

  bfs(1);

  if (parent[n] == -1) {
   System.out.println("IMPOSSIBLE");
  } else {
   // TODO: reconstruct and print path using parent[]
   int curr = n;
   ArrayList<Integer> path = new ArrayList();

   while(curr != parent[curr]){
    path.add(curr);
    curr = parent[curr];
   }


   path.add(curr);

   System.out.println(path.size());

   Collections.reverse(path);

   for(int p : path){
    System.out.print(p + " ");
   }
  }
 }

 // FastScanner for fast input
 static class FastScanner {
  BufferedReader br;
  StringTokenizer st;
  FastScanner(InputStream in) { br = new BufferedReader(new InputStreamReader(in)); }
  String next() throws IOException {
   while (st == null || !st.hasMoreElements()) {
    String line = br.readLine();
    if (line == null) return null;
    st = new StringTokenizer(line);
   }
   return st.nextToken();
  }
  int nextInt() throws IOException { return Integer.parseInt(next()); }
 }
}