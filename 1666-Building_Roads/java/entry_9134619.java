import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_9134619 {
 final static int N = 100000;
 public static void main(String[] args) throws IOException {

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  String string[] = br.readLine().trim().split(" ");
  int n = Integer.parseInt(string[0]);
  int m = Integer.parseInt(string[1]);
  ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
  for (int i = 0; i <= n; i++) {
   adj.add(new ArrayList<>());
  }

  for (int i = 0; i < m; i++) {
   String s[] = br.readLine().trim().split(" ");
   int x = Integer.parseInt(s[0]);
   int y = Integer.parseInt(s[1]);
   adj.get(x).add(y);
   adj.get(y).add(x);
  }

  boolean[] vis = new boolean[n + 1];
  int[] arrayList = new int[N];
  int count = 0;
  for (int i = 1; i <= n; i++) {
   if (vis[i] == false) {
    arrayList[count] = i;
    bfs(adj, vis, i);
    count++;
   }
  }
  if (count > 1) {
   System.out.println(count-1);
   for (int i = 0; i < count - 1; i++) {
    System.out.println(arrayList[i] + " " + arrayList[i+1]);
   }
  } else {
   System.out.println(0);
  }

 }

 public static void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src) {
  Queue<Integer> q = new ArrayDeque<>();
  vis[src] = true;
  q.add(src);
  while (!q.isEmpty()) {
   int u = q.poll();
   for (int v : adj.get(u)) {
    if (vis[v] == false) {
     vis[v] = true;
     q.add(v);
    }
   }
  }

 }

}