import java.util.*;
import java.io.*; 

public class entry_7863407 {
 static ArrayList<LinkedList<Integer>> gr;
 static ArrayList<Integer> path;
 static boolean[] visited;
 static int[] depth;
 static boolean found_path = false;
 static int starting;

 static void dfs (int i, int d) {
  if (visited[i]) {
   if (depth[i] + 2 < d) {
    found_path = true;
    starting = i;
    path.add(i);
   }
   return;
  }

  depth[i] = d;
  visited[i] = true;

  for (Integer u : gr.get(i)) {
   dfs(u, d + 1);
   if (found_path) {
    path.add(i);
    return;
   }
  }
 }

 public static void main(String []args) throws Exception {
  BufferedReader br = new BufferedReader( 
   new InputStreamReader(System.in));
  StringTokenizer st 
   = new StringTokenizer(br.readLine());

  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());

  gr = new ArrayList<LinkedList<Integer>>();
  path = new ArrayList<Integer>();
  visited = new boolean[n];
  depth = new int[n];

  for (int i = 0; i < n; i++)
   gr.add(new LinkedList<Integer>());
  for (int i = 0; i < m; i++) {
   st = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken()) - 1;
   int b = Integer.parseInt(st.nextToken()) - 1;

   gr.get(a).add(b);
   gr.get(b).add(a);
  }

  for (int i = 0; i < n; i++) {
   if (visited[i]) continue;
   dfs(i, 1);
   if (found_path) break;
  }

  if (found_path) {
   for (int i = path.size() - 1; i >= 0; i--) {
    if (path.get(i) == starting) break;
    path.remove(i);
   }
   System.out.println(path.size());
   for (int i = 0; i < path.size(); i++)
    System.out.print((path.get(i) + 1) + " ");
   System.out.println();
  } else {
   System.out.println("IMPOSSIBLE");
  }
 }
} 