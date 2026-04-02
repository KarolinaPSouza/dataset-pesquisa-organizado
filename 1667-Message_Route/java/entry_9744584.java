import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_9744584 {

 static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
 static int n, m;

 public static void main (String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());

  n = Integer.parseInt(st.nextToken());
  m = Integer.parseInt(st.nextToken());

  for (int i = 0; i <= n; i++) {
   adj.add(new ArrayList<Integer>());
  }

  for (int i = 0; i < m; i++) {
   st = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken());
   int b = Integer.parseInt(st.nextToken());
   adj.get(a).add(b);
   adj.get(b).add(a);
  }

  int[] d = new int[n+1];
  int[] p = new int[n+1];
  boolean[] vis = new boolean[n+1];

  int inf = Integer.MAX_VALUE;


  Arrays.fill(d, inf);
  Arrays.fill(p, -1);
  Queue<Integer> q = new LinkedList<Integer>();
  q.add(1);
  d[1] = 0;
  vis[1] = true;

  while (!q.isEmpty()) {
   int pop = q.poll();
   for (int ne : adj.get(pop)) {
    if (!vis[ne]) {
     q.add(ne);
     d[ne] = 1 + d[pop];
     vis[ne] = true;
     p[ne] = pop;
    }
   }

  }

  br.close();

  if (d[n] == inf) {
   System.out.println("IMPOSSIBLE");
   return;
  }

  ArrayList<Integer> path = new ArrayList<Integer>();
  int pt = n;
  while (pt != -1) {
   path.add(pt);
   pt = p[pt];
  }
  Collections.reverse(path);

  System.out.println(path.size());
  for (int i = 0; i < path.size(); i++) {
   System.out.print(path.get(i));
   if (i == path.size() - 1) {
    System.out.println();
   } else {
    System.out.print(" ");
   }
  }

 }
}