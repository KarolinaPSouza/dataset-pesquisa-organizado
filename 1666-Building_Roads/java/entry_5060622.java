import java.util.*;
import java.io.*;

public class entry_5060622 {
 static BufferedReader in;
 static int n, m;
 static ArrayList<Integer>[] a;
 static boolean[] w;

 public static void main(String[] args) throws IOException {
  in = new BufferedReader(new InputStreamReader(System.in));

  init();
  solve();

  in.close();
 }
 static void init() throws IOException {
  StringTokenizer st = new StringTokenizer(in.readLine());
  n = Integer.parseInt(st.nextToken());
  m = Integer.parseInt(st.nextToken());

  a = new ArrayList[n+1];
  for(int i = 1; i < n+1; i++) {
   a[i] = new ArrayList<Integer>();
  }

  for(int i = 0; i < m; i++) {
   st = new StringTokenizer(in.readLine());
   int u = Integer.parseInt(st.nextToken());
   int v = Integer.parseInt(st.nextToken());

   a[u].add(v);
   a[v].add(u);
  }
  //System.out.println(Arrays.toString(a));
  w = new boolean[n+1];
 }

 static void solve() {
  int ans = 0;
  ArrayList<Integer> c = new ArrayList<Integer>();

  for(int i = 1; i <= n; i++) {
   if(!w[i]) {
    dfs(i);
    c.add(i);
    ans++;
   }
  }
  System.out.println(ans-1);
  StringBuilder sb = new StringBuilder();
  for(int i = 1; i < c.size(); i++) {
   sb.append(c.get(i)-1).append(" ").append(c.get(i)).append("\n");
  }
  System.out.print(sb.toString());
 }

 static void dfs(int t) {
  w[t] = true;

  for(int i : a[t]) {
   if(!w[i]) {
    dfs(i);
   }
  }
 }
}