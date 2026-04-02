// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class entry_15814009 {
    static ArrayList<Integer> adj[];
    static boolean[] visited;

 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(r.readLine());
  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) { adj[i] = new ArrayList<Integer>(); }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        ArrayList<Integer> reps = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { reps.add(i); dfs(i); }
        }

        int k = reps.size() - 1;
        pw.println(k);

        for (int i = 1; i < k + 1; i++) {
            pw.println(reps.get(i - 1) + " " + reps.get(i));
        }


  pw.close();
 }

    public static void dfs(int node) {
        visited[node] = true;
        for (int n : adj[node]) { if(!visited[n]) { dfs(n); }}
    }
}