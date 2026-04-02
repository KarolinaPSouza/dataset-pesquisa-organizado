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
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.*;
import java.text.DecimalFormat;

public class entry_9720948 {

 static class Point{
  long x, y;
  Point(long x, long y){
   this.x = x;
   this.y = y;
  }

  long dist2(Point p){
   return sq(this.x-p.x) + sq(this.y-p.y);
  }

  long sq(long x){
   return x*x;
  }
  @Override
  public String toString(){
   return "("+this.x+" "+this.y+")";
  }
 }

 static class Pair{
  int first, second;
  Pair(int first, int second){
   this.first = first;
   this.second = second;
  }

 }

 static BufferedReader in;
 static PrintWriter out;
 static StringTokenizer tok;

 static ArrayList<Integer> adj[];
 static char grid[][];
 static int dx[] = {1,0,-1,0};
 static int dy[] = {0,1,0,-1};
 static int INF = (int)1e8;
 static int subSize[];

 private static void solve() throws IOException{
  int N, u;
  N = scanInt();
  adj = new ArrayList[N];
  int parent[] = new int[N];
  int depth[] = new int[N];
  parent[0] = -1;
  for(int i = 0; i<N; ++i)
   adj[i] = new ArrayList<>();
  for(int v = 1; v<=N-1; ++v){
   u = scanInt()-1;
   parent[v] = u;
   adj[u].add(v);
   adj[v].add(u);
  }
  subSize = new int[N];
  Queue<Integer> queue = new LinkedList<>();
  queue.add(0);
  ArrayList<Integer> nodesWithDepth[] = new ArrayList[N];
  for(int i = 0; i<N; ++i)
   nodesWithDepth[i] = new ArrayList<>();
  nodesWithDepth[0].add(0);
  while(!queue.isEmpty()){
   int node = queue.poll();
   for(int to: adj[node]){
    if(parent[node] == to)
     continue;
    queue.add(to);
    depth[to] = depth[node]+1;
    nodesWithDepth[depth[to]].add(to);
   }
  }
  for(int d = N-1; d>0; --d){
   if(nodesWithDepth[d].size() > 0){
    for(int node : nodesWithDepth[d]){
     subSize[parent[node]] += subSize[node] + 1;
    }
   }
  }

  for(int i = 0; i<N; ++i)
   out.print(subSize[i]+" ");



 }



 private static void dfs(int node, int parent){
  for(int to : adj[node]){
   if(to == parent)
    continue;
   dfs(to, node);
   subSize[node] += subSize[to]+1;
  }
 }



 private static int[] inputArray(int n) throws IOException {
  int arr[] = new int[n];
  for(int i=0; i<n; ++i)
   arr[i] = scanInt();
  return arr;
 }

 private static void displayArray(int arr[]){
  for(int i = 0; i<arr.length; ++i)
   out.print(arr[i]+" ");
  out.println();
 }



 public static void main(String[] args)  {
  try {
   long startTime = System.currentTimeMillis();

   in = new BufferedReader(new InputStreamReader(System.in));
   out = new PrintWriter(System.out);
   //in = new BufferedReader(new FileReader("input.txt"));
   //out = new PrintWriter(new FileWriter("output.txt"));
   // int test = scanInt();
   // for(int t=1; t<=test; t++){
    // out.print("Case #"+t+": ");
    solve();
   // }

   long endTime   = System.currentTimeMillis();
   long totalTime = endTime - startTime;
   //out.println(totalTime+"----------  "+System.currentTimeMillis() );
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

 private static void sort(Point arr[]){
  mergeSort(arr, 0, arr.length-1);
 }
 private static void sort(Point arr[], int start, int end){
  mergeSort(arr, start, end-1);
 }
 private static void mergeSort(Point arr[], int start, int end){
  if(start >= end)
   return;
  int mid = (start+end)/2;
  mergeSort(arr, start, mid);
  mergeSort(arr, mid+1, end);
  merge(arr, start, mid, end);
 }

 private static void merge(Point arr[], int start, int mid, int end){
  int n1 = mid - start+1;
  int n2 = end - mid;
  Point left[] = new Point[n1];
  Point right[] = new Point[n2];
  for(int i = 0; i<n1; ++i){
   left[i] = arr[i+start];
  }
  for(int i = 0; i<n2; ++i){
   right[i] = arr[mid+1+i];
  }
  int i = 0, j = 0, curr = start;
  while(i <n1 && j <n2){
   if(left[i].x <= right[j].x){
    arr[curr] = left[i];
    ++i;
   }
   else{
    arr[curr] = right[j];
    ++j;
   }
   ++curr;
  }
  while(i<n1){
   arr[curr] = left[i];
   ++i; ++curr;
  }
  while(j<n2){
   arr[curr] = right[j];
   ++j; ++curr;
  }
 }

}