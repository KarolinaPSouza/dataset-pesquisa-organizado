import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class entry_2124039 {
 static class InputReader {

  BufferedReader br;
  StringTokenizer st;
  public InputReader() {
   br = new BufferedReader(new InputStreamReader(System.in));
  }
  String next() {
   while (st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    } 
    catch (IOException e) {
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }
  String nextLine() {
   String str = "";
   try{
    str = br.readLine();
   } 
   catch (IOException e) {
    e.printStackTrace();
   }
   return str;
  } 

  int nextInt() {
   return Integer.parseInt(next());
  }
  int[] nextIntArray(int n){
   int[] array = new int[n];
   String[] s=nextLine().split(" ");
   for(int j = 0;j<n;j++)
    array[j] = Integer.parseInt(s[j]);
   return array;
  }
  long nextLong() {
   return Long.parseLong(next());
  }
  double nextDouble() {
   return Double.parseDouble(next());
  }
 }

 static class Pair{
  int to;
  long w;
  Pair(int to,long w){
   this.to=to;
   this.w=w;
  }
 }
 static long[] dijkstra(int n,ArrayList<Pair>[] adj) {
  long[] ans=new long[n];
  int[] p=new int[n];
  Arrays.fill(p, -1);
  Arrays.fill(ans, Long.MAX_VALUE);

  PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {

   @Override
   public int compare(Pair o1, Pair o2) {
    return o1.w > o2.w ? 1 : -1;
   }
  });
  ans[0]=0;
  pq.add(new Pair(0,0));
  Pair e;
  int to;
  long len;
  boolean[] isTemp=new boolean[n];
  Arrays.fill(isTemp, false);

  while(!pq.isEmpty()) {
   e=pq.poll();
   if(e.w!=ans[e.to])continue;   //very imp, it only checks duplicate edge once
   isTemp[e.to]=true;
   for (Pair edge : adj[e.to]) {
    to = edge.to;
    if(isTemp[to])continue;
    len = edge.w;

    if (ans[e.to] + len < ans[to]) {
     ans[to] = ans[e.to] + len;
     p[to] = e.to;
     pq.add(new Pair(to,ans[to]));
    }
   }
  }
  return ans;
 }

 public static void main(String args[] ) throws Exception {
  InputReader  sc=new InputReader();
  PrintWriter out=new PrintWriter(System.out);
  int n = sc.nextInt();
  int m = sc.nextInt();
  ArrayList<Pair>[] adj=new ArrayList[n];
  for(int i=0;i<n;i++)
   adj[i]=new ArrayList<Pair>();
  int a,b,w;
  String[] s;
  for(int i=0;i<m;i++){
   s=sc.nextLine().split(" ");
   a=Integer.parseInt(s[0])-1;
   b=Integer.parseInt(s[1])-1;
   w=Integer.parseInt(s[2]);
   adj[a].add(new Pair(b,w));
  }
  long[] dist=dijkstra(n,adj);
  for(int i=0;i<n;i++)
   out.print(dist[i]+" ");

  out.flush();
 }
}