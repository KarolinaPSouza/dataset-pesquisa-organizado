import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class entry_9253168 {
 static PrintWriter out = new PrintWriter(System.out);
 public static void main(String[] args) {
  FastScanner in = new FastScanner();
  int n = in.nextInt();
  int m = in.nextInt();
  ArrayList<Integer>[] adj = new ArrayList[n + 1];
  for(int i = 1; i <= n; i++)
   adj[i] = new ArrayList<Integer>();
  for(int i = 0; i < m; i++){
   int a = in.nextInt();
   int b = in.nextInt();
   adj[a].add(b);
   adj[b].add(a);
  }
  boolean[] visited = new boolean[n + 1];
  int[] inTeam = new int[n + 1];
  Queue<Integer> q = new LinkedList<>();
  boolean works = true;
  outer: for(int i = 1; i <= n; i++){
   if(visited[i])
    continue;
   visited[i] = true;
   q.offer(i);
   inTeam[i] = 1;
   while(!q.isEmpty()){
    int parent = q.poll();
    for(int child : adj[parent]){
     if(inTeam[parent] == inTeam[child]){
      works = false;
      break outer;
     }
     if(visited[child])
      continue;
     inTeam[child] = inTeam[parent] == 1 ? 2 : 1;
     q.offer(child);
     visited[child] = true;
    }
   }
  }
  if(!works)
   out.println("IMPOSSIBLE");
  else{
   for(int i = 1; i <= n; i++)
    out.print(inTeam[i] + " ");
   out.println();
  }
  out.flush();
  out.close();
 }

 static class Pair<T, U> {
  public T first;
  public U second;

  public Pair() {

  }

  public Pair(T index, U value) {
   this.first = index;
   this.second = value;
  }

  public String toString() {
   return this.first + " " + this.second;
  }

 }

 static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  String nextLine() {
   try {
    return br.readLine();
   } catch (IOException e) {
    e.printStackTrace();
    return "";
   }
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
 }

}