//package silverPrep;

import java.io.*;
import java.util.*;

public class entry_5542873 {
 static ArrayList<HashSet<Integer>> islands = new ArrayList<>();
 static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
 static boolean[] done;
 static int curIsland = 0;

 public static void main(String[] args) throws IOException {
  BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter p = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(s.readLine());
  int N = Integer.parseInt(st.nextToken());
  int M = Integer.parseInt(st.nextToken());

  done = new boolean[N];
  for (int i = 0; i < N; i++) adjacencyList.add(new ArrayList<>());

  for (int i = 0; i < M; i++) {
   st = new StringTokenizer(s.readLine());
   int a = Integer.parseInt(st.nextToken()) - 1;
   int b = Integer.parseInt(st.nextToken()) - 1;

   adjacencyList.get(a).add(b);
   adjacencyList.get(b).add(a);
  }

  islands.add(new HashSet<>());
  for (int i = 0; i < N; i++) if (!done[i]) {
   dfs(i);
   islands.add(new HashSet<>());
   curIsland++;
  }
  islands.remove(islands.size() - 1);

  p.println(islands.size() - 1);

  int[] ans = new int[islands.size()];
  for (int i = 0; i < ans.length; i++)
   ans[i] = islands.get(i).toArray(new Integer[islands.get(i).size()])[0];

  for (int i = 0; i < ans.length - 1; i++)
   p.println((ans[i] + 1) + " " + (ans[i + 1] + 1));

  s.close(); p.close();
 }

 public static void dfs(int node) {
  done[node] = true;
  islands.get(curIsland).add(node);

  for (int i: adjacencyList.get(node)) if (!done[i]) dfs(i);
 }
}