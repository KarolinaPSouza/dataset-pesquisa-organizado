import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class entry_1525073 {

 public static void main(String[] args) throws Exception {
//
//  File file = Paths.get("input.txt").toFile();
//  if (file.exists()) {
//   System.setIn(new FileInputStream(file));
//  }

  long t = System.currentTimeMillis();

  FastReader reader = new FastReader();
  int n = reader.nextInt();
  int m = reader.nextInt();

  adjList = new HashMap<>();
  for (int i = 0; i < m; i++) {
   int from = reader.nextInt();
   int to = reader.nextInt();
   adjList.computeIfAbsent(from, v -> new ArrayList<>()).add(to);
   adjList.computeIfAbsent(to, v -> new ArrayList<>()).add(from);
  }

  steps = new int[n + 1];
  from = new int[n + 1];
  visited = new boolean[n + 1];
  boolean done = false;
  for (int k = 1; k <= n; k++) {
   if (!adjList.containsKey(k)||visited[k]) {
    continue;
   }
   from = new int[n + 1];
   //System.out.println(k);
   int result = dfs(k, 1, k);
   if (result>-1) {
    int z=result;
    int nn=1;

    StringBuilder sb = new StringBuilder();
    sb.append(result + " ");

    while(result!=from[z]) {
     z=from[z];
     sb.append(z + " ");
     nn++;
    }
    nn++;
    sb.append(result + " ");
    System.out.println(nn);
    System.out.println(sb.toString());
    done = true;
    break;
   }else {
    //break;
   }
  }
  if (!done) {
   System.out.println("IMPOSSIBLE");
  }
 }

 static int[] steps;

 static Stack<Integer> stack = new Stack<>();

 static int[] from;

 static boolean[] visited;

 private static Integer dfs(int i, int c, int start) {

  stack.add(i);

  while (stack.size() > 0) {
   int v = stack.pop();

   if (visited[v]) {
    continue;
   }

   visited[v] = true;

   for (int next : adjList.get(v)) {

//    if(next==i&&from[v]!=start) {
//     from[i]=v;
//     //System.out.println("DONE");
//     return true;
//    }

    if (visited[next]) {

     if(from[v]!=next) {
      from[next] = v;
      //System.out.println("KKK: "+Arrays.toString(from));
      return next;
     }

     continue;
    }

    from[next] = v;
    stack.push(next);
   }
  }
  return -1;
 }

 private static boolean dfs2(int i, int c, int start) {

  for (int next : adjList.get(i)) {

   if (next == start) {
    if (c > 2) {
     steps[next] = c;
     return true;
    } else {
     continue;
    }
   }

   if (steps[next] > 0) {
    continue;
   }

   steps[next] = c;
   boolean result = dfs2(next, c + 1, start);
   if (result) {
    return true;
   }
   steps[next] = 0;
  }
  return false;
 }

 static Map<Integer, List<Integer>> adjList;

 static class FastReader {
  BufferedReader br;
  StringTokenizer st;

  public FastReader() {
   br = new BufferedReader(new InputStreamReader(System.in));
  }

  String next() {
   while (st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  long nextLong() {
   return Long.parseLong(next());
  }

  double nextDouble() {
   return Double.parseDouble(next());
  }

  String nextLine() {
   String str = "";
   try {
    str = br.readLine();
   } catch (IOException e) {
    e.printStackTrace();
   }
   return str;
  }
 }

}