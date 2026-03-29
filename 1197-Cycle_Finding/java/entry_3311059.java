import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.Math.PI;
import static java.lang.Math.min;
import static java.lang.System.arraycopy;
import static java.lang.System.exit;
import static java.util.Arrays.copyOf;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.*;
import java.text.DecimalFormat;
public class entry_3311059 {

 static class Edge{
  int u , v , w;
  Edge(int u, int v, int w){
   this.u = u;
   this.v = v;
   this.w = w;
  }
 }

 static BufferedReader in;
 static PrintWriter out;
 static StringTokenizer tok;
 static int mod= (int)1e9+7;
 static boolean isPrime[];
 static long INF = (long)1e17;



 private static void solve() throws IOException{ 
  int n = scanInt(), m = scanInt();
  Edge edges[] = new Edge[m];
  int parent[] = new int[n+1];
  long distance[] = new long[n+1];
  for(int i = 0; i<m; ++i){
   edges[i] = new Edge(scanInt(), scanInt(), scanInt());
  }
  Arrays.fill(distance, 0);
  distance[1] = 0;
  for(int i = 1; i<n; ++i){
   for(Edge edge : edges){
    if(distance[edge.v] > distance[edge.u]+edge.w){
     distance[edge.v] = distance[edge.u]+edge.w;
     parent[edge.v] = edge.u; 
    }
   }
  }
  boolean flag = false; int node=-1;
  for(Edge edge: edges){
   if(distance[edge.v] > distance[edge.u]+edge.w){
    parent[edge.v] = edge.u;
    node = edge.v;
    flag = true;
   }
  }
  if(flag){
   boolean vis[] = new boolean[n+1];
   for(int i=0; i<n; ++i)
    node = parent[node];
   out.print("YES\n");
   ArrayList<Integer> answer = new ArrayList<>();
   answer.add(node);
   while(!vis[parent[node]]){
    answer.add(parent[node]);
    vis[parent[node]] = true;
    node = parent[node];
   }
   Collections.reverse(answer);
   for(int x : answer){
    out.print(x+" ");
   }
  }
  else
   out.println("NO");
 }

 public static void main(String[] args) {
  try {
   long startTime = System.currentTimeMillis();

   in = new BufferedReader(new InputStreamReader(System.in));
   out = new PrintWriter(System.out);
   //in = new BufferedReader(new FileReader("input.txt"));
   //out = new PrintWriter(new FileWriter("output.txt"));
   // int test=scanInt();
   // for(int t=1; t<=test; t++){
    // out.print("Case #"+t+": ");
    solve();
   // }

   long endTime   = System.currentTimeMillis();
   long totalTime = endTime - startTime;
   //out.println(totalTime+"  "+System.currentTimeMillis() );
   in.close();
   out.close();

  } catch (Throwable e) {
   e.printStackTrace();
   exit(1);
  }
 }
 static int scanInt() throws IOException {
  return parseInt(scanString());
 }

 static long scanLong() throws IOException {
  return parseLong(scanString());
 }
 static double scanDouble() throws IOException {
  return parseDouble(scanString());
 }

 static String scanString() throws IOException {
  if (tok == null || !tok.hasMoreTokens()) {
   tok = new StringTokenizer(in.readLine());
  }
  return tok.nextToken();
 }
 static String scanLine() throws IOException {
  return in.readLine();
 }


}

