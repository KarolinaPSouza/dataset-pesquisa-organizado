import java.util.*;
import java.io.*; 

public class entry_7863071 {
 public static void main(String []args) throws Exception {
  BufferedReader br = new BufferedReader( 
   new InputStreamReader(System.in));
  StringTokenizer st 
   = new StringTokenizer(br.readLine());

  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());

  ArrayList<LinkedList<Integer>> gr = new ArrayList<LinkedList<Integer>>();
  boolean[] visited = new boolean[n];
  int parent[] = new int[n];

  for (int i = 0; i < n; i++)
   gr.add(new LinkedList<Integer>());
  for (int i = 0; i < m; i++) {
   st = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken()) - 1;
   int b = Integer.parseInt(st.nextToken()) - 1;

   gr.get(a).add(b);
   gr.get(b).add(a);
  }

  int queue[] = new int[n];
  int front = 0, rear = 0, s;
  boolean found_end = false;

  visited[0] = true;
  queue[rear++] = 0;

  while (front != rear) {
   s = queue[front++];

   for (Integer u : gr.get(s)) {
    if (visited[u]) continue;
    visited[u] = true;
    parent[u] = s;
    if (u == n - 1) {
     found_end = true;
     front = rear;
     break;
    }
    queue[rear++] = u;
   }
  }

  if (found_end) {
   ArrayList<Integer> path = new ArrayList<Integer>();
   path.add(n);
   int u = parent[n-1];
   while (u != 0) {
    path.add(u + 1);
    u = parent[u];
   }
   path.add(1);

   System.out.println(path.size());
   for (int i = path.size() - 1; i >= 0; i--)
    System.out.print(path.get(i) + " ");
   System.out.println();
  } else {
   System.out.println("IMPOSSIBLE");
  }
 }
}