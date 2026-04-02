import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class entry_9744770 {

 static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
 static int n, m;
 static int[] color;
 static boolean[] vis;

 public static void main (String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());

  n = Integer.parseInt(st.nextToken());
  m = Integer.parseInt(st.nextToken());

  for (int i = 0; i <= n; i++) {
   adj.add(new ArrayList<Integer>());
  }

  color = new int[n+1];
  vis = new boolean[n+1];

  int[] A = new int[m];
  int[] B = new int[m];

  for (int i = 0; i < m; i++) {
   st = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken());
   int b = Integer.parseInt(st.nextToken());

   adj.get(a).add(b);
   adj.get(b).add(a);
   A[i] = a;
   B[i] = b;
  }

  br.close();


  for (int i = 1; i <= n; i++) {
   if (!vis[i]) {
    dfs(i, 0);
   }
  }

  // System.out.println(Arrays.toString(color));

  for (int i = 0; i < m; i++) {
   int ai = A[i];
   int bi = B[i];
   //System.out.println("QUERY: " + ai + " " + bi);
   if (color[ai] == color[bi]) {
    System.out.println("IMPOSSIBLE");
    return;
   }
  }

  StringBuilder sb = new StringBuilder("");

  for (int i = 1; i <= n; i++) {
   sb.append((color[i] + 1));
   // System.out.print(color[i] + 1);
   if (i != n) {
    sb.append(" ");
   } 
  }


  System.out.println(sb.toString());



 }

 static void dfs(int u, int col) {
  vis[u] = true;
  color[u] = col;
  // System.out.println(u + " marked as " + col);
  for (int ne : adj.get(u)) {
   if (!vis[ne]) {
    dfs(ne, 1-col);
   }
  }
 }
}