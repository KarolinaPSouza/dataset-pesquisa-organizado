//package USACO;
import java.util.*;
import java.io.*;
public class entry_5250461 {
 public static int[]visited;
 public static boolean works = true;
 public static ArrayList<ArrayList<Integer>>arr;
 public static void dfs(int pos, int val) {
  visited[pos] = val;
  for(int i = 0; i < arr.get(pos).size(); i++) {
   int newpos = arr.get(pos).get(i);
   if(visited[newpos] == 0) {
    if(val == 1) {
     dfs(newpos, 2);
    }
    else {
     dfs(newpos, 1);
    }
   }
   else if(visited[newpos] == visited[pos]) {
    works = false;
   }
  }
 }
 public static void main(String[]args) throws IOException{
  Kattio io = new Kattio();
  int n = io.nextInt();
  int m = io.nextInt();
  visited = new int[n];
  arr = new ArrayList();
  for(int i = 0; i < n; i++) {
   arr.add(new ArrayList<Integer>());
  }
  for(int i = 0; i < m; i++) {
   int a = io.nextInt() - 1;
   int b = io.nextInt() - 1;
   arr.get(a).add(b);
   arr.get(b).add(a);
  }
  for(int i = 0; i < n; i++) {
   if(visited[i] == 0) {
    dfs(i, 1);
   }
  }
  if(works == false) {
   io.println("IMPOSSIBLE");
  }
  else {
   for(int i = 0; i < n; i++) {
    io.print(visited[i] + " ");
   }
  }
  io.close();
 }
 static class Kattio extends PrintWriter {
  private BufferedReader r;
  private StringTokenizer st;
  // standard input
  public Kattio() { this(System.in, System.out); }
  public Kattio(InputStream i, OutputStream o) {
   super(o);
   r = new BufferedReader(new InputStreamReader(i));
  }
  // USACO-style file input
  public Kattio(String problemName) throws IOException {
   super(problemName + ".out");
   r = new BufferedReader(new FileReader(problemName + ".in"));
  }
  // returns null if no more input
  public String next() {
   try {
    while (st == null || !st.hasMoreTokens())
     st = new StringTokenizer(r.readLine());
    return st.nextToken();
   } catch (Exception e) { }
   return null;
  }
  public int nextInt() { return Integer.parseInt(next()); }
  public double nextDouble() { return Double.parseDouble(next()); }
  public long nextLong() { return Long.parseLong(next()); }
 }

}