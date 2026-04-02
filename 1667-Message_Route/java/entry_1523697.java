import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_1523697 {

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

  Map<Integer, List<Integer>> adjList = new HashMap<>();

  for (int i = 0; i < m; i++) {
   int from = reader.nextInt();
   int to = reader.nextInt();
   adjList.computeIfAbsent(from, v -> new ArrayList<>()).add(to);
   adjList.computeIfAbsent(to, v -> new ArrayList<>()).add(from);
  }

  Queue<Integer> qu = new LinkedList<>();

  qu.add(1);

  int[] from = new int[n + 1];
  int[] dist = new int[n + 1];
  Arrays.fill(dist, Integer.MAX_VALUE / 2);
  dist[1] = 0;
  while (qu.size() > 0) {
   int v = qu.poll();
   if (v == n) {
    int c=1;
    List<Integer> list=new ArrayList<>();
    list.add(n);
    while(v!=1) {
     v=from[v];
     list.add(0,v);
     //System.out.println(v);
     c++;
    }
    StringBuilder builder=new StringBuilder();

    System.out.println(c);
    for(int i=0;i<list.size();i++) {
     builder.append(list.get(i));
     builder.append(" ");
    }
    System.out.println(builder.toString());
   // System.out.println(Arrays.toString(dist));
    //System.out.println(Arrays.toString(from));
    return;
   }

   if(!adjList.containsKey(v)) {
    continue;
   }
   for (int next : adjList.get(v)) {
    if (dist[next] > dist[v] + 1) {
     dist[next] = dist[v] + 1;
     qu.add(next);
     from[next] = v;
    }
   }
  }
  System.out.println("IMPOSSIBLE");

 }

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