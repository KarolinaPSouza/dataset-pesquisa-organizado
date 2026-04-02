//package silver;

import java.io.*;
import java.util.*;

public class entry_8051517 {
 static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 static PrintWriter out = new PrintWriter(System.out);

 public static final int MN = 200020;

 static int N, M, ans;
 static int[] hd = new int[MN], nx = new int[MN], to = new int[MN],
              s = new int[MN], p = new int[MN];

 public static void adde(int u, int v, int id) {
  nx[id] = hd[u];
  hd[u] = id;
  to[id] = v;
 }
 public static void dfs(int node) {
  s[node] = 1;
  for (int id = hd[node]; id != 0; id = nx[id]) {
   dfs(to[id]);
   s[node] += s[to[id]];
  }
 }
 public static void main(String... args) throws IOException {
  N = Integer.parseInt(in.readLine());
  StringTokenizer st = new StringTokenizer(in.readLine());
  for (int i = 2; i <= N; ++i) {
   p[i] = Integer.parseInt(st.nextToken());
   adde(p[i], i, i);
  }
  dfs(1);
  for (int i = 1; i <= N; ++i) {
   out.print(s[i] - 1);
   if (i < N) out.print(" ");
   else out.println();
  }
  out.close();
 }
}