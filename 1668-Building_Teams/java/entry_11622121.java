import java.util.*;
import java.io.*;

public class entry_11622121 {
 static ArrayList<Integer>[] adjList;
 static int[] ans;
 static boolean impossible = false;
 public static void main(String args[]) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());
  adjList = new ArrayList[n+1];
  for(int i = 1; i <= n; i++) {
   adjList[i] = new ArrayList<Integer>();
  }
  for(int i = 0; i < m; i++) {
   st = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken());
   int b = Integer.parseInt(st.nextToken());
   adjList[a].add(b);
   adjList[b].add(a);
  }
  ans = new int[n+1];
  Arrays.fill(ans, -1);
  for(int i = 1; i <= n; i++) {
   if(ans[i] != -1) {
    continue;
   }
   ans[i] = 1;
   dfs(i);
  }
  if(impossible) {
   pw.println("IMPOSSIBLE");
  } else {
   for(int i = 1; i <= n; i++) {
    pw.print(ans[i] + " ");
   }
  }
  pw.close();
 }

 public static void dfs(int root) {
  int color = ans[root] == 1 ? 2 : 1;
  for(int j : adjList[root]) {
   if(ans[j] == -1) {
    ans[j] = color;
    dfs(j);
   } else if(ans[j] != color) {
    impossible = true;
   }
  }
 }
}